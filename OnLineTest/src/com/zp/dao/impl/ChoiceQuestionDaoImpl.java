package com.zp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zp.dao.ChoiceQuestionDaoI;
import com.zp.model.ChoiceQuestion;
import com.zp.util.JdbcUtil;

/**
 * 选择题数据库操作实现类
 * @author blindeagle
 * @version 1.0
 */
public class ChoiceQuestionDaoImpl extends JdbcUtil implements ChoiceQuestionDaoI {
	
	private List<ChoiceQuestion> choiceQuestions = null; // 选择题集合
	ChoiceQuestion choiceQuestion = null; // 选择题对象

	@Override
	public ChoiceQuestion queryChoiceQuestionByQuestionId(int id) {
		String sql = "select cq_description,cq_choice,cq_result,cq_majorid,cq_courseid,cq_sectionid,cq_complexity from choicequestion where cq_id=?";
		Integer[] params = new Integer[] {id};
		rs = getQuery(sql, params);
		try {
			if (rs.next()) {
				choiceQuestion = new ChoiceQuestion();
				choiceQuestion.setId(id);
				choiceQuestion.setDescription(rs.getString(1));
				choiceQuestion.setChoice(rs.getString(2));
				choiceQuestion.setResult(rs.getString(3));
				choiceQuestion.setMajorId(rs.getString(4));
				choiceQuestion.setCourseId(rs.getString(5));
				choiceQuestion.setSectionId(rs.getInt(6));
				choiceQuestion.setComplexity(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return choiceQuestion;
	}

	@Override
	public List<ChoiceQuestion> queryChoiceQuestionBySectionIdAndComplexity(int sectionId, int complexity) {
		choiceQuestions = new ArrayList<ChoiceQuestion>();
		String sql = "select cq_id,cq_description,cq_choice,cq_result,cq_majorid,cq_courseid from choicequestion where cq_sectionid=? and cq_complexity=?";
		Integer[] params = new Integer[] {sectionId, complexity};
		rs = getQuery(sql, params);
		try {
			while (rs.next()) {
				choiceQuestion = new ChoiceQuestion();
				choiceQuestion.setId(rs.getInt(1));
				choiceQuestion.setDescription(rs.getString(2));
				choiceQuestion.setChoice(rs.getString(3));
				choiceQuestion.setResult(rs.getString(4));
				choiceQuestion.setMajorId(rs.getString(5));
				choiceQuestion.setCourseId(rs.getString(6));
				choiceQuestion.setSectionId(sectionId);
				choiceQuestion.setComplexity(complexity);
				choiceQuestions.add(choiceQuestion);
			}
			return choiceQuestions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
