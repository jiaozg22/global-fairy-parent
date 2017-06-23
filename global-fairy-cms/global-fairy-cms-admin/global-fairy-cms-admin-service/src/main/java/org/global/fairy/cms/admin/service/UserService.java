package org.global.fairy.cms.admin.service;

import org.global.fairy.cms.admin.service.params.RegistorServiceParams;
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
	 * @param pagerForm
	 * @return
	 */
	String list(Pager pagerForm);
}
