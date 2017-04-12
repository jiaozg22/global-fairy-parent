package org.global.fairy.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.global.fairy.service.IUserService;
import org.springframework.stereotype.Service;

public class UserServiceImpl implements IUserService{
	private static final Logger logger = LogManager.getLogger();
	
//	@Autowired
//	private UserDao userDao;

	@Override
	public void sayHello() {
		logger.info("into service");
		//userDao.sayHello();
	}

}
