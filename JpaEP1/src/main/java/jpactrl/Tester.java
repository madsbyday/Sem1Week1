/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpactrl;

import entity.Customer;
import entity.ItemType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author vfgya_000
 */
public class Tester {

    public static void main(String[] args) {
        Interface i = new Facade();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaep1");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
//        i.createCustomer(em, "Hans", "hans@yolo.com");
//        i.createCustomer(em, "Lorne", "malvo@fargocity.com");
//        i.findCustomer(em, 1);
//
//          i.createOrder(em, i.createCustomer(em, "hans", "hans@gmail.com"));
//          
//          i.findOrder(em, 2);

            Customer c1 = new Customer();
            c1.setName("hans");
            c1.setEmail("hans@gmail.com");
            
            ItemType it1 = new ItemType();
            it1.setName("Digoman");
            it1.setDescription("like pokamns but better");
            it1.setPrice(250.00);
            
            em.persist(c1);
            em.persist(it1);
         
            em.persist(i.createOrderLine(em, i.createOrder(em, c1), it1, 2));

//        i.getAllCustomers(em);
        
        em.getTransaction().commit();
        
        em.close();

    }

}
