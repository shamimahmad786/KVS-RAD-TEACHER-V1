package com.example.MOERADTEACHER.common.uneecops.master.vo;

import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class StationMasterVo {
	private Integer Id;
	//@NotNull(message = "please enter stationCode")
	private Integer stationCode;
	@NotNull(message = "please enter stationName")
	private String stationName;

	private Boolean status;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getStationCode() {
		return stationCode;
	}

	public void setStationCode(Integer stationCode) {
		this.stationCode = stationCode;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	
	
}
