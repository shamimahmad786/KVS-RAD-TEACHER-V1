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
//@Table(name = "teacher_traning",schema="public")
//public class TeacherTraining implements Serializable{
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id")
//	private Integer id;
//	@Column(name = "teacher_id")
//	private Integer teacherId;
//	@Column(name = "training_name")
//	private String trainingName;
//	@Column(name = "training_year")
//	private String trainingYear;
//	@Column(name = "training_organized_by")
//	private String trainingOrganizedBy;
//	@Column(name = "place")
//	private String place;
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
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public Integer getTeacherId() {
//		return teacherId;
//	}
//	public void setTeacherId(Integer teacherId) {
//		this.teacherId = teacherId;
//	}
//	public String getTrainingName() {
//		return trainingName;
//	}
//	public void setTrainingName(String trainingName) {
//		this.trainingName = trainingName;
//	}
//	public String getTrainingYear() {
//		return trainingYear;
//	}
//	public void setTrainingYear(String trainingYear) {
//		this.trainingYear = trainingYear;
//	}
//	public String getTrainingOrganizedBy() {
//		return trainingOrganizedBy;
//	}
//	public void setTrainingOrganizedBy(String trainingOrganizedBy) {
//		this.trainingOrganizedBy = trainingOrganizedBy;
//	}
//	public String getPlace() {
//		return place;
//	}
//	public void setPlace(String place) {
//		this.place = place;
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
//	
//}
