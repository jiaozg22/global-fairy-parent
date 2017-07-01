package org.global.fairy.cms.admin.service;

import org.global.fairy.cms.admin.service.params.RegistorServiceParams;
import org.global.fairy.core.PageParams;
import org.global.fairy.core.Pager;

public interface UserService {

	/**
	 * 注册方法
	 * 
	 * @param registorServiceParams
	 * @return
	 */
	String register(RegistorServiceParams registorServiceParams);

	/**
	 * 启动dubbo方法
	 * 
	 * @return
	 */
	boolean startDubbo();

	/**
	 * 用户列表
	 * 
	 * @param PageParams
	 * @return
	 */
	String list(PageParams pagerForm);

	/**
	 * 添加用戶
	 * 
	 * @param registorServiceParams
	 * @return
	 */
	int addUser(RegistorServiceParams registorServiceParams);
}
