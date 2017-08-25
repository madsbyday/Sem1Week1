/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpactrl;

import entity.Customer;
import entity.CustomerOrder;
import entity.ItemType;
import entity.OrderLine;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author vfgya_000
 */
public class Facade implements jpactrl.Interface{

    @Override
    public Customer createCustomer(EntityManager em, String name, String email) {
        Customer c = new Customer();
        c.setName(name);
        c.setEmail(email);
        em.persist(c);    
        
        return c;
    }

    @Override
    public Customer findCustomer(EntityManager em, long i) {
        Customer c = em.find(Customer.class, i);
        return c;
    }

    @Override
    public Collection<Customer> getAllCustomers(EntityManager em) {
        Query query = em.createQuery("SELECT c FROM Customer c");
        return (Collection<Customer>) query.getResultList();
    }

    @Override
    public CustomerOrder createOrder(EntityManager em, Customer c) {
        CustomerOrder co = new CustomerOrder();
        co.setCustomer(c);
        
        em.persist(co);
        
        return co;
    }

    @Override
    public CustomerOrder findOrder(EntityManager em, long id) {
        CustomerOrder co = em.find(CustomerOrder.class, id);
        return co;
    }

    @Override
    public ItemType createItemType(EntityManager em, String name, String desc, double price) {
        ItemType it = new ItemType();
        it.setName(name);
        it.setDescription(desc);
        it.setPrice(price);
        
        em.persist(it);
        
        return it;
    }

    @Override
    public OrderLine createOrderLine(EntityManager em, CustomerOrder co, ItemType it, int q) {
        OrderLine ol = new OrderLine();
        ol.setCOrder(co);
        ol.setItemType(it);
        ol.setQuantity(q);
        
        em.persist(ol);
        
        return ol;
    }
    
    

    
}
