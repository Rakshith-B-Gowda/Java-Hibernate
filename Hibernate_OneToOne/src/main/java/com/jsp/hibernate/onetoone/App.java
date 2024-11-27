package com.jsp.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Person person = new Person();
    	person.setPersonId(102);
    	person.setPersonName("Rakshith");
    	
    	Aadhar aadhar = new Aadhar();
    	aadhar.setAadharId(2);
    	aadhar.setAadharNumber(633678633773L);
    	
    	// Adding Aadhar Obj inside Person Obj
    	person.setAadhar(aadhar);
    	
    	Configuration cfg = new Configuration()
    			.configure()
    			.addAnnotatedClass(Person.class)
    			.addAnnotatedClass(Aadhar.class);
    	
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	session.save(person);
    	session.save(aadhar);
    	
    	
    	tran.commit();
    	session.close();
    	sf.close();
    	
    }
}
