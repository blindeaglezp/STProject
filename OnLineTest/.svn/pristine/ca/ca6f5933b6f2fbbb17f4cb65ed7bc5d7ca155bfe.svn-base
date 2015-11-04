package com.zp.dao.impl;

import java.sql.SQLException;

import com.zp.dao.AdminDaoI;
import com.zp.model.Admin;
import com.zp.util.JdbcUtil;

/**
 * 管理员数据库操作实现类
 * @author blindeagle
 * @version 1.0
 */
public class AdminDaoImpl extends JdbcUtil implements AdminDaoI {

	@Override
	public Admin checkLogin(String username, String password) {
		String sql = "select adm_id,adm_password,adm_name,adm_sex,adm_age,adm_job,adm_phone,adm_email,adm_address from admin where adm_id=? and adm_password=?";
		String[] params = new String[] {username, password};
		rs = getQuery(sql, params);
		Admin admin = null;
		try {
			if (rs.next()) {
				admin = new Admin();
				admin.setId(rs.getString(1));
				admin.setPassword(rs.getString(2));
				admin.setName(rs.getString(3));
				admin.setSex(rs.getString(4));
				admin.setAge(rs.getInt(5));
				admin.setJob(rs.getString(6));
				admin.setPhone(rs.getString(7));
				admin.setEmail(rs.getString(8));
				admin.setAddress(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return admin;
	}

	@Override
	public boolean updatePassword(String id, String newPassword) {
		return false;
	}

}
