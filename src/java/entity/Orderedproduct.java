/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "Ordered_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderedproduct.findAll", query = "SELECT o FROM Orderedproduct o"),
    @NamedQuery(name = "Orderedproduct.findByUserOrderOrderid", query = "SELECT o FROM Orderedproduct o WHERE o.orderedproductPK.userOrderOrderid = :userOrderOrderid"),
    @NamedQuery(name = "Orderedproduct.findByProductProductid", query = "SELECT o FROM Orderedproduct o WHERE o.orderedproductPK.productProductid = :productProductid"),
    @NamedQuery(name = "Orderedproduct.findByQuantity", query = "SELECT o FROM Orderedproduct o WHERE o.quantity = :quantity")})
public class Orderedproduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderedproductPK orderedproductPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "Product_Product_id", referencedColumnName = "Product_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "UserOrder_Order_id", referencedColumnName = "Order_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UserOrder userOrder;

    public Orderedproduct() {
    }

    public Orderedproduct(OrderedproductPK orderedproductPK) {
        this.orderedproductPK = orderedproductPK;
    }

    public Orderedproduct(OrderedproductPK orderedproductPK, int quantity) {
        this.orderedproductPK = orderedproductPK;
        this.quantity = quantity;
    }

    public Orderedproduct(int userOrderOrderid, int productProductid) {
        this.orderedproductPK = new OrderedproductPK(userOrderOrderid, productProductid);
    }

    public OrderedproductPK getOrderedproductPK() {
        return orderedproductPK;
    }

    public void setOrderedproductPK(OrderedproductPK orderedproductPK) {
        this.orderedproductPK = orderedproductPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public UserOrder getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(UserOrder userOrder) {
        this.userOrder = userOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderedproductPK != null ? orderedproductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderedproduct)) {
            return false;
        }
        Orderedproduct other = (Orderedproduct) object;
        if ((this.orderedproductPK == null && other.orderedproductPK != null) || (this.orderedproductPK != null && !this.orderedproductPK.equals(other.orderedproductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orderedproduct[ orderedproductPK=" + orderedproductPK + " ]";
    }
    
}
