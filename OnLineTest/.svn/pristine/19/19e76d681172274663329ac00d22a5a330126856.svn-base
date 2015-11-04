package com.zp.dao.impl;

import java.sql.SQLException;

import com.zp.dao.TeacherDaoI;
import com.zp.model.Teacher;
import com.zp.util.JdbcUtil;

/**
 * 教师数据库操作实现类
 * @author blindeagle
 * @version 1.0
 */
public class TeacherDaoImpl extends JdbcUtil implements TeacherDaoI {

	@Override
	public Teacher checkLogin(String username, String password) {
		String sql = "select tea_id,tea_password,tea_name,tea_sex,tea_age,tea_majorid,tea_courseid,tea_phone,tea_email,tea_address from teacher where tea_id=? and tea_password=?";
		String[] params = new String[] {username, password};
		Teacher teacher = null;
		rs = getQuery(sql, params);
		try {
			if (rs.next()) {
				teacher = new Teacher();
				teacher.setId(rs.getString(1));
				teacher.setPassword(rs.getString(2));
				teacher.setName(rs.getString(3));
				teacher.setSex(rs.getString(4));
				teacher.setAge(rs.getInt(5));
				teacher.setMajorId(rs.getString(6));
				teacher.setCourseId(rs.getString(7));
				teacher.setPhone(rs.getString(8));
				teacher.setEmail(rs.getString(9));
				teacher.setAddress(rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return teacher;
	}

	@Override
	public boolean updatePassword(String id, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}

}
