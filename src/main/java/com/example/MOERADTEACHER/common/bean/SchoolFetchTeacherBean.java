package com.example.MOERADTEACHER.common.bean;

import java.io.Serializable;

public class SchoolFetchTeacherBean implements Serializable{
	
private String currentUdiseSchCode;
private Integer teacherId;
private String businessUnitTypeCode;
private String kvName;

public String getCurrentUdiseSchCode() {
	return currentUdiseSchCode;
}
public void setCurrentUdiseSchCode(String currentUdiseSchCode) {
	this.currentUdiseSchCode = currentUdiseSchCode;
}
public Integer getTeacherId() {
	return teacherId;
}
public void setTeacherId(Integer teacherId) {
	this.teacherId = teacherId;
}
public String getBusinessUnitTypeCode() {
	return businessUnitTypeCode;
}
public void setBusinessUnitTypeCode(String businessUnitTypeCode) {
	this.businessUnitTypeCode = businessUnitTypeCode;
}
public String getKvName() {
	return kvName;
}
public void setKvName(String kvName) {
	this.kvName = kvName;
}



}
