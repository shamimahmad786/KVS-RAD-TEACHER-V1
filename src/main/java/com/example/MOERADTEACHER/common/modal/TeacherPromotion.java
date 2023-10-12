//package com.example.MOERADTEACHER.common.modal;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name = "teacher_promotion_detail",schema="public")
//public class TeacherPromotion implements Serializable{
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name="promotion_id")
//	private Integer promotionId;
//	@Column(name="teacher_id")
//	private Integer teacherId;
//	@Column(name="udise_sch_code")
//	private String udiseSchCode;
//	@Column(name="school_id")
//	private String schoolId;
//	@Column(name="business_unit_code")
//	private String businessUnitCode;
//	@Column(name="business_unit_type_id")
//	private String businessUnitTypeId;
//	@Column(name="currently_working_yn")
//	private String currentlyWorkingYn;
//	@Column(name="work_start_date")
//	private String workStartDate;
//	@Column(name="work_end_date")
//	private String workEndDate;
//	@Column(name="position_type")
//	private String positionType;
//	@Column(name="nature_of_appontment")
//	private String natureOfAppontment;
//	
//	@Column(name="created_by") 
//	private String createdBy ;
//	
//	@Column(name="created_time") 
//	private Date createdTime ;
//	
//	@Column(name="modified_by") 
//	private String modifiedBy ;
//	
//	@Column(name="modified_time") 
//	private Date modifiedTime;
//	
//	
//	
//	public Integer getPromotionId() {
//		return promotionId;
//	}
//	public void setPromotionId(Integer promotionId) {
//		this.promotionId = promotionId;
//	}
//	public Integer getTeacherId() {
//		return teacherId;
//	}
//	public void setTeacherId(Integer teacherId) {
//		this.teacherId = teacherId;
//	}
//	public String getUdiseSchCode() {
//		return udiseSchCode;
//	}
//	public void setUdiseSchCode(String udiseSchCode) {
//		this.udiseSchCode = udiseSchCode;
//	}
//	public String getSchoolId() {
//		return schoolId;
//	}
//	public void setSchoolId(String schoolId) {
//		this.schoolId = schoolId;
//	}
//	public String getBusinessUnitCode() {
//		return businessUnitCode;
//	}
//	public void setBusinessUnitCode(String businessUnitCode) {
//		this.businessUnitCode = businessUnitCode;
//	}
//	public String getBusinessUnitTypeId() {
//		return businessUnitTypeId;
//	}
//	public void setBusinessUnitTypeId(String businessUnitTypeId) {
//		this.businessUnitTypeId = businessUnitTypeId;
//	}
//	public String getCurrentlyWorkingYn() {
//		return currentlyWorkingYn;
//	}
//	public void setCurrentlyWorkingYn(String currentlyWorkingYn) {
//		this.currentlyWorkingYn = currentlyWorkingYn;
//	}
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
//	public String getPositionType() {
//		return positionType;
//	}
//	public void setPositionType(String positionType) {
//		this.positionType = positionType;
//	}
//	public String getNatureOfAppontment() {
//		return natureOfAppontment;
//	}
//	public void setNatureOfAppontment(String natureOfAppontment) {
//		this.natureOfAppontment = natureOfAppontment;
//	}
//	public String getCreatedBy() {
//		return createdBy;
//	}
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//	public Date getCreatedTime() {
//		return createdTime;
//	}
//	public void setCreatedTime(Date createdTime) {
//		this.createdTime = createdTime;
//	}
//	public String getModifiedBy() {
//		return modifiedBy;
//	}
//	public void setModifiedBy(String modifiedBy) {
//		this.modifiedBy = modifiedBy;
//	}
//	public Date getModifiedTime() {
//		return modifiedTime;
//	}
//	public void setModifiedTime(Date modifiedTime) {
//		this.modifiedTime = modifiedTime;
//	}
//
//	
//	
//	
//	
//}
