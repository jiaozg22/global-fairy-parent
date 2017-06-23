package org.global.fairy.cms.admin.service.impl;


import javax.annotation.Resource;
import org.global.fairy.cms.admin.dao.UserInfoMapper;
import org.global.fairy.cms.admin.dao.beans.UserInfoBean;
import org.global.fairy.cms.admin.service.UserService;
import org.global.fairy.cms.admin.service.impl.params.converters.RegistorServiceParams2UserInfoBeanConverter;
import org.global.fairy.cms.admin.service.params.RegistorServiceParams;
import org.global.fairy.core.Pager;
import org.global.fairy.core.utils.ResultJsonUtil;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource
	UserInfoMapper userInfoMapper;
	
	@Override
	public String register(RegistorServiceParams registorServiceParams) {
		UserInfoBean userInfoBean = RegistorServiceParams2UserInfoBeanConverter.newInstance().convert(registorServiceParams);
		userInfoMapper.insertUserInfo(userInfoBean);
		return "";
	}

	@Override
	public boolean startDubbo() {
		Assembly.startDubbo();
		return false;
	}

	@Override
	public String list(Pager pagerForm) {
		return ResultJsonUtil.toJsonList(userInfoMapper.list(pagerForm));
	}

}
