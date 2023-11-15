package com.example.MOERADTEACHER.common.uneecops.master.vo;

import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class SchoolMasterReqVO {

	@NotNull(message = "please enter schoolCode")
	private Integer schoolCode;

	@NotNull(message = "please enter schoolName")
	private String schoolName;

	private Boolean status;
	@NotNull(message = "please enter shift")
	private String shift;
	
	private Integer schoolType;
	
	
	public Integer getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(Integer schoolCode) {
		this.schoolCode = schoolCode;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	
	
	
}
