package com.jsp.hibernate.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Student student1 = new Student();
    	student1.setStudentId(101);
    	student1.setStudentName("Rakshith");
    	
    	Student student2 = new Student();
    	student2.setStudentId(102);
    	student2.setStudentName("Prajwal");
    	
    	Course course1 = new Course();
    	course1.setCourseId(1);
    	course1.setCourseName("Java Full Stack");
    	course1.setCourseFee(34999);
    	
    	Course course2 = new Course();
    	course2.setCourseId(2);
    	course2.setCourseName("Mern Stack");
    	course2.setCourseFee(24999);
    	
    	// Adding Course to Student
    	List<Course> cList = new ArrayList<Course>();
    	cList.add(course1);
    	cList.add(course2);
    	student1.setCourses(cList);
    	student2.setCourses(cList);
    	
    	// Adding Students to Courses
//    	List<Student> sList = new ArrayList<Student>();
//    	sList.add(student1);
//    	sList.add(student2);
//    	course1.setStudents(sList);
//    	course2.setStudents(sList);
    	
    	SessionFactory sf = new Configuration().configure()
    			.addAnnotatedClass(Course.class)
    			.addAnnotatedClass(Student.class)
    			.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	session.save(student1);
    	session.save(student2);
    	session.save(course1);
    	session.save(course2);
    	
    	tran.commit();
    	session.close();
    	sf.close();
    	
    }
}
