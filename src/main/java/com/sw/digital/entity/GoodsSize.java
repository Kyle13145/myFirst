package com.sw.digital.entity;

import java.io.Serializable;

public class GoodsSize implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Float size;
	private Goods goods;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getSize() {
		return size;
	}
	public void setSize(Float size) {
		this.size = size;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "GoodsSize [id=" + id + ", size=" + size + ", goods=" + goods + "]";
	}
	
	
	

	
}
