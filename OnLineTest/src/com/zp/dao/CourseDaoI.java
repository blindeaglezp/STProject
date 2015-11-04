package com.zp.dao;

import java.util.List;

import com.zp.model.Course;

/**
 * 课程科目数据库操作类抽象
 * @author blindeagle
 * @version 1.0
 */
public interface CourseDaoI {
	
	/**
	 * 根据年级号查询课程
	 * @author blindeagle
	 * @param gradeId	年级号
	 * @return	符合该年级的所有课程的名称和id的集合
	 */
	public List<Course> queryCourseNameByGradeId(String gradeId);
	
	/**
	 * 根据课程号查询课程信息
	 * @author blindeagle
	 * @param courseId 课程号
	 * @return Course 查询到的课程对象
	 */
	public Course queryCourseByCourseId(String courseId);

}
