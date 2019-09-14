package com.sw.digital.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sw.digital.entity.Goods;
import com.sw.digital.entity.GoodsImg;
import com.sw.digital.entity.GoodsSize;
import com.sw.digital.entity.Merchant;
import com.sw.digital.entity.TableEntity;
import com.sw.digital.entity.Type;
import com.sw.digital.service.GoodsImgService;
import com.sw.digital.service.GoodsService;
import com.sw.digital.service.GoodsSizeService;
import com.sw.digital.service.GoodsTypeService;
import com.sw.digital.service.MerchantService;
import com.sw.digital.service.PageTableService;

@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsSvr;

	@Autowired
	private PageTableService<Goods> pageTableSvr;

	@Autowired
	private GoodsSizeService goodsSizeSvr;
	@Autowired
	private GoodsImgService goodsImgSvr;
	@Autowired
	private MerchantService merchantSvr;
	@Autowired
	private GoodsTypeService goodsTypeSvr;

	//获取所有商品信息
	@RequestMapping(value = "/getAllGoods",method=RequestMethod.GET)
	public ResponseEntity<?> getAllGoodsInfo(){
		//封装商品数据
		TableEntity<Goods> goodsData = new TableEntity<Goods>();
		List<Goods> goods = goodsSvr.getAllGoods();
		goodsData.setCode(0);
		goodsData.setCount(goods.size());
		goodsData.setData(goods);
		goodsData.setMsg("success");
		return new ResponseEntity<>(goodsData,HttpStatus.OK);
	}

	/*
	 * 获取所有商品信息
	 * 进行分页模糊查询
	 */
	@RequestMapping(value = "/getAllGoodsLimit",method=RequestMethod.GET)
	public ResponseEntity<?> getAllGoodsInfoLimit(
			@RequestParam(required=false,defaultValue="1") int page,
			@RequestParam(required=false,defaultValue="15") int limit,
			String keyWord){
		//封装商品数据
		TableEntity<Goods> goodsData = new TableEntity<Goods>();
		int count = pageTableSvr.queryAllObjectCount(keyWord);
		List<Goods> goods = pageTableSvr.queryAllObjectData(page, limit, keyWord);
		goodsData.setCode(0);
		goodsData.setCount(count);
		goodsData.setData(goods);
		goodsData.setMsg("success");
		return new ResponseEntity<>(goodsData,HttpStatus.OK);
	}

	//根据Id获取商品信息
	@RequestMapping(value = "/getGoodsById",method=RequestMethod.GET)
	public ResponseEntity<?> getGoodsById(@RequestParam("id")String id){
		Goods goods = goodsSvr.getGoodsById(id);
		return new ResponseEntity<>(goods,HttpStatus.OK);
	}

	//更商品相关的数据
	@RequestMapping(value = "/updateGoodsInfo",method=RequestMethod.POST)
	public ResponseEntity<?> updateGoods(@RequestBody Goods goods){
		boolean flag = true;
		//更改商品大小
		List<GoodsSize> sizeList = goods.getGoodsSize();
		if(sizeList!=null) {
			for (GoodsSize goodsSize : sizeList) {
				int ret = goodsSizeSvr.updateGoodsSizeInfo(goodsSize);
				if(ret<0) {
					flag=false;
				}
			}
		}

		//更改商品图片
		List<GoodsImg> imgList = goods.getGoodsImg();
		if(imgList!=null) {
			for (GoodsImg goodsImg : imgList) {
				int ret = goodsImgSvr.updateGoodsImgInfo(goodsImg);
				if(ret<0) {
					flag=false;
				}
			}
		}
		
		//更商品信息
		int a = goodsSvr.updateGoodsInfo(goods);
		
		if(a<0) {
			flag=false;
		}

		TableEntity<Goods> tab = new TableEntity<Goods>();
		
		if(flag) {
			tab.setMsg("success");
			tab.setCode(0);
			return new ResponseEntity<>(tab,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.OK);
		}
	}
	
	//获取所有商家和所有类型
	@RequestMapping(value = "/getGoodsMerchantAndTyoe",method=RequestMethod.GET)
	public ResponseEntity<?> getMerchantAndTyoe(){
		List<Type> type = goodsTypeSvr.getAllType();
		List<Merchant> merchant = merchantSvr.getAllMerchant();
		Map<String,Object> obj = new HashMap<String,Object>();
		obj.put("type", type);
		obj.put("merchant", merchant);
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
	
	//添加商品
	@RequestMapping(value = "/addGoods",method=RequestMethod.PUT)
	public ResponseEntity<?> addGoodsInfo(@RequestBody Goods goods){
		//添加商品信息
		
		goods.setCreatetime(new Date());
		int a = goodsSvr.addGoodsInfo(goods);
		System.out.println(goods);
		if(a>0) {
			Goods g = new Goods();
			g.setId(goods.getId());
			//添加商品图片
			List<GoodsImg> goodsImgList = goods.getGoodsImg();
			for (GoodsImg goodsImg : goodsImgList) {
				goodsImg.setGoods(g);
				goodsImgSvr.addGoodsImgInfo(goodsImg);
			}
			
			//添加商品大小
			List<GoodsSize> goodsSizeList = goods.getGoodsSize();
			for (GoodsSize goodsSize : goodsSizeList) {
				goodsSize.setGoods(g);
				goodsSizeSvr.addGoodsSizeInfo(goodsSize);
			}
		}
		return new ResponseEntity<>(goods,HttpStatus.OK);
	}
}
