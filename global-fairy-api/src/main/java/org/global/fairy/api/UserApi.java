package org.global.fairy.api;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.global.fairy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserApi {
	private static final Logger logger = LogManager.getLogger();
	
	@Resource
	public IUserService userService;

	public void sayHello() {
		logger.info("into api");
		userService.sayHello();
	}
}
