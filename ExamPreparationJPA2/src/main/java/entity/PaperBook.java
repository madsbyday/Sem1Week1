/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author vfgya
 */
@Entity
public class PaperBook implements Serializable
{

    @OneToOne(mappedBy = "paperBook")
    private Book book;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int shippingWieght;
    
    private int inStock;
    

    public Long getId()
    {
        return id;
    }

    public Book getBook()
    {
        return book;
    }

    public void setBook(Book book)
    {
        this.book = book;
    }

    
    
    public int getShippingWieght()
    {
        return shippingWieght;
    }

    public void setShippingWieght(int shippingWieght)
    {
        this.shippingWieght = shippingWieght;
    }

    public int getInStock()
    {
        return inStock;
    }

    public void setInStock(int inStock)
    {
        this.inStock = inStock;
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
        if (!(object instanceof PaperBook))
        {
            return false;
        }
        PaperBook other = (PaperBook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.PaperBook[ id=" + id + " ]";
    }
    
}
