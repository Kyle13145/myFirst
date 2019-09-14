package com.sw.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sw.digital.entity.Comment;
import com.sw.digital.entity.TableEntity;
import com.sw.digital.entity.User;
import com.sw.digital.service.CommentService;
import com.sw.digital.service.PageTableService;

@RestController
@RequestMapping("/tasks/any")
public class CommentController {

	@Autowired
	private PageTableService<Comment> pageTableSvr;
	
	@Autowired CommentService commentSvr;
	
	/**
	 * 分页
	 * 获取用户所有信息
	 */
	@RequestMapping(value = "/getAllCommentLimit",method=RequestMethod.GET)
	public ResponseEntity<?> getAllMerchantByPage(
			@RequestParam(required=false,defaultValue="1") int page,
			@RequestParam(required=false,defaultValue="15") int limit,
			String keyWord){
		//封装商品数据
		TableEntity<Comment> commData = new TableEntity<Comment>();
		int count = pageTableSvr.queryAllObjectCount(keyWord);
		List<Comment> comm = pageTableSvr.queryAllObjectData(page, limit, keyWord);
		commData.setCode(0);
		commData.setCount(count);
		commData.setData(comm);
		commData.setMsg("success");
		return new ResponseEntity<>(commData,HttpStatus.OK);
	}
	
	//根据Id查询评论信息
	@RequestMapping(value = "/getCommentById",method=RequestMethod.GET)
	public ResponseEntity<?> getCommentByIds(@RequestParam("cid") String id){
		Comment comment = commentSvr.getCommentById(id);
		return new ResponseEntity<>(comment,HttpStatus.OK);
	}
	
	//更新评论信息
	@RequestMapping(value = "/updateCommentInfo",method=RequestMethod.POST)
	public ResponseEntity<?> updateCommentInfos(@RequestBody Comment comment){
		int a = commentSvr.updateCommentInfo(comment);
		if(a>0) {
			return new ResponseEntity<>(comment,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.OK);
		}
	}
}
