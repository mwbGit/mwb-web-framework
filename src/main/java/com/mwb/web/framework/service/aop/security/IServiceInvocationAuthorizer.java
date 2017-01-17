package com.mwb.web.framework.service.aop.security;

import java.lang.reflect.Method;

public interface IServiceInvocationAuthorizer {
	public void authorize(Method method) throws PermissionDeniedException;
}
