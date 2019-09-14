package com.sw.digital.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sw.digital.entity.GoodsSize;

public interface GoodsSizeDao {

	//根据商品Id获取商品大小
	@Select("SELECT gs_id,gs_size  FROM goodssize WHERE g_id=#{gid} ORDER BY gs_size")
	@Results({
		@Result(property="id",column="gs_id"),
		@Result(property="size",column="gs_size")
	})
	public List<GoodsSize> getGoodsSizeById(Integer gid);
	
	//更改商品大小
	@Update("UPDATE digital_mall.`goodssize` gs SET gs.`gs_size`=#{size} WHERE gs.`gs_id`=#{id}")
	public Integer updateGoodsSizeInfo(GoodsSize goodsSize);
	
	//添加商品大小
	@Insert("INSERT INTO digital_mall.`goodssize`(gs_size,g_id) VALUES(#{size},#{goods.id})")
	public Integer addGoodsSizeInfo(GoodsSize goodsSize);
}
