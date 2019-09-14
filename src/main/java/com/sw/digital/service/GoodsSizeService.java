package com.sw.digital.service;

import com.sw.digital.entity.GoodsSize;

public interface GoodsSizeService {

	//更改商品大小
	public Integer updateGoodsSizeInfo(GoodsSize goodsSize);
	
	//添加商品大小
	public Integer addGoodsSizeInfo(GoodsSize goodsSize);
	
}
