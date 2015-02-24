/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Embeddable
public class OrderedproductPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "UserOrder_Order_id")
    private int userOrderOrderid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Product_Product_id")
    private int productProductid;

    public OrderedproductPK() {
    }

    public OrderedproductPK(int userOrderOrderid, int productProductid) {
        this.userOrderOrderid = userOrderOrderid;
        this.productProductid = productProductid;
    }

    public int getUserOrderOrderid() {
        return userOrderOrderid;
    }

    public void setUserOrderOrderid(int userOrderOrderid) {
        this.userOrderOrderid = userOrderOrderid;
    }

    public int getProductProductid() {
        return productProductid;
    }

    public void setProductProductid(int productProductid) {
        this.productProductid = productProductid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += userOrderOrderid;
        hash += productProductid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderedproductPK)) {
            return false;
        }
        OrderedproductPK other = (OrderedproductPK) object;
        if (this.userOrderOrderid != other.userOrderOrderid) {
            return false;
        }
        if (this.productProductid != other.productProductid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderedproductPK[ userOrderOrderid=" + userOrderOrderid + ", productProductid=" + productProductid + " ]";
    }
    
}
