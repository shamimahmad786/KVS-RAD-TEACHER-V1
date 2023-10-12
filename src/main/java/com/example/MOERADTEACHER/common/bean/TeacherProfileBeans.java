package com.example.MOERADTEACHER.common.bean;





import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;





public class TeacherProfileBeans {
	private Integer teacherId;
	private String teacherName ;
	private String teacherGender ;
	private String teacherDob ;
	private String teacherEmployeeCode ;
	private String teacherSocialCategory ;
	private String teacherMobile ;
	private String teacherEmail ;
	private String teacherReligion ;
	private String teacherNationality ;
	private String teacherBloodGroup ;
	private String teacherPermanentAddress ;
	private String teacherParmanentState ;
	private String teacherPermanentDistrict ;
	private String teacherPermanentPin ;
	private String teacherCorrespondenceAddress ;
	private String teacherCorrespondenceState ;
	private String teacherCorrespondenceDistrict ;
	private String teacherCorrespondencePin ;
	private String teacherPersonnelIdentification ;
	private String  teacherPanNumber ;
	private String  teacherAadhaarNumber ;
	private String teacherPassportNumber ;
	private String teacherDisabilityYn ;
	private String teacherDisabilityType ;
	private String teacherDisabilityFromBirthYn ;
	private String teacherDisabilityDate ;
	private String teacherDisabilityPrcnt ;
	private String teacherDisabilityCertAuthority ;
	private String teacherDisabilityCertNumber ;
	private String teacherTempId ;
	private String teacherSystemGeneratedCode ;
	private String currentUdiseSchCode ;
	private String kvCode ;
	private String schoolId ;
	private String teacherAccountId ;
	private String createdBy ;
	private Date createdTime ;
	private String modifiedBy ;
	private Date modifiedTime;
	private String verifiedType;
	private Integer versionNo;
	private String teachingNonteaching;
	private String udiseSchoolName;
	private String teacherAge;
	private String workExperiencePositionTypePresentKv;
	private String workExperienceWorkStartDatePresentKv;
	private Integer workExperienceIdPresentKv;
	private String workExperiencePositionTypePresentStationStartDate;
	private String lastPromotionId;
	private String lastPromotionPositionType;
	private String lastPromotionPositionDate;
	private String workExperienceAppointedForSubject;
	private Integer dropBoxFlag;
	private String verifyFlag;
	private String transfered_udise_sch_code;
	private String dropbox_feedback;
	private java.sql.Date dropboxDate;
	private String tetQualifiedYn;
	private String tetQualifingYear;
	private String natureOfAppointment;
	private String spouseName;
	private String spouseEmpCode;
	private String spousePost;
	private String spouseStationCode;
	private String spouseStationName;
	private String spouseStatus;
	private String maritalStatus;
	private String schoolRemarks;
	private String teacherRemarks;
	private String singleParentStatusYn;
	private String specialRecruitmentYn;
	private String shiftChangeSameSchool;
	private String postName;
	private String subjectName;
	private String form1Status;
	private String form2Status;
	private String form3Status;
	private String form4Status;
	private String form5Status;
	private String form6Status;
	private String form7Status;
	private String finalStatus;
	private Integer id;
	private Integer tid;
	
	@JsonProperty(value="teacherId", access=JsonProperty.Access.READ_ONLY)
	public Integer getTeacherId() {
		return teacherId;
	}
	
	@JsonProperty(value="teacher_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	
	@JsonProperty(value="teacherName", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherName() {
		return teacherName;
	}
	@JsonProperty(value="teacher_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	@JsonProperty(value="teacherGender", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherGender() {
		return teacherGender;
	}
	@JsonProperty(value="teacher_gender", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherGender(String teacherGender) {
		this.teacherGender = teacherGender;
	}
	@JsonProperty(value="teacherDob", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherDob() {
		return teacherDob;
	}
	@JsonProperty(value="teacher_dob", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherDob(String teacherDob) {
		this.teacherDob = teacherDob;
	}
	@JsonProperty(value="teacherEmployeeCode", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherEmployeeCode() {
		return teacherEmployeeCode;
	}
	@JsonProperty(value="teacher_employee_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherEmployeeCode(String teacherEmployeeCode) {
		this.teacherEmployeeCode = teacherEmployeeCode;
	}
	@JsonProperty(value="teacherSocialCategory", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherSocialCategory() {
		return teacherSocialCategory;
	}
	@JsonProperty(value="teacher_social_category", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherSocialCategory(String teacherSocialCategory) {
		this.teacherSocialCategory = teacherSocialCategory;
	}
	@JsonProperty(value="teacherMobile", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherMobile() {
		return teacherMobile;
	}
	@JsonProperty(value="teacher_mobile", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherMobile(String teacherMobile) {
		this.teacherMobile = teacherMobile;
	}
	@JsonProperty(value="teacherEmail", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherEmail() {
		return teacherEmail;
	}
	@JsonProperty(value="teacher_email", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}
	@JsonProperty(value="teacherReligion", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherReligion() {
		return teacherReligion;
	}
	@JsonProperty(value="teacher_religion", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherReligion(String teacherReligion) {
		this.teacherReligion = teacherReligion;
	}
	@JsonProperty(value="teacherNationality", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherNationality() {
		return teacherNationality;
	}
	@JsonProperty(value="teacher_nationality", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherNationality(String teacherNationality) {
		this.teacherNationality = teacherNationality;
	}
	@JsonProperty(value="teacherBloodGroup", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherBloodGroup() {
		return teacherBloodGroup;
	}
	@JsonProperty(value="teacher_blood_group", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherBloodGroup(String teacherBloodGroup) {
		this.teacherBloodGroup = teacherBloodGroup;
	}
	@JsonProperty(value="teacherPermanentAddress", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherPermanentAddress() {
		return teacherPermanentAddress;
	}
	@JsonProperty(value="teacher_permanent_address", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherPermanentAddress(String teacherPermanentAddress) {
		this.teacherPermanentAddress = teacherPermanentAddress;
	}
	@JsonProperty(value="teacherParmanentState", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherParmanentState() {
		return teacherParmanentState;
	}
	@JsonProperty(value="teacher_parmanent_state", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherParmanentState(String teacherParmanentState) {
		this.teacherParmanentState = teacherParmanentState;
	}
	@JsonProperty(value="teacherPermanentDistrict", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherPermanentDistrict() {
		return teacherPermanentDistrict;
	}
	@JsonProperty(value="teacher_permanent_district", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherPermanentDistrict(String teacherPermanentDistrict) {
		this.teacherPermanentDistrict = teacherPermanentDistrict;
	}
	@JsonProperty(value="teacherPermanentPin", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherPermanentPin() {
		return teacherPermanentPin;
	}
	@JsonProperty(value="teacher_permanent_pin", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherPermanentPin(String teacherPermanentPin) {
		this.teacherPermanentPin = teacherPermanentPin;
	}
	@JsonProperty(value="teacherCorrespondenceAddress", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherCorrespondenceAddress() {
		return teacherCorrespondenceAddress;
	}
	@JsonProperty(value="teacher_correspondence_address", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherCorrespondenceAddress(String teacherCorrespondenceAddress) {
		this.teacherCorrespondenceAddress = teacherCorrespondenceAddress;
	}
	@JsonProperty(value="teacherCorrespondenceState", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherCorrespondenceState() {
		return teacherCorrespondenceState;
	}
	@JsonProperty(value="teacher_correspondence_state", access=JsonProperty.Access.WRITE_ONLY)	
	public void setTeacherCorrespondenceState(String teacherCorrespondenceState) {
		this.teacherCorrespondenceState = teacherCorrespondenceState;
	}
	@JsonProperty(value="teacherCorrespondenceDistrict", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherCorrespondenceDistrict() {
		return teacherCorrespondenceDistrict;
	}
	@JsonProperty(value="teacher_correspondence_district", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherCorrespondenceDistrict(String teacherCorrespondenceDistrict) {
		this.teacherCorrespondenceDistrict = teacherCorrespondenceDistrict;
	}
	@JsonProperty(value="teacherCorrespondencePin", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherCorrespondencePin() {
		return teacherCorrespondencePin;
	}
	@JsonProperty(value="teacher_correspondence_pin", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherCorrespondencePin(String teacherCorrespondencePin) {
		this.teacherCorrespondencePin = teacherCorrespondencePin;
	}
	@JsonProperty(value="teacherPersonnelIdentification", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherPersonnelIdentification() {
		return teacherPersonnelIdentification;
	}
	@JsonProperty(value="teacher_personnel_identification", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherPersonnelIdentification(String teacherPersonnelIdentification) {
		this.teacherPersonnelIdentification = teacherPersonnelIdentification;
	}
	@JsonProperty(value="teacherPanNumber", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherPanNumber() {
		return teacherPanNumber;
	}
	@JsonProperty(value="teacher_pan_number", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherPanNumber(String teacherPanNumber) {
		this.teacherPanNumber = teacherPanNumber;
	}
	@JsonProperty(value="teacherAadhaarNumber", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherAadhaarNumber() {
		return teacherAadhaarNumber;
	}
	@JsonProperty(value="teacher_aadhaar_number", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherAadhaarNumber(String teacherAadhaarNumber) {
		this.teacherAadhaarNumber = teacherAadhaarNumber;
	}
	@JsonProperty(value="teacherPassportNumber", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherPassportNumber() {
		return teacherPassportNumber;
	}
	@JsonProperty(value="teacher_passport_number", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherPassportNumber(String teacherPassportNumber) {
		this.teacherPassportNumber = teacherPassportNumber;
	}
	@JsonProperty(value="teacherDisabilityYn", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherDisabilityYn() {
		return teacherDisabilityYn;
	}
	@JsonProperty(value="teacher_disability_yn", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherDisabilityYn(String teacherDisabilityYn) {
		this.teacherDisabilityYn = teacherDisabilityYn;
	}
	@JsonProperty(value="teacherDisabilityType", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherDisabilityType() {
		return teacherDisabilityType;
	}
	@JsonProperty(value="teacher_disability_type", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherDisabilityType(String teacherDisabilityType) {
		this.teacherDisabilityType = teacherDisabilityType;
	}
	@JsonProperty(value="teacherDisabilityFromBirthYn", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherDisabilityFromBirthYn() {
		return teacherDisabilityFromBirthYn;
	}
	@JsonProperty(value="teacher_disability_from_birth_yn", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherDisabilityFromBirthYn(String teacherDisabilityFromBirthYn) {
		this.teacherDisabilityFromBirthYn = teacherDisabilityFromBirthYn;
	}
	@JsonProperty(value="teacherDisabilityDate", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherDisabilityDate() {
		return teacherDisabilityDate;
	}
	@JsonProperty(value="teacher_disability_date", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherDisabilityDate(String teacherDisabilityDate) {
		this.teacherDisabilityDate = teacherDisabilityDate;
	}
	@JsonProperty(value="teacherDisabilityPrcnt", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherDisabilityPrcnt() {
		return teacherDisabilityPrcnt;
	}
	@JsonProperty(value="teacher_disability_prcnt", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherDisabilityPrcnt(String teacherDisabilityPrcnt) {
		this.teacherDisabilityPrcnt = teacherDisabilityPrcnt;
	}
	@JsonProperty(value="teacherDisabilityCertAuthority", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherDisabilityCertAuthority() {
		return teacherDisabilityCertAuthority;
	}
	@JsonProperty(value="teacher_disability_cert_authority", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherDisabilityCertAuthority(String teacherDisabilityCertAuthority) {
		this.teacherDisabilityCertAuthority = teacherDisabilityCertAuthority;
	}
	@JsonProperty(value="teacherDisabilityCertNumber", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherDisabilityCertNumber() {
		return teacherDisabilityCertNumber;
	}
	@JsonProperty(value="teacher_disability_cert_number", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherDisabilityCertNumber(String teacherDisabilityCertNumber) {
		this.teacherDisabilityCertNumber = teacherDisabilityCertNumber;
	}
	@JsonProperty(value="teacherTempId", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherTempId() {
		return teacherTempId;
	}
	@JsonProperty(value="teacher_temp_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherTempId(String teacherTempId) {
		this.teacherTempId = teacherTempId;
	}
	@JsonProperty(value="teacherSystemGeneratedCode", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherSystemGeneratedCode() {
		return teacherSystemGeneratedCode;
	}
	@JsonProperty(value="teacher_system_generated_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherSystemGeneratedCode(String teacherSystemGeneratedCode) {
		this.teacherSystemGeneratedCode = teacherSystemGeneratedCode;
	}
	@JsonProperty(value="currentUdiseSchCode", access=JsonProperty.Access.READ_ONLY)
	public String getCurrentUdiseSchCode() {
		return currentUdiseSchCode;
	}
	@JsonProperty(value="current_udise_sch_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setCurrentUdiseSchCode(String currentUdiseSchCode) {
		this.currentUdiseSchCode = currentUdiseSchCode;
	}
	@JsonProperty(value="kvCode", access=JsonProperty.Access.READ_ONLY)
	public String getKvCode() {
		return kvCode;
	}
	@JsonProperty(value="kv_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setKvCode(String kvCode) {
		this.kvCode = kvCode;
	}
	@JsonProperty(value="schoolId", access=JsonProperty.Access.READ_ONLY)
	public String getSchoolId() {
		return schoolId;
	}
	@JsonProperty(value="school_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	@JsonProperty(value="teacherAccountId", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherAccountId() {
		return teacherAccountId;
	}
	@JsonProperty(value="teacher_account_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherAccountId(String teacherAccountId) {
		this.teacherAccountId = teacherAccountId;
	}
	@JsonProperty(value="createdBy", access=JsonProperty.Access.READ_ONLY)
	public String getCreatedBy() {
		return createdBy;
	}
	@JsonProperty(value="created_by", access=JsonProperty.Access.WRITE_ONLY)
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@JsonProperty(value="createdTime", access=JsonProperty.Access.READ_ONLY)
	public Date getCreatedTime() {
		return createdTime;
	}
	@JsonProperty(value="created_time", access=JsonProperty.Access.WRITE_ONLY)
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@JsonProperty(value="modifiedBy", access=JsonProperty.Access.READ_ONLY)
	public String getModifiedBy() {
		return modifiedBy;
	}
	@JsonProperty(value="modified_by", access=JsonProperty.Access.WRITE_ONLY)
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	@JsonProperty(value="modifiedTime", access=JsonProperty.Access.READ_ONLY)
	public Date getModifiedTime() {
		return modifiedTime;
	}
	@JsonProperty(value="modified_time", access=JsonProperty.Access.WRITE_ONLY)
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	@JsonProperty(value="verifiedType", access=JsonProperty.Access.READ_ONLY)
	public String getVerifiedType() {
		return verifiedType;
	}
	@JsonProperty(value="verified_type", access=JsonProperty.Access.WRITE_ONLY)
	public void setVerifiedType(String verifiedType) {
		this.verifiedType = verifiedType;
	}
	@JsonProperty(value="versionNo", access=JsonProperty.Access.READ_ONLY)
	public Integer getVersionNo() {
		return versionNo;
	}
	@JsonProperty(value="version_no", access=JsonProperty.Access.WRITE_ONLY)
	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}
	@JsonProperty(value="teachingNonteaching", access=JsonProperty.Access.READ_ONLY)
	public String getTeachingNonteaching() {
		return teachingNonteaching;
	}
	@JsonProperty(value="teaching_nonteaching", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeachingNonteaching(String teachingNonteaching) {
		this.teachingNonteaching = teachingNonteaching;
	}
	@JsonProperty(value="udiseSchoolName", access=JsonProperty.Access.READ_ONLY)
	public String getUdiseSchoolName() {
		return udiseSchoolName;
	}
	@JsonProperty(value="udise_school_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setUdiseSchoolName(String udiseSchoolName) {
		this.udiseSchoolName = udiseSchoolName;
	}
	@JsonProperty(value="teacherAge", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherAge() {
		return teacherAge;
	}
	@JsonProperty(value="teacher_age", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherAge(String teacherAge) {
		this.teacherAge = teacherAge;
	}
	@JsonProperty(value="workExperiencePositionTypePresentKv", access=JsonProperty.Access.READ_ONLY)
	public String getWorkExperiencePositionTypePresentKv() {
		return workExperiencePositionTypePresentKv;
	}
	@JsonProperty(value="work_experience_position_type_present_kv", access=JsonProperty.Access.WRITE_ONLY)
	public void setWorkExperiencePositionTypePresentKv(String workExperiencePositionTypePresentKv) {
		this.workExperiencePositionTypePresentKv = workExperiencePositionTypePresentKv;
	}
	@JsonProperty(value="workExperienceWorkStartDatePresentKv", access=JsonProperty.Access.READ_ONLY)
	public String getWorkExperienceWorkStartDatePresentKv() {
		return workExperienceWorkStartDatePresentKv;
	}
	@JsonProperty(value="work_experience_work_start_date_present_kv", access=JsonProperty.Access.WRITE_ONLY)
	public void setWorkExperienceWorkStartDatePresentKv(String workExperienceWorkStartDatePresentKv) {
		this.workExperienceWorkStartDatePresentKv = workExperienceWorkStartDatePresentKv;
	}
	@JsonProperty(value="workExperienceIdPresentKv", access=JsonProperty.Access.READ_ONLY)
	public Integer getWorkExperienceIdPresentKv() {
		return workExperienceIdPresentKv;
	}
	@JsonProperty(value="work_experience_id_present_kv", access=JsonProperty.Access.WRITE_ONLY)
	public void setWorkExperienceIdPresentKv(Integer workExperienceIdPresentKv) {
		this.workExperienceIdPresentKv = workExperienceIdPresentKv;
	}
	@JsonProperty(value="workExperiencePositionTypePresentStationStartDate", access=JsonProperty.Access.READ_ONLY)
	public String getWorkExperiencePositionTypePresentStationStartDate() {
		return workExperiencePositionTypePresentStationStartDate;
	}
	@JsonProperty(value="work_experience_position_type_present_station_start_date", access=JsonProperty.Access.WRITE_ONLY)
	public void setWorkExperiencePositionTypePresentStationStartDate(
			String workExperiencePositionTypePresentStationStartDate) {
		this.workExperiencePositionTypePresentStationStartDate = workExperiencePositionTypePresentStationStartDate;
	}
	@JsonProperty(value="lastPromotionId", access=JsonProperty.Access.READ_ONLY)
	public String getLastPromotionId() {
		return lastPromotionId;
	}
	@JsonProperty(value="last_promotion_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setLastPromotionId(String lastPromotionId) {
		this.lastPromotionId = lastPromotionId;
	}
	@JsonProperty(value="lastPromotionPositionType", access=JsonProperty.Access.READ_ONLY)
	public String getLastPromotionPositionType() {
		return lastPromotionPositionType;
	}
	@JsonProperty(value="last_promotion_position_type", access=JsonProperty.Access.WRITE_ONLY)
	public void setLastPromotionPositionType(String lastPromotionPositionType) {
		this.lastPromotionPositionType = lastPromotionPositionType;
	}
	@JsonProperty(value="lastPromotionPositionDate", access=JsonProperty.Access.READ_ONLY)
	public String getLastPromotionPositionDate() {
		return lastPromotionPositionDate;
	}
	@JsonProperty(value="last_promotion_position_date", access=JsonProperty.Access.WRITE_ONLY)
	public void setLastPromotionPositionDate(String lastPromotionPositionDate) {
		this.lastPromotionPositionDate = lastPromotionPositionDate;
	}
	@JsonProperty(value="workExperienceAppointedForSubject", access=JsonProperty.Access.READ_ONLY)
	public String getWorkExperienceAppointedForSubject() {
		return workExperienceAppointedForSubject;
	}
	@JsonProperty(value="work_experience_appointed_for_subject", access=JsonProperty.Access.WRITE_ONLY)
	public void setWorkExperienceAppointedForSubject(String workExperienceAppointedForSubject) {
		this.workExperienceAppointedForSubject = workExperienceAppointedForSubject;
	}
	@JsonProperty(value="dropBoxFlag", access=JsonProperty.Access.READ_ONLY)
	public Integer getDropBoxFlag() {
		return dropBoxFlag;
	}
	@JsonProperty(value="drop_box_flag", access=JsonProperty.Access.WRITE_ONLY)
	public void setDropBoxFlag(Integer dropBoxFlag) {
		this.dropBoxFlag = dropBoxFlag;
	}
	@JsonProperty(value="verifyFlag", access=JsonProperty.Access.READ_ONLY)
	public String getVerifyFlag() {
		return verifyFlag;
	}
	@JsonProperty(value="verify_flag", access=JsonProperty.Access.WRITE_ONLY)
	public void setVerifyFlag(String verifyFlag) {
		this.verifyFlag = verifyFlag;
	}
	@JsonProperty(value="transfered_udise_sch_code", access=JsonProperty.Access.READ_ONLY)
	public String getTransfered_udise_sch_code() {
		return transfered_udise_sch_code;
	}
	@JsonProperty(value="transfered_udise_sch_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setTransfered_udise_sch_code(String transfered_udise_sch_code) {
		this.transfered_udise_sch_code = transfered_udise_sch_code;
	}
	@JsonProperty(value="dropbox_feedback", access=JsonProperty.Access.READ_ONLY)
	public String getDropbox_feedback() {
		return dropbox_feedback;
	}
	@JsonProperty(value="dropbox_feedback", access=JsonProperty.Access.WRITE_ONLY)
	public void setDropbox_feedback(String dropbox_feedback) {
		this.dropbox_feedback = dropbox_feedback;
	}
	@JsonProperty(value="dropboxDate", access=JsonProperty.Access.READ_ONLY)
	public java.sql.Date getDropboxDate() {
		return dropboxDate;
	}
	@JsonProperty(value="dropbox_date", access=JsonProperty.Access.WRITE_ONLY)
	public void setDropboxDate(java.sql.Date dropboxDate) {
		this.dropboxDate = dropboxDate;
	}
	@JsonProperty(value="tetQualifiedYn", access=JsonProperty.Access.READ_ONLY)
	public String getTetQualifiedYn() {
		return tetQualifiedYn;
	}
	@JsonProperty(value="tet_qualified_yn", access=JsonProperty.Access.WRITE_ONLY)
	public void setTetQualifiedYn(String tetQualifiedYn) {
		this.tetQualifiedYn = tetQualifiedYn;
	}
	@JsonProperty(value="tetQualifingYear", access=JsonProperty.Access.READ_ONLY)
	public String getTetQualifingYear() {
		return tetQualifingYear;
	}
	@JsonProperty(value="tet_qualifing_year", access=JsonProperty.Access.WRITE_ONLY)
	public void setTetQualifingYear(String tetQualifingYear) {
		this.tetQualifingYear = tetQualifingYear;
	}
	@JsonProperty(value="natureOfAppointment", access=JsonProperty.Access.READ_ONLY)
	public String getNatureOfAppointment() {
		return natureOfAppointment;
	}
	@JsonProperty(value="nature_of_appointment", access=JsonProperty.Access.WRITE_ONLY)
	public void setNatureOfAppointment(String natureOfAppointment) {
		this.natureOfAppointment = natureOfAppointment;
	}
	@JsonProperty(value="spouseName", access=JsonProperty.Access.READ_ONLY)
	public String getSpouseName() {
		return spouseName;
	}
	@JsonProperty(value="spouse_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}
	@JsonProperty(value="spouseEmpCode", access=JsonProperty.Access.READ_ONLY)
	public String getSpouseEmpCode() {
		return spouseEmpCode;
	}
	@JsonProperty(value="spouse_emp_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setSpouseEmpCode(String spouseEmpCode) {
		this.spouseEmpCode = spouseEmpCode;
	}
	@JsonProperty(value="spousePost", access=JsonProperty.Access.READ_ONLY)
	public String getSpousePost() {
		return spousePost;
	}
	@JsonProperty(value="spouse_post", access=JsonProperty.Access.WRITE_ONLY)
	public void setSpousePost(String spousePost) {
		this.spousePost = spousePost;
	}
	@JsonProperty(value="spouseStationCode", access=JsonProperty.Access.READ_ONLY)
	public String getSpouseStationCode() {
		return spouseStationCode;
	}
	@JsonProperty(value="spouse_station_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setSpouseStationCode(String spouse_station_code) {
		this.spouseStationCode = spouse_station_code;
	}
	@JsonProperty(value="spouseStationName", access=JsonProperty.Access.READ_ONLY)
	public String getSpouseStationName() {
		return spouseStationName;
	}
	@JsonProperty(value="spouse_station_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setSpouseStationName(String spouseStationName) {
		this.spouseStationName = spouseStationName;
	}
	@JsonProperty(value="spouseStatus", access=JsonProperty.Access.READ_ONLY)
	public String getSpouseStatus() {
		return spouseStatus;
	}
	@JsonProperty(value="spouse_status", access=JsonProperty.Access.WRITE_ONLY)
	public void setSpouseStatus(String spouseStatus) {
		this.spouseStatus = spouseStatus;
	}
	@JsonProperty(value="maritalStatus", access=JsonProperty.Access.READ_ONLY)
	public String getMaritalStatus() {
		return maritalStatus;
	}
	@JsonProperty(value="marital_status", access=JsonProperty.Access.WRITE_ONLY)
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	@JsonProperty(value="schoolRemarks", access=JsonProperty.Access.READ_ONLY)
	public String getSchoolRemarks() {
		return schoolRemarks;
	}
	@JsonProperty(value="school_remarks", access=JsonProperty.Access.WRITE_ONLY)
	public void setSchoolRemarks(String schoolRemarks) {
		this.schoolRemarks = schoolRemarks;
	}
	@JsonProperty(value="teacherRemarks", access=JsonProperty.Access.READ_ONLY)
	public String getTeacherRemarks() {
		return teacherRemarks;
	}
	@JsonProperty(value="teacher_remarks", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherRemarks(String teacherRemarks) {
		this.teacherRemarks = teacherRemarks;
	}
	@JsonProperty(value="singleParentStatusYn", access=JsonProperty.Access.READ_ONLY)
	public String getSingleParentStatusYn() {
		return singleParentStatusYn;
	}
	@JsonProperty(value="single_parent_status_yn", access=JsonProperty.Access.WRITE_ONLY)
	public void setSingleParentStatusYn(String singleParentStatusYn) {
		this.singleParentStatusYn = singleParentStatusYn;
	}
	@JsonProperty(value="specialRecruitmentYn", access=JsonProperty.Access.READ_ONLY)
	public String getSpecialRecruitmentYn() {
		return specialRecruitmentYn;
	}
	@JsonProperty(value="special_recruitment_yn", access=JsonProperty.Access.WRITE_ONLY)
	public void setSpecialRecruitmentYn(String specialRecruitmentYn) {
		this.specialRecruitmentYn = specialRecruitmentYn;
	}
	@JsonProperty(value="shiftChangeSameSchool", access=JsonProperty.Access.READ_ONLY)
	public String getShiftChangeSameSchool() {
		return shiftChangeSameSchool;
	}
	@JsonProperty(value="shift_change_same_school", access=JsonProperty.Access.WRITE_ONLY)
	public void setShiftChangeSameSchool(String shiftChangeSameSchool) {
		this.shiftChangeSameSchool = shiftChangeSameSchool;
	}
	@JsonProperty(value="postName", access=JsonProperty.Access.READ_ONLY)
	public String getPostName() {
		return postName;
	}
	@JsonProperty(value="post_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setPostName(String postName) {
		this.postName = postName;
	}
	@JsonProperty(value="subjectName", access=JsonProperty.Access.READ_ONLY)
	public String getSubjectName() {
		return subjectName;
	}
	@JsonProperty(value="subject_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	@JsonProperty(value="form1Status", access=JsonProperty.Access.READ_ONLY)
	public String getForm1Status() {
		return form1Status;
	}
	@JsonProperty(value="form1_status", access=JsonProperty.Access.WRITE_ONLY)
	public void setForm1Status(String form1Status) {
		this.form1Status = form1Status;
	}
	@JsonProperty(value="form2Status", access=JsonProperty.Access.READ_ONLY)
	public String getForm2Status() {
		return form2Status;
	}
	@JsonProperty(value="form2_status", access=JsonProperty.Access.WRITE_ONLY)
	public void setForm2Status(String form2Status) {
		this.form2Status = form2Status;
	}
	
	@JsonProperty(value="form3Status", access=JsonProperty.Access.READ_ONLY)
	public String getForm3Status() {
		return form3Status;
	}
	@JsonProperty(value="form3_status", access=JsonProperty.Access.WRITE_ONLY)
	public void setForm3Status(String form3Status) {
		this.form3Status = form3Status;
	}
	@JsonProperty(value="form4Status", access=JsonProperty.Access.READ_ONLY)
	public String getForm4Status() {
		return form4Status;
	}
	@JsonProperty(value="form4_status", access=JsonProperty.Access.WRITE_ONLY)
	public void setForm4Status(String form4Status) {
		this.form4Status = form4Status;
	}
	@JsonProperty(value="form5Status", access=JsonProperty.Access.READ_ONLY)
	public String getForm5Status() {
		return form5Status;
	}
	@JsonProperty(value="form5_status", access=JsonProperty.Access.WRITE_ONLY)
	public void setForm5Status(String form5Status) {
		this.form5Status = form5Status;
	}
	@JsonProperty(value="form6Status", access=JsonProperty.Access.READ_ONLY)
	public String getForm6Status() {
		return form6Status;
	}
	@JsonProperty(value="form6_status", access=JsonProperty.Access.WRITE_ONLY)
	public void setForm6Status(String form6Status) {
		this.form6Status = form6Status;
	}
	@JsonProperty(value="form7Status", access=JsonProperty.Access.READ_ONLY)
	public String getForm7Status() {
		return form7Status;
	}
	@JsonProperty(value="form7_status", access=JsonProperty.Access.WRITE_ONLY)
	public void setForm7Status(String form7Status) {
		this.form7Status = form7Status;
	}
	@JsonProperty(value="finalStatus", access=JsonProperty.Access.READ_ONLY)
	public String getFinalStatus() {
		return finalStatus;
	}
	@JsonProperty(value="final_status", access=JsonProperty.Access.WRITE_ONLY)
	public void setFinalStatus(String finalStatus) {
		this.finalStatus = finalStatus;
	}
	@JsonProperty(value="id", access=JsonProperty.Access.READ_ONLY)
	public Integer getId() {
		return id;
	}
	@JsonProperty(value="id", access=JsonProperty.Access.WRITE_ONLY)
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonProperty(value="tid", access=JsonProperty.Access.READ_ONLY)
	public Integer getTid() {
		return tid;
	}
	@JsonProperty(value="tid", access=JsonProperty.Access.WRITE_ONLY)
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	
	
	
	
	
}
