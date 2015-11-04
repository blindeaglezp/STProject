package com.zp.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zp.dao.impl.AdminDaoImpl;
import com.zp.dao.impl.StudentDaoImpl;
import com.zp.dao.impl.TeacherDaoImpl;
import com.zp.model.Admin;
import com.zp.model.Student;
import com.zp.model.Teacher;
import com.zp.service.ChangePasswordServiceI;

/**
 * 更改密码业务逻辑实现类
 * @author blindeagle
 * @version 1.0
 */
public class ChangePasswordServiceImpl implements ChangePasswordServiceI {

	public boolean changePassword(HttpServletRequest request, String oldPassword, String newPassword, String reNewPassword) {
		HttpSession session = request.getSession();
		String identity =  (String) session.getAttribute("identity");
		boolean flag = false;
		
		if ("".equals(oldPassword) || "".equals(newPassword) || "".equals(reNewPassword)
				|| (! newPassword.equals(reNewPassword))) {
			//信息未填完整或两次输入密码不相同
			flag = false;
		} else if ("student".equals(identity)) {
			Student student = (Student) session.getAttribute("user");
			String password = student.getPassword();
			if (oldPassword.equals(password)) {
				//填写旧密码和原密码相同
				flag = new StudentDaoImpl().updatePassword(student.getId(), newPassword);
			}
		} else if ("teacher".equals(identity)) {
			Teacher teacher = (Teacher) session.getAttribute("user");
			String password = teacher.getPassword();
			if (oldPassword.equals(password)) {
				//填写旧密码和原密码相同
				flag = new TeacherDaoImpl().updatePassword(teacher.getId(), newPassword);
			}
		} else if ("admin".equals(identity)) {
			Admin admin = (Admin) session.getAttribute("user");
			String password = admin.getPassword();
			if (oldPassword.equals(password)) {
				//填写旧密码和原密码相同
				flag = new AdminDaoImpl().updatePassword(admin.getId(), newPassword);
			}
		}
		return flag;
	}
	
}
