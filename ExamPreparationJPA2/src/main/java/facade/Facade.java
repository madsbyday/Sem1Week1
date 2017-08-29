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
public class Facade implements FacadeInteface
{

    @Override
    public Book createBook(EntityManager em, String title, String author, double price, EBook eb, PaperBook pb)
    {
        Book b = new Book();
        b.setTitle(title);
        b.setAuthor(author);
        b.setPrice(price);
        b.seteBook(eb);
        b.setPaperBook(pb);

        em.persist(b);

        return b;
    }

    @Override
    public Book getBook(EntityManager em, long isbn)
    {
        Book b = em.find(Book.class, isbn);

        return b;
    }

    @Override
    public Book updateBook(EntityManager em, long isbn, String title, String author, double price, EBook eb, PaperBook pb)
    {
        Book b = em.find(Book.class, isbn);

        b.setTitle(title);
        b.setAuthor(author);
        b.setPrice(price);
        b.seteBook(eb);
        b.setPaperBook(pb);

        em.merge(b);

        return b;
    }

    @Override
    public void removeBook(EntityManager em, long isbn)
    {
        Book b = em.find(Book.class, isbn);
        PaperBook pb = null;
        EBook eb = null;

        // Errorhandlingen virker ikke!!!
        try
        {
            pb = em.find(PaperBook.class, b.getPaperBook().getId());
            eb = em.find(EBook.class, b.getPaperBook().getId());

            if (eb != null || pb != null)
            {
                em.remove(pb);
                em.remove(eb);
            }
        } catch (Exception ex)
        {
            
        }
        finally {
            em.remove(b);
        }
    }

    @Override
    public PaperBook createPaperBook(EntityManager em, int weight, int stock, long bid)
    {
        PaperBook pb = new PaperBook();
        Book b = em.find(Book.class, bid);

        pb.setInStock(stock);
        pb.setShippingWieght(weight);
        b.setPaperBook(pb);

        em.persist(pb);

        return pb;
    }

    @Override
    public PaperBook getPaperBook(EntityManager em, long id)
    {
        PaperBook pb = em.find(PaperBook.class, id);

        return pb;
    }

    @Override
    public PaperBook updatePaperBook(EntityManager em, long id, int weight, int stock, long bid)
    {
        PaperBook pb = em.find(PaperBook.class, id);
        Book b = em.find(Book.class, bid);

        pb.setInStock(stock);
        pb.setShippingWieght(weight);
        b.setPaperBook(pb);

        em.merge(pb);

        return pb;
    }

    @Override
    public void removePaperBook(EntityManager em, long isbn)
    {
        PaperBook pb = em.find(PaperBook.class, isbn);

        em.remove(pb);
    }

    @Override
    public EBook createEbook(EntityManager em, String downl, int size, long bid)
    {
        EBook eb = new EBook();
        Book b = em.find(Book.class, bid);

        eb.setDownloadUrl(downl);
        eb.setSizeMB(size);
        b.seteBook(eb);

        em.persist(eb);

        return eb;
    }

    @Override
    public EBook getEbook(EntityManager em, long id)
    {
        EBook eb = em.find(EBook.class, id);

        return eb;
    }

    @Override
    public EBook updateEbook(EntityManager em, long id, String downl, int size, long bid)
    {
        EBook eb = em.find(EBook.class, id);
        Book b = em.find(Book.class, bid);

        eb.setDownloadUrl(downl);
        eb.setSizeMB(size);
        b.seteBook(eb);

        em.merge(eb);

        return eb;
    }

    @Override
    public void removeEbook(EntityManager em, long id)
    {
        EBook eb = em.find(EBook.class, id);

        em.remove(eb);
    }

}
