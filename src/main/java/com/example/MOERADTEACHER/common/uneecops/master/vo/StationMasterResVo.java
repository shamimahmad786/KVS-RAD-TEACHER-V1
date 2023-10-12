package com.example.MOERADTEACHER.common.uneecops.master.vo;

import lombok.Data;

@Data
public class StationMasterResVo {

	private Integer id;
	private Integer stationCode;
	private String stationName;
	private Boolean isActive;
	private Integer schoolType;
	public StationMasterResVo(Integer id, Integer stationCode, String stationName, Boolean isActive) {
		super();
		this.id = id;
		this.stationCode = stationCode;
		this.stationName = stationName;
		this.isActive = isActive;
	
	}
	
	
}


