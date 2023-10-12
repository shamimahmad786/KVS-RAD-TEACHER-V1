//package com.example.MOERADTEACHER.modal;
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
//@Table(name = "teacher_profile_currection_initiate")
//public class TeacherProfileCurrectionInitiate implements Serializable{
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id")
//	private Integer id;
//	@Column(name = "teacher_id")
//	private Integer teacherId;
//	@Column(name = "teacher_employee_code")
//	private String teacherEmployeeCode;
//	@Column(name = "teacher_employee_code_new")
//	private String teacherEmployeeCodeNew;
//	@Column(name = "teacher_name")
//	private String teacherName;
//	@Column(name = "teacher_name_new")
//	private String teacherNameNew;
//	@Column(name = "teacher_gender")
//	private String teacherGender;
//	@Column(name = "teacher_gender_new")
//	private String teacherGenderNew;
//	@Column(name = "teacher_dob")
//	private String teacherDob;
//	@Column(name = "teacher_dob_new")
//	private String teacherDobNew;
//	@Column(name = "teacher_social_category")
//	private String teacherSocialCategory;
//	@Column(name = "teacher_social_category_new")
//	private String teacherSocialCategoryNew;
//	@Column(name = "teacher_religion")
//	private String teacherReligion;
//	@Column(name = "teacher_religion_new")
//	private String teacherReligionNew;
//	@Column(name = "teacher_nationality")
//	private String teacherNationality;
//	@Column(name = "teacher_nationality_new")
//	private String teacherNationalityNew;
//	@Column(name = "teacher_mobile")
//	private String teacherMobile;
//	@Column(name = "teacher_mobile_new")
//	private String teacherMobileNew;
//	@Column(name = "teacher_email")
//	private String teacherEmail;
//	@Column(name = "teacher_email_new")
//	private String teacherEmailNew;
//	@Column(name = "work_experience_position_type_present_station_start_date")
//	private String workExperiencePositionTypePresentStationStartDate;
//	@Column(name = "work_experience_position_type_present_station_start_date_new")
//	private String workExperiencePositionTypePresentStationStartDateNew;
//	@Column(name = "work_experience_work_start_date_present_kv")
//	private String workExperienceWorkStartDatePresentKv;
//	@Column(name = "work_experience_work_start_date_present_kv_new")
//	private String workExperienceWorkStartDatePresentKvNew;
//	@Column(name = "last_promotion_position_type")
//	private String lastPromotionPositionType;
//	@Column(name = "last_promotion_position_type_new")
//	private String lastPromotionPositionTypeNew;
//	@Column(name = "last_promotion_position_date")
//	private String lastPromotionPositionDate;
//	@Column(name = "last_promotion_position_date_new")
//	private String lastPromotionPositionDateNew;
//	@Column(name = "work_experience_appointed_for_subject")
//	private String workExperienceAppointedForSubject;
//	@Column(name = "work_experience_appointed_for_subject_new")
//	private String workExperienceAppointedForSubjectNew;
//	@Column(name = "remarks")
//	private String remarks;
//	@Column(name = "query_initiate_date")
//	private String queryInitiateDate;
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
//	public String getTeacherEmployeeCode() {
//		return teacherEmployeeCode;
//	}
//	public void setTeacherEmployeeCode(String teacherEmployeeCode) {
//		this.teacherEmployeeCode = teacherEmployeeCode;
//	}
//	public String getTeacherEmployeeCodeNew() {
//		return teacherEmployeeCodeNew;
//	}
//	public void setTeacherEmployeeCodeNew(String teacherEmployeeCodeNew) {
//		this.teacherEmployeeCodeNew = teacherEmployeeCodeNew;
//	}
//	public String getTeacherName() {
//		return teacherName;
//	}
//	public void setTeacherName(String teacherName) {
//		this.teacherName = teacherName;
//	}
//	public String getTeacherNameNew() {
//		return teacherNameNew;
//	}
//	public void setTeacherNameNew(String teacherNameNew) {
//		this.teacherNameNew = teacherNameNew;
//	}
//	public String getTeacherGender() {
//		return teacherGender;
//	}
//	public void setTeacherGender(String teacherGender) {
//		this.teacherGender = teacherGender;
//	}
//	public String getTeacherGenderNew() {
//		return teacherGenderNew;
//	}
//	public void setTeacherGenderNew(String teacherGenderNew) {
//		this.teacherGenderNew = teacherGenderNew;
//	}
//	public String getTeacherDob() {
//		return teacherDob;
//	}
//	public void setTeacherDob(String teacherDob) {
//		this.teacherDob = teacherDob;
//	}
//	public String getTeacherDobNew() {
//		return teacherDobNew;
//	}
//	public void setTeacherDobNew(String teacherDobNew) {
//		this.teacherDobNew = teacherDobNew;
//	}
//	public String getTeacherSocialCategory() {
//		return teacherSocialCategory;
//	}
//	public void setTeacherSocialCategory(String teacherSocialCategory) {
//		this.teacherSocialCategory = teacherSocialCategory;
//	}
//	public String getTeacherSocialCategoryNew() {
//		return teacherSocialCategoryNew;
//	}
//	public void setTeacherSocialCategoryNew(String teacherSocialCategoryNew) {
//		this.teacherSocialCategoryNew = teacherSocialCategoryNew;
//	}
//	public String getTeacherReligion() {
//		return teacherReligion;
//	}
//	public void setTeacherReligion(String teacherReligion) {
//		this.teacherReligion = teacherReligion;
//	}
//	public String getTeacherReligionNew() {
//		return teacherReligionNew;
//	}
//	public void setTeacherReligionNew(String teacherReligionNew) {
//		this.teacherReligionNew = teacherReligionNew;
//	}
//	public String getTeacherNationality() {
//		return teacherNationality;
//	}
//	public void setTeacherNationality(String teacherNationality) {
//		this.teacherNationality = teacherNationality;
//	}
//	public String getTeacherNationalityNew() {
//		return teacherNationalityNew;
//	}
//	public void setTeacherNationalityNew(String teacherNationalityNew) {
//		this.teacherNationalityNew = teacherNationalityNew;
//	}
//	public String getTeacherMobile() {
//		return teacherMobile;
//	}
//	public void setTeacherMobile(String teacherMobile) {
//		this.teacherMobile = teacherMobile;
//	}
//	public String getTeacherMobileNew() {
//		return teacherMobileNew;
//	}
//	public void setTeacherMobileNew(String teacherMobileNew) {
//		this.teacherMobileNew = teacherMobileNew;
//	}
//	public String getTeacherEmail() {
//		return teacherEmail;
//	}
//	public void setTeacherEmail(String teacherEmail) {
//		this.teacherEmail = teacherEmail;
//	}
//	public String getTeacherEmailNew() {
//		return teacherEmailNew;
//	}
//	public void setTeacherEmailNew(String teacherEmailNew) {
//		this.teacherEmailNew = teacherEmailNew;
//	}
//	public String getWorkExperiencePositionTypePresentStationStartDate() {
//		return workExperiencePositionTypePresentStationStartDate;
//	}
//	public void setWorkExperiencePositionTypePresentStationStartDate(
//			String workExperiencePositionTypePresentStationStartDate) {
//		this.workExperiencePositionTypePresentStationStartDate = workExperiencePositionTypePresentStationStartDate;
//	}
//	public String getWorkExperiencePositionTypePresentStationStartDateNew() {
//		return workExperiencePositionTypePresentStationStartDateNew;
//	}
//	public void setWorkExperiencePositionTypePresentStationStartDateNew(
//			String workExperiencePositionTypePresentStationStartDateNew) {
//		this.workExperiencePositionTypePresentStationStartDateNew = workExperiencePositionTypePresentStationStartDateNew;
//	}
//	public String getWorkExperienceWorkStartDatePresentKv() {
//		return workExperienceWorkStartDatePresentKv;
//	}
//	public void setWorkExperienceWorkStartDatePresentKv(String workExperienceWorkStartDatePresentKv) {
//		this.workExperienceWorkStartDatePresentKv = workExperienceWorkStartDatePresentKv;
//	}
//	public String getWorkExperienceWorkStartDatePresentKvNew() {
//		return workExperienceWorkStartDatePresentKvNew;
//	}
//	public void setWorkExperienceWorkStartDatePresentKvNew(String workExperienceWorkStartDatePresentKvNew) {
//		this.workExperienceWorkStartDatePresentKvNew = workExperienceWorkStartDatePresentKvNew;
//	}
//	public String getLastPromotionPositionType() {
//		return lastPromotionPositionType;
//	}
//	public void setLastPromotionPositionType(String lastPromotionPositionType) {
//		this.lastPromotionPositionType = lastPromotionPositionType;
//	}
//	public String getLastPromotionPositionTypeNew() {
//		return lastPromotionPositionTypeNew;
//	}
//	public void setLastPromotionPositionTypeNew(String lastPromotionPositionTypeNew) {
//		this.lastPromotionPositionTypeNew = lastPromotionPositionTypeNew;
//	}
//	public String getLastPromotionPositionDate() {
//		return lastPromotionPositionDate;
//	}
//	public void setLastPromotionPositionDate(String lastPromotionPositionDate) {
//		this.lastPromotionPositionDate = lastPromotionPositionDate;
//	}
//	public String getLastPromotionPositionDateNew() {
//		return lastPromotionPositionDateNew;
//	}
//	public void setLastPromotionPositionDateNew(String lastPromotionPositionDateNew) {
//		this.lastPromotionPositionDateNew = lastPromotionPositionDateNew;
//	}
//	public String getWorkExperienceAppointedForSubject() {
//		return workExperienceAppointedForSubject;
//	}
//	public void setWorkExperienceAppointedForSubject(String workExperienceAppointedForSubject) {
//		this.workExperienceAppointedForSubject = workExperienceAppointedForSubject;
//	}
//	public String getWorkExperienceAppointedForSubjectNew() {
//		return workExperienceAppointedForSubjectNew;
//	}
//	public void setWorkExperienceAppointedForSubjectNew(String workExperienceAppointedForSubjectNew) {
//		this.workExperienceAppointedForSubjectNew = workExperienceAppointedForSubjectNew;
//	}
//	public String getRemarks() {
//		return remarks;
//	}
//	public void setRemarks(String remarks) {
//		this.remarks = remarks;
//	}
//	public String getQueryInitiateDate() {
//		return queryInitiateDate;
//	}
//	public void setQueryInitiateDate(String queryInitiateDate) {
//		this.queryInitiateDate = queryInitiateDate;
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
