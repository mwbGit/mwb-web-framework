package com.mwb.web.framework.service.aop.validate.field.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MobileFormat {
	public static final boolean multiFields = false;
	
	public boolean required();
}
