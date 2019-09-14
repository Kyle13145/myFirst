package com.sw.digital.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sw.digital.entity.Type;

public interface GoodsTypeDao {

	//查询所有商品类型以及商品详情
	@Select("SELECT t.`t_id`,t.`t_name` FROM digital_mall.`type` t ORDER BY t.`t_id` DESC")
	@Results({
		@Result(property="id",column="t_id"),
		@Result(property="name",column="t_name"),
	})
	public List<Type> getAllType();

}
