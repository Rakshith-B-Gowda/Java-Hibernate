package com.jsp.hibernate.employee.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate.employee.entity.Employee;

public class EmployeeDAO {
	
	public static Session getSession() {
		Configuration cfg = new Configuration();
		cfg.configure("employee.cgf.xml");
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}
	
	public void addEmployee(Scanner scanner) {
		
		Employee employee = new Employee();
		System.out.println("Enter Employee Id, Name, Email, Age, Description, Salary :");
		employee.setEmployeeId(scanner.nextInt());
		employee.setEmployeeName(scanner.next());
		scanner.nextLine();
		employee.setEmployeeEmail(scanner.next());
		scanner.nextLine();
		employee.setEmployeeAge(scanner.nextInt());
		employee.setEmployeeDesc(scanner.next());
		scanner.nextLine();
		employee.setEmployeeSalary(scanner.nextInt());


		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(employee);
		
		transaction.commit();
		session.close();
	}
	
	public void findEmployeeById(Scanner scanner) {

		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println("Enter the Employee ID: ");
		int employeeId = scanner.nextInt();
		
		Employee employee = session.get(Employee.class, employeeId);
		System.out.println(employee);
		
		transaction.commit();
		session.close();
	}
	
	public void updateEmployeeDescAndSalaryById(Scanner scanner) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println("Enter the Employee ID to Update : ");
		int employeeId = scanner.nextInt();
		
		Employee employee = session.load(Employee.class, employeeId);
		
		System.out.println("Enter New Description : ");
		employee.setEmployeeDesc(scanner.next());  
		System.out.println("Enter New Salary : ");
		employee.setEmployeeSalary(scanner.nextInt());
		
		session.update(employee);
		
		transaction.commit();
		session.close();
	}
	
	public void deleteEmployeeById(Scanner scanner) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println("Enter the Employee ID: ");
		int employeeId = scanner.nextInt();
		
		Employee employee = session.load(Employee.class, employeeId);
		
		session.delete(employee);
		
		transaction.commit();
		session.close();
	}
}




















