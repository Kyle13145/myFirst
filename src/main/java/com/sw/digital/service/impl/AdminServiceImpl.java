package com.sw.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.digital.dao.AdminDao;
import com.sw.digital.entity.Admin;
import com.sw.digital.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public Admin getAdminByName(String name) {
		return adminDao.getAdminByName(name);
	}

	@Override
	public List<Admin> getAdminIsMerchant() {
		return adminDao.getAdminIsMerchant();
	}

	@Override
	public Admin getAdminById(String id) {
		return adminDao.getAdminById(id);
	}

	@Override
	public Integer updateAdminInfo(Admin admin) {
		return adminDao.updateAdminInfo(admin);
	}

	@Override
	public Integer addAdminInfo(Admin admin) {
		return adminDao.addAdminInfo(admin);
	}

}
