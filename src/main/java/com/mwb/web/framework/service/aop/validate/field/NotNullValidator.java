package com.mwb.web.framework.service.aop.validate.field;

import com.mwb.web.framework.service.aop.validate.field.exception.NotNullException;

import java.lang.annotation.Annotation;

public class NotNullValidator implements IValidator {

	@Override
	public void validate(Object obj, Annotation annotation) throws NotNullException {
		if (obj == null) {
			throw new NotNullException("Value is null!");
		}
	}
}
