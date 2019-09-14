package com.sw.digital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sw.digital.entity.User;

/**
 * 
 * @author Kyle
 *
 */

@Mapper
public interface UserMapper {

	//查找数据，存到缓冲中，第二次不查数据库
	@Select("SELECT u.`id`,u.`username`,u.`password` FROM jwt.`user` u WHERE u.`id`=#{id}")
	public User getUserById(@Param("id")int id);
	
	//查询所有数据
	@Select("SELECT u.`id`,u.`username`,u.`password` FROM jwt.`user` u")
	public List<User> getUsers();
	
	//添加
	@Insert("INSERT INTO jwt.`user`(u_name,u_password) VALUES(#{username},#{password})")
	public int addUser(User user);
	
	//更新
	@Update("UPDATE jwt.`user` u SET u.`username`=#{username},u.`password`={password},u.`birthday`={birthday},u.`job`=#{job},u.`email`={email},u.`dname`=#{dname},u.`phone`=#{phone} WHERE u.`id`=#{id}")
	public int updateUser(User user);
	
	//登录
	@Select("SELECT u.`id`,u.`username`,u.`password` WHERE u.username=#{username},u.password=#{password}")
	public User loginUser(@Param("username")String username,@Param("password")String password);
	
	/**
	 * 删除
	 * 如果指定为 true，则方法调用后将立即清空所有缓存
	 */
	@Delete("DELETE FROM jwt.`user` WHERE id=#{id}")
	public int deleteUser(@Param("id")int id);
	
	
	
}
