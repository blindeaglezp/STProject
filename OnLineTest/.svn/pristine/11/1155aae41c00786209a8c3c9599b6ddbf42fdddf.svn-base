package com.zp.dao.impl;

import java.sql.SQLException;

import com.zp.dao.StudentDaoI;
import com.zp.model.Student;
import com.zp.util.JdbcUtil;

/**
 * 学生数据库操作实现类
 * @author blindeagle
 * @version 1.0
 */
public class StudentDaoImpl extends JdbcUtil implements StudentDaoI {

	@Override
	public Student checkLogin(String username, String password) {
		String sql = "select stu_id,stu_password,stu_name,stu_sex,stu_age,stu_majorid,stu_classid,stu_phone,stu_email,stu_address,stu_gradeid from student where stu_id=? and stu_password=?";
		String[] params = new String[] {username, password};
		Student student = null;
		rs = getQuery(sql, params);
		try {
			if (rs.next()) {
				student = new Student();
				student.setId(rs.getString(1));
				student.setPassword(rs.getString(2));
				student.setName(rs.getString(3));
				student.setSex(rs.getString(4));
				student.setAge(rs.getInt(5));
				student.setMajorId(rs.getString(6));
				student.setClassId(rs.getString(7));
				student.setPhone(rs.getString(8));
				student.setEmail(rs.getString(9));
				student.setAddress(rs.getString(10));
				student.setGradeId(rs.getString(11));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return student;
	}

	@Override
	public boolean updatePassword(String id, String newPassword) {
		String sql = "update student set stu_password=? where stu_id=?";
		Object[] params = new Object[] {newPassword, id};
		int n = getUpdate(sql, params);
		if (n > 0) {
			return true;
		}
		return false;
	}

}
