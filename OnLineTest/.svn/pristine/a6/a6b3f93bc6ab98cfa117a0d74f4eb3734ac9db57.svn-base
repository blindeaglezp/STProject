package com.zp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zp.service.impl.ChangePasswordServiceImpl;

/**
 * 修改密码页面处理
 * @author 盲鹰
 * @version 1.0
 */
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		if ("stu_change_password_1".equals(type)) {
			request.getRequestDispatcher("/WEB-INF/jsp/student/change_password_1.jsp").forward(request, response);
		} else if ("stu_change_password_2".equals(type)) {
			String oldPassword = request.getParameter("old_password");
			String newPassword = request.getParameter("new_password");
			String reNewPassword = request.getParameter("re_new_password");
			if (new ChangePasswordServiceImpl().changePassword(request, oldPassword, newPassword, reNewPassword)) {
				request.getRequestDispatcher("/WEB-INF/jsp/student/change_password_2.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/jsp/student/change_password_1.jsp").forward(request, response);
			}
		} 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
