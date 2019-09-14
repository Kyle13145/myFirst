package com.sw.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.digital.dao.PageTableDao;
import com.sw.digital.entity.Merchant;
import com.sw.digital.service.PageTableService;


@Service
public class PageTableMerchantServiceImpl implements PageTableService<Merchant> {

	@Autowired
	private PageTableDao<Merchant> pageTableDao;
	
	@Override
	public List<Merchant> queryAllObjectData(int page, int limit, String keyWord) {
		page=(page-1)*limit;
		return pageTableDao.queryAllMerchantData(page, limit, keyWord);
	}

	@Override
	public Integer queryAllObjectCount(String keyWord) {
		return pageTableDao.queryAllMerchantCount(keyWord);
	}

}
