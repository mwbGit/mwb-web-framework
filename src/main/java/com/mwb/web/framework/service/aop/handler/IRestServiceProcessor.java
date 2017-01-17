package com.mwb.web.framework.service.aop.handler;

import com.mwb.web.framework.api.service.rs.api.ServiceResponse;
import org.aspectj.lang.ProceedingJoinPoint;

public interface IRestServiceProcessor {
	
	public ServiceResponse process(ProceedingJoinPoint pjp, Object[] args) throws Throwable;
	
	public boolean match();
	//值越大，优先级越高
	public Integer sequence();
}
