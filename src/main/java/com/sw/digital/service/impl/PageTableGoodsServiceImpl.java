package com.sw.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.digital.dao.PageTableDao;
import com.sw.digital.entity.Goods;
import com.sw.digital.service.PageTableService;

@Service
public class PageTableGoodsServiceImpl implements PageTableService<Goods> {

	@Autowired
	private PageTableDao<Goods> pageTableDao;
	
	@Override
	public List<Goods> queryAllObjectData(int page, int limit, String keyWord) {
		page=(page-1)*limit;
		return pageTableDao.queryAllGoodsData(page, limit, keyWord);
	}

	@Override
	public Integer queryAllObjectCount(String keyWord) {
		return pageTableDao.queryAllGoodsCount(keyWord);
	}

}
