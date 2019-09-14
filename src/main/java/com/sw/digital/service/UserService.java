package com.sw.digital.service;

import java.util.List;

import com.sw.digital.entity.User;

public interface UserService {

	//查找数据，存到缓冲中，第二次不查数据库
	public User getUserById(int id);
	
	//查询所有数据
	public List<User> getUsers();
	
	//添加
	public int addUser(User user);
	
	//更新
	public int updateUser(User user);
	
	/**
	 * 删除
	 * 如果指定为 true，则方法调用后将立即清空所有缓存
	 */
	public int deleteUser(int id);
	
	//登录
	public User loginUser(String username,String password);
	
	
	//根据用户名查询用户信息
	public User getUserByName(String name);
	
	//更新用户信息
	public Integer updateUserInfo(User user);
	
	//获得用户详细信息
	public User getUserDetailById(String id);
	
	//更新用户详细信息
	public Integer updateUserDetailInfo(User user);
	
	//添加用户详细信息
	public Integer addUserDetailInfo(User user);
}
