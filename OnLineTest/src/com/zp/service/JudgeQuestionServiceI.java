package com.zp.service;

import java.util.List;

import com.zp.model.JudgeQuestion;

/**
 * 判断题业务层抽象
 * @author blindeagle
 * @version 1.0
 */
public interface JudgeQuestionServiceI {

	/**
	 * 根据id号查询判断题
	 * @author blindeagle
	 * @param id id号
	 * @return JudgeQuestion 查询到的判断题对象
	 */
	public JudgeQuestion queryJudgeQuestionByQuestionId(int id);
	
	/**
	 * 根据章节号和试题难易程度查询试题ID
	 * @author blindeagle
	 * @param sectionId 章节号
	 * @param complexity 难易程度
	 * @return List<Integer> 符合条件的判断题的ID集合
	 */
	public List<Integer> queryJudgeQuestionIdBySectionIdAndComplexity(int sectionId, int complexity);
	
}
