package com.mwb.web.framework.mybatis.proxy.injection;


import com.mwb.web.framework.context.AuthorizedLocationAccessor;

public class AuthorizedLocationInjector implements IObjectInjector {
	
	public final static Object[] AUTO_INJECT = new Object[0]; 
	public final static Object[] NOT_INJECT = new Object[0];

	@Override
	public Object getObject(Object originalObj) {
		if (originalObj == AUTO_INJECT) {
			return AuthorizedLocationAccessor.getQueryLocations();
		} else if (originalObj == NOT_INJECT) {
			return null;
		} else {
			return originalObj;
		}
	}

}
