package com.sw.digital.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sw.digital.entity.Admin;
import com.sw.digital.service.AdminService;
import com.sw.digital.utils.JwtTokenUtils;

/**
 * 获取用户信息
 * @author Kyle
 *
 */

@RestController
@RequestMapping("/AdminInfo")
public class InfoController {

	@Autowired
	private AdminService adminSvr;
	
	//获得管理员信息
	@RequestMapping("/getAdminInfoByName")
	public ResponseEntity<?> getAdminInfo(HttpServletRequest request) {
		String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
		String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX, "");
        String username = JwtTokenUtils.getUsername(token);
        System.out.println(username);
        Admin admin = adminSvr.getAdminByName(username);
        System.out.println(admin);
        return new ResponseEntity<>(admin,HttpStatus.OK);
	}
	
}
