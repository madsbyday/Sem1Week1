/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Address;
import entity.Book;
import entity.Customer;
import enums.CustomerType;
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
        test();
        
    }
    
    public static void test() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaex");
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
//        Book b1 = new Book();
//        b1.setTitle("ten nigger boys");
//        
//        Book b2 = new Book();
//        b2.setTitle("mein kampf");
//        
//        em.persist(b1);
//        em.persist(b2);
//
//        Customer c1 = new Customer();
//        c1.setCt(CustomerType.GOLD);
//        c1.addHobby("loligagging");
//        c1.addHobby("Vigilantism");
//        
//        c1.addPhone("20202030", "mah phone");
//        
//        em.persist(c1);

        Customer c2 = new Customer();
        c2.setCt(CustomerType.GOLD);
        
        Address a = new Address();
        a.setStreet("high road 1");
        a.setCity("new york");
        
        em.persist(a);
        
        c2.setAddress(a);
        
        em.persist(c2);
        
        em.getTransaction().commit();
        
    }
}
