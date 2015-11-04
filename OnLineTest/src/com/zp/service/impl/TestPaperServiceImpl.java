package com.zp.service.impl;

import java.util.List;

import com.zp.dao.impl.ChoiceQuestionDaoImpl;
import com.zp.dao.impl.TestPaperDaoImpl;
import com.zp.model.ChoiceQuestion;
import com.zp.model.FillBlanksQuestion;
import com.zp.model.JudgeQuestion;
import com.zp.model.TestPaper;
import com.zp.service.TestPaperServiceI;
import com.zp.util.TestPaperData;

/**
 * 试卷信息操作业务层实现类
 * @author 盲鹰
 * @version 1.0
 */
public class TestPaperServiceImpl implements TestPaperServiceI {
	
	private ChoiceQuestion choiceQuestion = null; // 选择题对象
	private JudgeQuestion judgeQuestion = null; // 判断题对象
	private FillBlanksQuestion fillBlanksQuestion = null; // 填空题对象
	private List<Integer> questionIds = null; // 试题id号集合
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
			
			System.out.println(sectionId);
			System.out.println(questionComplexity);
			System.out.println(questionNum);
			System.out.println("********************");
			
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
					
					// 讲试题添加到试题数据集合
					if ("choiceQuestion".equals(questionType)) {
						choiceQuestion = new ChoiceQuestionDaoImpl().queryChoiceQuestionByQuestionId(questionId);
						if (choiceQuestion != null) {
							TestPaperData.questions.put(questionCount + 1, choiceQuestion); // 将查询到的试题添加到试题集合
							questionCount++; // 试题总数加1
						}
					} else if ("judgeQuestion".equals(questionType)) {
						judgeQuestion = new JudgeQuestionServiceImpl().queryJudgeQuestionByQuestionId(questionId);
						if (judgeQuestion != null) {
							TestPaperData.questions.put(questionCount + 1, judgeQuestion);
							questionCount++;
						}
					} else if ("fillBlanksQuestion".equals(questionType)) {
						fillBlanksQuestion = new FillBlanksQuestionServiceImpl().queryFillBlanksQuestionByQuestionId(questionId);
						if (fillBlanksQuestion != null) {
							TestPaperData.questions.put(questionCount + 1, fillBlanksQuestion);
							questionCount++;
						}
					}
				}
			}
		}
	}

}
