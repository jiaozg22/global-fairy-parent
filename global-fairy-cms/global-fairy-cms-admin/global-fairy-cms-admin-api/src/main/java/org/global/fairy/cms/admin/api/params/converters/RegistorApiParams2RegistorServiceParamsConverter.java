package org.global.fairy.cms.admin.api.params.converters;

import org.global.fairy.cms.admin.api.params.RegistorApiParams;
import org.global.fairy.cms.admin.service.params.RegistorServiceParams;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

public class RegistorApiParams2RegistorServiceParamsConverter implements
Converter<RegistorApiParams, RegistorServiceParams> {
	
	public static RegistorApiParams2RegistorServiceParamsConverter newInstance(){
		return new RegistorApiParams2RegistorServiceParamsConverter();
	}
	
	@Override
	public RegistorServiceParams convert(RegistorApiParams registorApiParams) {
		RegistorServiceParams registorServiceParams = new RegistorServiceParams();
		BeanUtils.copyProperties(registorApiParams, registorServiceParams);
		return registorServiceParams;
	}

}
