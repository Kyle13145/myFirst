package com.sw.digital.repository;

import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.CrudRepository;

import com.sw.digital.entity.Admin;

/**
 * 根据用户名获取用户
 * @author Kyle
 *
 */

public interface UserRepository extends CrudRepository<Admin, Integer> {

	@Select("SELECT a_id,a_name,a_password,a_role FROM digital_mall.`admin` WHERE a_name=#{name}")
	public Admin findByName(String name);
}


