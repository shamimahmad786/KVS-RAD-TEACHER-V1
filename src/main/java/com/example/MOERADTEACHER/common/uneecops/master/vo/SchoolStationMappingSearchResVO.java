package com.example.MOERADTEACHER.common.uneecops.master.vo;

import java.time.LocalDate;

import lombok.Data;
@Data
public class SchoolStationMappingSearchResVO {

	private String schoolName;
	private String shift;
	private String stationName;
	private Integer stationCode;
	private Integer schoolCode;
	private LocalDate fromDate;
	private LocalDate toDate;
	private boolean isActive;
	
	
	
	
	
	public SchoolStationMappingSearchResVO(String schoolName, String shift, String stationName, Integer stationCode,
			Integer schoolCode, LocalDate fromDate, LocalDate toDate, boolean isActive) {
		super();
		this.schoolName = schoolName;
		this.shift = shift;
		this.stationName = stationName;
		this.stationCode = stationCode;
		this.schoolCode = schoolCode;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.isActive = isActive;
	}
	
	
	
	
	
	
	
}
