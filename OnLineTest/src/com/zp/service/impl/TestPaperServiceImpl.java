package com.zp.service.impl;

import java.util.List;

import com.zp.dao.impl.TestPaperDaoImpl;
import com.zp.model.ChoiceQuestion;
import com.zp.model.FillBlanksQuestion;
import com.zp.model.JudgeQuestion;
import com.zp.model.TestPaper;
import com.zp.service.TestPaperServiceI;
import com.zp.util.TestPaperData;

/**
 * 试卷信息操作业务层实现类
 * @author blindeagle
 * @version 1.0
 */
public class TestPaperServiceImpl implements TestPaperServiceI {
	
	private List<Integer> questionIds = null; // 所有试题id
	private String choiceQuestionId = null; // 选择题id号信息
	private String judgeQuestionId = null; // 判断题id信息
	private String fillBlanksQuestionId = null; // 填空题id信息
	private int choiceQuestionCount = 0;
	private int judgeQuestionCount = 0;
	private int fillBlanksQuestionCount = 0;
	private int questionCount = 0; // 试题总数

	@Override
	public List<TestPaper> queryTestPaperByCourseId(String courseId) {
		return new TestPaperDaoImpl().queryTestPaperByCourseId(courseId);
	}

	@Override
	public TestPaper queryTestPaperByTestPaperId(String testPaperId) {
		return new TestPaperDaoImpl().queryTestPaperByTestPaperId(testPaperId);
	}
	
	@Override
	public int findAndPackageMap(TestPaper testPaper) {
		String[] questionInfo = null; // 封装多个{章节号，难以程度，试题数量}信息
		String questionType = null; // 试题类型
		
		// 获取试卷中选择题的信息，包括多组的{章节号，难以程度，试题数量}组合
		String choiceQuestionInfo = testPaper.getChoiceQuestionInfo();
		if (choiceQuestionInfo != null) {
			questionInfo = choiceQuestionInfo.split(",");
			questionType = "choiceQuestion";
			addQuestionToData(questionType, questionInfo);
		}
		
		String judgeQuestionInfo = testPaper.getJudgeQuestionInfo();
		if (judgeQuestionInfo != null) {
			questionInfo = judgeQuestionInfo.split(",");
			questionType = "judgeQuestion";
			addQuestionToData(questionType, questionInfo);
		}
		
		String fillBlanksQuestionInfo = testPaper.getFillBlanksQuestionInfo();
		if (fillBlanksQuestionInfo != null) {
			System.out.println("33333");
			questionInfo = fillBlanksQuestionInfo.split(",");
			questionType = "fillBlanksQuestion";
			addQuestionToData(questionType, questionInfo);
		}
		return questionCount;
		
	}
	
	private void addQuestionToData(String questionType, String[] questionInfo) {
		for (int i = 0; i < questionInfo.length; i++) {
			// 获取到试题信息的一组数据(章节号，难易程度，试题数量)
			int sectionId = Integer.parseInt(questionInfo[i].split("==")[0]); // 章节号
			int questionComplexity = Integer.parseInt(questionInfo[i].split("==")[1]); // 难易程度
			int questionNum = Integer.parseInt(questionInfo[i].split("==")[2]); // 试题数量
			
			// 根据章节id号及试题难易程度查询到所有试题的id号
			if ("choiceQuestion".equals(questionType)) {
				questionIds = new ChoiceQuestionServiceImpl().queryChoiceQuestionIdBySectionIdAndComplexity(sectionId, questionComplexity);
			} else if ("judgeQuestion".equals(questionType)) {
			 	questionIds = new JudgeQuestionServiceImpl().queryJudgeQuestionIdBySectionIdAndComplexity(sectionId, questionComplexity);
			} else if ("fillBlanksQuestion".equals(questionType)) {
				questionIds = new FillBlanksQuestionServiceImpl().queryFillBlanksQuestionIdBySectionIdAndComplexity(sectionId, questionComplexity);
			}
			if (questionIds != null) {
				// 该数组用来保存特定章节的试题id号
				int[] questionIdsArr = new int[questionNum];
				// 随机查询指定章节的questionNum道试题
				for (int j = 0; j < questionNum; j++) {
					boolean flag; // 标记是否已经获取过此试题
					int questionId;
					// 判断是否已经读取过此试题
					do {
						flag = false;
						questionId = (int) (Math.random() * questionIds.size());
						for (int k = 0; k < j; k++) {
							if (questionId == questionIdsArr[k]) {
								flag = true;
								break;
							}
						}
					} while(flag);
					
					// 将试题id号连接
					if ("choiceQuestion".equals(questionType)) {
						choiceQuestionId += (questionId + ",");
						choiceQuestionCount++;
//						questionCount++;
					} else if ("judgeQuestion".equals(questionType)) {
						judgeQuestionId += (questionId + ",");
						judgeQuestionCount++;
//						questionCount++;
					} else if ("fillBlanksQuestion".equals(questionType)) {
						fillBlanksQuestionId += (questionId + ",");
						fillBlanksQuestionCount++;
//						questionCount++;
					}
				}
			}
		}
		// 将临时信息存储
		TestPaper
	}

}
