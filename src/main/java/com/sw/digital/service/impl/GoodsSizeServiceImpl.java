package com.sw.digital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.digital.dao.GoodsSizeDao;
import com.sw.digital.entity.GoodsSize;
import com.sw.digital.service.GoodsSizeService;

@Service
public class GoodsSizeServiceImpl implements GoodsSizeService {

	@Autowired
	private GoodsSizeDao goodsSizeDao;
	
	@Override
	public Integer updateGoodsSizeInfo(GoodsSize goodsSize) {
		// TODO Auto-generated method stub
		return goodsSizeDao.updateGoodsSizeInfo(goodsSize);
	}

	@Override
	public Integer addGoodsSizeInfo(GoodsSize goodsSize) {
		return  goodsSizeDao.addGoodsSizeInfo(goodsSize);
	}

}
