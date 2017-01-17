package com.mwb.web.framework.service.aop.security;

import com.mwb.web.framework.model.Location;

import java.util.List;

public interface IServiceLocationAuthorizer {
	
	public boolean authorize(List<Location> locations);
	
}
