package com.example.MOERADTEACHER.common.uneecops.master.vo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class StationCategoryMappingReqVO {

	@NotNull(message = "please enter station code")
	private Integer stationCode;
	@NotNull(message = "please enter category id ")
//	@NotNull(message = "please enter  category id")
	private Integer categoryId;
	@NotNull(message = "please enter from date")
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fromDate;
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate toDate;
	@NotNull(message = "please enter status")
	private boolean status;
	
	private Integer id;

	public Integer getStationCode() {
		return stationCode;
	}
	public void setStationCode(Integer stationCode) {
		this.stationCode = stationCode;
	}

	
	

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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

	
	
	
}
