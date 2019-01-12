package org.global.fairy.cms.admin.forms.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.global.fairy.cms.admin.api.params.RegistorApiParams;
import org.global.fairy.cms.admin.forms.RegistorForm;
import org.global.fairy.security.utils.ScryptPasswordHashingUtil;

public class RegistorForm2RegistorApiParams implements
		Converter<RegistorForm, RegistorApiParams> {
	public static RegistorForm2RegistorApiParams getInstance() {
		return new RegistorForm2RegistorApiParams();
	}

	@Override
	public RegistorApiParams convert(RegistorForm registorForm) {
		RegistorApiParams registorApiParams = new RegistorApiParams();
		BeanUtils.copyProperties(registorForm, registorApiParams);
		String password = ScryptPasswordHashingUtil.createScryptHash(registorForm.getPassword());
		registorApiParams.setPassword(password);
		return registorApiParams;
	}

}
