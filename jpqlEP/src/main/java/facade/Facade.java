/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Semester;
import entity.Student;
import entity.Teacher;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author vfgya_000
 */
public class Facade implements FacadeInterface {

    @Override
    public List<Student> getAllStudents(EntityManager em) {
        List<Student> students;
        Query query = null;

        query = em.createQuery("SELECT s FROM Student s");
        students = query.getResultList();

        return students;
    }

    @Override
    public List<Student> getAllStudentsByName(EntityManager em, String name) {
        List<Student> students = null;

        Query query = null;

        query = em.createQuery("SELECT s FROM Student s WHERE s.firstname = '" + name + "'");
        students = (List<Student>) query.getResultList();

        return students;
    }

    @Override
    public Student InsertStudent(EntityManager em, String fname, String lname) {
        Student s = new Student();
        s.setFirstname(fname);
        s.setLastname(lname);
        
        em.persist(s);
        
        return s;
    }

    @Override
    public Student AssignStudent(EntityManager em, Student stu, long semid) {
        stu = em.find(Student.class, stu.getId());
        Semester s = em.find(Semester.class, semid);
        
        stu.setSemester(s);
        
        em.merge(stu);
        
        return stu;
    }

    @Override
    public List<Student> getAllStudentsByLastName(EntityManager em, String name) {
        List<Student> students = null;

        Query query = null;

        query = em.createQuery("SELECT s FROM Student s WHERE s.lastname = '" + name + "'");
        students = (List<Student>) query.getResultList();

        return students;
    }

    @Override
    public int numberOfStudentsBySemester(EntityManager em, String name) {
        int studentCount = 0;
        studentCount = ((Number)em.createQuery("SELECT COUNT(s) FROM Student s WHERE s.semester.name = '" + name + "'").getSingleResult()).intValue();
        return studentCount;
    }

    @Override
    public int numberOfStudents(EntityManager em) {
        int studentCount = 0;
        studentCount = ((Number)em.createQuery("SELECT COUNT(s) FROM Student s WHERE s.semester IS NOT NULL").getSingleResult()).intValue();
        return studentCount;
    }

    @Override
    public Teacher getTeacherByMostSemesters(EntityManager em) {
        Teacher t = new Teacher();
        Query query = em.createQuery("SELECT t FROM Teacher t");
        t.getSemesterCollection().size();
        
    }

}
