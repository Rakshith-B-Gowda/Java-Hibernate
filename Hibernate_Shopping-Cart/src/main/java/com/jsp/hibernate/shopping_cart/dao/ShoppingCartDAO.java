package com.jsp.hibernate.shopping_cart.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate.shopping_cart.entity.Cart;
import com.jsp.hibernate.shopping_cart.entity.Product;
import com.jsp.hibernate.shopping_cart.entity.User;

public class ShoppingCartDAO {
	
	public static Session getSession() {
		
		SessionFactory sf = new Configuration()
				.configure()
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Cart.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		Session session = sf.openSession();
		
		return session;	
	}

	
	public void addProduct(Scanner scanner) {
		Product product = new Product();
		System.out.println("Enter Product ID : ");
		product.setProductId(scanner.nextInt());
		System.out.println("Enter Product Name :");
		product.setProductName(scanner.next());
		System.out.println("Enter Product Brand :");
		product.setProductBrand(scanner.next());
		System.out.println("Enter Product Price :");
		product.setProductPrice(scanner.nextInt());
		System.out.println();
			
		Session session = getSession();
		Transaction tran = session.beginTransaction();
		
		session.save(product);
		
		tran.commit();
		session.close();	
	}

	
	public void addUserWithCart(Scanner scanner) {
		User user = new User();
		System.out.println("Enter User ID :");
		user.setUserId(scanner.nextInt());
		System.out.println("Enter User Name :");
		user.setUserName(scanner.next());
		System.out.println("Enter User Email :");
		user.setUserEmail(scanner.next());
		System.out.println("Enter User Age :");
		user.setUserAge(scanner.nextInt());
		System.out.println("Enter User City :");
		user.setUserCity(scanner.next());
		System.out.println();
		
		Cart cart = new Cart();
		System.out.println("Enter Cart ID :");
		cart.setCartId(scanner.nextInt());
		
		user.setCart(cart);
		
		Session session = getSession();
		Transaction tran = session.beginTransaction();
		
		session.save(cart);
		session.save(user);
		
		tran.commit();
		session.close();
	}

	
	public void addProductToCart(Scanner scanner) {
		System.out.println("Enter the Product ID :");
		int productId = scanner.nextInt();
		
		Session session = getSession();
		Transaction tran = session.beginTransaction();
		
		Product product = session.get(Product.class, productId);
		
		if (product != null) {
			System.out.println("Enter the User ID :");
			User user = session.get(User.class, scanner.nextInt());
			if (user != null) {
				Cart cart = user.getCart();
				
				cart.getProducts().add(product);
				
				session.update(cart);
				
			} else {
				System.err.println("User Not Found!!");
			}
		} else {
			System.err.println("Product Not Found!!");
		}
		
		tran.commit();
		session.close();
	}
	
	
	public void removeProductFromCart(Scanner scanner) {
		System.out.println("Enter the User ID from which Product Should be Removed :");
		int userId = scanner.nextInt();
		
		Session session = getSession();
		Transaction tran = session.beginTransaction();
		
		User user = session.get(User.class, userId);
		
		if (user != null) {
			Cart cart = user.getCart();
			
			System.out.println("Enter the Product ID to be Removed :");
			int productId = scanner.nextInt();
			Product product = session.get(Product.class, productId);
			
			if (product != null) {
				cart.getProducts().remove(product);
				
				session.update(cart);
				
			} else {
				System.err.println("Product Not Found!!");
			}
			
		} else {
			System.err.println("User Not Found!!");
		}
		
		tran.commit();
		session.close();
	}

	
	public void findAllProductFromCart(Scanner scanner) {
		System.out.println("Enter the User ID :");
		int userId = scanner.nextInt();
		
		
		Session session = getSession();
		Transaction tran = session.beginTransaction();
		
		User user = session.get(User.class, userId);
		if (user != null) {
			Cart cart = user.getCart();
			for (Product products : cart.getProducts()) {
				System.out.println(products);
				System.out.println();
			}
		} else {
			System.err.println("User Not Found!!");
		}
		
		tran.commit();
		session.close();
		
		
	}
	
}

	






















