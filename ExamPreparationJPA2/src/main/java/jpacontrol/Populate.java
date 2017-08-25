/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontrol;

import entity.Book;
import entity.EBook;
import entity.PaperBook;
import facade.BookInterface;
import facade.BookInterfaceFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alexander
 */
public class Populate {
    public static void main(String[] args) {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        BookInterface bi = new BookInterfaceFacade(emf);
 
        Book b1 = new Book(1, "Harry Potter 1", "J.K. Rolling", 75);
        EBook eb1 = new EBook("www.thepiratebay.org", 223, 2, b1.getTitle(), b1.getAuthor(), b1.getPrice());
        PaperBook pb1 = new PaperBook(0, true, 3, b1.getTitle(), b1.getAuthor(), b1.getPrice());
        EBook eb2 = new EBook("www.legalBookDownLoad.com", 223, 2, b1.getTitle(), b1.getAuthor(), b1.getPrice());
        Book b2 = new Book(5, "Illigal Book 1", "The Bad guy", 7500);
        
       bi.createBook(b1);
       bi.createBook(eb1);
       bi.createBook(pb1);
       bi.createBook(b2);
       
       bi.updateBook(eb2, 2);
       
       bi.findBook(2);
       
       bi.deleteBook(5);
        
       em.getTransaction().commit();
        
       em.close();
   }   
        
       
    
}
