package com.be.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.be.dao.SubjectDaoI;
import com.be.model.Subject;
import com.be.utils.JdbcUtil;

/**
 * 科目操作数据库实体类
 * @author blindeagle
 * @version 1.0
 */
public class SubjectDaoImpl extends JdbcUtil implements SubjectDaoI {
	
	private List<Subject> subjects = null; // 科目集合
	private Subject subjectObj = null; // 科目对象

	@Override
	public int addSubject(String name) {
		String sql = "insert into subject(name,stateid) values(?,?)";
		Object[] params = new Object[] {name, 1};
		return getUpdate(sql, params);
	}

	@Override
	public List<Subject> queryAllSubject() {
		String sql = "select subject.id,subject.name,state.name from subject,state"
				+ " where subject.stateid=state.id";
		subjects = new ArrayList<Subject>();
		rs = getQuery(sql, null);
		try {
			while (rs.next()) {
				subjectObj = new Subject();
				subjectObj.setId(rs.getInt(1));
				subjectObj.setName(rs.getString(2));
				subjectObj.setState(rs.getString(3));
				subjects.add(subjectObj);
			}
			return subjects;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseConnection();
		}
		return null;
	}

	@Override
	public int deleteSubjectById(int id) {
		String sql = "update subject set stateid=? where id=?";
		Integer[] params = new Integer[] {2, id};
		return getUpdate(sql, params);
	}

	@Override
	public int updateSubjectById(int id, String name) {
		String sql = "update subject set name=? where id=?";
		Object[] params = new Object[] {name, id};
		return getUpdate(sql, params);
	}

}
