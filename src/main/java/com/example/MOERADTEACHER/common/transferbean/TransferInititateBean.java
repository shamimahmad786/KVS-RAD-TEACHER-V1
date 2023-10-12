package com.example.MOERADTEACHER.common.transferbean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferInititateBean {
	
	private String teacher_id;
	private String transfer_application_number;
	private String teacher_name;
	private String teacher_gender;
	private String teacher_dob;
	private String teacher_employee_code;
	private String teacher_mobile;
	private String teacher_email;
	private String transfer_status;
	
	@JsonProperty(value="teacherId", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_id() {
		return teacher_id;
	}
	@JsonProperty(value="teacher_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	@JsonProperty(value="transferApplicationNumber", access=JsonProperty.Access.READ_ONLY)
	public String getTransfer_application_number() {
		return transfer_application_number;
	}
	@JsonProperty(value="transfer_application_number", access=JsonProperty.Access.WRITE_ONLY)
	public void setTransfer_application_number(String transfer_application_number) {
		this.transfer_application_number = transfer_application_number;
	}
	@JsonProperty(value="teacherName", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_name() {
		return teacher_name;
	}
	@JsonProperty(value="teacher_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	@JsonProperty(value="teacherGender", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_gender() {
		return teacher_gender;
	}
	@JsonProperty(value="teacher_gender", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_gender(String teacher_gender) {
		this.teacher_gender = teacher_gender;
	}
	@JsonProperty(value="teacherDob", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_dob() {
		return teacher_dob;
	}
	@JsonProperty(value="teacher_dob", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_dob(String teacher_dob) {
		this.teacher_dob = teacher_dob;
	}
	@JsonProperty(value="teacherEmployeeCode", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_employee_code() {
		return teacher_employee_code;
	}
	@JsonProperty(value="teacher_employee_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_employee_code(String teacher_employee_code) {
		this.teacher_employee_code = teacher_employee_code;
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
	@JsonProperty(value="transferStatus", access=JsonProperty.Access.READ_ONLY)
	public String getTransfer_status() {
		return transfer_status;
	}
	@JsonProperty(value="transfer_status", access=JsonProperty.Access.WRITE_ONLY)
	public void setTransfer_status(String transfer_status) {
		this.transfer_status = transfer_status;
	} 
	
	
	
}
