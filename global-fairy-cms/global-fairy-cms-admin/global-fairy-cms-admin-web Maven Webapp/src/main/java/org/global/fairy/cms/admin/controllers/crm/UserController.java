package org.global.fairy.cms.admin.controllers.crm;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.global.fairy.cms.admin.api.UserApi;
import org.global.fairy.cms.admin.api.params.RegistorApiParams;
import org.global.fairy.cms.admin.forms.RegistorForm;
import org.global.fairy.cms.admin.forms.converters.RegistorForm2RegistorApiParams;
import org.global.fairy.core.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(value = "/cms")
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
		System.out.println(registorForm.toString());
		
		logger.info(  "注册...");
		RegistorApiParams registorApiParams = RegistorForm2RegistorApiParams
				.getInstance().convert(registorForm);
		userApi.register(registorApiParams);
		logger.info("注册成功!");
		RegistorApiParams registorApiResult = new RegistorApiParams();
		registorApiResult.setUsername("jiao");
		registorApiResult.setPassword("123456");
		String json = "/\"total/\":2,/\"rows/\""
				+ "{/\"username/\":/\"jiao_zg/\",/\"password/\":/\"123456/\"},"
				+ "{/\"username/\":/\"jiao_zg/\",/\"password/\":/\"123456/\"}";
		return JSONObject.toJSONString(registorApiResult);
	}
	
	/**
	 * 查询接口
	 * 
	 * @param registorForm
	 * @return
	 */
	@RequestMapping(value = "/userinfo/list", method = RequestMethod.GET)
	@ResponseBody()
	public String userList(Pager pagerForm) {
		System.out.println(pagerForm.toString());
		logger.info(  "用户列表...");
		
		String result = userApi.list(pagerForm);
		return result;
	}
}
