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

import com.sw.digital.entity.Admin;
import com.sw.digital.entity.TableEntity;
import com.sw.digital.service.AdminService;
import com.sw.digital.service.PageTableService;

@RestController
@RequestMapping("/tasks/role")
public class AdminInfoController {

	@Autowired
	private PageTableService<Admin> pageTableSvr;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private AdminService adminSvr;
	
	/**
	 * 管理员信息分页
	 * 获取所有管理员信息
	 */
	@RequestMapping(value = "/getAllAdminLimit",method=RequestMethod.GET)
	public ResponseEntity<?> getAllMerchantByPage(
			@RequestParam(required=false,defaultValue="1") int page,
			@RequestParam(required=false,defaultValue="15") int limit,
			String keyWord){
		//封装商品数据
		TableEntity<Admin> adminData = new TableEntity<Admin>();
		int count = pageTableSvr.queryAllObjectCount(keyWord);
		List<Admin> admin = pageTableSvr.queryAllObjectData(page, limit, keyWord);
		
		adminData.setCode(0);
		adminData.setCount(count);
		adminData.setData(admin);
		adminData.setMsg("success");
		System.out.println(adminData);
		return new ResponseEntity<TableEntity<Admin>>(adminData,HttpStatus.OK);

	}
	
	
	//根据查询管理员信息
	@RequestMapping(value = "/getAllAdminById",method=RequestMethod.GET)
	public ResponseEntity<?> getAllAdminByIds(@RequestParam("aid")String aid){
		Admin admin = adminSvr.getAdminById(aid);
		return new ResponseEntity<>(admin,HttpStatus.OK);
	}
	
	//更新管理员信息
	@RequestMapping(value = "/updateAdminInfo",method=RequestMethod.POST)
	public ResponseEntity<?> updateAdminInfos(@RequestBody Admin admin){
		int a = adminSvr.updateAdminInfo(admin);
		if(a>0) {
			return new ResponseEntity<>(admin,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
	//添加管理员信息
	@RequestMapping(value = "/addAdminInfo",method=RequestMethod.PUT)
	public  ResponseEntity<?> addAdminInfos(@RequestBody Admin admin){
		//加密密码
		admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
		admin.setCreatetime(new Date());
		int a = adminSvr.addAdminInfo(admin);
		if(a>0) {
			return new ResponseEntity<>(admin,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
}
