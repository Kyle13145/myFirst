package com.sw.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.digital.dao.GoodsDao;
import com.sw.digital.entity.Goods;
import com.sw.digital.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public List<Goods> getAllGoods() {
		return goodsDao.getAllGoods();
	}

	@Override
	public Goods getGoodsById(String id) {
		return goodsDao.getGoodsById(id);
	}

	@Override
	public Integer updateGoodsInfo(Goods goods) {
		return goodsDao.updateGoodsInfo(goods);
	}

	@Override
	public Integer addGoodsInfo(Goods goods) {
		return goodsDao.addGoodsInfo(goods);
	}

}
