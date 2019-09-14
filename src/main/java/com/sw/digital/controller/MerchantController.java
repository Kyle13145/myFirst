package com.sw.digital.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sw.digital.entity.Merchant;
import com.sw.digital.entity.TableEntity;
import com.sw.digital.service.MerchantService;
import com.sw.digital.service.PageTableService;

@RestController
@RequestMapping("/tasks/any")
public class MerchantController {

	@Autowired
	private PageTableService<Merchant> pageTableSvr;
	
	@Autowired
	private MerchantService merchantSvr;
	
	/**
	 * 分页
	 * 获取商家所有信息
	 */
	@RequestMapping(value = "/getAllMerchantLimit",method=RequestMethod.GET)
	public ResponseEntity<?> getAllMerchantByPage(
			@RequestParam(required=false,defaultValue="1") int page,
			@RequestParam(required=false,defaultValue="15") int limit,
			String keyWord){
		//封装商品数据
		TableEntity<Merchant> goodsData = new TableEntity<Merchant>();
		int count = pageTableSvr.queryAllObjectCount(keyWord);
		List<Merchant> goods = pageTableSvr.queryAllObjectData(page, limit, keyWord);
		goodsData.setCode(0);
		goodsData.setCount(count);
		goodsData.setData(goods);
		goodsData.setMsg("success");
		return new ResponseEntity<>(goodsData,HttpStatus.OK);

	}
	
	//添加商家信息
	@RequestMapping(value = "/addMerchantInfo",method=RequestMethod.PUT)
	public ResponseEntity<?> addMerchant(@RequestBody Merchant merchant){
		merchant.setCreatetime(new Date());
		int a = merchantSvr.addMerchantInfo(merchant);
		TableEntity<Merchant> msg = new TableEntity<Merchant>();
		if(a>0) {
			msg.setMsg("success");
			msg.setCode(0);
			return new ResponseEntity<>(msg,HttpStatus.OK);
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	//根据Id获取商家信息
	@RequestMapping(value = "/getMerchanBytId",method=RequestMethod.GET)
	public ResponseEntity<?> getMerchanInfotId(@RequestParam("id")String id){
		Merchant merchant = merchantSvr.getMerchantById(id);
		//System.out.println(merchant);
		return new ResponseEntity<>(merchant,HttpStatus.OK);
	}
	
	
	//更新商家信息
	@RequestMapping(value = "/updateMerchant",method=RequestMethod.POST)
	public ResponseEntity<?> updateMerchantInfo(@RequestBody Merchant merchant){
		System.out.println(merchant);
		int a = merchantSvr.updateMerchant(merchant);
		if(a>0) {
			return new ResponseEntity<>(merchant,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.OK);
		}
		
	}
}
