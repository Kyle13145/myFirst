package com.sw.digital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.digital.dao.GoodsImgDao;
import com.sw.digital.entity.GoodsImg;
import com.sw.digital.service.GoodsImgService;

@Service
public class GoodsImgServiceimpl implements GoodsImgService {

	@Autowired
	private GoodsImgDao goodsImgDao;
	
	@Override
	public Integer updateGoodsImgInfo(GoodsImg goodsImg) {
		// TODO Auto-generated method stub
		return goodsImgDao.updateGoodsImgInfo(goodsImg);
	}

	@Override
	public Integer addGoodsImgInfo(GoodsImg goodsImg) {
		return goodsImgDao.addGoodsImgInfo(goodsImg);
	}

}
