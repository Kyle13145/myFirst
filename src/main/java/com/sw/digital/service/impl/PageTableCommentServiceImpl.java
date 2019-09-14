package com.sw.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.digital.dao.PageTableDao;
import com.sw.digital.entity.Comment;
import com.sw.digital.service.PageTableService;


@Service
public class PageTableCommentServiceImpl implements PageTableService<Comment> {

	@Autowired
	private PageTableDao<Comment> pageTableDao;
	
	@Override
	public List<Comment> queryAllObjectData(int page, int limit, String keyWord) {
		page=(page-1)*limit;
		return pageTableDao.queryAllCommentData(page, limit, keyWord);
	}

	@Override
	public Integer queryAllObjectCount(String keyWord) {
		return pageTableDao.queryAllCommentCount(keyWord);
	}

}
