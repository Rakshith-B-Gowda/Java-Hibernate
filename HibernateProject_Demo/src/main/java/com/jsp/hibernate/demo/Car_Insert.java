package com.jsp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Car_Insert {
	public static void main(String[] args) {
		Car car = new Car();
		car.setCarId(102);
		car.setCarName("SVJ");
		car.setCarBrand("Lamborghini");
		car.setCarPrice(5.4);
		
		Car car2 = new Car();
		car2.setCarId(103);
		car2.setCarName("911 Gt3RS");
		car2.setCarBrand("Porsche");
		car2.setCarPrice(5.5);
		
		Configuration conn = new Configuration();
		conn.configure();
		conn.addAnnotatedClass(Car.class);
		SessionFactory sf = conn.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(car);
		session.save(car2);
		
		transaction.commit();
		session.close();
		sf.close();
	}
}
