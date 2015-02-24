/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "UserOrder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserOrder.findAll", query = "SELECT u FROM UserOrder u"),
    @NamedQuery(name = "UserOrder.findByOrderid", query = "SELECT u FROM UserOrder u WHERE u.orderid = :orderid"),
    @NamedQuery(name = "UserOrder.findByReciept", query = "SELECT u FROM UserOrder u WHERE u.reciept = :reciept"),
    @NamedQuery(name = "UserOrder.findByAmount", query = "SELECT u FROM UserOrder u WHERE u.amount = :amount")})
public class UserOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Order_id")
    private Integer orderid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Reciept")
    private int reciept;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount")
    private double amount;
    @JoinColumn(name = "User_User_id", referencedColumnName = "User_id")
    @ManyToOne(optional = false)
    private User userUserid;

    public UserOrder() {
    }

    public UserOrder(Integer orderid) {
        this.orderid = orderid;
    }

    public UserOrder(Integer orderid, int reciept, double amount) {
        this.orderid = orderid;
        this.reciept = reciept;
        this.amount = amount;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public int getReciept() {
        return reciept;
    }

    public void setReciept(int reciept) {
        this.reciept = reciept;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
        if (!(object instanceof UserOrder)) {
            return false;
        }
        UserOrder other = (UserOrder) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserOrder[ orderid=" + orderid + " ]";
    }
    
}
