package com.example.MOERADTEACHER.common.transfermodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="surplus_teacher", schema = "transfer")
public class SurplusTransfer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "current_udise_sch_code")
	private String currentUdiseSchCode;
	@Column(name = "accademic_year")
	private Date accademicYear;
	@Column(name = "last_promotion_id")
	private String lastPromotionId;
	@Column(name = "last_promotion_position_type")
	private String lastPromotionPositionType;
	@Column(name = "work_experience_appointed_for_subject")
	private String workExperienceAppointedForSubject;
	@Column(name = "no_of_sanction_post")
	private String noOfsanctionPost;
	
	@Column(name="created_by") 
	private String createdBy ;
	
	@Column(name="created_time") 
	private Date createdTime ;
	
	@Column(name="modified_by") 
	private String modifiedBy ;
	
	@Column(name="modified_time") 
	private Date modifiedTime;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCurrentUdiseSchCode() {
		return currentUdiseSchCode;
	}
	public void setCurrentUdiseSchCode(String currentUdiseSchCode) {
		this.currentUdiseSchCode = currentUdiseSchCode;
	}
	public Date getAccademicYear() {
		return accademicYear;
	}
	public void setAccademicYear(Date accademicYear) {
		this.accademicYear = accademicYear;
	}
	public String getLastPromotionId() {
		return lastPromotionId;
	}
	public void setLastPromotionId(String lastPromotionId) {
		this.lastPromotionId = lastPromotionId;
	}
	public String getLastPromotionPositionType() {
		return lastPromotionPositionType;
	}
	public void setLastPromotionPositionType(String lastPromotionPositionType) {
		this.lastPromotionPositionType = lastPromotionPositionType;
	}
	public String getWorkExperienceAppointedForSubject() {
		return workExperienceAppointedForSubject;
	}
	public void setWorkExperienceAppointedForSubject(String workExperienceAppointedForSubject) {
		this.workExperienceAppointedForSubject = workExperienceAppointedForSubject;
	}
	public String getNoOfsanctionPost() {
		return noOfsanctionPost;
	}
	public void setNoOfsanctionPost(String noOfsanctionPost) {
		this.noOfsanctionPost = noOfsanctionPost;
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
	


}
