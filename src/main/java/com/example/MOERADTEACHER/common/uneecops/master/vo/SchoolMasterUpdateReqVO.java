package com.example.MOERADTEACHER.common.uneecops.master.vo;

import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class SchoolMasterUpdateReqVO {
	private Integer id;
	@NotNull(message = "please enter schoolCode")
	private Integer schoolCode;

	@NotNull(message = "please enter schoolName")
	private String schoolName;
	private String shift;
	private Integer schoolType;
	private Boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public Integer getSchoolType() {
		return schoolType;
	}
	public void setSchoolType(Integer schoolType) {
		this.schoolType = schoolType;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
