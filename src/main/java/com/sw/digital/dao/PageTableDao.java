package com.sw.digital.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 表格分页
 * @author Kyle
 *
 */

public interface PageTableDao<T>{

	//商品分页
	public List<T> queryAllGoodsData(@Param("page") int page, @Param("limit") int limit, @Param("keyWord") String keyWord);
	public Integer queryAllGoodsCount(String keyWord);

	//商家分页信息
	public List<T> queryAllMerchantData(@Param("page") int page, @Param("limit") int limit, @Param("keyWord") String keyWord);
	public Integer queryAllMerchantCount(String keyWord);

	//用户分页
	public List<T> queryAllUserData(@Param("page") int page, @Param("limit") int limit, @Param("keyWord") String keyWord);
	public Integer queryAllUserCount(String keyWord);


	//管理员分页
	public List<T> queryAllAdminData(@Param("page") int page, @Param("limit") int limit, @Param("keyWord") String keyWord);
	public Integer queryAllAdminCount(String keyWord);
	
	//评论分页
	public List<T> queryAllCommentData(@Param("page") int page, @Param("limit") int limit, @Param("keyWord") String keyWord);
	public Integer queryAllCommentCount(String keyWord);

}
