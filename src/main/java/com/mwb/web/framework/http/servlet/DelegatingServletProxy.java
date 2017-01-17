package com.mwb.web.framework.http.servlet;

import com.mwb.web.framework.context.BeanContextUtility;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class DelegatingServletProxy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Servlet proxy;

	public void init() throws ServletException {
		proxy = (Servlet) BeanContextUtility.getBean(this.getServletName());
		proxy.init(getServletConfig());
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		proxy.service(req, res);
	}
}
