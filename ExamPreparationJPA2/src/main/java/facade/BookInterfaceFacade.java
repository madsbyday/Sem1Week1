/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Book;
import entity.EBook;
import entity.PaperBook;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alexander
 */
public class BookInterfaceFacade implements BookInterface {
    
    private EntityManagerFactory emf;
    
    public BookInterfaceFacade(EntityManagerFactory emf) {
        this.emf = emf; 
    }
    
    @Override
    public Book createBook(Book b) {
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(b);
            em.getTransaction().commit();
            return b;
        }
        finally {
            em.close();
        }
    }

    @Override
    public Book findBook(long isbn) {
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            Book b = em.find(Book.class, isbn);
            em.getTransaction().commit();
            return b;
       }
        finally {
            em.close();
        }
    }

    @Override
    public Book deleteBook(long isbn) {
         EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Book b = em.find(Book.class, isbn); 
            if( b != null)
            {
                em.remove(b);
            }
            em.getTransaction().commit();
            return b;
        }
        finally
        {
            em.close();
        }
    }

    @Override
    public Book updateBook(Book b, long isbn) {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Book book = em.find(Book.class, isbn);
            if( book != null)
            {
                em.merge(b);
            }
            em.getTransaction().commit();
            return book;
        }
        finally
        {
            em.close();
        }
    }

    
}
