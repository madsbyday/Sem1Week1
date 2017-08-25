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

/**
 *
 * @author vfgya_000
 */
public interface FacadeInterface {
    // queries
    public List<Student> getAllStudents(EntityManager em);
    public List<Student> getAllStudentsByName(EntityManager em, String name);
    public List<Student> getAllStudentsByLastName(EntityManager em, String name);
    public int numberOfStudentsBySemester(EntityManager em, String name);
    public int numberOfStudents(EntityManager em);
    public Teacher getTeacherByMostSemesters(EntityManager em);
    
    
    // CRUD
    public Student InsertStudent(EntityManager em, String fname, String lname);
    public Student AssignStudent(EntityManager em, Student stu, long semid);
}
