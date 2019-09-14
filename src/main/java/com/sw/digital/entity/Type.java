package com.sw.digital.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Type implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	public List<TypeDetial> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<TypeDetial> typeList) {
		this.typeList = typeList;
	}
	private List<TypeDetial> typeList = new ArrayList<TypeDetial>();
	
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
	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + "]";
	}
	

}
