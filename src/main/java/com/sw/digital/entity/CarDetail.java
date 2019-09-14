package com.sw.digital.entity;

import java.io.Serializable;

public class CarDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ShoppingCar shoppingCar;
	private Goods goods;
	private Integer gCount;
	private Float gPrice;
	
	
	
	public ShoppingCar getShoppingCar() {
		return shoppingCar;
	}



	public void setShppingCar(ShoppingCar shoppingCar) {
		this.shoppingCar = shoppingCar;
	}



	public Goods getGoods() {
		return goods;
	}



	public void setGoods(Goods goods) {
		this.goods = goods;
	}



	public Integer getgCount() {
		return gCount;
	}



	public void setgCount(Integer gCount) {
		this.gCount = gCount;
	}



	public Float getgPrice() {
		return gPrice;
	}



	public void setgPrice(Float gPrice) {
		this.gPrice = gPrice;
	}



	@Override
	public String toString() {
		return "CarDetail [shoppingCar=" + shoppingCar + ", goods=" + goods + ", gCount=" + gCount + ", gPrice="
				+ gPrice + "]";
	}



	
	
	

	
}
