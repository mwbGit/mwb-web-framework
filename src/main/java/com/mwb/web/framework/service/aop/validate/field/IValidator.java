package com.mwb.web.framework.service.aop.validate.field;

import com.mwb.web.framework.service.aop.validate.field.exception.ValidationException;

import java.lang.annotation.Annotation;


public interface IValidator {
	public void validate(Object obj, Annotation annotation) throws ValidationException;
}
