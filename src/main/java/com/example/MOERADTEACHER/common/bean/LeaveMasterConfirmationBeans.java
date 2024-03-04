package com.example.MOERADTEACHER.common.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LeaveMasterConfirmationBeans {
//	@JsonProperty(value="workExperienceId", access=JsonProperty.Access.READ_ONLY)
//	@JsonProperty(value="work_experience_id", access=JsonProperty.Access.WRITE_ONLY)
	
	public Object startDate;
	public Object endDate;
	public Object isContiniousLeave;
	public Object noOfLeave;
	public Object teacherId;
	
	@JsonProperty(value="startDate", access=JsonProperty.Access.READ_ONLY)
	public Object getStartDate() {
		return startDate;
	}
	@JsonProperty(value="start_date", access=JsonProperty.Access.WRITE_ONLY)
	public void setStartDate(Object startDate) {
		this.startDate = startDate;
	}
	@JsonProperty(value="endDate", access=JsonProperty.Access.READ_ONLY)
	public Object getEndDate() {
		return endDate;
	}
	@JsonProperty(value="end_date", access=JsonProperty.Access.WRITE_ONLY)
	public void setEndDate(Object endDate) {
		this.endDate = endDate;
	}
	@JsonProperty(value="isContiniousLeave", access=JsonProperty.Access.READ_ONLY)
	public Object getIsContiniousLeave() {
		return isContiniousLeave;
	}
	@JsonProperty(value="is_continious_leave", access=JsonProperty.Access.WRITE_ONLY)
	public void setIsContiniousLeave(Object isContiniousLeave) {
		this.isContiniousLeave = isContiniousLeave;
	}
	@JsonProperty(value="noOfLeave", access=JsonProperty.Access.READ_ONLY)
	public Object getNoOfLeave() {
		return noOfLeave;
	}
	@JsonProperty(value="no_of_leave", access=JsonProperty.Access.WRITE_ONLY)
	public void setNoOfLeave(Object noOfLeave) {
		this.noOfLeave = noOfLeave;
	}
	@JsonProperty(value="teacherId", access=JsonProperty.Access.READ_ONLY)
	public Object getTeacherId() {
		return teacherId;
	}
	@JsonProperty(value="teacher_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherId(Object teacherId) {
		this.teacherId = teacherId;
	}
	
	
	
}
