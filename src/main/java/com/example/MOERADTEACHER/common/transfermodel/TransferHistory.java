package com.example.MOERADTEACHER.common.transfermodel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.Transactional;

@Entity
@Table(name="transfer_work_experience", schema = "transfer")

public class TransferHistory implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="transfer_work_experience_id")
	private Integer transferWorkExperienceId;
	@Column(name="work_experience_id")
	private Integer workExperienceId;
	@Column(name="teacher_id")
	private Integer teacherId;
	@Column(name="udise_sch_code")
	private String udiseSchCode;
	@Column(name="school_id")
	private String schoolId;
	@Column(name="udise_school_name")
	private String udiseSchoolName;
	@Column(name="kv_code")
	private String kvCode;
	@Column(name="shift_type")
	private String shiftType;
	@Column(name="work_start_date")
	private Date workStartDate;
	@Column(name="work_end_date")
	private Date workEndDate;

//	@Column(name="ground_for_transfer")
//	private String groundForTransfer;
	
//	@Column(name="ground_for_transfer")
	@Transient
	private List groundForTransfer;
	
	
	@Column(name="station_type")
	private String stationType;
	@Column(name="station_name")
	private String stationName;
	@Column(name="nature_of_appointment")
	private String natureOfAppointment;
	@Column(name="position_type")
	private String positionType;
	
	@Column(name="created_by") 
	private String createdBy ;
	
	@Column(name="created_time") 
	private Date createdTime ;
	
	@Column(name="modified_by") 
	private String modifiedBy ;
	
	@Column(name="modified_time") 
	private Date modifiedTime;
	
	
	// Added By Bibek
	@Column(name="shift_yn")
	public Integer shiftYn;
	
	public Integer getWorkExperienceId() {
		return workExperienceId;
	}
	public void setWorkExperienceId(Integer workExperienceId) {
		this.workExperienceId = workExperienceId;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getUdiseSchCode() {
		return udiseSchCode;
	}
	public void setUdiseSchCode(String udiseSchCode) {
		this.udiseSchCode = udiseSchCode;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getUdiseSchoolName() {
		return udiseSchoolName;
	}
	public void setUdiseSchoolName(String udiseSchoolName) {
		this.udiseSchoolName = udiseSchoolName;
	}
	public String getKvCode() {
		return kvCode;
	}
	public void setKvCode(String kvCode) {
		this.kvCode = kvCode;
	}
	public String getShiftType() {
		return shiftType;
	}
	public void setShiftType(String shiftType) {
		this.shiftType = shiftType;
	}
//	public String getWorkStartDate() {
//		return workStartDate;
//	}
//	public void setWorkStartDate(String workStartDate) {
//		this.workStartDate = workStartDate;
//	}
//	public String getWorkEndDate() {
//		return workEndDate;
//	}
//	public void setWorkEndDate(String workEndDate) {
//		this.workEndDate = workEndDate;
//	}
	
	
//	public String getGroundForTransfer() {
//		return groundForTransfer;
//	}
//	public void setGroundForTransfer(String groundForTransfer) {
//		this.groundForTransfer = groundForTransfer;
//	}
	
	
	
	public String getStationType() {
		return stationType;
	}
	public void setStationType(String stationType) {
		this.stationType = stationType;
	}
	public Integer getTransferWorkExperienceId() {
		return transferWorkExperienceId;
	}
	public void setTransferWorkExperienceId(Integer transferWorkExperienceId) {
		this.transferWorkExperienceId = transferWorkExperienceId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getNatureOfAppointment() {
		return natureOfAppointment;
	}
	public void setNatureOfAppointment(String natureOfAppointment) {
		this.natureOfAppointment = natureOfAppointment;
	}
	public String getPositionType() {
		return positionType;
	}
	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
	
	public List getGroundForTransfer() {
		return groundForTransfer;
	}
	public void setGroundForTransfer(List groundForTransfer) {
		this.groundForTransfer = groundForTransfer;
	}
	
	
	public Integer getShiftYn() {
		return shiftYn;
	}
	public void setShiftYn(Integer shiftYn) {
		this.shiftYn = shiftYn;
	}
	public Date getWorkStartDate() {
		return workStartDate;
	}
	public void setWorkStartDate(Date workStartDate) {
		this.workStartDate = workStartDate;
	}
	public Date getWorkEndDate() {
		return workEndDate;
	}
	public void setWorkEndDate(Date workEndDate) {
		this.workEndDate = workEndDate;
	}
	
	
	
	
	
	
}
