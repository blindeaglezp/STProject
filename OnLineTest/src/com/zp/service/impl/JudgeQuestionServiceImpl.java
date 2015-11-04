package com.zp.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zp.dao.impl.JudgeQuestionDaoImpl;
import com.zp.model.JudgeQuestion;
import com.zp.service.JudgeQuestionServiceI;

/**
 * 判断题业务层实现类
 * @author blindeagle
 * @version 1.0
 */
public class JudgeQuestionServiceImpl implements JudgeQuestionServiceI {

	private List<JudgeQuestion> judgeQuestions = null; // 判断题集合
	List<Integer> judgeQuestionIds = null; // 判断题ID集合
	
	@Override
	public JudgeQuestion queryJudgeQuestionByQuestionId(int id) {
		return new JudgeQuestionDaoImpl().queryJudgeQuestionByQuestionId(id);
	}

	@Override
	public List<Integer> queryJudgeQuestionIdBySectionIdAndComplexity(int sectionId, int complexity) {
		judgeQuestions = new JudgeQuestionDaoImpl().queryJudgeQuestionIdBySectionIdAndComplexity(sectionId, complexity);
		if (judgeQuestions != null && judgeQuestions.size() > 0) {
			judgeQuestionIds = new ArrayList<Integer>();
			for (JudgeQuestion jq : judgeQuestions) {
				judgeQuestionIds.add(jq.getId());
			}
		}
		return judgeQuestionIds;
	}

}
