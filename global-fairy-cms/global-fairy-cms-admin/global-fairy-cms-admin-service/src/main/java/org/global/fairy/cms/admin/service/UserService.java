package org.global.fairy.cms.admin.service;

import org.global.fairy.cms.admin.service.params.RegistorServiceParams;

public interface UserService {
	
	/**
	 * 注册方法
	 * 
	 * @param registorServiceParams
	 * @return
	 */
	String register(RegistorServiceParams registorServiceParams);
	
	boolean startDubbo();
}
