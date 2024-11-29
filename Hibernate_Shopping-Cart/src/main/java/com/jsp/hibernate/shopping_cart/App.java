package com.jsp.hibernate.shopping_cart;

import java.util.Scanner;

import com.jsp.hibernate.shopping_cart.dao.ShoppingCartDAO;

public class App {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			
			System.out.println("-----------");
			System.out.println("1. ADD PRODUCT");
			System.out.println("2. ADD USER");
			System.out.println("3. ADD PRODUCT TO CART");
			System.out.println("4. REMOVE PRODUCT FROM CART");
			System.out.println("5. FIND ALL PRODUCT FROM CART");
			System.out.println("6. EXIT");
			System.out.println("ENTER YOUR CHOICE : ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				new ShoppingCartDAO().addProduct(scanner);
				break;

			case 2:
				new ShoppingCartDAO().addUserWithCart(scanner);
				break;

			case 3:
				new ShoppingCartDAO().addProductToCart(scanner);
				break;

			case 4:
				new ShoppingCartDAO().removeProductFromCart(scanner);
				break;

			case 5:
				new ShoppingCartDAO().findAllProductFromCart(scanner);
				break;

			case 6:
				scanner.close();
				System.out.println("Existed...");
				System.exit(0);

			default:
				System.out.println("InValid Choice!!");
				break;
			}
		}
	}
}
