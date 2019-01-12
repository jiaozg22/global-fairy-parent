package org.global.fairy.cms.front.service.results;

import org.global.fairy.service.results.CommonResult;


public class CommentServiceResult extends CommonResult {
	private String name;//名字
	private String content;//评论内容
	private String commentDate;//评论时间
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	
}
