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

/**
 *
 * @author vfgya
 */
public interface FacadeInteface
{
    // CRUD Book
    public Book createBook(EntityManager em, String title, String author, double price, EBook eb, PaperBook pb);
    public Book getBook(EntityManager em, long isbn);
    public Book updateBook(EntityManager em, long isbn, String title, String author, double price, EBook eb, PaperBook pb);
    public void removeBook(EntityManager em, long isbn);
    
    // CRUD PaperBook
    public PaperBook createPaperBook(EntityManager em, int weight, int stock, long bid);
    public PaperBook getPaperBook(EntityManager em, long id);
    public PaperBook updatePaperBook(EntityManager em, long id, int weight, int stock, long bid);
    public void removePaperBook(EntityManager em, long isbn);
    
    // CRUD EBook
    public EBook createEbook(EntityManager em , String downl, int size, long bid);
    public EBook getEbook(EntityManager em, long id);
    public EBook updateEbook(EntityManager em, long id, String downl, int size, long bid);
    public void removeEbook(EntityManager em, long id);
    
    
}
