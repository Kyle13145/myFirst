package com.sw.digital.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sw.digital.entity.Admin;

public interface AdminDao {
	
	//根据管理员的名称获得管理员信息或者商家信息
	@Select("SELECT a.`a_id`,a.`a_name`,a.`a_role`,a.`a_icon`,a.`a_state` FROM admin a WHERE a.`a_name`=#{name}")
	@Results({
		@Result(property="id",column="a_id"),
		@Result(property="name",column="a_name"),
		@Result(property="role",column="a_role"),
		@Result(property="icon",column="a_icon"),
		@Result(property="state",column="a_state"),
	})
	public Admin getAdminByName(String name);
	
	//查找所有是商家的管理员
	@Select("SELECT a.`a_id`,a.`a_name`,a.`a_role`,a.`a_icon`,a.`a_state` FROM admin a WHERE a.`a_role`='USER' AND a.`a_state`='2'")
	@Results({
		@Result(property="id",column="a_id"),
		@Result(property="name",column="a_name"),
		@Result(property="role",column="a_role"),
		@Result(property="icon",column="a_icon"),
		@Result(property="state",column="a_state"),
	})
	public List<Admin> getAdminIsMerchant();
	
	//根据Id查找是商家的管理员
	@Select("SELECT a.`a_id`,a.`a_name`,a.`a_role`,a.`a_icon`,a.`a_state` FROM admin a WHERE a.`a_role`='USER' AND a.`a_state`='2' AND a.`a_id`=#{id}")
	@Results({
		@Result(property="id",column="a_id"),
		@Result(property="name",column="a_name"),
		@Result(property="role",column="a_role"),
		@Result(property="icon",column="a_icon"),
		@Result(property="state",column="a_state"),
	})
	public Admin getAdminByIdIsMerchant(String id);
	
	//根据Id查询管理员信息
	@Select("SELECT a.`a_id`,a.`a_name`,a.`a_role`,a.`a_icon`,a.`a_state`,a.`a_createtime` FROM admin a WHERE a.`a_id`=#{id}")
	@Results({
		@Result(property="id",column="a_id"),
		@Result(property="name",column="a_name"),
		@Result(property="role",column="a_role"),
		@Result(property="createtime",column="a_createtime"),
		@Result(property="icon",column="a_icon"),
		@Result(property="state",column="a_state"),
	})
	public Admin getAdminById(String id);
	
	//更新管理员信息
	@Update("UPDATE digital_mall.`admin` SET a_name=#{name},a_role=#{role},a_icon=#{icon},a_state=#{state} WHERE a_id=#{id}")
	public Integer updateAdminInfo(Admin admin);
	
	//添加管理员信息
	@Insert("INSERT INTO admin(a_name,a_role,a_createtime,a_password,a_icon,a_state) VALUES(#{name},#{role},#{createtime},#{password},#{icon},#{state})")
	public Integer addAdminInfo(Admin admin);
}
