package org.global.fairy.cms.admin.service.impl.params.converters;

import org.global.fairy.cms.admin.dao.beans.UserInfoBean;
import org.global.fairy.cms.admin.service.params.RegistorServiceParams;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

public class RegistorServiceParams2UserInfoBeanConverter implements
		Converter<RegistorServiceParams, UserInfoBean> {

	public static RegistorServiceParams2UserInfoBeanConverter newInstance() {
		return new RegistorServiceParams2UserInfoBeanConverter();
	}

	@Override
	public UserInfoBean convert(RegistorServiceParams registorServiceParams) {
		UserInfoBean userInfoBean = new UserInfoBean();

		BeanUtils.copyProperties(registorServiceParams, userInfoBean);
		return userInfoBean;
	}

}
