package com.sw.digital.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sw.digital.entity.Admin;
import com.sw.digital.entity.User;
import com.sw.digital.repository.UserRepository;
import com.sw.digital.service.UserService;

/**
 * User控制器类
 * @author Kyle
 *
 */
@RestController
@RequestMapping("/auth")
public class UserController {

	
	@Autowired
    private UserRepository userRepository;


	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;



	//添加
	@RequestMapping(value = "/addAdmin" , method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody Map<String,String> registerUser){
		Admin admin = new Admin();
		admin.setName(registerUser.get("username"));
		//记得注册的时候进行加密
		admin.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
		admin.setRole("USER");
		//int a = userSvr.addUser(user);
		Admin a = userRepository.save(admin);
		System.out.println(a.toString());
		if(a!=null) {
			return new ResponseEntity<Admin>(a,HttpStatus.OK);
		}

		return new ResponseEntity<Admin>(new Admin(),HttpStatus.OK);
	}


	
	
	
}
