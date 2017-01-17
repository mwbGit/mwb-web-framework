package com.mwb.web.framework.service.aop.handler;

import com.mwb.web.framework.api.service.rs.api.ServiceResponse;
import org.aspectj.lang.ProceedingJoinPoint;

public class DefaultRestServiceProcessor implements IRestServiceProcessor {
	
	@Override
	public ServiceResponse process(ProceedingJoinPoint pjp, Object[] args) throws Throwable {
		if (args != null) {
			return (ServiceResponse)pjp.proceed(args);
		} else {
			return (ServiceResponse)pjp.proceed();
		}
	}

	@Override
	public boolean match() {
		return true;
	}

	@Override
	public Integer sequence() {
		return Integer.MIN_VALUE;
	}

}
