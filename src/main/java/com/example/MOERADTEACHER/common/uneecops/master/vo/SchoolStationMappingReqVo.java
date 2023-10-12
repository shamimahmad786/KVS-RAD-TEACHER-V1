package com.example.MOERADTEACHER.common.uneecops.master.vo;

import java.time.LocalDate;

import java.util.List;

import javax.validation.constraints.NotNull;

public class SchoolStationMappingReqVo {




	@NotNull(message = "please enter station code")
	private Integer stationCode;
	
	private List<SchoolMasterReqVO> schoolMasterReqVoList;

	@NotNull(message = "please enter fromDate")
	private LocalDate fromDate;
	
	private LocalDate toDate;
	@NotNull(message = "please enter  status")
	private boolean status;
	
	

	public Integer getStationCode() {
		return stationCode;
	}
	public void setStationCode(Integer stationCode) {
		this.stationCode = stationCode;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<SchoolMasterReqVO> getSchoolMasterReqVoList() {
		return schoolMasterReqVoList;
	}
	public void setSchoolMasterReqVoList(List<SchoolMasterReqVO> schoolMasterReqVoList) {
		this.schoolMasterReqVoList = schoolMasterReqVoList;
	}
	
	
	
	
}
