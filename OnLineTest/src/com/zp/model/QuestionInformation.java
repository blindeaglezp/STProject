package com.zp.model;

/**
 * 每个人每次考试的试题信息实体
 * @author blindeagle
 * @version 1.0
 */
public class QuestionInformation {

	private int id; // id号
	private String studentId; // 学号
	private String courseId; // 课程号
	private String choiceQuestionId; // 选择题ID号
	private String judgeQuestionId; // 判断题ID号
	private String fillBlanksQuestionId; // 填空题ID号
	private String choiceQuestionAnswer; // 选择题答案
	private String judgeQuestionAnswer; // 判断题答案
	private String fillBlanksQuestionAnswer; // 填空题答案

	public String getChoiceQuestionAnswer() {
		return choiceQuestionAnswer;
	}

	public void setChoiceQuestionAnswer(String choiceQuestionAnswer) {
		this.choiceQuestionAnswer = choiceQuestionAnswer;
	}

	public String getJudgeQuestionAnswer() {
		return judgeQuestionAnswer;
	}

	public void setJudgeQuestionAnswer(String judgeQuestionAnswer) {
		this.judgeQuestionAnswer = judgeQuestionAnswer;
	}

	public String getFillBlanksQuestionAnswer() {
		return fillBlanksQuestionAnswer;
	}

	public void setFillBlanksQuestionAnswer(String fillBlanksQuestionAnswer) {
		this.fillBlanksQuestionAnswer = fillBlanksQuestionAnswer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getChoiceQuestionId() {
		return choiceQuestionId;
	}

	public void setChoiceQuestionId(String choiceQuestionId) {
		this.choiceQuestionId = choiceQuestionId;
	}

	public String getJudgeQuestionId() {
		return judgeQuestionId;
	}

	public void setJudgeQuestionId(String judgeQuestionId) {
		this.judgeQuestionId = judgeQuestionId;
	}

	public String getFillBlanksQuestionId() {
		return fillBlanksQuestionId;
	}

	public void setFillBlanksQuestionId(String fillBlanksQuestionId) {
		this.fillBlanksQuestionId = fillBlanksQuestionId;
	}

}
