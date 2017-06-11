package org.global.fairy.cms.admin.controllers.crm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.global.fairy.cms.admin.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/cms")
public class UserController {
	private static final Logger logger = LogManager.getLogger();
	
	@Autowired
	private UserApi userApi;
	
	@RequestMapping(value = "/registor" , method= RequestMethod.GET)
	@ResponseBody()
	public String registor(){
		logger.info("注册...");
		userApi.register();
		logger.info("注册成功!");
		return "registor";
	}
}
