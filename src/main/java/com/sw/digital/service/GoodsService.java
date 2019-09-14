package com.sw.digital.service;

import java.util.List;

import com.sw.digital.entity.Goods;

public interface GoodsService {

	//获得所有商品信息
	public List<Goods> getAllGoods();
	
	//根据Id查询商品信息
	public Goods getGoodsById(String id);
	
	//更改商品数据
	public Integer updateGoodsInfo(Goods goods);
	
	//添加商品
	public Integer addGoodsInfo(Goods goods);
}
