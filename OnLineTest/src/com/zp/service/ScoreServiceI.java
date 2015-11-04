package com.zp.service;

import java.util.List;

import com.zp.model.Score;

/**
 * 对成绩操作的业务层接口
 * @author 盲鹰
 * @version 1.0
 */
public interface ScoreServiceI {
	
	/**
	 * 根据学号查询成绩
	 * @author blindeagle
	 * @param stuId 学号
	 * @return List<Score> 查询到的学生成绩的集合
	 */
	public List<Score> queryScoreByStudentId(String studentId);
	
	/**
	 * 将分数存入数据库
	 * @author blindeagle
	 * @param studentId 学号
	 * @param testPaperId 试卷号
	 * @param value 分数
	 * @return int 受影响条数
	 */
	public int insertScore(String studentId, String testPaperId, float value);
	
	/**
	 * 根据学号和课程号查询
	 * @author blindeagle
	 * @param studentId 学号
 	 * @param courseId 课程号
	 * @return 查询到的成绩集合
	 */
	public List<Score> queryScoreByStudentIdAndCourseId(String studentId, String courseId);
	
	/**
	 * 检查成绩是否被提交
	 * @author blindeagle
	 * @param studentId 学生ID
	 * @param testPaperId 试卷ID
	 * @return boolean 若已经提交，返回true，否则返回false
	 */
	public boolean checkScoreIsSubmit(String studentId, String testPaperId);
	
}
