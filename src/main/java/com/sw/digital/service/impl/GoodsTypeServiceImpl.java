package com.sw.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.digital.dao.GoodsTypeDao;
import com.sw.digital.entity.Type;
import com.sw.digital.service.GoodsTypeService;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

	@Autowired
	private GoodsTypeDao typeDao;
	
	@Override
	public List<Type> getAllType() {
		return typeDao.getAllType();
	}

}
