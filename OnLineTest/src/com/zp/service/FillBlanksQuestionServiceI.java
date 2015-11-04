package com.zp.service;

import java.util.List;

import com.zp.model.FillBlanksQuestion;

/**
 * 填空题业务层抽象
 * @author blindeagle
 * @version 1.0
 */
public interface FillBlanksQuestionServiceI {
	
	/**
	 * 根据填空题的id号查询填空题内容
	 * @author blindeagle
	 * @param id 填空题id
	 * @return FillBlanksQuestion 填空题对象
	 */
	public FillBlanksQuestion queryFillBlanksQuestionByQuestionId(int id);
	
	/**
	 * 根据填空题的章节号和难易程度查询试题
	 * @author blindeagle
	 * @param sectionId 章节号
	 * @param complexity 难易程度
	 * @return List<Integer> 符合条件的试题ID集合
	 */
	public List<Integer> queryFillBlanksQuestionIdBySectionIdAndComplexity(int sectionId, int complexity);
	
}
