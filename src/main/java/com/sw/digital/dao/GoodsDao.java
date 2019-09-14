package com.sw.digital.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sw.digital.entity.Goods;

public interface GoodsDao {

	//查找所有商品信息
	@Select("SELECT g.`g_id`,g.`g_name`,g.`g_describe`,g.`g_price`,g.`g_count`,g.`g_attract`,g.`g_state`,g.`g_merchant` FROM goods g ORDER BY g.`g_id` DESC;")
	@Results({
		@Result(property="id",column="g_id"),
		@Result(property="name",column="g_name"),
		@Result(property="describe",column="g_describe"),
		@Result(property="price",column="g_price"),
		@Result(property="count",column="g_count"),
		@Result(property="attract",column="g_attract"),
		@Result(property="state",column="g_state"),
		@Result(property="goodsSize",column="g_id",
			many=@Many(select="com.sw.digital.dao.GoodsSizeDao.getGoodsSizeById")
		),
		@Result(property="goodsImg",column="g_id",
		many=@Many(select="com.sw.digital.dao.GoodsImgDao.getBoodsImgByGoodsId")
		),
		@Result(property="merchant",column="g_merchant",
		many=@Many(select="com.sw.digital.dao.MerchantDao.getMerchantByGoodsId")
		)
	})
	public List<Goods> getAllGoods();
	
	
	//根据Id查询商品信息
	@Select("SELECT g.`g_id`,g.`g_name`,g.`g_describe`,g.`g_price`,g.`g_count`,g.`g_attract`,g.`g_state`,g.`g_merchant` FROM goods g WHERE g.`g_id`=#{id}")
	@Results({
		@Result(property="id",column="g_id"),
		@Result(property="name",column="g_name"),
		@Result(property="describe",column="g_describe"),
		@Result(property="price",column="g_price"),
		@Result(property="count",column="g_count"),
		@Result(property="attract",column="g_attract"),
		@Result(property="state",column="g_state"),
		@Result(property="goodsSize",column="g_id",
			many=@Many(select="com.sw.digital.dao.GoodsSizeDao.getGoodsSizeById")
		),
		@Result(property="goodsImg",column="g_id",
		many=@Many(select="com.sw.digital.dao.GoodsImgDao.getBoodsImgByGoodsId")
		),
		@Result(property="merchant",column="g_merchant",
		many=@Many(select="com.sw.digital.dao.MerchantDao.getMerchantByGoodsId")
		)
	})
	public Goods getGoodsById(String id);
	
	/*
	 * 根据Id查询商品信息不包括商品其他信息
	 */
	@Select("SELECT g.`g_id`,g.`g_name`,g.`g_describe`,g.`g_price`,g.`g_count`,g.`g_attract`,g.`g_state`,g.`g_merchant` FROM goods g WHERE g.`g_id`=#{id} ")
	@Results({
		@Result(property="id",column="g_id"),
		@Result(property="name",column="g_name"),
		@Result(property="describe",column="g_describe"),
		@Result(property="price",column="g_price"),
		@Result(property="count",column="g_count"),
		@Result(property="attract",column="g_attract"),
		@Result(property="state",column="g_state")
	})
	public Goods getGoodsByIdSimple(String id);
	
	//更改商品数据
	@Update("UPDATE digital_mall.`goods` g SET g.`g_name`=#{name},g.`g_describe`=#{describe},g.`g_price`=#{price},g.`g_count`=#{count},g.`g_attract`=#{attract},g.`g_state`=#{state} WHERE g.`g_id`=#{id}")
	public Integer updateGoodsInfo(Goods goods);
	
	//添加商品信息
	@Insert("INSERT INTO digital_mall.`goods`(g_name,g_describe,g_price,g_count,g_merchant,t_id,g_createtime,g_attract,g_state) VALUES(#{name},#{describe},#{price},#{count},#{merchant.id},#{type.id},#{createtime},#{attract},#{state})")
	@Options(useGeneratedKeys=true, keyProperty="id",keyColumn="g_id")
	public Integer addGoodsInfo(Goods goods);
}
