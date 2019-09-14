package com.sw.digital.entity;

import java.io.Serializable;
import java.util.List;

public class AddrTab implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer code;
	private String message;
	private Integer count;
	private List<ReceiveAddr> data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<ReceiveAddr> getData() {
		return data;
	}
	public void setData(List<ReceiveAddr> data) {
		this.data = data;
	}
	
	
	
}
