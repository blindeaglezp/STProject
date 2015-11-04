package com.zp.dao;

import java.util.List;

import com.zp.model.FillBlanksQuestion;

/**
 * 填空题数据库操作类抽象
 * @author blindeagle
 * @version 1.0
 */
public interface FillBlanksQuestionDaoI {
	
	/**
	 * 根据填空题id查询试题
	 * @author blindeagle
	 * @param id 填空题id
	 * @return FillBlanksQuestion 填空题试题对象
	 */
	public FillBlanksQuestion queryFillBlanksQuestionByQuestionId(int id);
	
	/**
	 * 根据填空题的章节号和试题难易程度查询试题
	 * @author blindeagle
	 * @param sectionId 章节号
	 * @param complexity 难易程度
	 * @return List<FillBlanksQuestion> 符合条件的填空题的集合
	 */
	public List<FillBlanksQuestion> queryFillBlanksQuestionBySectionIdAndComplexity(int sectionId, int complexity);
	
}
