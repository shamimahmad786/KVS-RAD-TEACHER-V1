package com.example.MOERADTEACHER.common.uneecops.master.vo;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class StationCategoryMappingSearchResVO {

	private String stationName;
	private Integer stationCode;
	private String categoryName;
	private LocalDate fromDate;
	private LocalDate toDate;
	private boolean isActive;
	public StationCategoryMappingSearchResVO(String stationName, Integer stationCode, String categoryName,
			LocalDate fromDate, LocalDate toDate, boolean isActive) {
		super();
		this.stationName = stationName;
		this.stationCode = stationCode;
		this.categoryName = categoryName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.isActive = isActive;
	}
	
	
	

}
