package com.zp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zp.service.impl.LoginServiceImpl;

import net.sf.json.JSONObject;

/**
 * 登录页面处理
 * @author blindeagle
 * @version 1.0
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		
		String type = request.getParameter("type");
		
		if ("check".equals(type)) {
			//获取输入值
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String identity = request.getParameter("identity");
			//交由service层处理
			Object user = new LoginServiceImpl().checkLogin(username, password, identity);
			
			if (user != null) {
				if ("error".equals(user.toString())) {
					response.getWriter().print("请补全所填信息");
				} else {
					//将用户信息和用户身份添加到session域中
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(30 * 60);
					session.setAttribute("user", user);
					session.setAttribute("identity", identity);
					String result = "{'data':'success'}";
					JSONObject json = JSONObject.fromObject(result);
					response.getWriter().print(json);
				}
			} else {
				String result = "{'data':'uperror'}";
				JSONObject json = JSONObject.fromObject(result);
				response.getWriter().print(json);
			}
		}
		
		if ("index".equals(type)) {
			String identity = (String) request.getSession().getAttribute("identity");
			if ("student".equals(identity)) {
				request.getRequestDispatcher("/WEB-INF/jsp/student/index.jsp").forward(request, response);
			} else if ("teacher".equals(identity)) {
				
			} else if ("admin".equals(identity)) {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/index.jsp").forward(request, response);
			}
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
