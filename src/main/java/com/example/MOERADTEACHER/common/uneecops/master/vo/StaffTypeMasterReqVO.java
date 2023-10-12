package com.example.MOERADTEACHER.common.uneecops.master.vo;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class StaffTypeMasterReqVO {

	@NotNull(message = "Please enter the staff type")
	private String staffType;
	
	private boolean status;

	public String getStaffType() {
		return staffType;
	}

	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


	
	
	

}
