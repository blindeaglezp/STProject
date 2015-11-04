package com.zp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zp.dao.JudgeQuestionDaoI;
import com.zp.model.JudgeQuestion;
import com.zp.util.JdbcUtil;

/**
 * 判断题数据库操作类实现
 * @author blindeagle
 * @version 1.0
 */
public class JudgeQuestionDaoImpl extends JdbcUtil implements JudgeQuestionDaoI {
	
	private JudgeQuestion judgeQuestion = null; // 判断题对象
	private List<JudgeQuestion> judgeQuestions = null; // 判断题集合对象

	@Override
	public JudgeQuestion queryJudgeQuestionByQuestionId(int id) {
		String sql = "select jq_description,jq_trueorfalse,jq_courseid,jq_majorid,jq_sectionid,jq_complexity from judgequestion where jq_id=?";
		Integer[] params = new Integer[] {id};
		rs = getQuery(sql, params);
		try {
			if (rs.next()) {
				judgeQuestion = new JudgeQuestion();
				judgeQuestion.setId(id);
				judgeQuestion.setDescription(rs.getString(1));
				judgeQuestion.setTrueOrFalse(rs.getString(2));
				judgeQuestion.setCourseId(rs.getString(3));
				judgeQuestion.setMajorId(rs.getString(4));
				judgeQuestion.setSectionId(rs.getInt(5));
				judgeQuestion.setComplexity(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return judgeQuestion;
	}

	@Override
	public List<JudgeQuestion> queryJudgeQuestionIdBySectionIdAndComplexity(int sectionId, int complexity) {
		String sql = "select jq_id,jq_description,jq_trueorfalse,jq_courseid,jq_majorid from judgequestion where jq_sectionid=? and jq_complexity=?";
		Integer[] params = new Integer[] {sectionId, complexity};
		judgeQuestions = new ArrayList<JudgeQuestion>();
		rs = getQuery(sql, params);
		try {
			while (rs.next()) {
				judgeQuestion = new JudgeQuestion();
				judgeQuestion.setId(rs.getInt(1));
				judgeQuestion.setDescription(rs.getString(2));
				judgeQuestion.setTrueOrFalse(rs.getString(3));
				judgeQuestion.setCourseId(rs.getString(4));
				judgeQuestion.setMajorId(rs.getString(5));
				judgeQuestion.setSectionId(sectionId);
				judgeQuestion.setComplexity(complexity);
				judgeQuestions.add(judgeQuestion);
			}
			return judgeQuestions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}










