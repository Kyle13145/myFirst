package com.sw.digital.dao;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sw.digital.entity.Comment;

public interface CommentDao {
	
	//根据Id查询评论信息
	@Select("SELECT c_id,c_detial,c_date,c_service,c_speed,c_gdescribe,u_id,g_id,c_state FROM digital_mall.`comment` c WHERE c_id=#{id}")
	@Results({
		@Result(property="id",column="c_id"),
		@Result(property="detial",column="c_detial"),
		@Result(property="date",column="c_date"),
		@Result(property="service",column="c_service"),
		@Result(property="speed",column="c_speed"),
		@Result(property="gdescribe",column="c_gdescribe"),
		@Result(property="state",column="c_state"),
		@Result(property="user",column="u_id",
				one=@One(select="com.sw.digital.dao.UserDao.getUserDetailById")
		),
		@Result(property="goods",column="g_id",
		one=@One(select="com.sw.digital.dao.GoodsDao.getGoodsByIdSimple")
		)
	})
	public Comment getCommentById(String id);
	
	//修改评论信息
	@Update("UPDATE digital_mall.`comment` SET c_detial=#{detial},c_service=#{service},c_speed=#{speed},c_gdescribe=#{gdescribe},c_state=#{state} WHERE c_id=#{id}")
	public Integer updateCommentInfo(Comment comment);
}
