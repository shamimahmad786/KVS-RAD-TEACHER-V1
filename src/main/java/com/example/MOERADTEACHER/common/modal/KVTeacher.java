package com.example.MOERADTEACHER.common.modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kv_teacher_profile_minimum", schema = "kv")
public class KVTeacher implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="teacher_id")
	private	Integer teacherId;
	@Column(name="teacher_name")
	private	String teacherName;
	@Column(name="post_code")			
	private	String postCode;
	@Column(name="subject_code")			
	private	String subjectCode;
	@Column(name="employee_code")			
	private	String employeeCode;
	@Column(name="present_station_code")			
	private	String presentStationCode;
	@Column(name="present_kv_code")		
	private	String presentKvCode;
	@Column(name="shift_type")		
	private	String shiftType;
	@Column(name="doj_present_post")		
	private	Date dojPresentPost;
	@Column(name="doj_present_stn_present_post")		
	private	Date dojPresentStnPresentPost;
	@Column(name="doj_present_kv_present_post")	
	private	Date dojPresentKvPresentPost;
	@Column(name="gender")
	private	Integer gender;
	@Column(name="dob")		
	private	Date dob;
	@Column(name="email")		
	private	String email;
	@Column(name="mobile")		
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
