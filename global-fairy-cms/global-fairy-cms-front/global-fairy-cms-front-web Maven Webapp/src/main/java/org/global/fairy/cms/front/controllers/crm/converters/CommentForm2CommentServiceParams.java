package org.global.fairy.cms.front.controllers.crm.converters;

import org.global.fairy.cms.front.controllers.crm.forms.CommentForm;
import org.global.fairy.cms.front.service.params.CommentServiceParams;
import org.springframework.core.convert.converter.Converter;

public class CommentForm2CommentServiceParams implements Converter<CommentForm, CommentServiceParams> {
	public static CommentForm2CommentServiceParams getInstance() {
		return new CommentForm2CommentServiceParams();
	}
	
	@Override
	public CommentServiceParams convert(CommentForm arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
