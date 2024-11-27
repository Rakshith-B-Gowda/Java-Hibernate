package com.jsp.hibernate.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
	
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carName=" + carName + ", carBrand=" + carBrand + ", carPrice=" + carPrice
				+ "]";
	}
	@Id
	private int carId;
	private String carName;
	private String carBrand;
	private double carPrice;
	
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public double getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}
	
	
}
