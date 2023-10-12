package com.example.MOERADTEACHER.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExperienceBean implements Serializable{
	public String work_experience_id;
	public String teacher_id;
	public String udise_sch_code;
	public String school_id;
	public String work_start_date;
	public String work_end_date;
	public String position_type;
	public String nature_of_appointment;
	public String appointed_for_subject;
	public String shift_type;
	public String verify_flag;
	public String verified_type;
	public String created_by;
	public String created_time;
	public String modified_by;
	public String modified_time;
	public String kv_code;
	// Added By Bibek
	public String shift_yn;
//	public String ground_for_transfer;
	
	public String ground_for_transfer;
	
	public String currently_active_yn;
	public String kv_name;
	public String udise_school_name;
	private String experience_type;
	
	
	@JsonProperty(value="workExperienceId", access=JsonProperty.Access.READ_ONLY)
	public String getWork_experience_id() {
		return work_experience_id;
	}
	@JsonProperty(value="work_experience_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setWork_experience_id(String work_experience_id) {
		this.work_experience_id = work_experience_id;
	}
	@JsonProperty(value="teacherId", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_id() {
		return teacher_id;
	}
	@JsonProperty(value="teacher_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_id(String teacher_id) {
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
	public String getWork_start_date() {
		return work_start_date;
	}
	@JsonProperty(value="work_start_date", access=JsonProperty.Access.WRITE_ONLY)
	public void setWork_start_date(String work_start_date) {
		this.work_start_date = work_start_date;
	}
	@JsonProperty(value="workEndDate", access=JsonProperty.Access.READ_ONLY)
	public String getWork_end_date() {
		return work_end_date;
	}
	@JsonProperty(value="work_end_date", access=JsonProperty.Access.WRITE_ONLY)
	public void setWork_end_date(String work_end_date) {
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
	public String getCreated_time() {
		return created_time;
	}
	@JsonProperty(value="created_time", access=JsonProperty.Access.WRITE_ONLY)
	public void setCreated_time(String created_time) {
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
	public String getModified_time() {
		return modified_time;
	}
	@JsonProperty(value="modified_time", access=JsonProperty.Access.WRITE_ONLY)
	public void setModified_time(String modified_time) {
		this.modified_time = modified_time;
	}
//	@JsonProperty(value="groundForTransfer", access=JsonProperty.Access.READ_ONLY)
//	public String getGround_for_transfer() {
//		return ground_for_transfer;
//	}
//	@JsonProperty(value="ground_for_transfer", access=JsonProperty.Access.WRITE_ONLY)
//	public void setGround_for_transfer(String ground_for_transfer) {
//		this.ground_for_transfer = ground_for_transfer;
//	}
	@JsonProperty(value="currentlyActiveYn", access=JsonProperty.Access.READ_ONLY)
	public String getCurrently_active_yn() {
		return currently_active_yn;
	}
	@JsonProperty(value="currently_active_yn", access=JsonProperty.Access.WRITE_ONLY)
	public void setCurrently_active_yn(String currently_active_yn) {
		this.currently_active_yn = currently_active_yn;
	}
	@JsonProperty(value="kvName", access=JsonProperty.Access.READ_ONLY)
	public String getKv_name() {
		return kv_name;
	}
	@JsonProperty(value="kv_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setKv_name(String kv_name) {
		this.kv_name = kv_name;
	}
	@JsonProperty(value="udiseSchoolName", access=JsonProperty.Access.READ_ONLY)
	public String getUdise_school_name() {
		return udise_school_name;
	}
	@JsonProperty(value="udise_school_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setUdise_school_name(String udise_school_name) {
		this.udise_school_name = udise_school_name;
	}
	
	@JsonProperty(value="groundForTransfer", access=JsonProperty.Access.READ_ONLY)
	public String getGround_for_transfer() {
		return ground_for_transfer;
	}
	
	@JsonProperty(value="ground_for_transfer", access=JsonProperty.Access.WRITE_ONLY)
	public void setGround_for_transfer(String ground_for_transfer) {
		this.ground_for_transfer = ground_for_transfer;
	}
	
	@JsonProperty(value="shift_yn", access=JsonProperty.Access.READ_ONLY)
	public String getShift_yn() {
		return shift_yn;
	}
	@JsonProperty(value="shift_yn", access=JsonProperty.Access.WRITE_ONLY)
	public void setShift_yn(String shift_yn) {
		this.shift_yn = shift_yn;
	}
	@JsonProperty(value="experienceType", access=JsonProperty.Access.READ_ONLY)
	public String getExperience_type() {
		return experience_type;
	}
	@JsonProperty(value="experience_type", access=JsonProperty.Access.WRITE_ONLY)
	public void setExperience_type(String experience_type) {
		this.experience_type = experience_type;
	}
	
	@JsonProperty(value="kvCode", access=JsonProperty.Access.READ_ONLY)
	public String getKv_code() {
		return kv_code;
	}
	@JsonProperty(value="kv_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setKv_code(String kv_code) {
		this.kv_code = kv_code;
	}
	
	
	
	
	
	
}
