package com.example.MOERADTEACHER.common.uneecops.master.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class StaffTypePostMappingReqVO {

	@NotNull(message = "please enter staff type id")
	private Integer staffTypeId;
	@NotNull(message = "please enter  designation id")
	private Integer designationId;
	private boolean status;
	public Integer getStaffTypeId() {
		return staffTypeId;
	}
	public void setStaffTypeId(Integer staffTypeId) {
		this.staffTypeId = staffTypeId;
	}
	public Integer getDesignationId() {
		return designationId;
	}
	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
