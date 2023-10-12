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
//@Entity
//@Table(name = "teacher_awards" ,schema="public")
//public class TeacherAwards implements Serializable{
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id")
//	private Integer id;
//	@Column(name = "teacher_id")
//	private Integer teacherId;
//	@Column(name = "award_name")
//	private String awardName;
//	@Column(name = "award_year")
//	private String awardYear;
//	@Column(name = "award_by")
//	private String awardBy;
//	@Column(name = "remarks")
//	private String remarks;
//	@Column(name = "award_id")
//	private Integer awardId;
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
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public String getAwardName() {
//		return awardName;
//	}
//	public void setAwardName(String awardName) {
//		this.awardName = awardName;
//	}
//	public String getAwardYear() {
//		return awardYear;
//	}
//	public void setAwardYear(String awardYear) {
//		this.awardYear = awardYear;
//	}
//	public String getAwardBy() {
//		return awardBy;
//	}
//	public void setAwardBy(String awardBy) {
//		this.awardBy = awardBy;
//	}
//	public String getRemarks() {
//		return remarks;
//	}
//	public void setRemarks(String remarks) {
//		this.remarks = remarks;
//	}
//	public Integer getTeacherId() {
//		return teacherId;
//	}
//	public void setTeacherId(Integer teacherId) {
//		this.teacherId = teacherId;
//	}
//	public Integer getAwardId() {
//		return awardId;
//	}
//	public void setAwardId(Integer awardId) {
//		this.awardId = awardId;
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
//}
