package com.mwb.web.framework.service.aop.validate.field.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumericalRangeFormat {
	public static final boolean multiFields = false;
	
	public double max() default 1;
	
	public double min() default 0;
}
