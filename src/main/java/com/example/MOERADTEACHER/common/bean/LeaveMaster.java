package com.example.MOERADTEACHER.common.bean;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LeaveMaster {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
public Date startDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
public Date endDate;
	
public Integer isContiniousLeave;
public Integer noOfLeave;
public Integer teacherId;

@JsonProperty(value="startDate", access=JsonProperty.Access.READ_ONLY)
public Date getStartDate() {
	return startDate;
}
@JsonProperty(value="start_date", access=JsonProperty.Access.WRITE_ONLY)
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
@JsonProperty(value="endDate", access=JsonProperty.Access.READ_ONLY)
public Date getEndDate() {
	return endDate;
}
@JsonProperty(value="end_date", access=JsonProperty.Access.WRITE_ONLY)
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}

@JsonProperty(value="isContiniousLeave", access=JsonProperty.Access.READ_ONLY)
public Integer getIsContiniousLeave() {
	return isContiniousLeave;
}

@JsonProperty(value="is_continious_leave", access=JsonProperty.Access.WRITE_ONLY)
public void setIsContiniousLeave(Integer isContiniousLeave) {
	this.isContiniousLeave = isContiniousLeave;
}



@JsonProperty(value="noOfLeave", access=JsonProperty.Access.READ_ONLY)
public Integer getNoOfLeave() {
	return noOfLeave;
}

@JsonProperty(value="no_of_leave", access=JsonProperty.Access.WRITE_ONLY)
public void setNoOfLeave(Integer noOfLeave) {
	this.noOfLeave = noOfLeave;
}

@JsonProperty(value="teacherId", access=JsonProperty.Access.READ_ONLY)
public Integer getTeacherId() {
	return teacherId;
}

@JsonProperty(value="teacher_id", access=JsonProperty.Access.WRITE_ONLY)
public void setTeacherId(Integer teacherId) {
	this.teacherId = teacherId;
}





}
