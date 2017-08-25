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

/**
 *
 * @author vfgya_000
 */
public interface Interface {
    
    public Customer createCustomer(EntityManager em, String name, String email);
    public Customer findCustomer(EntityManager em, long i);
    public Collection<Customer> getAllCustomers(EntityManager em);
    public CustomerOrder createOrder(EntityManager em, Customer c);
    public CustomerOrder findOrder(EntityManager em, long id);
    public ItemType createItemType(EntityManager em, String name, String desc, double price);
    public OrderLine createOrderLine(EntityManager em, CustomerOrder co, ItemType it, int q);
     
}
