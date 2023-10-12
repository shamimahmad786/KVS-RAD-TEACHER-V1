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
//
//@Entity
//@Table(name = "teacher_profile_history")
//public class TeacherProfileHistory implements Serializable{
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name="history_id")
//	private Integer historyId;
//	
//	@Column(name="teacher_id")
//	private Integer teacherId;
//	@Column(name="teacher_name")
//	private String teacherName;
//	@Column(name="teacher_gender")
//	private String teacherGender;
//	@Column(name="teacher_dob")
//	private String teacherDob;
//	@Column(name="teacher_employee_code")
//	private String teacherEmployeeCode;
//	@Column(name="teacher_social_category")
//	private String teacherSocialCategory;
//	@Column(name="teacher_mobile")
//	private String teacherMobile;
//	@Column(name="teacher_email")
//	private String teacherEmail;
//	@Column(name="teacher_religion")
//	private String teacherReligion;
//	@Column(name="teacher_nationality")
//	private String teacherNationality;
//	@Column(name="teacher_blood_group")
//	private String teacherBloodGroup;
//	@Column(name="teacher_permanent_address")
//	private String teacherPermanentAddress;
//	@Column(name="teacher_parmanent_state")
//	private String teacherParmanentState;
//	@Column(name="teacher_permanent_district")
//	private String teacherPermanentDistrict;
//	@Column(name="teacher_permanent_pin")
//	private String teacherPermanentPin;
//	@Column(name="teacher_correspondence_address")
//	private String teacherCorrespondenceAddress;
//	@Column(name="teacher_correspondence_state")
//	private String teacherCorrespondenceState;
//	@Column(name="teacher_correspondence_district")
//	private String teacherCorrespondenceDistrict;
//	@Column(name="teacher_correspondence_pin")
//	private String teacherCorrespondencePin;
//	@Column(name="teacher_personnel_identification")
//	private String teacherPersonnelIdentification;
//	@Column(name="teacher_pan_number")
//	private String teacherPanNumber;
//	@Column(name="teacher_aadhaar_number")
//	private String teacherAadhaarNumber;
//	@Column(name="teacher_passport_number")
//	private String teacherPassportNumber;
//	@Column(name="teacher_disability_yn")
//	private String teacherDisabilityYn;
//	@Column(name="teacher_disability_type")
//	private String teacherDisabilityType;
//	@Column(name="teacher_disability_from_birth_yn")
//	private String teacherDisabilityFromBirthYn;
//	@Column(name="teacher_disability_date")
//	private String teacherDisabilityDate;
//	@Column(name="teacher_disability_prcnt")
//	private String teacherDisabilityPrcnt;
//	@Column(name="teacher_disability_cert_authority")
//	private String teacherDisabilityCertAuthority;
//	@Column(name="teacher_disability_cert_number")
//	private String teacherDisabilityCertNumber;
//	@Column(name="work_experience_position_type_present_kv")
//	private String workExperiencePositionTypePresentKv;
//	@Column(name="work_experience_work_start_date_present_kv")
//	private String workExperienceWorkStartDatePresentKv;
//	@Column(name="work_experience_id_present_kv")
//	private Integer workExperienceIdPresentKv;
//	@Column(name="work_experience_position_type_present_station_start_date")
//	private String workExperiencePositionTypePresentStationStartDate;
//	@Column(name="work_experience_appointed_for_subject")
//	private String workExperienceAppointedForSubject;
//	@Column(name="last_promotion_id")
//	private String lastPromotionId;
//	@Column(name="last_promotion_position_type")
//	private String lastPromotionPositionType;
//	@Column(name="last_promotion_position_date")
//	private String lastPromotionPositionDate;
//	@Column(name="tet_qualified_yn")
//	private String tetQualifiedYn;
//	@Column(name="tet_qualifing_year")
//	private String tetQualifingYear;
//	@Column(name="teacher_temp_id")
//	private String teacherTempId;
//	@Column(name="tid")
//	private Integer tid;
//	@Column(name="teacher_system_generated_code")
//	private String teacherSystemGeneratedCode;
//	@Column(name="teacher_account_id")
//	private String teacherAccountId;
//	@Column(name="current_udise_sch_code")
//	private String currentUdiseSchCode;
//	@Column(name="school_id")
//	private String schoolId;
//	@Column(name="drop_box_flag")
//	private String dropBoxFlag;
//	@Column(name="verify_flag")
//	private String verifyFlag;
//	@Column(name="transfered_udise_sch_code")
//	private String transferedUdiseSchCode;
//	@Column(name="dropbox_feedback")
//	private String dropboxFeedback;
//	@Column(name="created_by")
//	private String createdBy;
//	@Column(name="created_time")
//	private Date createdTime;
//	@Column(name="modified_by")
//	private String modifiedBy;
//	@Column(name="modified_time")
//	private Date modifiedTime;
//	@Column(name="verified_type")
//	private String verifiedType;
//	@Column(name="teaching_nonteaching")
//	private String teachingNonteaching;
//	@Column(name="version_no")
//	private Integer versionNo;
//	@Column(name="nature_of_appointment")
//	private String natureOfAppointment;
//	@Column(name="teacher_profile_teacher_id")
//	private Integer teacherProfileTeacherId;
//	
//	
//	
//	
//	
//	public Integer getHistoryId() {
//		return historyId;
//	}
//	public void setHistoryId(Integer historyId) {
//		this.historyId = historyId;
//	}
//	public Integer getTeacherId() {
//		return teacherId;
//	}
//	public void setTeacherId(Integer teacherId) {
//		this.teacherId = teacherId;
//	}
//	public String getTeacherName() {
//		return teacherName;
//	}
//	public void setTeacherName(String teacherName) {
//		this.teacherName = teacherName;
//	}
//	public String getTeacherGender() {
//		return teacherGender;
//	}
//	public void setTeacherGender(String teacherGender) {
//		this.teacherGender = teacherGender;
//	}
//	public String getTeacherDob() {
//		return teacherDob;
//	}
//	public void setTeacherDob(String teacherDob) {
//		this.teacherDob = teacherDob;
//	}
//	public String getTeacherEmployeeCode() {
//		return teacherEmployeeCode;
//	}
//	public void setTeacherEmployeeCode(String teacherEmployeeCode) {
//		this.teacherEmployeeCode = teacherEmployeeCode;
//	}
//	public String getTeacherSocialCategory() {
//		return teacherSocialCategory;
//	}
//	public void setTeacherSocialCategory(String teacherSocialCategory) {
//		this.teacherSocialCategory = teacherSocialCategory;
//	}
//	public String getTeacherMobile() {
//		return teacherMobile;
//	}
//	public void setTeacherMobile(String teacherMobile) {
//		this.teacherMobile = teacherMobile;
//	}
//	public String getTeacherEmail() {
//		return teacherEmail;
//	}
//	public void setTeacherEmail(String teacherEmail) {
//		this.teacherEmail = teacherEmail;
//	}
//	public String getTeacherReligion() {
//		return teacherReligion;
//	}
//	public void setTeacherReligion(String teacherReligion) {
//		this.teacherReligion = teacherReligion;
//	}
//	public String getTeacherNationality() {
//		return teacherNationality;
//	}
//	public void setTeacherNationality(String teacherNationality) {
//		this.teacherNationality = teacherNationality;
//	}
//	public String getTeacherBloodGroup() {
//		return teacherBloodGroup;
//	}
//	public void setTeacherBloodGroup(String teacherBloodGroup) {
//		this.teacherBloodGroup = teacherBloodGroup;
//	}
//	public String getTeacherPermanentAddress() {
//		return teacherPermanentAddress;
//	}
//	public void setTeacherPermanentAddress(String teacherPermanentAddress) {
//		this.teacherPermanentAddress = teacherPermanentAddress;
//	}
//	public String getTeacherParmanentState() {
//		return teacherParmanentState;
//	}
//	public void setTeacherParmanentState(String teacherParmanentState) {
//		this.teacherParmanentState = teacherParmanentState;
//	}
//	public String getTeacherPermanentDistrict() {
//		return teacherPermanentDistrict;
//	}
//	public void setTeacherPermanentDistrict(String teacherPermanentDistrict) {
//		this.teacherPermanentDistrict = teacherPermanentDistrict;
//	}
//	public String getTeacherPermanentPin() {
//		return teacherPermanentPin;
//	}
//	public void setTeacherPermanentPin(String teacherPermanentPin) {
//		this.teacherPermanentPin = teacherPermanentPin;
//	}
//	public String getTeacherCorrespondenceAddress() {
//		return teacherCorrespondenceAddress;
//	}
//	public void setTeacherCorrespondenceAddress(String teacherCorrespondenceAddress) {
//		this.teacherCorrespondenceAddress = teacherCorrespondenceAddress;
//	}
//	public String getTeacherCorrespondenceState() {
//		return teacherCorrespondenceState;
//	}
//	public void setTeacherCorrespondenceState(String teacherCorrespondenceState) {
//		this.teacherCorrespondenceState = teacherCorrespondenceState;
//	}
//	public String getTeacherCorrespondenceDistrict() {
//		return teacherCorrespondenceDistrict;
//	}
//	public void setTeacherCorrespondenceDistrict(String teacherCorrespondenceDistrict) {
//		this.teacherCorrespondenceDistrict = teacherCorrespondenceDistrict;
//	}
//	public String getTeacherCorrespondencePin() {
//		return teacherCorrespondencePin;
//	}
//	public void setTeacherCorrespondencePin(String teacherCorrespondencePin) {
//		this.teacherCorrespondencePin = teacherCorrespondencePin;
//	}
//	public String getTeacherPersonnelIdentification() {
//		return teacherPersonnelIdentification;
//	}
//	public void setTeacherPersonnelIdentification(String teacherPersonnelIdentification) {
//		this.teacherPersonnelIdentification = teacherPersonnelIdentification;
//	}
//	public String getTeacherPanNumber() {
//		return teacherPanNumber;
//	}
//	public void setTeacherPanNumber(String teacherPanNumber) {
//		this.teacherPanNumber = teacherPanNumber;
//	}
//	public String getTeacherAadhaarNumber() {
//		return teacherAadhaarNumber;
//	}
//	public void setTeacherAadhaarNumber(String teacherAadhaarNumber) {
//		this.teacherAadhaarNumber = teacherAadhaarNumber;
//	}
//	public String getTeacherPassportNumber() {
//		return teacherPassportNumber;
//	}
//	public void setTeacherPassportNumber(String teacherPassportNumber) {
//		this.teacherPassportNumber = teacherPassportNumber;
//	}
//	public String getTeacherDisabilityYn() {
//		return teacherDisabilityYn;
//	}
//	public void setTeacherDisabilityYn(String teacherDisabilityYn) {
//		this.teacherDisabilityYn = teacherDisabilityYn;
//	}
//	public String getTeacherDisabilityType() {
//		return teacherDisabilityType;
//	}
//	public void setTeacherDisabilityType(String teacherDisabilityType) {
//		this.teacherDisabilityType = teacherDisabilityType;
//	}
//	public String getTeacherDisabilityFromBirthYn() {
//		return teacherDisabilityFromBirthYn;
//	}
//	public void setTeacherDisabilityFromBirthYn(String teacherDisabilityFromBirthYn) {
//		this.teacherDisabilityFromBirthYn = teacherDisabilityFromBirthYn;
//	}
//	public String getTeacherDisabilityDate() {
//		return teacherDisabilityDate;
//	}
//	public void setTeacherDisabilityDate(String teacherDisabilityDate) {
//		this.teacherDisabilityDate = teacherDisabilityDate;
//	}
//	public String getTeacherDisabilityPrcnt() {
//		return teacherDisabilityPrcnt;
//	}
//	public void setTeacherDisabilityPrcnt(String teacherDisabilityPrcnt) {
//		this.teacherDisabilityPrcnt = teacherDisabilityPrcnt;
//	}
//	public String getTeacherDisabilityCertAuthority() {
//		return teacherDisabilityCertAuthority;
//	}
//	public void setTeacherDisabilityCertAuthority(String teacherDisabilityCertAuthority) {
//		this.teacherDisabilityCertAuthority = teacherDisabilityCertAuthority;
//	}
//	public String getTeacherDisabilityCertNumber() {
//		return teacherDisabilityCertNumber;
//	}
//	public void setTeacherDisabilityCertNumber(String teacherDisabilityCertNumber) {
//		this.teacherDisabilityCertNumber = teacherDisabilityCertNumber;
//	}
//	public String getWorkExperiencePositionTypePresentKv() {
//		return workExperiencePositionTypePresentKv;
//	}
//	public void setWorkExperiencePositionTypePresentKv(String workExperiencePositionTypePresentKv) {
//		this.workExperiencePositionTypePresentKv = workExperiencePositionTypePresentKv;
//	}
//	public String getWorkExperienceWorkStartDatePresentKv() {
//		return workExperienceWorkStartDatePresentKv;
//	}
//	public void setWorkExperienceWorkStartDatePresentKv(String workExperienceWorkStartDatePresentKv) {
//		this.workExperienceWorkStartDatePresentKv = workExperienceWorkStartDatePresentKv;
//	}
//	public Integer getWorkExperienceIdPresentKv() {
//		return workExperienceIdPresentKv;
//	}
//	public void setWorkExperienceIdPresentKv(Integer workExperienceIdPresentKv) {
//		this.workExperienceIdPresentKv = workExperienceIdPresentKv;
//	}
//	public String getWorkExperiencePositionTypePresentStationStartDate() {
//		return workExperiencePositionTypePresentStationStartDate;
//	}
//	public void setWorkExperiencePositionTypePresentStationStartDate(
//			String workExperiencePositionTypePresentStationStartDate) {
//		this.workExperiencePositionTypePresentStationStartDate = workExperiencePositionTypePresentStationStartDate;
//	}
//	public String getWorkExperienceAppointedForSubject() {
//		return workExperienceAppointedForSubject;
//	}
//	public void setWorkExperienceAppointedForSubject(String workExperienceAppointedForSubject) {
//		this.workExperienceAppointedForSubject = workExperienceAppointedForSubject;
//	}
//	public String getLastPromotionId() {
//		return lastPromotionId;
//	}
//	public void setLastPromotionId(String lastPromotionId) {
//		this.lastPromotionId = lastPromotionId;
//	}
//	public String getLastPromotionPositionType() {
//		return lastPromotionPositionType;
//	}
//	public void setLastPromotionPositionType(String lastPromotionPositionType) {
//		this.lastPromotionPositionType = lastPromotionPositionType;
//	}
//	public String getLastPromotionPositionDate() {
//		return lastPromotionPositionDate;
//	}
//	public void setLastPromotionPositionDate(String lastPromotionPositionDate) {
//		this.lastPromotionPositionDate = lastPromotionPositionDate;
//	}
//	public String getTetQualifiedYn() {
//		return tetQualifiedYn;
//	}
//	public void setTetQualifiedYn(String tetQualifiedYn) {
//		this.tetQualifiedYn = tetQualifiedYn;
//	}
//	public String getTetQualifingYear() {
//		return tetQualifingYear;
//	}
//	public void setTetQualifingYear(String tetQualifingYear) {
//		this.tetQualifingYear = tetQualifingYear;
//	}
//	public String getTeacherTempId() {
//		return teacherTempId;
//	}
//	public void setTeacherTempId(String teacherTempId) {
//		this.teacherTempId = teacherTempId;
//	}
//	public Integer getTid() {
//		return tid;
//	}
//	public void setTid(Integer tid) {
//		this.tid = tid;
//	}
//	public String getTeacherSystemGeneratedCode() {
//		return teacherSystemGeneratedCode;
//	}
//	public void setTeacherSystemGeneratedCode(String teacherSystemGeneratedCode) {
//		this.teacherSystemGeneratedCode = teacherSystemGeneratedCode;
//	}
//	public String getTeacherAccountId() {
//		return teacherAccountId;
//	}
//	public void setTeacherAccountId(String teacherAccountId) {
//		this.teacherAccountId = teacherAccountId;
//	}
//	public String getCurrentUdiseSchCode() {
//		return currentUdiseSchCode;
//	}
//	public void setCurrentUdiseSchCode(String currentUdiseSchCode) {
//		this.currentUdiseSchCode = currentUdiseSchCode;
//	}
//	public String getSchoolId() {
//		return schoolId;
//	}
//	public void setSchoolId(String schoolId) {
//		this.schoolId = schoolId;
//	}
//	public String getDropBoxFlag() {
//		return dropBoxFlag;
//	}
//	public void setDropBoxFlag(String dropBoxFlag) {
//		this.dropBoxFlag = dropBoxFlag;
//	}
//	public String getVerifyFlag() {
//		return verifyFlag;
//	}
//	public void setVerifyFlag(String verifyFlag) {
//		this.verifyFlag = verifyFlag;
//	}
//	public String getTransferedUdiseSchCode() {
//		return transferedUdiseSchCode;
//	}
//	public void setTransferedUdiseSchCode(String transferedUdiseSchCode) {
//		this.transferedUdiseSchCode = transferedUdiseSchCode;
//	}
//	public String getDropboxFeedback() {
//		return dropboxFeedback;
//	}
//	public void setDropboxFeedback(String dropboxFeedback) {
//		this.dropboxFeedback = dropboxFeedback;
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
//	public String getVerifiedType() {
//		return verifiedType;
//	}
//	public void setVerifiedType(String verifiedType) {
//		this.verifiedType = verifiedType;
//	}
//	public String getTeachingNonteaching() {
//		return teachingNonteaching;
//	}
//	public void setTeachingNonteaching(String teachingNonteaching) {
//		this.teachingNonteaching = teachingNonteaching;
//	}
//	public Integer getVersionNo() {
//		return versionNo;
//	}
//	public void setVersionNo(Integer versionNo) {
//		this.versionNo = versionNo;
//	}
//	public String getNatureOfAppointment() {
//		return natureOfAppointment;
//	}
//	public void setNatureOfAppointment(String natureOfAppointment) {
//		this.natureOfAppointment = natureOfAppointment;
//	}
//	public Integer getTeacherProfileTeacherId() {
//		return teacherProfileTeacherId;
//	}
//	public void setTeacherProfileTeacherId(Integer teacherProfileTeacherId) {
//		this.teacherProfileTeacherId = teacherProfileTeacherId;
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
