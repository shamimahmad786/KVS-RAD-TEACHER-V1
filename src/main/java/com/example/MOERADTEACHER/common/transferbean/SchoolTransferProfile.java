package com.example.MOERADTEACHER.common.transferbean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SchoolTransferProfile {

	Object teacherId;
	Object teacherEmployeeCode;
	Object teacherName;
	Object tcTotalPoint;
	Object dcTotalPoint;
	Object transferFinalStatus;
	Object tcSaveYn;
	Object dcSaveYn;
    
    @JsonProperty(value="teacherId", access=JsonProperty.Access.READ_ONLY)
	public Object getTeacherId() {
		return teacherId;
	}
    @JsonProperty(value="teacher_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherId(Object teacherId) {
		this.teacherId = teacherId;
	}
    @JsonProperty(value="teacherEmployeeCode", access=JsonProperty.Access.READ_ONLY)
	public Object getTeacherEmployeeCode() {
		return teacherEmployeeCode;
	}
    @JsonProperty(value="teacher_employee_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherEmployeeCode(Object teacherEmployeeCode) {
		this.teacherEmployeeCode = teacherEmployeeCode;
	}
	@JsonProperty(value="teacherName", access=JsonProperty.Access.READ_ONLY)
	public Object getTeacherName() {
		return teacherName;
	}
	@JsonProperty(value="teacher_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherName(Object teacherName) {
		this.teacherName = teacherName;
	}
	@JsonProperty(value="tcTotalPoint", access=JsonProperty.Access.READ_ONLY)
	public Object getTcTotalPoint() {
		return tcTotalPoint;
	}
	@JsonProperty(value="tc_total_point", access=JsonProperty.Access.WRITE_ONLY)
	public void setTcTotalPoint(Object tcTotalPoint) {
		this.tcTotalPoint = tcTotalPoint;
	}
	@JsonProperty(value="dcTotalPoint", access=JsonProperty.Access.READ_ONLY)
	public Object getDcTotalPoint() {
		return dcTotalPoint;
	}
	@JsonProperty(value="dc_total_point", access=JsonProperty.Access.WRITE_ONLY)
	public void setDcTotalPoint(Object dcTotalPoint) {
		this.dcTotalPoint = dcTotalPoint;
	}
	@JsonProperty(value="transferFinalStatus", access=JsonProperty.Access.READ_ONLY)
	public Object getTransferFinalStatus() {
		return transferFinalStatus;
	}
	@JsonProperty(value="transfer_final_status", access=JsonProperty.Access.WRITE_ONLY)
	public void setTransferFinalStatus(Object transferFinalStatus) {
		this.transferFinalStatus = transferFinalStatus;
	}

    
}
