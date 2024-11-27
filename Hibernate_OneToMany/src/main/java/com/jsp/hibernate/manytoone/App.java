package com.jsp.hibernate.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Company company = new Company();
    	company.setCompanyId(1);
    	company.setCompanyName("Zomato");
    	
    	Employee employee1 = new Employee();
    	employee1.setEmployeeId(101);
    	employee1.setEmployeeName("Rakshith");
    	employee1.setEmployeeSalary(55000);
    	
    	Employee employee2 = new Employee();
    	employee2.setEmployeeId(102);
    	employee2.setEmployeeName("Prajwal");
    	employee2.setEmployeeSalary(35000);
    	
    	Employee employee3 = new Employee();
    	employee3.setEmployeeId(103);
    	employee3.setEmployeeName("Rehman");
    	employee3.setEmployeeSalary(25000);
    	
    	employee1.setCompany(company);
    	employee2.setCompany(company);
    	employee3.setCompany(company);
    	
    	Configuration cfg = new Configuration()
    			.configure()
    			.addAnnotatedClass(Employee.class)
    			.addAnnotatedClass(Company.class);
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	session.save(company);
    	session.save(employee1);
    	session.save(employee2);
    	session.save(employee3);
    	
    	tran.commit();
    	session.close();
    	sf.close();
    	
    }
}
