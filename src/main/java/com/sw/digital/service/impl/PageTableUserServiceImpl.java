package com.sw.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.digital.dao.PageTableDao;
import com.sw.digital.entity.User;
import com.sw.digital.service.PageTableService;

@Service
public class PageTableUserServiceImpl implements PageTableService<User> {

	@Autowired
	private PageTableDao<User> pageTableDao;
	
	@Override
	public List<User> queryAllObjectData(int page, int limit, String keyWord) {
		page=(page-1)*limit;
		return pageTableDao.queryAllUserData(page, limit, keyWord);
	}

	@Override
	public Integer queryAllObjectCount(String keyWord) {
		return pageTableDao.queryAllUserCount(keyWord);
	}

}
