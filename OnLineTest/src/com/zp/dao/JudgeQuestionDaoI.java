package com.zp.dao;

import java.util.List;

import com.zp.model.JudgeQuestion;

/**
 * 判断题数据库操作类抽象
 * @author blindeagle
 * @version 1.0
 */
public interface JudgeQuestionDaoI {

	/**
	 * 根据判断题id号查询试题
	 * @author blindeagle
	 * @param id id号
	 * @return JudgeQuestion 查询到的判断题对象
	 */
	public JudgeQuestion queryJudgeQuestionByQuestionId(int id);
	
	/**
	 * 根据试题章节号和难易程度查询试题
	 * @author blindeagle
	 * @param sectionId 章节号
	 * @param complexity 难易程度（1-5）
	 * @return 符合条件的判断题集合
	 */
	public List<JudgeQuestion> queryJudgeQuestionIdBySectionIdAndComplexity(int sectionId, int complexity);
	
}
