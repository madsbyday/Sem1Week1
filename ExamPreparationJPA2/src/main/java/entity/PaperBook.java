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
 * @author Alexander
 */
@Entity
public class PaperBook extends Book implements Serializable {
    
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long isbn;

    public PaperBook(int shippingWeight, boolean inStock, long isbn, String title, String author, int price) {
        super(isbn, title, author, price);
        this.shippingWeight = shippingWeight;
        this.inStock = inStock;
    }

    public PaperBook(){
        
    }
    
    private int shippingWeight;

    public int getShippingWeight() {
        return shippingWeight;
    }

    public void setShippingWeight(int shippingWeight) {
        this.shippingWeight = shippingWeight;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
    
    private boolean inStock;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the isbn fields are not set
        if (!(object instanceof PaperBook)) {
            return false;
        }
        PaperBook other = (PaperBook) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PaperBook[ id=" + isbn + " ]";
    }
    
}
