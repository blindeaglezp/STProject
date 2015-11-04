package com.zp.model;

/**
 * 联系方式实体类
 * @author blindeagle
 * @version 1.0
 */
public class Connect {

	private String name;		//名称（例如：QQ）
	private String value;		//值（例如：2430168648）
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
