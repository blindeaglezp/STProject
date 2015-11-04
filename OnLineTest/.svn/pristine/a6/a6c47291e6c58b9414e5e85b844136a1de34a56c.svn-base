package com.zp.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zp.model.Student;

/**
 * 对学生处理信息拦截器
 * @author blindeagle
 * @version 1.0
 */
public class StudentFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException { }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String servletPath = httpRequest.getServletPath();
		Student student = (Student) httpRequest.getSession().getAttribute("user");
		if (student == null && !"/servlet/LoginServlet".equals(servletPath)) {
			request.getRequestDispatcher("/error.jsp").forward(httpRequest, (HttpServletResponse) response);
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() { }

}
