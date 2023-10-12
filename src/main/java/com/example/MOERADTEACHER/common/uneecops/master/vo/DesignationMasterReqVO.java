package com.example.MOERADTEACHER.common.uneecops.master.vo;

import javax.validation.constraints.NotNull;

public class DesignationMasterReqVO {

	@NotNull(message="Please enter postCode")
	private String postCode;
	@NotNull(message="Please enter post name")
	private String postName;
	private Boolean status;
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
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
