package com.sw.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sw.digital.entity.Admin;
import com.sw.digital.entity.TableEntity;
import com.sw.digital.service.AdminService;

@RestController
@RequestMapping("/tasks/any")
public class AdminConotroller {

	@Autowired
	private AdminService adminSvr;
	
	//获取所有是商家的用户
	@RequestMapping(value = "/getAdminIsMerchant",method=RequestMethod.GET)
	public ResponseEntity<?> getAllMerchant(){
		List<Admin> merchants = adminSvr.getAdminIsMerchant();
		TableEntity<Admin> msg = new TableEntity<Admin>();
		if(merchants!=null) {
			msg.setMsg("success");
			msg.setCode(0);
			msg.setData(merchants);
			return new ResponseEntity<>(msg,HttpStatus.OK);
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
}
