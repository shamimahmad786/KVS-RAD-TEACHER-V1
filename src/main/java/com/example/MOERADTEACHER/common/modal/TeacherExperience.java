package com.example.MOERADTEACHER.common.modal;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "teacher_work_experience", schema="public")
public class TeacherExperience implements Serializable{
	
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_experience_id_seq")
	
//	@SequenceGenerator(name = "workExperienceIdSeq", sequenceName = "work_experience_id_seq",allocationSize=1)
//	@GeneratedValue( generator = "workExperienceIdSeq")
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="workExperienceIdSeq")
    @SequenceGenerator(name="workExperienceIdSeq",sequenceName="work_experience_id_seq", allocationSize=1)
	@Column(name="work_experience_id")
	private Integer workExperienceId;
	@Column(name="teacher_id")
	private Integer teacherId;
	@Column(name="udise_sch_code")
	private String udiseSchCode;
	@Column(name="school_id")
	private String schoolId;
	@Temporal(TemporalType.DATE)
	@Column(name="work_start_date")
	private Date workStartDate;
	@Temporal(TemporalType.DATE)
	@Column(name="work_end_date")
	private Date workEndDate;
	@Column(name="position_type")
	private String positionType;
	@Column(name="nature_of_appointment")
	private String natureOfAppointment;
	@Column(name="appointed_for_subject")
	private String appointedForSubject;
	@Column(name="udise_school_name")
	private String udiseSchoolName;
	@Column(name="shift_type")
	private String shiftType;
	
	// Added By Bibek
	@Column(name="shift_yn")
	public Integer shiftYn;
	
	@Column(name="kv_code")
	private String kvCode ;
	
	@Column(name="ground_for_transfer")
	private String groundForTransfer;
	
	
	@Column(name="currently_active_yn")
	private String currentlyActiveYn;
	
	@Column(name="created_by") 
	private String createdBy ;
	
	@Column(name="created_time") 
	private Date createdTime ;
	
	@Column(name="modified_by") 
	private String modifiedBy ;
	
	@Column(name="modified_time") 
	private Date modifiedTime;
	
	@Column(name="experience_type")
	private String experienceType;
	
	
	
	
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

	public String getPositionType() {
		return positionType;
	}
	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}
	
	public String getAppointedForSubject() {
		return appointedForSubject;
	}
	public void setAppointedForSubject(String appointedForSubject) {
		this.appointedForSubject = appointedForSubject;
	}
	public String getUdiseSchoolName() {
		return udiseSchoolName;
	}
	public void setUdiseSchoolName(String udiseSchoolName) {
		this.udiseSchoolName = udiseSchoolName;
	}
	public String getNatureOfAppointment() {
		return natureOfAppointment;
	}
	public void setNatureOfAppointment(String natureOfAppointment) {
		this.natureOfAppointment = natureOfAppointment;
	}
	
	
	
	public String getShiftType() {
		return shiftType;
	}
	public void setShiftType(String shiftType) {
		this.shiftType = shiftType;
	}

	public String getCurrentlyActiveYn() {
		return currentlyActiveYn;
	}
	public void setCurrentlyActiveYn(String currentlyActiveYn) {
		this.currentlyActiveYn = currentlyActiveYn;
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
	public String getKvCode() {
		return kvCode;
	}
	public void setKvCode(String kvCode) {
		this.kvCode = kvCode;
	}
	public String getExperienceType() {
		return experienceType;
	}
	public void setExperienceType(String experienceType) {
		this.experienceType = experienceType;
	}
	public String getGroundForTransfer() {
		return groundForTransfer;
	}
	public void setGroundForTransfer(String groundForTransfer) {
		this.groundForTransfer = groundForTransfer;
	}
	
	
	 @PrePersist
	    void updatedAt() {
	      this.modifiedTime = new Date();
	      this.createdTime=new Date();
	    }
	    
	    @PreUpdate
	    void updatAt() {
	      this.modifiedTime = new Date();
	    }
	
}
