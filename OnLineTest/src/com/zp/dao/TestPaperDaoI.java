package com.zp.dao;

import java.util.List;

import com.zp.model.TestPaper;

/**
 * 试卷信息数据库操作接口
 * @author 盲鹰
 * @version 1.0
 */
public interface TestPaperDaoI {

	/**
	 * 根据课程号查询试卷信息数据库操作抽象
	 * @author blindeagle
	 * @param courseId 课程号
	 * @return 课程号为courseId的试卷信息的集合
	 */
	public List<TestPaper> queryTestPaperByCourseId(String courseId);
	
	/**
	 * 根据试卷号查询试卷信息数据库操作抽象
	 * @author blindeagle
	 * @param testPaperId 试卷号
	 * @return 试卷号为testPaperId的试卷信息
	 */
	public TestPaper queryTestPaperByTestPaperId(String testPaperId);
	
}
