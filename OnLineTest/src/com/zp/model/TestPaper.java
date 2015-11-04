package com.zp.model;

/**
 * 试卷信息实体类
 * 
 * @author 盲鹰
 * @version 1.0
 */
public class TestPaper {

	private String id;// 试卷号
	private String name;// 试卷名称
	private String courseId;// 课程号
	private String majorId;// 专业号
	private String createDate;// 创建时间
	private String testDate;// 考试开始时间
	private int testTime;// 考试总时长
	private int score;// 试卷总分数
	private String choiceQuestionInfo;// 选择题的信息（包括章节号、试题难度、试题数量）
	private String judgeQuestionInfo; // 判断题的信息
	private String fillBlanksQuestionInfo; // 填空题的信息

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTestTime() {
		return testTime;
	}

	public void setTestTime(int testTime) {
		this.testTime = testTime;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getMajorId() {
		return majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getChoiceQuestionInfo() {
		return choiceQuestionInfo;
	}

	public void setChoiceQuestionInfo(String choiceQuestionInfo) {
		this.choiceQuestionInfo = choiceQuestionInfo;
	}

	public String getJudgeQuestionInfo() {
		return judgeQuestionInfo;
	}

	public void setJudgeQuestionInfo(String judgeQuestionInfo) {
		this.judgeQuestionInfo = judgeQuestionInfo;
	}

	public String getFillBlanksQuestionInfo() {
		return fillBlanksQuestionInfo;
	}

	public void setFillBlanksQuestionInfo(String fillBlanksQuestionInfo) {
		this.fillBlanksQuestionInfo = fillBlanksQuestionInfo;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
