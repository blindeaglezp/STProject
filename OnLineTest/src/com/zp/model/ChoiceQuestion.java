package com.zp.model;

/**
 * 选择题实体类
 * 
 * @author blindeagle
 * @version 1.0
 */
public class ChoiceQuestion {

	private int id; // 试题id号（自增）
	private String description; // 试题描述
	private String choice; // 试题选项
	private String result; // 试题答案
	private String majorId; // 专业号
	private String courseId; // 课程号
	private int sectionId; // 章节号
	private int complexity; // 难易程度（由1-5构成）

	public int getComplexity() {
		return complexity;
	}

	public void setComplexity(int complexity) {
		this.complexity = complexity;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMajorId() {
		return majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

}
