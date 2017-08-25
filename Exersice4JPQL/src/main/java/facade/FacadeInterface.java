/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Customer;
import entity.Employee;
import java.util.List;

/**
 *
 * @author vfgya_000
 */
public interface FacadeInterface {
    public Employee createEmploye(int enr, String lastname, String firstname, String extension, String mail, String jtitle);
    public Customer updateCustomer(int cnr, String name, String clastname, String cfirstname, String phone, String addressline1, String city, String country);
    public int getEmployeCount();
    public List<Customer> getCustomerInCity(String city);
}
