package com.sw.digital.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sw.digital.entity.TableEntity;
import com.sw.digital.entity.User;
import com.sw.digital.service.PageTableService;
import com.sw.digital.service.UserService;

@RestController
@RequestMapping("/tasks/any")
public class UserInfoController {
	
	
	@Autowired
	private PageTableService<User> pageTableSvr;
	
	@Autowired
	private UserService userSvr;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/**
	 * 分页
	 * 获取用户所有信息
	 */
	@RequestMapping(value = "/getAllUserLimit",method=RequestMethod.GET)
	public ResponseEntity<?> getAllMerchantByPage(
			@RequestParam(required=false,defaultValue="1") int page,
			@RequestParam(required=false,defaultValue="15") int limit,
			String keyWord){
		//封装用户数据
		TableEntity<User> userData = new TableEntity<User>();
		int count = pageTableSvr.queryAllObjectCount(keyWord);
		List<User> user = pageTableSvr.queryAllObjectData(page, limit, keyWord);
		userData.setCode(0);
		userData.setCount(count);
		userData.setData(user);
		userData.setMsg("success");
		return new ResponseEntity<>(userData,HttpStatus.OK);

	}
	
	//获得用户详细信息
	@RequestMapping(value = "/getUserDetail",method=RequestMethod.GET)
	public ResponseEntity<?> getUserDetailInfo(@RequestParam("uid")String id){
		User user = userSvr.getUserDetailById(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	//更新用户详细信息
	@RequestMapping(value = "/updateUserDetail",method=RequestMethod.POST)
	public ResponseEntity<?> updateUserDetailInfo(@RequestBody User user){
		int a = userSvr.updateUserDetailInfo(user);
		if(a>0) {
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.OK);
		}
	}
	
	//添加用户详细信息
	@RequestMapping(value = "/addUserDetail",method=RequestMethod.PUT)
	public ResponseEntity<?> addUserDetailInfo(@RequestBody User user){
		user.setCreatetime(new Date());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		int a = userSvr.addUserDetailInfo(user);
		if(a>0) {
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.OK);
		}
	}

}
