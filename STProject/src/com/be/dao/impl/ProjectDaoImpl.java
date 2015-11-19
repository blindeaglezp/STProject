package com.be.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.be.dao.ProjectDaoI;
import com.be.model.Project;
import com.be.utils.JdbcUtil;

/**
 * 项目操作数据库实现类
 * @author gaohailong
 * @version 1.0
 */
public class ProjectDaoImpl extends JdbcUtil implements ProjectDaoI {
	private List<Project> projects = null;// 项目集合
	private Project projectObj = null; // 项目对象

	@Override
	public List<Project> queryProjectByCityId(int cityId) {
		String sql = "select project.id,project.proid,project.name,project.budtarget,project.paynum,project.total,project.payprogress ,project.examine,city.name,county.name,"
				+ "subject.name,scale.name,state.name,project.charnum from project,city,county,subject,scale,state where project.cityid=city.id  and project.countyid=county.id "
				+ "and project.subjectid=subject.id  and project.scaleid=scale.id and project.stateid=state.id and project.cityid=? and project.stateid=?;";
		Integer[] params = new Integer[] { cityId, 1 };
		projects = new ArrayList<Project>();
		rs = getQuery(sql, params);
		try {
			while (rs.next()) {
				projectObj = new Project();
				projectObj.setId(rs.getInt(1));
				projectObj.setProId(rs.getString(2));
				projectObj.setName(rs.getString(3));
				projectObj.setBudTarget(rs.getInt(4));
				projectObj.setPayNum(rs.getInt(5));
				projectObj.setTotal(rs.getInt(6));
				projectObj.setPayProgress(rs.getInt(7));
				projectObj.setExamine(rs.getInt(rs.getInt(8)));
				projectObj.setCity(rs.getString(9));
				projectObj.setCounty(rs.getString(10));
				projectObj.setSubject(rs.getString(11));
				projectObj.setScale(rs.getString(12));
				projectObj.setState(rs.getString(13));
				projectObj.setCharNum(rs.getString(14));
			}
			return projects;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseConnection();
		}
		return null;
	}

}
