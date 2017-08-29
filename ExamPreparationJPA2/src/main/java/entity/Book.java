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
public class Book implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isbn;
    
    private String title;
    
    private String author;
    
    private double price;
    
    @OneToOne
    private EBook eBook;
    
    @OneToOne
    private PaperBook paperBook;

    public Long getIsbn()
    {
        return isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public EBook geteBook()
    {
        return eBook;
    }

    public void seteBook(EBook eBook)
    {
        this.eBook = eBook;
    }

    public PaperBook getPaperBook()
    {
        return paperBook;
    }

    public void setPaperBook(PaperBook paperBook)
    {
        this.paperBook = paperBook;
    }

    
    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book))
        {
            return false;
        }
        Book other = (Book) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.Book[ id=" + isbn + " ]";
    }
    
}
