package com.zp.service;

import java.util.List;

import com.zp.model.ChoiceQuestion;

/**
 * 选择题业务层抽象
 * @author blindeagle
 * @version 1.0
 */
public interface ChoiceQuestionServiceI {
	
	/**
	 * 根据选择题的id号查询选择题内容
	 * @author blindeagle
	 * @param id 选择题id
	 * @return ChoiceQuestion 选择题对象
	 */
	public ChoiceQuestion queryChoiceQuestionByQuestionId(int id);
	
	/**
	 * 根据选择题的章节号和试题难易程度查询试题ID
	 * @author blindeagle
	 * @param sectionId 章节号
	 * @param complexity 难易程度（1-5）
	 * @return List<Integer> 符合查询条件的选择题ID的集合
	 */
	public List<Integer> queryChoiceQuestionIdBySectionIdAndComplexity(int sectionId, int complexity);
	
}
