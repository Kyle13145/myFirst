package com.sw.digital.entity;

import java.io.Serializable;

public class IndexHeadGoods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String src;
	private Integer gid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	@Override
	public String toString() {
		return "IndexHeadGoods [id=" + id + ", src=" + src + ", gid=" + gid + "]";
	}
	
	
	
	
}
