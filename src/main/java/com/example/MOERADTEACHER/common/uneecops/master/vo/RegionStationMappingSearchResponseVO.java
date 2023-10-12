package com.example.MOERADTEACHER.common.uneecops.master.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RegionStationMappingSearchResponseVO {

	
	private String stationName;
	private String regionName;
	private Integer stationCode;
	private Integer regionCode;
	private LocalDate fromDate;
	private LocalDate toDate;
	private boolean isActive;
	
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public Integer getStationCode() {
		return stationCode;
	}
	public void setStationCode(Integer stationCode) {
		this.stationCode = stationCode;
	}
	public Integer getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(Integer regionCode) {
		this.regionCode = regionCode;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public RegionStationMappingSearchResponseVO(String stationName, String regionName, Integer stationCode,
			Integer regionCode, LocalDate fromDate, LocalDate toDate, boolean isActive) {
		super();
		this.stationName = stationName;
		this.regionName = regionName;
		this.stationCode = stationCode;
		this.regionCode = regionCode;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.isActive = isActive;
	}
	
	
	
	
	
	
	
}