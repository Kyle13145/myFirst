package com.sw.digital.entity;

import java.io.Serializable;

public class ShoppingCar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CarDetail carDetail;
	private User user;
	private Float price;
	public CarDetail getCarDetail() {
		return carDetail;
	}
	public void setCarDetail(CarDetail carDetail) {
		this.carDetail = carDetail;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ShoppingCar [carDetail=" + carDetail + ", user=" + user + ", price=" + price + "]";
	}
	
	

}
