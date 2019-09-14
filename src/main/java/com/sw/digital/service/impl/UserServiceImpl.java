package com.sw.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.digital.dao.UserDao;
import com.sw.digital.entity.User;
import com.sw.digital.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User loginUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateUserInfo(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserDetailById(String id) {
		return userDao.getUserDetailById(id);
	}

	@Override
	public Integer updateUserDetailInfo(User user) {
		return userDao.updateUserDetailInfo(user);
	}

	@Override
	public Integer addUserDetailInfo(User user) {
		return userDao.addUserDetailInfo(user);
	}

}
