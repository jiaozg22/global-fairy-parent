package org.global.fairy.cms.front.controllers.crm;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.global.fairy.cms.front.controllers.crm.converters.CommentForm2CommentServiceParams;
import org.global.fairy.cms.front.controllers.crm.forms.CommentForm;
import org.global.fairy.cms.front.service.CommentService;
import org.global.fairy.cms.front.service.params.CommentServiceParams;
import org.global.fairy.cms.front.service.results.CommentServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(value = "/cms")
public class CommentController {
	private static final Logger logger = LogManager.getLogger();
	
	@Autowired
	CommentService commentService;

	/**
	 * 提交评论接口
	 * 
	 * @param registorForm
	 * @return
	 */
	@RequestMapping(value = "/comment/save", method = RequestMethod.POST)
	@ResponseBody()
	public String registor(@RequestBody CommentForm commentForm) {
		logger.info("提交评论...");
		CommentServiceParams commentServiceParams = CommentForm2CommentServiceParams
				.getInstance().convert(commentForm);
		int result = commentService.save(commentServiceParams);
		
		CommentServiceResult commentServiceResult = new CommentServiceResult();
		commentServiceResult.setName("jiao");
		commentServiceResult.setContent("评论内容");
		commentServiceResult.setCommentDate(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));

		logger.info("评论提交成功!");
		return JSONObject.toJSONString(commentServiceResult);
	}

}
