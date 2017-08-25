/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpactrl;

import entity.Student;
import facade.Facade;
import facade.FacadeInterface;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vfgya_000
 */
public class Tester {

    static FacadeInterface fi = new Facade();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpql");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Student> allStudents = fi.getAllStudents(em);
        List<Student> studentsByName = fi.getAllStudentsByName(em, "Anders");
        List<Student> studentsByLastName = fi.getAllStudentsByLastName(em, "And");

        for (Student s : studentsByLastName) {
            System.out.println(s.getFirstname() + " " + s.getLastname());
        }
        
        // System.out.println(fi.numberOfStudentsBySemester(em, "CLcos-v14e"));
        
        System.out.println(fi.numberOfStudents(em));

        // insertAndAssignStudentTest(em);
        
        em.getTransaction().commit();
        em.close();
    }

    public static void insertAndAssignStudentTest(EntityManager em) {
        Student s1 = fi.InsertStudent(em, "Lorne", "Malvo");
        em.getTransaction().commit();

        em.getTransaction().begin();

        fi.AssignStudent(em, s1, 2);
    }

}
