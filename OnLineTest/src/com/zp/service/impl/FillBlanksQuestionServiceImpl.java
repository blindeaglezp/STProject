package com.zp.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zp.dao.impl.FillBlanksQuestionDaoImpl;
import com.zp.model.FillBlanksQuestion;
import com.zp.service.FillBlanksQuestionServiceI;

/**
 * 填空题业务实现类
 * @author 盲鹰
 * @version 1.0
 */
public class FillBlanksQuestionServiceImpl implements FillBlanksQuestionServiceI {

	private List<FillBlanksQuestion> fillBlanksQuestions = null; // 填空题集合对象
	private List<Integer> fillBlanksQuestionIds = null;// 填空题ID集合对象
	
	@Override
	public FillBlanksQuestion queryFillBlanksQuestionByQuestionId(int id) {
		return new FillBlanksQuestionDaoImpl().queryFillBlanksQuestionByQuestionId(id);
	}

	@Override
	public List<Integer> queryFillBlanksQuestionIdBySectionIdAndComplexity(int sectionId, int complexity) {
		fillBlanksQuestions = new FillBlanksQuestionDaoImpl().queryFillBlanksQuestionBySectionIdAndComplexity(sectionId, complexity);
		if (fillBlanksQuestions != null && fillBlanksQuestions.size() > 0) {
			fillBlanksQuestionIds = new ArrayList<Integer>();
			for (FillBlanksQuestion fbq : fillBlanksQuestions) {
				fillBlanksQuestionIds.add(fbq.getId());
			}
		}
		return fillBlanksQuestionIds;
	}

}
