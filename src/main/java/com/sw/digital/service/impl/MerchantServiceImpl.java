package com.sw.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.digital.dao.MerchantDao;
import com.sw.digital.entity.Merchant;
import com.sw.digital.service.MerchantService;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private MerchantDao merchantDao;
	
	@Override
	public List<Merchant> getAllMerchant() {
		return merchantDao.getAllMerchant();
	}

	@Override
	public Integer addMerchantInfo(Merchant merchant) {
		return merchantDao.addMerchantInfo(merchant);
	}

	@Override
	public Merchant getMerchantById(String id) {
		return merchantDao.getMerchantById(id);
	}

	@Override
	public Integer updateMerchant(Merchant merchant) {
		return merchantDao.updateMerchant(merchant);
	}

}
