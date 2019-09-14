package com.sw.digital.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Comment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String detial;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date date;
	private Integer service;
	private Integer speed;
	private Integer gdescribe;
	private User user;
	private Goods goods;
	private String state;
	
	
	
	
	
	
	public String getState() {
		return state;
	}





	public void setState(String state) {
		this.state = state;
	}





	public Goods getGoods() {
		return goods;
	}





	public void setGoods(Goods goods) {
		this.goods = goods;
	}





	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public String getDetial() {
		return detial;
	}





	public void setDetial(String detial) {
		this.detial = detial;
	}





	public Date getDate() {
		return date;
	}





	public void setDate(Date date) {
		this.date = date;
	}





	public Integer getService() {
		return service;
	}





	public void setService(Integer service) {
		this.service = service;
	}





	public Integer getSpeed() {
		return speed;
	}





	public void setSpeed(Integer speed) {
		this.speed = speed;
	}





	public Integer getGdescribe() {
		return gdescribe;
	}





	public void setGdescribe(Integer gdescribe) {
		this.gdescribe = gdescribe;
	}





	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
	}




	
	
	
}
