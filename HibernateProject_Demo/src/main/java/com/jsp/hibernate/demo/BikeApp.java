package com.jsp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BikeApp 
{
    public static void main( String[] args )
    {
    	Bike bike = new Bike();
    	bike.setBikeId(102);
    	bike.setBikeModel("RSV4");
    	bike.setBikeBrand("Aprilia");
    	bike.setBikePrice(35);
    	
    	Configuration config = new Configuration();
    	config.configure();
    	config.addAnnotatedClass(Bike.class);
    	SessionFactory sessionFactory = config.buildSessionFactory();
    	Session session = sessionFactory.openSession();
    	Transaction transaction = session.beginTransaction();
    	
    	session.save(bike);    	
    	
    	transaction.commit();
    	session.close();
    	sessionFactory.close();
    	
    }
}
