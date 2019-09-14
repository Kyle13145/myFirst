package com.sw.digital.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String name;
	private String describe;
	private Float price;
	private Integer count;
	private Merchant merchant;
	private Type type;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createtime;
	private Integer attract;
	private String state;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getAttract() {
		return attract;
	}
	public void setAttract(Integer attract) {
		this.attract = attract;
	}
	private List<GoodsImg> goodsImg = new ArrayList<GoodsImg>();
	
	private List<GoodsSize> goodsSize;
	
	private List<Comment> goodsComment;
	
	
	public List<Comment> getGoodsComment() {
		return goodsComment;
	}
	public void setGoodsComment(List<Comment> goodsComment) {
		this.goodsComment = goodsComment;
	}

	public List<GoodsSize> getGoodsSize() {
		return goodsSize;
	}
	public void setGoodsSize(List<GoodsSize> goodsSize) {
		this.goodsSize = goodsSize;
	}
	public List<GoodsImg> getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(List<GoodsImg> goodsImg) {
		this.goodsImg = goodsImg;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", describe=" + describe + ", price=" + price + ", count=" + count
				+ ", merchant=" + merchant + ", type=" + type + ", createtime=" + createtime + ", goodsImg=" + goodsImg
				+ "]";
	}
	
	
}
