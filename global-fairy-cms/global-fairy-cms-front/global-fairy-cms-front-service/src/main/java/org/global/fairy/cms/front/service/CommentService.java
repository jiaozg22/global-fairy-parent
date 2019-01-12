package org.global.fairy.cms.front.service;

import org.global.fairy.cms.front.service.params.CommentServiceParams;
import org.global.fairy.service.ICommonService;

public interface CommentService extends ICommonService{

	/**
	 * 保存评论
	 * 
	 * @param commentServiceParams
	 */
	int save(CommentServiceParams commentServiceParams);

}
