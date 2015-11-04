package com.zp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zp.dao.FillBlanksQuestionDaoI;
import com.zp.model.FillBlanksQuestion;
import com.zp.util.JdbcUtil;

/**
 * 填空题数据库操作实现类
 * @author blindeagle
 * @version 1.0
 */
public class FillBlanksQuestionDaoImpl extends JdbcUtil implements FillBlanksQuestionDaoI {
	
	private FillBlanksQuestion fillBlanksQuestion = null; // 填空题对象
	private List<FillBlanksQuestion> fillBlanksQuestions = null; // 填空题集合对象

	@Override
	public FillBlanksQuestion queryFillBlanksQuestionByQuestionId(int id) {
		String sql = "select fbq_description,fbq_blanks,fbq_courseid,fbq_majorid,fbq_sectionid,fbq_complexity from fillblanksquestion where fbq_id=?";
		Integer[] params = {id};
		rs = getQuery(sql, params);
		try {
			if (rs.next()) {
				fillBlanksQuestion = new FillBlanksQuestion();
				fillBlanksQuestion.setId(id);
				fillBlanksQuestion.setDescription(rs.getString(1));
				fillBlanksQuestion.setBlanks(rs.getString(2));
				fillBlanksQuestion.setCourseId(rs.getString(3));
				fillBlanksQuestion.setMajorId(rs.getString(4));
				fillBlanksQuestion.setSectionId(rs.getInt(5));
				fillBlanksQuestion.setComplexity(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fillBlanksQuestion;
	}

	@Override
	public List<FillBlanksQuestion> queryFillBlanksQuestionBySectionIdAndComplexity(int sectionId, int complexity) {
		String sql = "select fbq_id,fbq_description,fbq_blanks,fbq_courseid,fbq_majorid from fillblanksquestion where fbq_sectionid=? and fbq_complexity=?";
		Integer[] params = new Integer[] {sectionId, complexity};
		fillBlanksQuestions = new ArrayList<FillBlanksQuestion>();
		rs = getQuery(sql, params);
		try {
			while (rs.next()) {
				fillBlanksQuestion = new FillBlanksQuestion();
				fillBlanksQuestion.setId(rs.getInt(1));
				fillBlanksQuestion.setDescription(rs.getString(rs.getString(2)));
				fillBlanksQuestion.setBlanks(rs.getString(3));
				fillBlanksQuestion.setCourseId(rs.getString(4));
				fillBlanksQuestion.setMajorId(rs.getString(5));
				fillBlanksQuestion.setSectionId(sectionId);
				fillBlanksQuestion.setComplexity(complexity);
				fillBlanksQuestions.add(fillBlanksQuestion);
			}
			return fillBlanksQuestions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
