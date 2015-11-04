package com.zp.model;

/**
 * 填空题实体类
 * 
 * @author blindeagle
 * @version 1.0
 */
public class FillBlanksQuestion {

	private int id; // id
	private String description; // 试题描述
	private String blanks; // 所空内容
	private String courseId; // 课程号
	private String majorId; // 专业号
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

	public String getBlanks() {
		return blanks;
	}

	public void setBlanks(String blanks) {
		this.blanks = blanks;
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

}
