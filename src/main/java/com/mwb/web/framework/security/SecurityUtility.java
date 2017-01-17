package com.mwb.web.framework.security;

import com.mwb.web.framework.context.model.AccountCO;
import com.mwb.web.framework.http.context.HttpSessionContextUtility;

public class SecurityUtility {

	public static void createSession(DefaultUserDetails userDetails) {
		HttpSessionContextUtility.setAttribute(AccountCO.getContextKey(), userDetails.getAccount());
	}
}
