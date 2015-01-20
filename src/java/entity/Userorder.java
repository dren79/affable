/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "userorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userorder.findAll", query = "SELECT u FROM Userorder u"),
    @NamedQuery(name = "Userorder.findByOrderid", query = "SELECT u FROM Userorder u WHERE u.orderid = :orderid"),
    @NamedQuery(name = "Userorder.findByDate", query = "SELECT u FROM Userorder u WHERE u.date = :date"),
    @NamedQuery(name = "Userorder.findByReciept", query = "SELECT u FROM Userorder u WHERE u.reciept = :reciept"),
    @NamedQuery(name = "Userorder.findByAmount", query = "SELECT u FROM Userorder u WHERE u.amount = :amount")})
public class Userorder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Order_id")
    private Integer orderid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Reciept")
    private String reciept;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount")
    private BigDecimal amount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userorder")
    private Collection<OrderedProduct> orderedProductCollection;
    @JoinColumn(name = "User_User_id", referencedColumnName = "User_id")
    @ManyToOne(optional = false)
    private User userUserid;

    public Userorder() {
    }

    public Userorder(Integer orderid) {
        this.orderid = orderid;
    }

    public Userorder(Integer orderid, Date date, String reciept, BigDecimal amount) {
        this.orderid = orderid;
        this.date = date;
        this.reciept = reciept;
        this.amount = amount;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReciept() {
        return reciept;
    }

    public void setReciept(String reciept) {
        this.reciept = reciept;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @XmlTransient
    public Collection<OrderedProduct> getOrderedProductCollection() {
        return orderedProductCollection;
    }

    public void setOrderedProductCollection(Collection<OrderedProduct> orderedProductCollection) {
        this.orderedProductCollection = orderedProductCollection;
    }

    public User getUserUserid() {
        return userUserid;
    }

    public void setUserUserid(User userUserid) {
        this.userUserid = userUserid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userorder)) {
            return false;
        }
        Userorder other = (Userorder) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Userorder[ orderid=" + orderid + " ]";
    }
    
}
