package com.zp.service;

import java.util.List;

import com.zp.model.TestPaper;

/**
 * 试卷信息操作业务层抽象
 * @author blindeagle
 * @version 1.0
 */
public interface TestPaperServiceI {

	/**
	 * 根据课程号查询试卷信息
	 * @author blindeagle
	 * @param courseId 课程号
	 * @return List<TestPaper> 课程号为courseId的试卷信息
	 */
	public List<TestPaper> queryTestPaperByCourseId(String courseId);
	
	/**
	 * 根据试卷号查询试卷信息
	 * @author blindeagle
	 * @param testPaperId 试卷号
	 * @return TestPaper 试卷号为testPaperId的试卷信息
	 */
	public TestPaper queryTestPaperByTestPaperId(String testPaperId);

	/**
	 * 查询并将查询结果封装到Map集合
	 * @author blindeagle
	 * @param testPaper 试题对象
	 * @return int 试卷总题数
	 */
	public int findAndPackageMap(TestPaper testPaper);
	
}
