package com.zp.service.impl;

import com.zp.dao.impl.AdminDaoImpl;
import com.zp.dao.impl.StudentDaoImpl;
import com.zp.dao.impl.TeacherDaoImpl;
import com.zp.model.Admin;
import com.zp.model.Student;
import com.zp.model.Teacher;
import com.zp.service.LoginServiceI;

/**
 * 登录业务处理实现类
 * @author blindeagle
 * @version 1.0
 */
public class LoginServiceImpl implements LoginServiceI {
	private Student student;
	private Teacher teacher;
	private Admin admin;

	@Override
	public Object checkLogin(String username, String password, String identity) {
		if (username == null || password == null || identity == null || "".equals(username.trim()) || "".equals(password.trim()) || "".equals(identity.trim())) {
			return "error";
		}
		if ("student".equals(identity)) {
			student = new StudentDaoImpl().checkLogin(username, password);
			return student;
		} else if ("teacher".equals(identity)) {
			teacher = new TeacherDaoImpl().checkLogin(username, password);
			return teacher;
		} else if ("admin".equals(identity)) {
			admin = new AdminDaoImpl().checkLogin(username, password);
			return admin;
		} else {
			return null;
		}
	}
	
}
