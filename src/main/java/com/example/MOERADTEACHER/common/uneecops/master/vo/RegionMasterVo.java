package com.example.MOERADTEACHER.common.uneecops.master.vo;

import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class RegionMasterVo {

	private Integer id;
	private Integer regionCode;
	@NotNull(message="please enter regionName")
	private String regionName;
	 
	private Boolean Status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(Integer regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Boolean getStatus() {
		return Status;
	}

	public void setStatus(Boolean status) {
		Status = status;
	}
	
	


}
