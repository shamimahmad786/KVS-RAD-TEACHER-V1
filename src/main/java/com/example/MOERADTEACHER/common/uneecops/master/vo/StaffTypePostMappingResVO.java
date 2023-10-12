package com.example.MOERADTEACHER.common.uneecops.master.vo;

import lombok.Data;

@Data
public class StaffTypePostMappingResVO {

	private String staffType;
	private String postCode;
	private String postName;
	private Boolean status;

	public StaffTypePostMappingResVO(String staffType, String postCode, String postName, Boolean status) {
		super();
		this.staffType = staffType;
		this.postCode = postCode;
		this.postName = postName;
		this.status = status;
	}
	
	
	
	
	
	
}
