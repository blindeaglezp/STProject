package com.be.model;

/**
 * 县实体类
 * @author blindeagle
 * @version 1.0
 */
public class County {

	private int id; // id号
	private String name; // 县名
	private String city; // 市名
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
