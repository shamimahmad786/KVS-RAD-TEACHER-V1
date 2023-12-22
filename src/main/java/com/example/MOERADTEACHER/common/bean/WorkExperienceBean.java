package com.example.MOERADTEACHER.common.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkExperienceBean implements Serializable{
	
	private Integer work_experience_id;
	private Integer teacher_id;
	private String udise_sch_code;
	private String school_id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
//	@Temporal(TemporalType.DATE)
	private Date work_start_date;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
//	@Temporal(TemporalType.DATE)
	private Date work_end_date;
	private String position_type;
	private String nature_of_appointment;
	private String appointed_for_subject;
	private String udise_school_name;
	private String shift_type;
	private String verify_flag;
	private String verified_type;
	private String created_by;
	private Date created_time;
	private String modified_by;
	private Date modified_time;
	private String ground_for_transfer;
	private String currently_active_yn;
	// Added By Bibek
	public String shift_yn;
	
	
	@JsonProperty(value="workExperienceId", access=JsonProperty.Access.READ_ONLY)
	public Integer getWork_experience_id() {
		return work_experience_id;
	}
	@JsonProperty(value="work_experience_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setWork_experience_id(Integer work_experience_id) {
		this.work_experience_id = work_experience_id;
	}
	@JsonProperty(value="teacherId", access=JsonProperty.Access.READ_ONLY)
	public Integer getTeacher_id() {
		return teacher_id;
	}
	@JsonProperty(value="teacher_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}
	@JsonProperty(value="udiseSchCode", access=JsonProperty.Access.READ_ONLY)
	public String getUdise_sch_code() {
		return udise_sch_code;
	}
	@JsonProperty(value="udise_sch_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setUdise_sch_code(String udise_sch_code) {
		this.udise_sch_code = udise_sch_code;
	}
	@JsonProperty(value="schoolId", access=JsonProperty.Access.READ_ONLY)
	public String getSchool_id() {
		return school_id;
	}
	@JsonProperty(value="school_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setSchool_id(String school_id) {
		this.school_id = school_id;
	}
	@JsonProperty(value="workStartDate", access=JsonProperty.Access.READ_ONLY)
	public Date getWork_start_date() {
		return work_start_date;
	}
	@JsonProperty(value="work_start_date", access=JsonProperty.Access.WRITE_ONLY)
	public void setWork_start_date(Date work_start_date) {
		this.work_start_date = work_start_date;
	}
	@JsonProperty(value="workEndDate", access=JsonProperty.Access.READ_ONLY)
	public Date getWork_end_date() {
		return work_end_date;
	}
	@JsonProperty(value="work_end_date", access=JsonProperty.Access.WRITE_ONLY)
	public void setWork_end_date(Date work_end_date) {
		this.work_end_date = work_end_date;
	}
	@JsonProperty(value="positionType", access=JsonProperty.Access.READ_ONLY)
	public String getPosition_type() {
		return position_type;
	}
	@JsonProperty(value="position_type", access=JsonProperty.Access.WRITE_ONLY)
	public void setPosition_type(String position_type) {
		this.position_type = position_type;
	}
	@JsonProperty(value="natureOfAppointment", access=JsonProperty.Access.READ_ONLY)
	public String getNature_of_appointment() {
		return nature_of_appointment;
	}
	@JsonProperty(value="nature_of_appointment", access=JsonProperty.Access.WRITE_ONLY)
	public void setNature_of_appointment(String nature_of_appointment) {
		this.nature_of_appointment = nature_of_appointment;
	}
	@JsonProperty(value="appointedForSubject", access=JsonProperty.Access.READ_ONLY)
	public String getAppointed_for_subject() {
		return appointed_for_subject;
	}
	@JsonProperty(value="appointed_for_subject", access=JsonProperty.Access.WRITE_ONLY)
	public void setAppointed_for_subject(String appointed_for_subject) {
		this.appointed_for_subject = appointed_for_subject;
	}
	@JsonProperty(value="udiseSchoolName", access=JsonProperty.Access.READ_ONLY)
	public String getUdise_school_name() {
		return udise_school_name;
	}
	@JsonProperty(value="udise_school_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setUdise_school_name(String udise_school_name) {
		this.udise_school_name = udise_school_name;
	}
	@JsonProperty(value="shiftType", access=JsonProperty.Access.READ_ONLY)
	public String getShift_type() {
		return shift_type;
	}
	@JsonProperty(value="shift_type", access=JsonProperty.Access.WRITE_ONLY)
	public void setShift_type(String shift_type) {
		this.shift_type = shift_type;
	}
	@JsonProperty(value="verifyFlag", access=JsonProperty.Access.READ_ONLY)
	public String getVerify_flag() {
		return verify_flag;
	}
	@JsonProperty(value="verify_flag", access=JsonProperty.Access.WRITE_ONLY)
	public void setVerify_flag(String verify_flag) {
		this.verify_flag = verify_flag;
	}
	@JsonProperty(value="verifiedType", access=JsonProperty.Access.READ_ONLY)
	public String getVerified_type() {
		return verified_type;
	}
	@JsonProperty(value="verified_type", access=JsonProperty.Access.WRITE_ONLY)
	public void setVerified_type(String verified_type) {
		this.verified_type = verified_type;
	}
	@JsonProperty(value="createdBy", access=JsonProperty.Access.READ_ONLY)
	public String getCreated_by() {
		return created_by;
	}
	@JsonProperty(value="created_by", access=JsonProperty.Access.WRITE_ONLY)
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	@JsonProperty(value="createdTime", access=JsonProperty.Access.READ_ONLY)
	public Date getCreated_time() {
		return created_time;
	}
	@JsonProperty(value="created_time", access=JsonProperty.Access.WRITE_ONLY)
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	@JsonProperty(value="modifiedBy", access=JsonProperty.Access.READ_ONLY)
	public String getModified_by() {
		return modified_by;
	}
	@JsonProperty(value="modified_by", access=JsonProperty.Access.WRITE_ONLY)
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	@JsonProperty(value="modifiedTime", access=JsonProperty.Access.READ_ONLY)
	public Date getModified_time() {
		return modified_time;
	}
	@JsonProperty(value="modified_time", access=JsonProperty.Access.WRITE_ONLY)
	public void setModified_time(Date modified_time) {
		this.modified_time = modified_time;
	}
	@JsonProperty(value="groundForTransfer", access=JsonProperty.Access.READ_ONLY)
	public String getGround_for_transfer() {
		return ground_for_transfer;
	}
	@JsonProperty(value="ground_for_transfer", access=JsonProperty.Access.WRITE_ONLY)
	public void setGround_for_transfer(String ground_for_transfer) {
		this.ground_for_transfer = ground_for_transfer;
	}
	@JsonProperty(value="currentlyActiveYn", access=JsonProperty.Access.READ_ONLY)
	public String getCurrently_active_yn() {
		return currently_active_yn;
	}
	@JsonProperty(value="currently_active_yn", access=JsonProperty.Access.WRITE_ONLY)
	public void setCurrently_active_yn(String currently_active_yn) {
		this.currently_active_yn = currently_active_yn;
	}
	
	@JsonProperty(value="shift_yn", access=JsonProperty.Access.READ_ONLY)
	public String getShift_yn() {
		return shift_yn;
	}
	@JsonProperty(value="shift_yn", access=JsonProperty.Access.WRITE_ONLY)
	public void setShift_yn(String shift_yn) {
		this.shift_yn = shift_yn;
	}
	
	
}
