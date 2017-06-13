package com.accenture;



import java.util.ArrayList;

import org.apache.struts.action.ActionForm;


public class DashboardDataForm extends ActionForm
{
	
private static final long serialVersionUID = -473562596852452021L;



public ArrayList<String> getLRAddList() {
	return LRAddList;
}

public void setLRAddList(ArrayList<String> lRAddList) {
	LRAddList = lRAddList;
}

public ArrayList<String> getLRSubList() {
	return LRSubList;
}

public void setLRSubList(ArrayList<String> lRSubList) {
	LRSubList = lRSubList;
}

private ArrayList<String> LRAddList = new ArrayList<String>();
private ArrayList<String> LRSubList = new ArrayList<String>();




private String aseCountUp,aseCountDown,other1Up,other1Down,asePlusSeCountUp,asePlusSeCountDown,other2Up,other2Down,femaleCountUp,femaleCountDown,maleCountUp,maleCountDown;


public String getAseCountUp() {
	return aseCountUp;
}

public void setAseCountUp(String aseCountUp) {
	this.aseCountUp = aseCountUp;
}

public String getAseCountDown() {
	return aseCountDown;
}

public void setAseCountDown(String aseCountDown) {
	this.aseCountDown = aseCountDown;
}

public String getOther1Up() {
	return other1Up;
}

public void setOther1Up(String other1Up) {
	this.other1Up = other1Up;
}

public String getOther1Down() {
	return other1Down;
}

public void setOther1Down(String other1Down) {
	this.other1Down = other1Down;
}

public String getAsePlusSeCountUp() {
	return asePlusSeCountUp;
}

public void setAsePlusSeCountUp(String asePlusSeCountUp) {
	this.asePlusSeCountUp = asePlusSeCountUp;
}

public String getAsePlusSeCountDown() {
	return asePlusSeCountDown;
}

public void setAsePlusSeCountDown(String asePlusSeCountDown) {
	this.asePlusSeCountDown = asePlusSeCountDown;
}

public String getOther2Up() {
	return other2Up;
}

public void setOther2Up(String other2Up) {
	this.other2Up = other2Up;
}

public String getOther2Down() {
	return other2Down;
}

public void setOther2Down(String other2Down) {
	this.other2Down = other2Down;
}

public String getFemaleCountUp() {
	return femaleCountUp;
}

public void setFemaleCountUp(String femaleCountUp) {
	this.femaleCountUp = femaleCountUp;
}

public String getFemaleCountDown() {
	return femaleCountDown;
}

public void setFemaleCountDown(String femaleCountDown) {
	this.femaleCountDown = femaleCountDown;
}

public String getMaleCountUp() {
	return maleCountUp;
}

public void setMaleCountUp(String maleCountUp) {
	this.maleCountUp = maleCountUp;
}

public String getMaleCountDown() {
	return maleCountDown;
}

public void setMaleCountDown(String maleCountDown) {
	this.maleCountDown = maleCountDown;
}

private String empAdd,empSub;

public String getEmpAdd() {
	return empAdd;
}

public void setEmpAdd(String empAdd) {
	this.empAdd = empAdd;
}

public String getEmpSub() {
	return empSub;
}

public void setEmpSub(String empSub) {
	this.empSub = empSub;
}

private ArrayList<DashboardDataForm> EmpAddSubList = new ArrayList<DashboardDataForm>();

public ArrayList<DashboardDataForm> getEmpAddSubList() {
	return EmpAddSubList;
}

public void setEmpAddSubList(ArrayList<DashboardDataForm> empAddSubList) {
	EmpAddSubList = empAddSubList;
}






private ArrayList<String> AttritionCountList = new ArrayList<String>();
public ArrayList<String> getAttritionCountList() {
	return AttritionCountList;
}

public void setAttritionCountList(ArrayList<String> attritionCountList) {
	AttritionCountList = attritionCountList;
}

public ArrayList<String> getAttritionPercentageList() {
	return AttritionPercentageList;
}

public void setAttritionPercentageList(ArrayList<String> attritionPercentageList) {
	AttritionPercentageList = attritionPercentageList;
}

public ArrayList<String> getTurnOverCountList() {
	return TurnOverCountList;
}

public void setTurnOverCountList(ArrayList<String> turnOverCountList) {
	TurnOverCountList = turnOverCountList;
}

public ArrayList<String> getTurnOverPercentagetList() {
	return TurnOverPercentagetList;
}

public void setTurnOverPercentagetList(ArrayList<String> turnOverPercentagetList) {
	TurnOverPercentagetList = turnOverPercentagetList;
}

private ArrayList<String> AttritionPercentageList = new ArrayList<String>();
private ArrayList<String> TurnOverCountList = new ArrayList<String>();
private ArrayList<String> TurnOverPercentagetList = new ArrayList<String>();

private String otherJobRollOffPercentage,higherStudiesRollOffPercentage,LocChangeRollOffPercentage,PersonnalIssueRollOffPercentage,HealthRollOffPercentage,HealthRollOffCount;

public String getOtherJobRollOffPercentage() {
	return otherJobRollOffPercentage;
}

public void setOtherJobRollOffPercentage(String otherJobRollOffPercentage) {
	this.otherJobRollOffPercentage = otherJobRollOffPercentage;
}

public String getHigherStudiesRollOffPercentage() {
	return higherStudiesRollOffPercentage;
}

public void setHigherStudiesRollOffPercentage(String higherStudiesRollOffPercentage) {
	this.higherStudiesRollOffPercentage = higherStudiesRollOffPercentage;
}

public String getLocChangeRollOffPercentage() {
	return LocChangeRollOffPercentage;
}

public void setLocChangeRollOffPercentage(String locChangeRollOffPercentage) {
	LocChangeRollOffPercentage = locChangeRollOffPercentage;
}

public String getPersonnalIssueRollOffPercentage() {
	return PersonnalIssueRollOffPercentage;
}

public void setPersonnalIssueRollOffPercentage(String personnalIssueRollOffPercentage) {
	PersonnalIssueRollOffPercentage = personnalIssueRollOffPercentage;
}

public String getHealthRollOffPercentage() {
	return HealthRollOffPercentage;
}

public void setHealthRollOffPercentage(String healthRollOffPercentage) {
	HealthRollOffPercentage = healthRollOffPercentage;
}

public String getHealthRollOffCount() {
	return HealthRollOffCount;
}

public void setHealthRollOffCount(String healthRollOffCount) {
	HealthRollOffCount = healthRollOffCount;
}

private String otherJobRollOffNumber,higherStudiesRollOffNumber,LocChangeRollOffNumber,PersonnalIssueRollOffNumber;


public String getOtherJobRollOffNumber() {
	return otherJobRollOffNumber;
}

public void setOtherJobRollOffNumber(String otherJobRollOffNumber) {
	this.otherJobRollOffNumber = otherJobRollOffNumber;
}

public String getHigherStudiesRollOffNumber() {
	return higherStudiesRollOffNumber;
}

public void setHigherStudiesRollOffNumber(String higherStudiesRollOffNumber) {
	this.higherStudiesRollOffNumber = higherStudiesRollOffNumber;
}

public String getLocChangeRollOffNumber() {
	return LocChangeRollOffNumber;
}

public void setLocChangeRollOffNumber(String locChangeRollOffNumber) {
	LocChangeRollOffNumber = locChangeRollOffNumber;
}

public String getPersonnalIssueRollOffNumber() {
	return PersonnalIssueRollOffNumber;
}

public void setPersonnalIssueRollOffNumber(String personnalIssueRollOffNumber) {
	PersonnalIssueRollOffNumber = personnalIssueRollOffNumber;
}

private ArrayList<String> GreenList = new ArrayList<String>();
public ArrayList<String> getGreenList() {
	return GreenList;
}

public void setGreenList(ArrayList<String> greenList) {
	GreenList = greenList;
}

public ArrayList<String> getRedList() {
	return RedList;
}

public void setRedList(ArrayList<String> redList) {
	RedList = redList;
}

public ArrayList<String> getNeutralList() {
	return NeutralList;
}

public void setNeutralList(ArrayList<String> neutralList) {
	NeutralList = neutralList;
}

private ArrayList<String> RedList = new ArrayList<String>();
private ArrayList<String> NeutralList = new ArrayList<String>();

private String empCountChange,aseCountChange,asePlusSeCountChange,gcpCountChange,diversityRatioChange,loanResourceChange,nonBillableChange;


public String getEmpCountChange() {
	return empCountChange;
}

public void setEmpCountChange(String empCountChange) {
	this.empCountChange = empCountChange;
}

public String getAseCountChange() {
	return aseCountChange;
}

public void setAseCountChange(String aseCountChange) {
	this.aseCountChange = aseCountChange;
}

public String getAsePlusSeCountChange() {
	return asePlusSeCountChange;
}

public void setAsePlusSeCountChange(String asePlusSeCountChange) {
	this.asePlusSeCountChange = asePlusSeCountChange;
}

public String getGcpCountChange() {
	return gcpCountChange;
}

public void setGcpCountChange(String gcpCountChange) {
	this.gcpCountChange = gcpCountChange;
}

public String getDiversityRatioChange() {
	return diversityRatioChange;
}

public void setDiversityRatioChange(String diversityRatioChange) {
	this.diversityRatioChange = diversityRatioChange;
}

public String getLoanResourceChange() {
	return loanResourceChange;
}

public void setLoanResourceChange(String loanResourceChange) {
	this.loanResourceChange = loanResourceChange;
}

public String getNonBillableChange() {
	return nonBillableChange;
}

public void setNonBillableChange(String nonBillableChange) {
	this.nonBillableChange = nonBillableChange;
}

private String empCount;

public String getEmpCount() {
	return empCount;
}

public void setEmpCount(String empCount) {
	this.empCount = empCount;
}

private String aseCount,aseCountPercentage,asePlusScCount,asePlusScPer,gcpCount,femaleCount,maleCount;
private String gcpCountPercentage;
private String loanedResourceCount;
private String amCount,mCount,seCount,smCount,sExecCount,sseCount,tlCount;


public String getAmCount() {
	return amCount;
}

public void setAmCount(String amCount) {
	this.amCount = amCount;
}

public String getmCount() {
	return mCount;
}

public void setmCount(String mCount) {
	this.mCount = mCount;
}

public String getSeCount() {
	return seCount;
}

public void setSeCount(String seCount) {
	this.seCount = seCount;
}

public String getSmCount() {
	return smCount;
}

public void setSmCount(String smCount) {
	this.smCount = smCount;
}

public String getsExecCount() {
	return sExecCount;
}

public void setsExecCount(String sExecCount) {
	this.sExecCount = sExecCount;
}

public String getSseCount() {
	return sseCount;
}

public void setSseCount(String sseCount) {
	this.sseCount = sseCount;
}

public String getTlCount() {
	return tlCount;
}

public void setTlCount(String tlCount) {
	this.tlCount = tlCount;
}

public String getLoanedResourceCount() {
	return loanedResourceCount;
}

public void setLoanedResourceCount(String loanedResourceCount) {
	this.loanedResourceCount = loanedResourceCount;
}

public String getGcpCountPercentage() {
	return gcpCountPercentage;
}

public void setGcpCountPercentage(String gcpCountPercentage) {
	this.gcpCountPercentage = gcpCountPercentage;
}

public String getAseCount() {
	return aseCount;
}

public void setAseCount(String aseCount) {
	this.aseCount = aseCount;
}

public String getAseCountPercentage() {
	return aseCountPercentage;
}

public void setAseCountPercentage(String aseCountPercentage) {
	this.aseCountPercentage = aseCountPercentage;
}

public String getAsePlusScCount() {
	return asePlusScCount;
}

public void setAsePlusScCount(String asePlusScCount) {
	this.asePlusScCount = asePlusScCount;
}

public String getAsePlusScPer() {
	return asePlusScPer;
}

public void setAsePlusScPer(String asePlusScPer) {
	this.asePlusScPer = asePlusScPer;
}

public String getGcpCount() {
	return gcpCount;
}

public void setGcpCount(String gcpCount) {
	this.gcpCount = gcpCount;
}

public String getFemaleCount() {
	return femaleCount;
}

public void setFemaleCount(String femaleCount) {
	this.femaleCount = femaleCount;
}

public String getMaleCount() {
	return maleCount;
}

public void setMaleCount(String maleCount) {
	this.maleCount = maleCount;
}
	
}
