package com.example.MOERADTEACHER.common.uneecops.master.vo;

import lombok.Data;

@Data
public class StaffTypePostMappingSearchReqVO {

	private String staffType;
	private String postCode;
	private String postName;
	public String getStaffType() {
		return staffType;
	}
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	
	
}
