package com.accenture;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

public class EmployeeForm extends ActionForm {

	private static final long serialVersionUID = -473562596852452021L;

	private ArrayList<String> turnOverTypeList = new ArrayList<String>();

	public ArrayList<String> getTurnOverTypeList() {
		return turnOverTypeList;
	}

	public void setTurnOverTypeList(ArrayList<String> turnOverTypeList) {
		this.turnOverTypeList = turnOverTypeList;
	}

	public ArrayList<String> getAttritionTypeList() {
		return attritionTypeList;
	}

	public void setAttritionTypeList(ArrayList<String> attritionTypeList) {
		this.attritionTypeList = attritionTypeList;
	}

	public ArrayList<String> getLevelList() {
		return levelList;
	}

	public void setLevelList(ArrayList<String> levelList) {
		this.levelList = levelList;
	}

	public ArrayList<String> getLocationList() {
		return locationList;
	}

	public void setLocationList(ArrayList<String> locationList) {
		this.locationList = locationList;
	}

	private ArrayList<String> attritionTypeList = new ArrayList<String>();
	private ArrayList<String> levelList = new ArrayList<String>();
	private ArrayList<String> locationList = new ArrayList<String>();

	private ArrayList<EmployeeForm> empUnderList = new ArrayList<EmployeeForm>();

	public ArrayList<EmployeeForm> getEmpUnderList() {
		return empUnderList;
	}

	public void setEmpUnderList(ArrayList<EmployeeForm> empUnderList) {
		this.empUnderList = empUnderList;
	}

	private String attritionType, turnOverType;

	public String getAttritionType() {
		return attritionType;
	}

	public void setAttritionType(String attritionType) {
		this.attritionType = attritionType;
	}

	public String getTurnOverType() {
		return turnOverType;
	}

	public void setTurnOverType(String turnOverType) {
		this.turnOverType = turnOverType;
	}

	private String rollOffDate;

	public String getRollOffDate() {
		return rollOffDate;
	}

	public void setRollOffDate(String rollOffDate) {
		this.rollOffDate = rollOffDate;
	}

	private String username, enterpriseId, emailId, password, doj, location, level, supervisor;

	private String errorMessgae;

	public String getErrorMessgae() {
		return errorMessgae;
	}

	public void setErrorMessgae(String errorMessgae) {
		this.errorMessgae = errorMessgae;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

}
