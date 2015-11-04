package com.zp.model;

/**
 * 章节实体类
 * @author blindeagle
 * @version 1.0
 */
public class Section {

	private int id; // id号
	private String name; // 章节名
	private String courseId; // 课程号
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
}
