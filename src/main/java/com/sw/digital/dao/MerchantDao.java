package com.sw.digital.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sw.digital.entity.Merchant;

public interface MerchantDao {

	//根据商品id获取商家信息
	@Select("SELECT m.`m_id`,m.`m_name`,m.`m_describe`,m.`m_createtime`,m.`m_addr`,m.`m_shopkeeper`,m.`m_state` FROM merchant m WHERE m.`m_id`=#{id}")
	@Results({
		@Result(property="id",column="m_id"),
		@Result(property="name",column="m_name"),
		@Result(property="describe",column="m_describe"),
		@Result(property="createtime",column="m_createtime"),
		@Result(property="addr",column="m_addr"),
		@Result(property="shopkeeper",column="m_shopkeeper"),
		@Result(property="state",column="m_state")
	})
	public Merchant getMerchantByGoodsId(Integer id);
	
	//获取所有商家信息
	@Select("SELECT m.`m_id`,m.`m_name`,m.`m_describe`,m.`m_createtime`,m.`m_addr`,m.`m_shopkeeper`,m.`m_state` FROM merchant m")
	@Results({
		@Result(property="id",column="m_id"),
		@Result(property="name",column="m_name"),
		@Result(property="describe",column="m_describe"),
		@Result(property="createtime",column="m_createtime"),
		@Result(property="addr",column="m_addr"),
		@Result(property="shopkeeper",column="m_shopkeeper"),
		@Result(property="state",column="m_state")
	})
	public List<Merchant> getAllMerchant();
	
	
	//添加商家信息
	@Insert("INSERT INTO digital_mall.`merchant`(m_name,m_describe,m_createtime,m_addr,m_shopkeeper,a_id) VALUES(#{name},#{describe},#{createtime},#{addr},#{shopkeeper},#{admin.id})")
	public Integer addMerchantInfo(Merchant merchant);
	
	//根据Id获取商家信息
	@Select("SELECT m.`m_id`,m.`m_name`,m.`m_describe`,m.`m_createtime`,m.`m_addr`,m.`m_shopkeeper`,m.`m_state`,m.`a_id` FROM merchant m WHERE m.`m_id`=#{id}")
	@Results({
		@Result(property="id",column="m_id"),
		@Result(property="name",column="m_name"),
		@Result(property="describe",column="m_describe"),
		@Result(property="createtime",column="m_createtime"),
		@Result(property="addr",column="m_addr"),
		@Result(property="shopkeeper",column="m_shopkeeper"),
		@Result(property="state",column="m_state"),
		@Result(property="admin",column="a_id",
		one=@One(select="com.sw.digital.dao.AdminDao.getAdminByIdIsMerchant")
		)
	})
	public Merchant getMerchantById(String id);
	
	//更新商家数据
	@Update("UPDATE merchant SET m_name=#{name},m_describe=#{describe},m_addr=#{addr},m_shopkeeper=#{shopkeeper},m_state=#{state},a_id=#{admin.id} WHERE m_id=#{id}")
	public Integer updateMerchant(Merchant merchant);
	
}
