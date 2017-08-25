/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Customer;
import entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author vfgya_000
 */
public class Facade implements FacadeInterface {

    private EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Employee createEmploye(int enr, String lastname, String firstname, String extension, String mail, String jtitle) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Employee e = new Employee(enr, lastname, firstname, extension, mail, jtitle);

            em.persist(e);

            em.getTransaction().commit();

            return e;
        } finally {
            em.close();
        }
    }

    @Override
    public Customer updateCustomer(int cnr, String name, String clastname, String cfirstname, String phone, String addressline1, String city, String country) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            
            Customer c = em.find(Customer.class, cnr);
            
            c.setCustomerName(name);
            c.setContactLastName(clastname);
            c.setContactFirstName(cfirstname);
            c.setPhone(phone);
            c.setAddressLine1(addressline1);
            c.setCity(city);
            c.setCountry(country);
            
            em.merge(c);
            
            em.getTransaction().commit();
            
            return c;
        }
        finally {
            em.close();
        }
    }

    @Override
    public int getEmployeCount() {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            
            int employeCount = 0;
            employeCount = ((Number)em.createQuery("SELECT COUNT(e) FROM Employee e").getSingleResult()).intValue();
            em.getTransaction().commit();
            return employeCount;
        }
        finally {
            em.close();
        }
    }

    @Override
    public List<Customer> getCustomerInCity(String city) {
        EntityManager em = emf.createEntityManager();
        
        List<Customer> customers = null;
        
        Query query = null;
        
        try {
            em.getTransaction().begin();
            
            query = em.createQuery("SELECT c FROM Customer c WHERE c.city = '" + city + "'");
            customers = (List<Customer>)query.getResultList();
            
            return customers;
        }
        finally {
            em.close();
        }
    }

}
