package com.example.MOERADTEACHER.common.bean;

import java.io.Serializable;
import java.util.Date;

public class KVTeacherBean implements Serializable{
	
	private	Integer teacherId;
	private	String teacherName;
	private	String postCode;
	private	String subjectCode;
	private	String employeeCode;
	private	String presentStationCode;
	private	String presentKvCode;
	private	String shiftType;
	private	Date dojPresentPost;
	private	Date dojPresentStnPresentPost;
	private	Date dojPresentKvPresentPost;
	private	Integer gender;
	private	Date dob;
	private	String email;
	private	String mobile;
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getPresentStationCode() {
		return presentStationCode;
	}
	public void setPresentStationCode(String presentStationCode) {
		this.presentStationCode = presentStationCode;
	}
	public String getPresentKvCode() {
		return presentKvCode;
	}
	public void setPresentKvCode(String presentKvCode) {
		this.presentKvCode = presentKvCode;
	}
	public String getShiftType() {
		return shiftType;
	}
	public void setShiftType(String shiftType) {
		this.shiftType = shiftType;
	}
	public Date getDojPresentPost() {
		return dojPresentPost;
	}
	public void setDojPresentPost(Date dojPresentPost) {
		this.dojPresentPost = dojPresentPost;
	}
	public Date getDojPresentStnPresentPost() {
		return dojPresentStnPresentPost;
	}
	public void setDojPresentStnPresentPost(Date dojPresentStnPresentPost) {
		this.dojPresentStnPresentPost = dojPresentStnPresentPost;
	}
	public Date getDojPresentKvPresentPost() {
		return dojPresentKvPresentPost;
	}
	public void setDojPresentKvPresentPost(Date dojPresentKvPresentPost) {
		this.dojPresentKvPresentPost = dojPresentKvPresentPost;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
