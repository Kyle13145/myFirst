package com.sw.digital.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sw.digital.entity.GoodsImg;

public interface GoodsImgDao {

	//根据商品Id获得商品图片
	@Select("SELECT gi_id,gi_src,g_id FROM goodsimg WHERE g_id=#{gid}")
	@Results({
		@Result(property="id",column="gi_id"),
		@Result(property="src",column="gi_src")
	})
	public List<GoodsImg> getBoodsImgByGoodsId(Integer gid);
	
	//更改商品图片信息
	@Update("UPDATE digital_mall.`goodsimg` gs SET gs.`gi_src`=#{src} WHERE gs.`gi_id` = #{id}")
	public Integer updateGoodsImgInfo(GoodsImg goodsImg);
	
	//添加商品图片
	@Insert("INSERT INTO digital_mall.`goodsimg`(gi_src,g_id) VALUES(#{src},#{goods.id})")
	public Integer addGoodsImgInfo(GoodsImg goodsImg);
}
