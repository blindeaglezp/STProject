package com.zp.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zp.dao.impl.ChoiceQuestionDaoImpl;
import com.zp.model.ChoiceQuestion;
import com.zp.service.ChoiceQuestionServiceI;

/**
 * 选择题业务实现类
 * @author 盲鹰
 * @version 1.0
 */
public class ChoiceQuestionServiceImpl implements ChoiceQuestionServiceI {
	private List<Integer> choiceQuestionIds = null;
	private List<ChoiceQuestion> choiceQuestions = null;

	@Override
	public ChoiceQuestion queryChoiceQuestionByQuestionId(int id) {
		return new ChoiceQuestionDaoImpl().queryChoiceQuestionByQuestionId(id);
	}

	@Override
	public List<Integer> queryChoiceQuestionIdBySectionIdAndComplexity(int sectionId, int complexity) {
		choiceQuestions = new ChoiceQuestionDaoImpl().queryChoiceQuestionBySectionIdAndComplexity(sectionId, complexity);
		if (choiceQuestions != null && choiceQuestions.size() > 0) {
			choiceQuestionIds = new ArrayList<Integer>();
			for (ChoiceQuestion cq : choiceQuestions) {
				choiceQuestionIds.add(cq.getId());
			}
		}
		return choiceQuestionIds;
	}

}
