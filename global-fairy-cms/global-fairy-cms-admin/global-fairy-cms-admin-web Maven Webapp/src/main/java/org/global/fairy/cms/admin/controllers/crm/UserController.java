package org.global.fairy.cms.admin.controllers.crm;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.global.fairy.cms.admin.api.UserApi;
import org.global.fairy.cms.admin.api.params.RegistorApiParams;
import org.global.fairy.cms.admin.forms.RegistorForm;
import org.global.fairy.cms.admin.forms.converters.RegistorForm2RegistorApiParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/cms")
public class UserController {
	private static final Logger logger = LogManager.getLogger();

	@Resource
	private UserApi userApi;

	@RequestMapping(value = "/registor", method = RequestMethod.POST)
	@ResponseBody()
	public String registor(@RequestBody RegistorForm registorForm) {
		System.out.println(registorForm.toString());
		
		logger.info(  "注册...");
		RegistorApiParams registorApiParams = RegistorForm2RegistorApiParams
				.getInstance().convert(registorForm);
		userApi.register(registorApiParams);
		logger.info("注册成功!");
		return "registor";
	}
}
