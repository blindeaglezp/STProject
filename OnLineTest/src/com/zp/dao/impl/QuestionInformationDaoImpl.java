package com.zp.dao.impl;

import com.zp.dao.QuestionInformationDaoI;
import com.zp.model.QuestionInformation;
import com.zp.util.JdbcUtil;

/**
 * 试题信息数据库操作实现类
 * @author blindeagle
 * @version 1.0
 */
public class QuestionInformationDaoImpl extends JdbcUtil implements QuestionInformationDaoI {

	@Override
	public int insertQuestionInformation(QuestionInformation questionInformation) {
		String sql = "insert into questioninformation(studentid,courseid,testpaperid,choicequestionid"
				+ ",judgequestionid,fillblanksquestionid) values(?,?,?,?,?,?)";
		String[] params = new String[] {questionInformation.getStudentId(), questionInformation.getCourseId(), questionInformation.getTestPaperId(),
				questionInformation.getChoiceQuestionId(), questionInformation.getJudgeQuestionId(), questionInformation.getFillBlanksQuestionId()};
		int result = getUpdate(sql, params);
		return result;
	}

}
