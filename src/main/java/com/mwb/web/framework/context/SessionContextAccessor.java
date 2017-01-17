package com.mwb.web.framework.context;

import com.mwb.web.framework.context.model.AccountCO;
import com.mwb.web.framework.http.context.HttpSessionContextUtility;

import java.util.Set;


public class SessionContextAccessor {

	@SuppressWarnings("unchecked")
	public static <T extends AccountCO> T getCurrentAccount() {
		return (T) HttpSessionContextUtility.getAttribute(AccountCO.getContextKey());
    }
	
	public static Set<String> getPermissions() {
		AccountCO account = getCurrentAccount();
		
		if (account != null) {
			return account.getPermissions();
		} else {
			return null;
		}
    }
	
}