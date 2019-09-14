package com.sw.digital.service;

import java.util.List;

public interface PageTableService <T>{

	public List<T> queryAllObjectData(int page,int limit,String keyWord);
	
	public Integer queryAllObjectCount(String keyWord);
}
