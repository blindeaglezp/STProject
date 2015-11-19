package com.be.model;

/**
 * 项目实体类
 * 
 * @author blindeagle
 * @version 1.0
 */
public class Project {

	private int id; // id号
	private String proId; // 项目号
	private String name; // 项目名
	private int budTarget; // 预期目标
	private int payNum; // 支付数
	private int total; // 总数
	private int payProgress; // 支付进度
	private int examine; // 审核状态
	private String city; // 市名
	private String county; // 县名
	private String subject; // 科目名
	private String scale; // 级别
	private String charNum; // 项目文号
	private String state; // 状态

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBudTarget() {
		return budTarget;
	}

	public void setBudTarget(int budTarget) {
		this.budTarget = budTarget;
	}

	public int getPayNum() {
		return payNum;
	}

	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPayProgress() {
		return payProgress;
	}

	public void setPayProgress(int payProgress) {
		this.payProgress = payProgress;
	}

	public int getExamine() {
		return examine;
	}

	public void setExamine(int examine) {
		this.examine = examine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getCharNum() {
		return charNum;
	}

	public void setCharNum(String charNum) {
		this.charNum = charNum;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
