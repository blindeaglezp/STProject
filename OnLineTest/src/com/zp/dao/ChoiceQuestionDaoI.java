package com.zp.dao;

import java.util.List;

import com.zp.model.ChoiceQuestion;

/**
 * 选择题数据库操作类抽象
 * @author blindeagle
 * @version 1.0
 */
public interface ChoiceQuestionDaoI {
	
	/**
	 * 根据选择题id查询试题
	 * @author blindeagle
	 * @param id 选择题id
	 * @return ChoiceQuestion 选择题试题对象
	 */
	public ChoiceQuestion queryChoiceQuestionByQuestionId(int id);
	
	/**
	 * 根据章节号和试题难易程度查询试题
	 * @author blindeagle
	 * @param sectionId 章节号
	 * @param complexity 试题难易程度（1-5）
	 * @return List<ChoiceQuestion> 查询到的试题集合
	 */
	public List<ChoiceQuestion> queryChoiceQuestionBySectionIdAndComplexity(int sectionId, int complexity);
	
}
