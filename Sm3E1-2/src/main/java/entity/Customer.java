/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import enums.CustomerType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author vfgya
 */
@Entity
public class Customer implements Serializable
{

    @OneToOne(mappedBy = "customer")
    private Address address;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CustomerType ct;

    @ElementCollection()
    private List<String> hobbies = new ArrayList();

    @ElementCollection(fetch = FetchType.LAZY)
    @MapKeyColumn(name = "PHONE")
    @Column(name = "Description")
    private Map<String, String> phones = new HashMap();
    
    

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }
    
    

    public CustomerType getCt()
    {
        return ct;
    }

    public void setCt(CustomerType ct)
    {
        this.ct = ct;
    }

    public void addHobby(String s)
    {
        hobbies.add(s);
    }

    public void addPhone(String phoneNo, String description)
    {
        phones.put(phoneNo, description);
    }

    public String getPhoneDesciption(String phoneNo)
    {
        String desc = "";
        if (phones.containsKey(phoneNo))
        {
            desc = phones.get(phoneNo);
        }
        return desc;
    }

    public String getHobbies()
    {
        String list = "";
        for (String s : hobbies)
        {
            list = list + s + ",";
        }
        return list;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer))
        {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.Customer[ id=" + id + " ]";
    }

}
