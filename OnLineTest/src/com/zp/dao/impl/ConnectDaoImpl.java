package com.zp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zp.dao.ConnectDaoI;
import com.zp.model.Connect;
import com.zp.util.JdbcUtil;

/**
 * 联系方式数据库操作实现类
 * @author blindeagle
 * @version 1.0
 */
public class ConnectDaoImpl extends JdbcUtil implements ConnectDaoI {

	public List<Connect> queryConnect() {
		String sql = "select name,value from connect";
		List<Connect> connects = new ArrayList<Connect>();
		Connect connect = null;
		rs = getQuery(sql, null);
		try {
			while (rs.next()) {
				connect = new Connect();
				connect.setName(rs.getString(1));
				connect.setValue(rs.getString(2));
				connects.add(connect);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return connects;
			
	}

}
