package com.sw.digital.service;

import com.sw.digital.entity.GoodsImg;

public interface GoodsImgService {

	//更改商品图片信息
	public Integer updateGoodsImgInfo(GoodsImg goodsImg);
	
	//添加商品图片
	public Integer addGoodsImgInfo(GoodsImg goodsImg);
}
