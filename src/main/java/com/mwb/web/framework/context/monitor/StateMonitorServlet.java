package com.mwb.web.framework.context.monitor;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StateMonitorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("contextRefreshed : ").append(BeanContextMonitor.isContextRefreshed());
		
		response.getWriter().print(sb.toString());
	}
	
}
