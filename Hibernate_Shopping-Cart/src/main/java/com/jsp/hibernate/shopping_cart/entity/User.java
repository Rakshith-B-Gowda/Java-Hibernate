package com.jsp.hibernate.shopping_cart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	private int userId;
	private String userName;
	private String userEmail;
	private int userAge;
	private String userCity;
	
	@OneToOne
	private Cart cart;

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public int getUserAge() {
		return userAge;
	}

	public String getUserCity() {
		return userCity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
}
