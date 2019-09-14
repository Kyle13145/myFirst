package com.sw.digital.entity;

import java.io.Serializable;

public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Order order;
	private Goods goods;
	private Integer count;
	private Float price;
	private Float size;
	
	
	public Float getSize() {
		return size;
	}
	public void setSize(Float size) {
		this.size = size;
	}
	
	
	
	@Override
	public String toString() {
		return "OrderDetail [order=" + order + ", goods=" + goods + ", count=" + count + ", price=" + price + ", size="
				+ size + "]";
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}

}
