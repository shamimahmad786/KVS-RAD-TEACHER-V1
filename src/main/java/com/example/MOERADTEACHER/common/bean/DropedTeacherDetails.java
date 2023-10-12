package com.example.MOERADTEACHER.common.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DropedTeacherDetails implements Serializable{
	
	private String teacher_id;
	private String teacher_name;
	private String teacher_mobile;
	private String teacher_email;
	private String teacher_dob;
	private String final_status;
	private String kv_name;
	private String station_name;
	private String current_udise_sch_code;
	private Integer drop_box_flag;
	
	
	@JsonProperty(value="teacherId", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_id() {
		return teacher_id;
	}
	@JsonProperty(value="teacher_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	@JsonProperty(value="teacherName", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_name() {
		return teacher_name;
	}
	@JsonProperty(value="teacher_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	@JsonProperty(value="teacherMobile", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_mobile() {
		return teacher_mobile;
	}
	@JsonProperty(value="teacher_mobile", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_mobile(String teacher_mobile) {
		this.teacher_mobile = teacher_mobile;
	}
	@JsonProperty(value="teacherEmail", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_email() {
		return teacher_email;
	}
	@JsonProperty(value="teacher_email", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_email(String teacher_email) {
		this.teacher_email = teacher_email;
	}
	@JsonProperty(value="teacherDob", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_dob() {
		return teacher_dob;
	}
	@JsonProperty(value="teacher_dob", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_dob(String teacher_dob) {
		this.teacher_dob = teacher_dob;
	}
	@JsonProperty(value="finalStatus", access=JsonProperty.Access.READ_ONLY)
	public String getFinal_status() {
		return final_status;
	}
	@JsonProperty(value="final_status", access=JsonProperty.Access.WRITE_ONLY)
	public void setFinal_status(String final_status) {
		this.final_status = final_status;
	}
	@JsonProperty(value="kvName", access=JsonProperty.Access.READ_ONLY)
	public String getKv_name() {
		return kv_name;
	}
	@JsonProperty(value="kv_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setKv_name(String kv_name) {
		this.kv_name = kv_name;
	}
	@JsonProperty(value="stationName", access=JsonProperty.Access.READ_ONLY)
	public String getStation_name() {
		return station_name;
	}
	@JsonProperty(value="station_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	@JsonProperty(value="currentUdiseSchCode", access=JsonProperty.Access.READ_ONLY)
	public String getCurrent_udise_sch_code() {
		return current_udise_sch_code;
	}
	@JsonProperty(value="current_udise_sch_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setCurrent_udise_sch_code(String current_udise_sch_code) {
		this.current_udise_sch_code = current_udise_sch_code;
	}
	@JsonProperty(value="dropBoxFlag", access=JsonProperty.Access.READ_ONLY)
	public Integer getDrop_box_flag() {
		return drop_box_flag;
	}
	@JsonProperty(value="drop_box_flag", access=JsonProperty.Access.WRITE_ONLY)
	public void setDrop_box_flag(Integer drop_box_flag) {
		this.drop_box_flag = drop_box_flag;
	}
	
	
	
	
}
