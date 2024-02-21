package com.example.MOERADTEACHER.common.dropboxbean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDetailsSearchList {
	private Integer teacherId;
	private String teacherName;
	private String teacherEmployeeCode;
	private String teacherGender;
	private String teachingNonteaching;
	private String lastPromotionPositionType;
	private String kvCode;
	private String kvName;
	private Integer dropBoxFlag;
	private Integer employeedropid;
	@JsonProperty(value="teacherId", access=JsonProperty.Access.READ_ONLY)
	public Integer getTeacherId() {
		return teacherId;
	}
	
	@JsonProperty(value="teacher_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	
	@JsonProperty(value="teacherName", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherName() {
		return teacherName;
	}
	@JsonProperty(value="teacher_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	@JsonProperty(value="teacherEmployeeCode", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherEmployeeCode() {
		return teacherEmployeeCode;
	}
	@JsonProperty(value="teacher_employee_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherEmployeeCode(String teacherEmployeeCode) {
		this.teacherEmployeeCode = teacherEmployeeCode;
	}
	@JsonProperty(value="teacherGender", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherGender() {
		return teacherGender;
	}
	@JsonProperty(value="teacher_gender", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherGender(String teacherGender) {
		this.teacherGender = teacherGender;
	}
	@JsonProperty(value="teachingNonteaching", access=JsonProperty.Access.READ_ONLY)
	public String getTeachingNonteaching() {
		return teachingNonteaching;
	}
	@JsonProperty(value="teaching_nonteaching", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeachingNonteaching(String teachingNonteaching) {
		this.teachingNonteaching = teachingNonteaching;
	}
	@JsonProperty(value="lastPromotionPositionType", access=JsonProperty.Access.READ_ONLY)
	public String getLastPromotionPositionType() {
		return lastPromotionPositionType;
	}
	@JsonProperty(value="last_promotion_position_type", access=JsonProperty.Access.WRITE_ONLY)
	public void setLastPromotionPositionType(String lastPromotionPositionType) {
		this.lastPromotionPositionType = lastPromotionPositionType;
	}
	@JsonProperty(value="kvCode", access=JsonProperty.Access.READ_ONLY)
	public String getKvCode() {
		return kvCode;
	}
	@JsonProperty(value="kv_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setKvCode(String kvCode) {
		this.kvCode = kvCode;
	}
	@JsonProperty(value="kvName", access=JsonProperty.Access.READ_ONLY)
	public String getKvName() {
		return kvName;
	}
	@JsonProperty(value="kv_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setKvName(String kvName) {
		this.kvName = kvName;
	}
	@JsonProperty(value="dropBoxFlag", access=JsonProperty.Access.READ_ONLY)
	public Integer getDropBoxFlag() {
		return dropBoxFlag;
	}
	@JsonProperty(value="drop_box_flag", access=JsonProperty.Access.WRITE_ONLY)
	public void setDropBoxFlag(Integer dropBoxFlag) {
		this.dropBoxFlag = dropBoxFlag;
	}
	@JsonProperty(value="employeedropid", access=JsonProperty.Access.READ_ONLY)
	public Integer getEmployeedropid() {
		return employeedropid;
	}
	@JsonProperty(value="employeedropid", access=JsonProperty.Access.WRITE_ONLY)
	public void setEmployeedropid(Integer employeedropid) {
		this.employeedropid = employeedropid;
	}
	
	
	
}
