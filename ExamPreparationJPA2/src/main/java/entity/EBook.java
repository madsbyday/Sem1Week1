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
public class EBook extends Book implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long isbn;

    public EBook(String downloadUrl, int sizeMB, long isbn, String title, String author, int price) {
        super(isbn, title, author, price);
        this.downloadUrl = downloadUrl;
        this.sizeMB = sizeMB;
    }
    
    public EBook(){
        
    }

    private String downloadUrl;
    private int sizeMB;

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public int getSizeMB() {
        return sizeMB;
    }

    public void setSizeMB(int sizeMB) {
        this.sizeMB = sizeMB;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the isbn fields are not set
        if (!(object instanceof EBook)) {
            return false;
        }
        EBook other = (EBook) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EBoook[ id=" + isbn + " ]";
    }
    
}
