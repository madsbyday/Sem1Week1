/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpactrl;

import facade.Facade;
import facade.FacadeInteface;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vfgya
 */
public class Tester
{
    public static void main(String[] args)
    {
        FacadeInteface fi = new Facade();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaem2");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        // fi.createBook(em, "The master of sunshine", "H.P. Lovecraft", 200.00, null, null);
        
        // System.out.println(fi.getBook(em, 1).getTitle());
        
        // fi.updateBook(em, 1, "The master of darkness", "P.H Hatecraft", 250.00, null, null);
        
        
        // fi.removeBook(em, 1);
        
        //fi.createPaperBook(em, 20, 30, 1);
        
        // fi.createEbook(em, "wuddup", 20, 1);
        
        em.getTransaction().commit();
        
        em.close();
    }
    
    
    
    
}
