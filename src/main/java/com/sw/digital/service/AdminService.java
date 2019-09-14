package com.sw.digital.service;

import java.util.List;

import com.sw.digital.entity.Admin;

public interface AdminService {

	//根据管理员的名称获得管理员信息或者商家信息
	public Admin getAdminByName(String name);
	
	//查找所有是商家的用户
	public List<Admin> getAdminIsMerchant();
	
	public Admin getAdminById(String id);
	
	public Integer updateAdminInfo(Admin admin);
	
	public Integer addAdminInfo(Admin admin);
}
