package com.example.MOERADTEACHER.common.uneecops.master.vo;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RegionStationMapReqVo {
	@NotNull(message="please enter station code")
	private Integer stationCode;
	@NotNull(message="please enter station name")
	private String stationName;
	@NotNull(message="please enter region code")
	private Integer regionCode;
	@NotNull(message="please enter region name")
	private String regionName;
	@NotNull(message="please enter from date")
	private Date fromDate;
	private Date toDate;
	@NotNull(message="please enter status")
	private boolean status;
	
	
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
	
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Integer getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(Integer regionCode) {
		this.regionCode = regionCode;
	}
	
	
	
}
