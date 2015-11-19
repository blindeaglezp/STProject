package com.be.model;

/**
 * 市实体类
 * 
 * @author blindeagle
 * @version 1.0
 */
public class City {

	private int id; // id号
	private String name; // 市名
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
