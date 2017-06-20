package org.global.fairy.cms.admin.api;

import javax.annotation.Resource;

import org.global.fairy.cms.admin.api.params.RegistorApiParams;
import org.global.fairy.cms.admin.api.params.converters.RegistorApiParams2RegistorServiceParamsConverter;
import org.global.fairy.cms.admin.service.UserService;
import org.global.fairy.cms.admin.service.params.RegistorServiceParams;
import org.springframework.stereotype.Component;

@Component("userApi")
public class UserApi {
	@Resource
	UserService userService;

	public String register(RegistorApiParams registorApiParams) {
		RegistorServiceParams registorServiceParams = RegistorApiParams2RegistorServiceParamsConverter
				.newInstance().convert(registorApiParams);
		return userService.register(registorServiceParams);
	}

}
