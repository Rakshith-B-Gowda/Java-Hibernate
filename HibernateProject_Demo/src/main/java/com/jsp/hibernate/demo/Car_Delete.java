package com.jsp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Car_Delete {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Car.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		// Fetch
		Car car = session.get(Car.class, 101);
		
		// Delete
		session.delete(car);
		
		tran.commit();
		session.close();
		sf.close();
		
		
	}
}
