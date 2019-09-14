package com.sw.digital.service;

import com.sw.digital.entity.Comment;

public interface CommentService {

	//根据Id查询Comment
	public Comment getCommentById(String id);
	
	public Integer updateCommentInfo(Comment comment);
}
