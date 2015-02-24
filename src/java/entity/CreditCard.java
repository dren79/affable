/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "creditCard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditCard.findAll", query = "SELECT c FROM CreditCard c"),
    @NamedQuery(name = "CreditCard.findByCcId", query = "SELECT c FROM CreditCard c WHERE c.ccId = :ccId"),
    @NamedQuery(name = "CreditCard.findByCcNumber", query = "SELECT c FROM CreditCard c WHERE c.ccNumber = :ccNumber"),
    @NamedQuery(name = "CreditCard.findByCcExp", query = "SELECT c FROM CreditCard c WHERE c.ccExp = :ccExp"),
    @NamedQuery(name = "CreditCard.findByCcCvv", query = "SELECT c FROM CreditCard c WHERE c.ccCvv = :ccCvv"),
    @NamedQuery(name = "CreditCard.findByCcName", query = "SELECT c FROM CreditCard c WHERE c.ccName = :ccName")})
public class CreditCard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cc_id")
    private Integer ccId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cc_number")
    private String ccNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cc_exp")
    private String ccExp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cc_cvv")
    private String ccCvv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cc_name")
    private String ccName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditCardccid")
    private Collection<User> userCollection;

    public CreditCard() {
    }

    public CreditCard(Integer ccId) {
        this.ccId = ccId;
    }

    public CreditCard( String ccNumber, String ccExp, String ccCvv, String ccName) {
        
        this.ccNumber = ccNumber;
        this.ccExp = ccExp;
        this.ccCvv = ccCvv;
        this.ccName = ccName;
    }

    public Integer getCcId() {
        return ccId;
    }

    public void setCcId(Integer ccId) {
        this.ccId = ccId;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcExp() {
        return ccExp;
    }

    public void setCcExp(String ccExp) {
        this.ccExp = ccExp;
    }

    public String getCcCvv() {
        return ccCvv;
    }

    public void setCcCvv(String ccCvv) {
        this.ccCvv = ccCvv;
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccId != null ? ccId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditCard)) {
            return false;
        }
        CreditCard other = (CreditCard) object;
        if ((this.ccId == null && other.ccId != null) || (this.ccId != null && !this.ccId.equals(other.ccId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CreditCard[ ccId=" + ccId + " ]";
    }
    
}
