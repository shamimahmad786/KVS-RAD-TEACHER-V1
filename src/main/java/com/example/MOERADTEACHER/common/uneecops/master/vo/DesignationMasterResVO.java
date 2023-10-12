package com.example.MOERADTEACHER.common.uneecops.master.vo;

import lombok.Data;

@Data
public class DesignationMasterResVO {
	private int id;
	private String postCode;
	private String postName;
	private Boolean status;
	public DesignationMasterResVO(int id, String postCode, String postName, Boolean status) {
		super();
		this.id = id;
		this.postCode = postCode;
		this.postName = postName;
		this.status = status;
	}

	

}