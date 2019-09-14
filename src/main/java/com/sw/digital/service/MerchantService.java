package com.sw.digital.service;

import java.util.List;

import com.sw.digital.entity.Merchant;

public interface MerchantService {

	public List<Merchant> getAllMerchant();
	
	//添加商家信息
	public Integer addMerchantInfo(Merchant merchant);
	
	//根据Id获得商家信息
	public Merchant getMerchantById(String id);
	
	//更新商家数据
	public Integer updateMerchant(Merchant merchant);
	
}
