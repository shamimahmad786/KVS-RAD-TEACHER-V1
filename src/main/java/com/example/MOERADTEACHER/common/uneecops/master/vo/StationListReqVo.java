package com.example.MOERADTEACHER.common.uneecops.master.vo;

import java.sql.Date;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class StationListReqVo {
	
	@NotNull(message="pleage enter  station code")
	private int stationCode;
	@NotNull(message="pleage enter station name")
	private String stationName;
	@NotNull(message="pleage enter from date")
	private LocalDate fromDate;
	@NotNull(message="pleage enter to date")
	private LocalDate toDate;
	public int getStationCode() {
		return stationCode;
	}
	public void setStationCode(int stationCode) {
		this.stationCode = stationCode;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
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
	
	
	

}
