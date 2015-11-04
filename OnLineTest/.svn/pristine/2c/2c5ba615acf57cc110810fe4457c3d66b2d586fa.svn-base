package com.zp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zp.dao.CourseDaoI;
import com.zp.model.Course;
import com.zp.util.JdbcUtil;

/**
 * 科目数据库实现类
 * @author 盲鹰
 * @version 1.0
 */
public class CourseDaoImpl extends JdbcUtil implements CourseDaoI {
	private Course course = null;

	public List<Course> queryCourseNameByGradeId(String gradeId) {
		String sql = "select cou_id,cou_name,cou_majorid,cou_gradeid from course where cou_gradeid=?";
		List<Course> courses = new ArrayList<Course>();
		String[] params = new String[] {gradeId};
		rs = getQuery(sql, params);
		try {
			while (rs.next()) {
				course = new Course();
				course.setId(rs.getString(1));
				course.setName(rs.getString(2));
				course.setMajorId(rs.getString(3));
				course.setGradeId(rs.getString(4));
				courses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			closeConnection();
		} finally {
			closeConnection();
		}
		return courses;	
	}

	@Override
	public Course queryCourseByCourseId(String courseId) {
		String sql = "select cou_name,cou_majorid,cou_gradeid from course where cou_id=?";
		String[] params = new String[] {courseId};
		rs = getQuery(sql, params);
		try {
			if (rs.next()) {
				course = new Course();
				course.setId(courseId);
				course.setName(rs.getString(1));
				course.setMajorId(rs.getString(2));
				course.setGradeId(rs.getString(3));
				return course;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}

}
