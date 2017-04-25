package org.global.fairy.api;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.global.fairy.modules.dao.User;
import org.global.fairy.service.IUserService;
import org.springframework.stereotype.Component;

@Component
public class UserApi {
	private static final Logger logger = LogManager.getLogger();
	
	@Resource
	public IUserService userService;

	public void sayHello() {
		logger.info("into api");
		User user = new User();
		
		user.setId(10000);
		user.setName("jiao_zg");
		userService.sayHello(user);
	}
}
