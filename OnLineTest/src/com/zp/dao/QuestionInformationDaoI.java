package com.zp.dao;

import com.zp.model.QuestionInformation;

/**
 * 试题信息数据库操作接口
 * @author blindeagle
 * @version 1.0
 */
public interface QuestionInformationDaoI {

	/**
	 * 添加试题信息
	 * @author blindeagle
	 * @param questionInformation 试题信息对象
	 * @return int 受影响的记录条数
	 */
	public int insertQuestionInformation(QuestionInformation questionInformation);
	
}
