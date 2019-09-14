package com.sw.digital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.digital.dao.CommentDao;
import com.sw.digital.entity.Comment;
import com.sw.digital.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public Comment getCommentById(String id) {
		return commentDao.getCommentById(id);
	}

	@Override
	public Integer updateCommentInfo(Comment comment) {
		return commentDao.updateCommentInfo(comment);
	}

}
