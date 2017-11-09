package org.global.fairy.cms.front.service.impl;

import org.global.fairy.cms.front.dao.CommentDao;
import org.global.fairy.cms.front.dao.beans.Comment;
import org.global.fairy.cms.front.service.CommentService;
import org.global.fairy.cms.front.service.params.CommentServiceParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDao commentDao;

	@Override
	public int save(CommentServiceParams commentServiceParams) {
		// TODO Auto-generated method stub
		Comment comment = new Comment();
		
		return commentDao.add(comment);
	}
}
