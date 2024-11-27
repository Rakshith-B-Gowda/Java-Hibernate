package com.jsp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Car_Fetch {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Car.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		
		// 1. Returns null if the primary key doesn't exists.
		// 2. get() is Eager Loader -> Query is fired even if the object is not used.
		Car car = session.get(Car.class, 101);
		System.out.println(car);

		//1. Throws an Exception if the primary key doesn't exists.
		//2. load() is lazy Loaded -> Query is not fired if the object is not used in the code.
		Car car2 = session.load(Car.class, 101);
		System.out.println(car2);

		
		tran.commit();
		session.close();
		sf.close();
		
		
	}
}
