package com.be.model;

/**
 * 科目实体类
 * @author gaohailong
 * @version 1.0
 */
public class Subject {
	
	private int id; // 科目id
	private String name; // 科目名
	private String state; // 状态

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
