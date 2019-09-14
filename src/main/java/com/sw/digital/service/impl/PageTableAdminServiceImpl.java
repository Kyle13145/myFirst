package com.sw.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.digital.dao.PageTableDao;
import com.sw.digital.entity.Admin;
import com.sw.digital.service.PageTableService;

@Service
public class PageTableAdminServiceImpl implements PageTableService<Admin> {

	@Autowired
	private PageTableDao<Admin> pageTableDao;
	
	@Override
	public List<Admin> queryAllObjectData(int page, int limit, String keyWord) {
		page=(page-1)*limit;
		return pageTableDao.queryAllAdminData(page, limit, keyWord);
	}

	@Override
	public Integer queryAllObjectCount(String keyWord) {
		return pageTableDao.queryAllAdminCount(keyWord);
	}

}
