package com.sw.digital.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sw.digital.entity.User;

public interface UserDao {

	//根据用户名获取用户信息
	@Select("SELECT u.`u_id`,u.`u_name`,u.`u_nickname`,u.`u_mail`,u.`u_birth`,u.`u_phone`,u.`u_sex`,u.`u_icon` FROM digital_mall.`user` u WHERE u.`u_name`=#{name}")
	@Results({
		@Result(property="id",column="u_id"),
		@Result(property="username",column="u_name"),
		@Result(property="nickname",column="u_nickname"),
		@Result(property="mail",column="u_mail"),
		@Result(property="birth",column="u_birth"),
		@Result(property="phone",column="u_phone"),
		@Result(property="sex",column="u_sex"),
		@Result(property="icon",column="u_icon")
	})
	public User getUserByName(String name);

	//根据Id查询用户信息
	@Select("SELECT u.`u_id`,u.`u_name`,u.`u_nickname`,u.`u_mail`,u.`u_birth`,u.`u_phone`,u.`u_sex`,u.`u_icon` FROM digital_mall.`user` u WHERE u.`u_id`=#{id}")
	@Results({
		@Result(property="id",column="u_id"),
		@Result(property="username",column="u_name"),
		@Result(property="nickname",column="u_nickname"),
		@Result(property="mail",column="u_mail"),
		@Result(property="birth",column="u_birth"),
		@Result(property="phone",column="u_phone"),
		@Result(property="sex",column="u_sex"),
		@Result(property="icon",column="u_icon")
	})
	public User getUserById(String id);

	//修改用户信息
	@Update("UPDATE digital_mall.`user` SET u_nickname=#{nickname},u_mail=#{mail},u_birth=#{birth},u_phone=#{phone},u_sex=#{sex},u_icon=#{icon} WHERE u_id=#{id}")
	public Integer updateUserInfo(User user);

	//根据Id查询用户详细信息
	@Select("SELECT u.`u_id`,u.`u_name`,u.`u_nickname`,u.`u_mail`,u.`u_birth`,u.`u_phone`,u.`u_sex`,u.`u_createtime`,u.`u_role`,u.`u_icon`,u.`u_state` FROM digital_mall.`user` u WHERE u.`u_id`=#{id}")
	@Results({
		@Result(property="id",column="u_id"),
		@Result(property="username",column="u_name"),
		@Result(property="role",column="u_role"),
		@Result(property="nickname",column="u_nickname"),
		@Result(property="mail",column="u_mail"),
		@Result(property="birth",column="u_birth"),
		@Result(property="phone",column="u_phone"),
		@Result(property="sex",column="u_sex"),
		@Result(property="createtime",column="u_createtime"),
		@Result(property="icon",column="u_icon"),
		@Result(property="state",column="u_state")
	})
	public User getUserDetailById(String id);
	
	//更新用户详细数据
	@Update("UPDATE digital_mall.`user` SET  u_name=#{username},u_role=#{role},u_nickname=#{nickname},u_mail=#{mail},u_birth=#{birth},u_phone=#{phone},u_sex=#{sex},u_icon=#{icon},u_state=#{state} WHERE u_id=#{id}")
	public Integer updateUserDetailInfo(User user);
	
	//添加用户详细信息
	@Insert("INSERT INTO digital_mall.`user`(u_name,u_nickname,u_mail,u_birth,u_phone,u_sex,u_createtime,u_password,u_role,u_icon,u_state) VALUES (#{username},#{nickname},#{mail},#{birth},#{phone},#{sex},#{createtime},#{password},#{role},#{icon},#{state})")
	public Integer addUserDetailInfo(User user);
	
}
