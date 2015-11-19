package com.be.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.be.dao.CityDaoI;
import com.be.model.City;
import com.be.utils.JdbcUtil;

/**
 * 市操作数据库实现类
 * @author blindeagle
 * @version 1.0
 */
public class CityDaoImpl extends JdbcUtil implements CityDaoI {
	
	private List<City> citys = null; // 市集合
	private City cityObj = null; // 市对象

	@Override
	public List<City> queryAllCity() {
		String sql = "select city.id,city.name,state.name from city,state where city.stateid=state.id and stateid=?";
		Integer[] params = new Integer[] {1};
		rs = getQuery(sql, params);
		citys = new ArrayList<City>();
		try {
			while (rs.next()) {
				cityObj = new City();
				cityObj.setId(rs.getInt(1));
				cityObj.setName(rs.getString(2));
				cityObj.setState(rs.getString(3));
				citys.add(cityObj);
			}
			return citys;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseConnection();
		}
		return null;
	}

}
