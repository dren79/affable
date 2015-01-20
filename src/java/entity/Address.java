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
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByAddressid", query = "SELECT a FROM Address a WHERE a.addressid = :addressid"),
    @NamedQuery(name = "Address.findByAddresstype", query = "SELECT a FROM Address a WHERE a.addresstype = :addresstype"),
    @NamedQuery(name = "Address.findByLine1", query = "SELECT a FROM Address a WHERE a.line1 = :line1"),
    @NamedQuery(name = "Address.findByLine2", query = "SELECT a FROM Address a WHERE a.line2 = :line2"),
    @NamedQuery(name = "Address.findByTowncity", query = "SELECT a FROM Address a WHERE a.towncity = :towncity"),
    @NamedQuery(name = "Address.findByCounty", query = "SELECT a FROM Address a WHERE a.county = :county")})
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Address_id")
    private Integer addressid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Address_type")
    private String addresstype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Line1")
    private String line1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Line2")
    private String line2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Town_city")
    private String towncity;
    @Size(max = 45)
    @Column(name = "County")
    private String county;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressAddressid")
    private Collection<User> userCollection;

    public Address() {
    }

    public Address(Integer addressid) {
        this.addressid = addressid;
    }

    public Address(Integer addressid, String addresstype, String line1, String line2, String towncity) {
        this.addressid = addressid;
        this.addresstype = addresstype;
        this.line1 = line1;
        this.line2 = line2;
        this.towncity = towncity;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public String getAddresstype() {
        return addresstype;
    }

    public void setAddresstype(String addresstype) {
        this.addresstype = addresstype;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getTowncity() {
        return towncity;
    }

    public void setTowncity(String towncity) {
        this.towncity = towncity;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
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
        hash += (addressid != null ? addressid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressid == null && other.addressid != null) || (this.addressid != null && !this.addressid.equals(other.addressid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Address[ addressid=" + addressid + " ]";
    }
    
}
