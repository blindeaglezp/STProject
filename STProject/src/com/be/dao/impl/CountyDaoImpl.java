package com.be.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.be.dao.CountyDaoI;
import com.be.model.County;
import com.be.utils.JdbcUtil;

/**
 * 县操作数据库实现类
 * @author blindeagle
 * @version 1.0
 */
public class CountyDaoImpl extends JdbcUtil implements CountyDaoI {
	
	private List<County> countys = null; // 县集合
	private County countyObj = null; // 县对象

	@Override
	public List<County> queryCountyByCityId(int cityId) {
		String sql="select county.id,county.name,city.name,state.name from county,city,state "
				+ "where county.cityid=city.id and county.stateid=state.id and county.cityid=? and county.stateid=?";
		Integer[] params = new Integer[] {cityId, 1};
		countys = new ArrayList<County>();
		rs = getQuery(sql, params);
		try {
			while (rs.next()) {
				countyObj = new County();
				countyObj.setId(rs.getInt(1));
				countyObj.setName(rs.getString(2));
				countyObj.setCity(rs.getString(3));
				countyObj.setState(rs.getString(4));
				countys.add(countyObj);
			}
			return countys;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseConnection();
		}
		return null;
	}

	@Override
	public int insertCounty(String name, int cityId, int stateId) {
		String sql = "insert into county(name,cityid,stateid) values(?,?,?)";
		Object[] params = new Object[] {name, cityId, stateId};
		return getUpdate(sql, params);
	}

	@Override
	public County queryCountyByCityIdAndCountyName(int cityId, String countyName) {
		String sql = "select county.id,city.name,state.name from county,city,state where county.cityid=city.id"
				+ " and county.stateid=state.id and county.cityid=? and county.stateid=? and county.name=?";
		Object[] params = new Object[] {cityId, 1, countyName};
		rs = getQuery(sql, params);
		try {
			if (rs.next()) {
				countyObj = new County();
				countyObj.setId(rs.getInt(1));
				countyObj.setName(countyName);
				countyObj.setCity(rs.getString(2));
				countyObj.setState(rs.getString(3));
				return countyObj;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			releaseConnection();
		}
		return null;
	}

}
