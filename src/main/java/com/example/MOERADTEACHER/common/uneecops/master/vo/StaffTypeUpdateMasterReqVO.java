package com.example.MOERADTEACHER.common.uneecops.master.vo;

import javax.validation.constraints.NotNull;

public class StaffTypeUpdateMasterReqVO {

	@NotNull(message="Please enter id.")
	private Integer id;
	@NotNull(message="Please enter staffType")
	private String staffType;
	private Boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStaffType() {
		return staffType;
	}
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
