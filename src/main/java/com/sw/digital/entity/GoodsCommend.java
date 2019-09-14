package com.sw.digital.entity;

import java.io.Serializable;

public class GoodsCommend implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Goods goods;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "GoodsCommend [id=" + id + ", goods=" + goods + "]";
	}
	
	
	

}
