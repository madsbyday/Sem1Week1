/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpactrl;

import entity.Customer;
import facade.Facade;
import facade.FacadeInterface;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vfgya_000
 */
public class Tester {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpql4");
        
        FacadeInterface fi = new Facade(emf);
        
        // fi.createEmploye(1, "Anderson", "Neo", "x5600", "enter@matrix.net", "The One");
        // fi.updateCustomer(121, "Naugty ltm.", "Hitler", "Adolf", "9999999", "Kehlsteinhaus", "Berchtesgaden", "Germany");
        
        // System.out.println(fi.getEmployeCount());
        
        List<Customer> clist = fi.getCustomerInCity("Nantes");
        
        for (Customer c : clist){
            System.out.println(c.getCustomerName());
        }
    }
    
}
