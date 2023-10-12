package com.example.MOERADTEACHER.common.uneecops.master.vo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

public class RegionStationsMappingReqVo {
	@NotNull(message="pleage enter region code")
	private int regionCode;
	
	@NotNull(message="pleage enter station list")
	private List<StationMasterVo> station;
	
	@NotNull(message="please enter from date")
	private LocalDate fromDate;
	private LocalDate toDate;
	
	@NotNull
	private boolean isActive;
	

	

	public int getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(int regionCode) {
		this.regionCode = regionCode;
	}

	

	public List<StationMasterVo> getStation() {
		return station;
	}

	public void setStation(List<StationMasterVo> station) {
		this.station = station;
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



	
	
	
	
	
	
	
	

	
}
