package org.global.fairy.cms.admin.controllers.crm;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.global.fairy.cms.admin.api.UserApi;
import org.global.fairy.cms.admin.api.params.RegistorApiParams;
import org.global.fairy.cms.admin.forms.RegistorForm;
import org.global.fairy.cms.admin.forms.converters.RegistorForm2RegistorApiParams;
import org.global.fairy.core.PageParams;
import org.global.fairy.core.Pager;
import org.global.fairy.core.utils.ResultJsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(value = "/crm")
public class UserController {
	private static final Logger logger = LogManager.getLogger();

	@Resource
	private UserApi userApi;

	/**
	 * 注册接口
	 * 
	 * @param registorForm
	 * @return
	 */
	@RequestMapping(value = "/registor", method = RequestMethod.POST)
	@ResponseBody()
	public String registor(@RequestBody RegistorForm registorForm) {
		logger.debug("注册...");
		RegistorApiParams registorApiParams = RegistorForm2RegistorApiParams
				.getInstance().convert(registorForm);
		userApi.register(registorApiParams);
		logger.debug("注册成功!");
		RegistorApiParams registorApiResult = new RegistorApiParams();
		registorApiResult.setUsername(registorApiParams.getUsername());
		registorApiResult.setPassword(registorApiParams.getPassword());
		return JSONObject.toJSONString(registorApiResult);
	}

	/**
	 * 新增用戶
	 * 
	 * @param registorForm
	 * @return
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody()
	public String addUser(@RequestBody RegistorForm registorForm) {
		logger.info("新增用户...");
		RegistorApiParams registorApiParams = RegistorForm2RegistorApiParams
				.getInstance().convert(registorForm);
		String result = ResultJsonUtil.toJson(userApi
				.addUser(registorApiParams));

		logger.info("新增用户成功!");

		return result;
	}

	/**
	 * 列表查询接口
	 * 
	 * @param registorForm
	 * @return
	 */
	@RequestMapping(value = "/userinfo/list", method = RequestMethod.GET)
	@ResponseBody()
	public String userList(PageParams pagerForm) {
		System.out.println(pagerForm.toString());
		logger.info("用户列表...");

		String result = userApi.list(pagerForm);
		return result;
	}

}
