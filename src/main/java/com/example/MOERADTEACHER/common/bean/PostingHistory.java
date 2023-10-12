package com.example.MOERADTEACHER.common.bean;

import java.io.Serializable;
import java.util.List;

public class PostingHistory implements Serializable{
public	String regionCode;
public	String regionName;
public	String stationCode;
public	String stationName;
public	String kvCode;
public	String udiseSchoolName;
public	String udiseSchCode;
public	String stationType;
public	String workExperienceId;
public	String teacherId;
public	String workStartDate;
public	String workEndDate;
//public String groundForTransfer;
public List groundForTransfer;
public String shiftType;
public String transferWorkExperienceId;
public String natureOfAppointment;
public String positionType;


public String getRegionCode() {
	return regionCode;
}
public void setRegionCode(String regionCode) {
	this.regionCode = regionCode;
}
public String getRegionName() {
	return regionName;
}
public void setRegionName(String regionName) {
	this.regionName = regionName;
}
public String getStationCode() {
	return stationCode;
}
public void setStationCode(String stationCode) {
	this.stationCode = stationCode;
}
public String getStationName() {
	return stationName;
}
public void setStationName(String stationName) {
	this.stationName = stationName;
}
public String getKvCode() {
	return kvCode;
}
public void setKvCode(String kvCode) {
	this.kvCode = kvCode;
}

public String getUdiseSchCode() {
	return udiseSchCode;
}
public void setUdiseSchCode(String udiseSchCode) {
	this.udiseSchCode = udiseSchCode;
}
public String getStationType() {
	return stationType;
}
public void setStationType(String stationType) {
	this.stationType = stationType;
}
public String getWorkExperienceId() {
	return workExperienceId;
}
public void setWorkExperienceId(String workExperienceId) {
	this.workExperienceId = workExperienceId;
}
public String getTeacherId() {
	return teacherId;
}
public void setTeacherId(String teacherId) {
	this.teacherId = teacherId;
}
public String getWorkStartDate() {
	return workStartDate;
}
public void setWorkStartDate(String workStartDate) {
	this.workStartDate = workStartDate;
}
public String getWorkEndDate() {
	return workEndDate;
}
public void setWorkEndDate(String workEndDate) {
	this.workEndDate = workEndDate;
}
public String getUdiseSchoolName() {
	return udiseSchoolName;
}
public void setUdiseSchoolName(String udiseSchoolName) {
	this.udiseSchoolName = udiseSchoolName;
}
//public String getGroundForTransfer() {
//	return groundForTransfer;
//}
//public void setGroundForTransfer(String groundForTransfer) {
//	this.groundForTransfer = groundForTransfer;
//}
public String getShiftType() {
	return shiftType;
}
public void setShiftType(String shiftType) {
	this.shiftType = shiftType;
}
public String getTransferWorkExperienceId() {
	return transferWorkExperienceId;
}
public void setTransferWorkExperienceId(String transferWorkExperienceId) {
	this.transferWorkExperienceId = transferWorkExperienceId;
}
public String getNatureOfAppointment() {
	return natureOfAppointment;
}
public void setNatureOfAppointment(String natureOfAppointment) {
	this.natureOfAppointment = natureOfAppointment;
}
public String getPositionType() {
	return positionType;
}
public void setPositionType(String positionType) {
	this.positionType = positionType;
}
public List getGroundForTransfer() {
	return groundForTransfer;
}
public void setGroundForTransfer(List groundForTransfer) {
	this.groundForTransfer = groundForTransfer;
}





}
