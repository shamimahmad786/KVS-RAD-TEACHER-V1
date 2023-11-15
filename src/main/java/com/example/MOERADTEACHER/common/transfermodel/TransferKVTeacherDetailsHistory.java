package com.example.MOERADTEACHER.common.transfermodel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="transfer_kvteacher_detail_histroy", schema = "transfer")
public class TransferKVTeacherDetailsHistory implements Serializable{

	
	

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id")
public Integer id;
@Column(name="transfer_kvteacher_detail_id")
public String transferKvteacherDetailId;
@Column(name="transferKvConfigId")
public String transfer_kv_config_id;
@Column(name="configured_date_compare")
public String configuredDateCompare;
@Column(name="transfer_application_number")
public String transferApplicationNumber;
@Column(name="teacher_id")
public String teacherId;
@Column(name="teacher_name")
public String teacherName;
@Column(name="teacher_gender")
public String teacherGender;
@Column(name="teacher_dob")
public String teacherDob;
@Column(name="teacher_employee_code")
public String teacherEmployeeCode;
@Column(name="teacher_mobile")
public String teacherMobile;
@Column(name="teacher_email")
public String teacherEmail;
@Column(name="teacher_permanent_address")
public String teacherPermanentAddress;
@Column(name="teacher_parmanent_state")
public String teacherParmanentState;
@Column(name="teacher_permanent_district")
public String teacherPermanentDistrict;
@Column(name="teacher_permanent_pin")
public String teacherPermanentPin;
@Column(name="teacher_correspondence_address")
public String teacherCorrespondenceAddress;
@Column(name="teacher_correspondence_state")
public String teacherCorrespondenceState;
@Column(name="teacher_correspondence_district")
public String teacherCorrespondenceDistrict;
@Column(name="teacher_correspondence_pin")
public String teacherCorrespondencePin;
@Column(name="teacher_disability_yn")
public String teacherDisabilityYn;
@Column(name="isLastTransferGroundTeacherDisabilityYn")
public String is_last_transfer_ground_teacher_disability_yn;
@Column(name="work_experience_position_type_present_kv")
public String workExperiencePositionTypePresentKv;
@Column(name="work_experience_work_start_date_present_kv")
public String workExperienceWorkStartDatePresentKv ;
@Column(name="work_experience_id_present_kv")
public String workExperienceIdPresentKv;
@Column(name="present_station_code")
public String presentStationCode;
@Column(name="present_station_name")
public String presentStationName;
@Column(name="present_station_type")
public String presentStationType;
@Column(name="work_experience_position_type_present_station_start_date")
public String workExperiencePositionTypePresentStationStartDate;
@Column(name="work_experience_appointed_for_subject")
public String workExperienceAppointedForSubject;
@Column(name="last_promotion_id")
public String lastPromotionId;
@Column(name="last_promotion_position_type")
public String lastPromotionPositionType;
@Column(name="last_promotion_position_date")
public String lastPromotionPositionDate;
@Column(name="current_udise_sch_code")
public String currentUdiseSchCode;
@Column(name="current_kv_code")
public String currentKvCode;
@Column(name="current_school_name")
public String currentSchoolName;
@Column(name="appr_grade_yr1")
public String apprGradeYr1;
@Column(name="appr_grade1")
public String apprGrade1;
@Column(name="appr_grade_yr2")
public String apprGradeYr2;
@Column(name="appr_grade2")
public String apprGrade2;
@Column(name="hard_station_code")
public String hardStationCode;
@Column(name="hard_station_name")
public String hardStationName;
@Column(name="hard_station_work_start_date")
public String hardStationWorkStartDate;
@Column(name="hard_station_work_end_date")
public String hardStationWorkEndDate;
@Column(name="personal_status")
public String personalStatus;
@Column(name="is_last_transfer_ground_personal_status_yn")
public String isLastTransferGroundPersonalStatusYn;
@Column(name="spouse_status")
public String spouseStatus;
@Column(name="association_member_yn")
public String associationMemberYn;
@Column(name="president_award")
public String presidentAward;
@Column(name="national_award")
public String nationalAward;
@Column(name="regional_award")
public String regionalAward;
@Column(name="child_10_12_yn")
public String child_10_12_yn;
@Column(name="care_giver_yn")
public String careGiverYn;
@Column(name="child_different_able_yn")
public String childDifferentAbleYn;
@Column(name="child_different_able_station_1")
public String childDifferentAbleStation_1;
@Column(name="child_different_able_station_2")
public String childDifferentAbleStation_2;
@Column(name="q1_d_yn")
public String q1DYn;
@Column(name="q1_d_pt")
public String q1DPt;
@Column(name="q2_d_yn")
public String q2DYn;
@Column(name="q2_d_pt")
public String q2DPt;
@Column(name="q3_d_yn")
public String q3DYn;
@Column(name="q3_d_pt")
public String q3DPt;

@Column(name="q4_d_yn")
public String q4DYn;
@Column(name="q4_d_pt")
public String q4DPt;


@Column(name="q5_d_yn")
public String q5DYn;
@Column(name="q5_d_pt")
public String q5DPt;

@Column(name="q6_d_yn")
public String q6DYn;
@Column(name="q6_d_pt")
public String q6DPt;

@Column(name="q7_d_yn")
public String q7DYn;
@Column(name="q7_d_pt")
public String q7DPt;

@Column(name="q8_d_yn")
public String q8DYn;
@Column(name="q8_d_pt")
public String q8DPt;


@Column(name="q9_d_yn")
public String q9DYn;
@Column(name="q9_d_pt")
public String q9DPt;


@Column(name="q10_d_yn")
public String q10DYn;
@Column(name="q10_d_pt")
public String q10DPt;


@Column(name="q11_d_yn")
public String q11DYn;
@Column(name="q11_d_pt")
public String q11DPt;


@Column(name="q12_d_yn")
public String q12DYn;
@Column(name="q12_d_pt")
public String q12DPt;


@Column(name="q13_d_yn")
public String q13DYn;
@Column(name="q13_d_pt")
public String q13DPt;



@Column(name="apply_to_transfer_yn")
public String applyToTransfern;
@Column(name="q1_t_yn")
public String q1TYyn;
@Column(name="q1_t_pt")
public String q1TPt;

@Column(name="q2_t_yn")
public String q2TYyn;
@Column(name="q2_t_pt")
public String q2TPt;

@Column(name="q3_t_yn")
public String q3TYyn;
@Column(name="q3_t_pt")
public String q3TPt;

@Column(name="q4_t_yn")
public String q4TYyn;
@Column(name="q4_t_pt")
public String q4TPt;

@Column(name="q5_t_yn")
public String q5TYyn;
@Column(name="q5_t_pt")
public String q5TPt;

@Column(name="q6_t_yn")
public String q6TYyn;
@Column(name="q6_t_pt")
public String q6TPt;

@Column(name="q7_t_yn")
public String q7TYyn;
@Column(name="q7_t_pt")
public String q7TPt;

@Column(name="q8_t_yn")
public String q8TYyn;
@Column(name="q8_t_pt")
public String q8TPt;

@Column(name="q9_t_yn")
public String q9TYyn;
@Column(name="q9_t_pt")
public String q9TPt;

@Column(name="q10_t_yn")
public String q10TYyn;
@Column(name="q10_t_pt")
public String q10TPt;

//public String createdBy;
//public String modifiedBy;
//public String modifiedDate;

@Column(name="created_by") 
private String createdBy ;

@Column(name="created_time") 
private Date createdTime ;

@Column(name="modified_by") 
private String modifiedBy ;

@Column(name="modified_time") 
private Date modifiedTime;

@Column(name="station_within100km_disp_yn")
private String stationWithin100kmDispYn;


public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTransferKvteacherDetailId() {
	return transferKvteacherDetailId;
}
public void setTransferKvteacherDetailId(String transferKvteacherDetailId) {
	this.transferKvteacherDetailId = transferKvteacherDetailId;
}
public String getTransfer_kv_config_id() {
	return transfer_kv_config_id;
}
public void setTransfer_kv_config_id(String transfer_kv_config_id) {
	this.transfer_kv_config_id = transfer_kv_config_id;
}
public String getConfiguredDateCompare() {
	return configuredDateCompare;
}
public void setConfiguredDateCompare(String configuredDateCompare) {
	this.configuredDateCompare = configuredDateCompare;
}
public String getTransferApplicationNumber() {
	return transferApplicationNumber;
}
public void setTransferApplicationNumber(String transferApplicationNumber) {
	this.transferApplicationNumber = transferApplicationNumber;
}
public String getTeacherId() {
	return teacherId;
}
public void setTeacherId(String teacherId) {
	this.teacherId = teacherId;
}
public String getTeacherName() {
	return teacherName;
}
public void setTeacherName(String teacherName) {
	this.teacherName = teacherName;
}
public String getTeacherGender() {
	return teacherGender;
}
public void setTeacherGender(String teacherGender) {
	this.teacherGender = teacherGender;
}
public String getTeacherDob() {
	return teacherDob;
}
public void setTeacherDob(String teacherDob) {
	this.teacherDob = teacherDob;
}
public String getTeacherEmployeeCode() {
	return teacherEmployeeCode;
}
public void setTeacherEmployeeCode(String teacherEmployeeCode) {
	this.teacherEmployeeCode = teacherEmployeeCode;
}
public String getTeacherMobile() {
	return teacherMobile;
}
public void setTeacherMobile(String teacherMobile) {
	this.teacherMobile = teacherMobile;
}
public String getTeacherEmail() {
	return teacherEmail;
}
public void setTeacherEmail(String teacherEmail) {
	this.teacherEmail = teacherEmail;
}
public String getTeacherPermanentAddress() {
	return teacherPermanentAddress;
}
public void setTeacherPermanentAddress(String teacherPermanentAddress) {
	this.teacherPermanentAddress = teacherPermanentAddress;
}
public String getTeacherParmanentState() {
	return teacherParmanentState;
}
public void setTeacherParmanentState(String teacherParmanentState) {
	this.teacherParmanentState = teacherParmanentState;
}
public String getTeacherPermanentDistrict() {
	return teacherPermanentDistrict;
}
public void setTeacherPermanentDistrict(String teacherPermanentDistrict) {
	this.teacherPermanentDistrict = teacherPermanentDistrict;
}
public String getTeacherPermanentPin() {
	return teacherPermanentPin;
}
public void setTeacherPermanentPin(String teacherPermanentPin) {
	this.teacherPermanentPin = teacherPermanentPin;
}
public String getTeacherCorrespondenceAddress() {
	return teacherCorrespondenceAddress;
}
public void setTeacherCorrespondenceAddress(String teacherCorrespondenceAddress) {
	this.teacherCorrespondenceAddress = teacherCorrespondenceAddress;
}
public String getTeacherCorrespondenceState() {
	return teacherCorrespondenceState;
}
public void setTeacherCorrespondenceState(String teacherCorrespondenceState) {
	this.teacherCorrespondenceState = teacherCorrespondenceState;
}
public String getTeacherCorrespondenceDistrict() {
	return teacherCorrespondenceDistrict;
}
public void setTeacherCorrespondenceDistrict(String teacherCorrespondenceDistrict) {
	this.teacherCorrespondenceDistrict = teacherCorrespondenceDistrict;
}



public String getTeacherCorrespondencePin() {
	return teacherCorrespondencePin;
}
public void setTeacherCorrespondencePin(String teacherCorrespondencePin) {
	this.teacherCorrespondencePin = teacherCorrespondencePin;
}
public String getTeacherDisabilityYn() {
	return teacherDisabilityYn;
}
public void setTeacherDisabilityYn(String teacherDisabilityYn) {
	this.teacherDisabilityYn = teacherDisabilityYn;
}
public String getIs_last_transfer_ground_teacher_disability_yn() {
	return is_last_transfer_ground_teacher_disability_yn;
}
public void setIs_last_transfer_ground_teacher_disability_yn(String is_last_transfer_ground_teacher_disability_yn) {
	this.is_last_transfer_ground_teacher_disability_yn = is_last_transfer_ground_teacher_disability_yn;
}
public String getWorkExperiencePositionTypePresentKv() {
	return workExperiencePositionTypePresentKv;
}
public void setWorkExperiencePositionTypePresentKv(String workExperiencePositionTypePresentKv) {
	this.workExperiencePositionTypePresentKv = workExperiencePositionTypePresentKv;
}
public String getWorkExperienceWorkStartDatePresentKv() {
	return workExperienceWorkStartDatePresentKv;
}
public void setWorkExperienceWorkStartDatePresentKv(String workExperienceWorkStartDatePresentKv) {
	this.workExperienceWorkStartDatePresentKv = workExperienceWorkStartDatePresentKv;
}
public String getWorkExperienceIdPresentKv() {
	return workExperienceIdPresentKv;
}
public void setWorkExperienceIdPresentKv(String workExperienceIdPresentKv) {
	this.workExperienceIdPresentKv = workExperienceIdPresentKv;
}
public String getPresentStationCode() {
	return presentStationCode;
}
public void setPresentStationCode(String presentStationCode) {
	this.presentStationCode = presentStationCode;
}
public String getPresentStationName() {
	return presentStationName;
}
public void setPresentStationName(String presentStationName) {
	this.presentStationName = presentStationName;
}
public String getPresentStationType() {
	return presentStationType;
}
public void setPresentStationType(String presentStationType) {
	this.presentStationType = presentStationType;
}
public String getWorkExperiencePositionTypePresentStationStartDate() {
	return workExperiencePositionTypePresentStationStartDate;
}
public void setWorkExperiencePositionTypePresentStationStartDate(
		String workExperiencePositionTypePresentStationStartDate) {
	this.workExperiencePositionTypePresentStationStartDate = workExperiencePositionTypePresentStationStartDate;
}
public String getWorkExperienceAppointedForSubject() {
	return workExperienceAppointedForSubject;
}
public void setWorkExperienceAppointedForSubject(String workExperienceAppointedForSubject) {
	this.workExperienceAppointedForSubject = workExperienceAppointedForSubject;
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
public String getLastPromotionPositionDate() {
	return lastPromotionPositionDate;
}
public void setLastPromotionPositionDate(String lastPromotionPositionDate) {
	this.lastPromotionPositionDate = lastPromotionPositionDate;
}
public String getCurrentUdiseSchCode() {
	return currentUdiseSchCode;
}
public void setCurrentUdiseSchCode(String currentUdiseSchCode) {
	this.currentUdiseSchCode = currentUdiseSchCode;
}
public String getCurrentKvCode() {
	return currentKvCode;
}
public void setCurrentKvCode(String currentKvCode) {
	this.currentKvCode = currentKvCode;
}
public String getCurrentSchoolName() {
	return currentSchoolName;
}
public void setCurrentSchoolName(String currentSchoolName) {
	this.currentSchoolName = currentSchoolName;
}
public String getApprGradeYr1() {
	return apprGradeYr1;
}
public void setApprGradeYr1(String apprGradeYr1) {
	this.apprGradeYr1 = apprGradeYr1;
}
public String getApprGrade1() {
	return apprGrade1;
}
public void setApprGrade1(String apprGrade1) {
	this.apprGrade1 = apprGrade1;
}
public String getApprGradeYr2() {
	return apprGradeYr2;
}
public void setApprGradeYr2(String apprGradeYr2) {
	this.apprGradeYr2 = apprGradeYr2;
}
public String getApprGrade2() {
	return apprGrade2;
}
public void setApprGrade2(String apprGrade2) {
	this.apprGrade2 = apprGrade2;
}
public String getHardStationCode() {
	return hardStationCode;
}
public void setHardStationCode(String hardStationCode) {
	this.hardStationCode = hardStationCode;
}
public String getHardStationName() {
	return hardStationName;
}
public void setHardStationName(String hardStationName) {
	this.hardStationName = hardStationName;
}
public String getHardStationWorkStartDate() {
	return hardStationWorkStartDate;
}
public void setHardStationWorkStartDate(String hardStationWorkStartDate) {
	this.hardStationWorkStartDate = hardStationWorkStartDate;
}
public String getHardStationWorkEndDate() {
	return hardStationWorkEndDate;
}
public void setHardStationWorkEndDate(String hardStationWorkEndDate) {
	this.hardStationWorkEndDate = hardStationWorkEndDate;
}
public String getPersonalStatus() {
	return personalStatus;
}
public void setPersonalStatus(String personalStatus) {
	this.personalStatus = personalStatus;
}
public String getIsLastTransferGroundPersonalStatusYn() {
	return isLastTransferGroundPersonalStatusYn;
}
public void setIsLastTransferGroundPersonalStatusYn(String isLastTransferGroundPersonalStatusYn) {
	this.isLastTransferGroundPersonalStatusYn = isLastTransferGroundPersonalStatusYn;
}
public String getSpouseStatus() {
	return spouseStatus;
}
public void setSpouseStatus(String spouseStatus) {
	this.spouseStatus = spouseStatus;
}
public String getAssociationMemberYn() {
	return associationMemberYn;
}
public void setAssociationMemberYn(String associationMemberYn) {
	this.associationMemberYn = associationMemberYn;
}
public String getPresidentAward() {
	return presidentAward;
}
public void setPresidentAward(String presidentAward) {
	this.presidentAward = presidentAward;
}
public String getNationalAward() {
	return nationalAward;
}
public void setNationalAward(String nationalAward) {
	this.nationalAward = nationalAward;
}
public String getRegionalAward() {
	return regionalAward;
}
public void setRegionalAward(String regionalAward) {
	this.regionalAward = regionalAward;
}
public String getChild_10_12_yn() {
	return child_10_12_yn;
}
public void setChild_10_12_yn(String child_10_12_yn) {
	this.child_10_12_yn = child_10_12_yn;
}
public String getCareGiverYn() {
	return careGiverYn;
}
public void setCareGiverYn(String careGiverYn) {
	this.careGiverYn = careGiverYn;
}
public String getChildDifferentAbleYn() {
	return childDifferentAbleYn;
}
public void setChildDifferentAbleYn(String childDifferentAbleYn) {
	this.childDifferentAbleYn = childDifferentAbleYn;
}
public String getChildDifferentAbleStation_1() {
	return childDifferentAbleStation_1;
}
public void setChildDifferentAbleStation_1(String childDifferentAbleStation_1) {
	this.childDifferentAbleStation_1 = childDifferentAbleStation_1;
}
public String getChildDifferentAbleStation_2() {
	return childDifferentAbleStation_2;
}
public void setChildDifferentAbleStation_2(String childDifferentAbleStation_2) {
	this.childDifferentAbleStation_2 = childDifferentAbleStation_2;
}
public String getQ1DYn() {
	return q1DYn;
}
public void setQ1DYn(String q1dYn) {
	q1DYn = q1dYn;
}
public String getQ1DPt() {
	return q1DPt;
}
public void setQ1DPt(String q1dPt) {
	q1DPt = q1dPt;
}
public String getQ2DYn() {
	return q2DYn;
}
public void setQ2DYn(String q2dYn) {
	q2DYn = q2dYn;
}
public String getQ2DPt() {
	return q2DPt;
}
public void setQ2DPt(String q2dPt) {
	q2DPt = q2dPt;
}
public String getQ3DYn() {
	return q3DYn;
}
public void setQ3DYn(String q3dYn) {
	q3DYn = q3dYn;
}
public String getQ3DPt() {
	return q3DPt;
}
public void setQ3DPt(String q3dPt) {
	q3DPt = q3dPt;
}
public String getQ4DYn() {
	return q4DYn;
}
public void setQ4DYn(String q4dYn) {
	q4DYn = q4dYn;
}
public String getQ4DPt() {
	return q4DPt;
}
public void setQ4DPt(String q4dPt) {
	q4DPt = q4dPt;
}
public String getQ5DYn() {
	return q5DYn;
}
public void setQ5DYn(String q5dYn) {
	q5DYn = q5dYn;
}
public String getQ5DPt() {
	return q5DPt;
}
public void setQ5DPt(String q5dPt) {
	q5DPt = q5dPt;
}
public String getQ6DYn() {
	return q6DYn;
}
public void setQ6DYn(String q6dYn) {
	q6DYn = q6dYn;
}
public String getQ6DPt() {
	return q6DPt;
}
public void setQ6DPt(String q6dPt) {
	q6DPt = q6dPt;
}
public String getQ7DYn() {
	return q7DYn;
}
public void setQ7DYn(String q7dYn) {
	q7DYn = q7dYn;
}
public String getQ7DPt() {
	return q7DPt;
}
public void setQ7DPt(String q7dPt) {
	q7DPt = q7dPt;
}
public String getQ8DYn() {
	return q8DYn;
}
public void setQ8DYn(String q8dYn) {
	q8DYn = q8dYn;
}
public String getQ8DPt() {
	return q8DPt;
}
public void setQ8DPt(String q8dPt) {
	q8DPt = q8dPt;
}
public String getQ9DYn() {
	return q9DYn;
}
public void setQ9DYn(String q9dYn) {
	q9DYn = q9dYn;
}
public String getQ9DPt() {
	return q9DPt;
}
public void setQ9DPt(String q9dPt) {
	q9DPt = q9dPt;
}
public String getQ10DYn() {
	return q10DYn;
}
public void setQ10DYn(String q10dYn) {
	q10DYn = q10dYn;
}
public String getQ10DPt() {
	return q10DPt;
}
public void setQ10DPt(String q10dPt) {
	q10DPt = q10dPt;
}
public String getQ11DYn() {
	return q11DYn;
}
public void setQ11DYn(String q11dYn) {
	q11DYn = q11dYn;
}
public String getQ11DPt() {
	return q11DPt;
}
public void setQ11DPt(String q11dPt) {
	q11DPt = q11dPt;
}
public String getQ12DYn() {
	return q12DYn;
}
public void setQ12DYn(String q12dYn) {
	q12DYn = q12dYn;
}
public String getQ12DPt() {
	return q12DPt;
}
public void setQ12DPt(String q12dPt) {
	q12DPt = q12dPt;
}
public String getQ13DYn() {
	return q13DYn;
}
public void setQ13DYn(String q13dYn) {
	q13DYn = q13dYn;
}
public String getQ13DPt() {
	return q13DPt;
}
public void setQ13DPt(String q13dPt) {
	q13DPt = q13dPt;
}
public String getApplyToTransfern() {
	return applyToTransfern;
}
public void setApplyToTransfern(String applyToTransfern) {
	this.applyToTransfern = applyToTransfern;
}
public String getQ1TYyn() {
	return q1TYyn;
}
public void setQ1TYyn(String q1tYyn) {
	q1TYyn = q1tYyn;
}
public String getQ1TPt() {
	return q1TPt;
}
public void setQ1TPt(String q1tPt) {
	q1TPt = q1tPt;
}
public String getQ2TYyn() {
	return q2TYyn;
}
public void setQ2TYyn(String q2tYyn) {
	q2TYyn = q2tYyn;
}
public String getQ2TPt() {
	return q2TPt;
}
public void setQ2TPt(String q2tPt) {
	q2TPt = q2tPt;
}
public String getQ3TYyn() {
	return q3TYyn;
}
public void setQ3TYyn(String q3tYyn) {
	q3TYyn = q3tYyn;
}
public String getQ3TPt() {
	return q3TPt;
}
public void setQ3TPt(String q3tPt) {
	q3TPt = q3tPt;
}
public String getQ4TYyn() {
	return q4TYyn;
}
public void setQ4TYyn(String q4tYyn) {
	q4TYyn = q4tYyn;
}
public String getQ4TPt() {
	return q4TPt;
}
public void setQ4TPt(String q4tPt) {
	q4TPt = q4tPt;
}
public String getQ5TYyn() {
	return q5TYyn;
}
public void setQ5TYyn(String q5tYyn) {
	q5TYyn = q5tYyn;
}
public String getQ5TPt() {
	return q5TPt;
}
public void setQ5TPt(String q5tPt) {
	q5TPt = q5tPt;
}
public String getQ6TYyn() {
	return q6TYyn;
}
public void setQ6TYyn(String q6tYyn) {
	q6TYyn = q6tYyn;
}
public String getQ6TPt() {
	return q6TPt;
}
public void setQ6TPt(String q6tPt) {
	q6TPt = q6tPt;
}
public String getQ7TYyn() {
	return q7TYyn;
}
public void setQ7TYyn(String q7tYyn) {
	q7TYyn = q7tYyn;
}
public String getQ7TPt() {
	return q7TPt;
}
public void setQ7TPt(String q7tPt) {
	q7TPt = q7tPt;
}
public String getQ8TYyn() {
	return q8TYyn;
}
public void setQ8TYyn(String q8tYyn) {
	q8TYyn = q8tYyn;
}
public String getQ8TPt() {
	return q8TPt;
}
public void setQ8TPt(String q8tPt) {
	q8TPt = q8tPt;
}
public String getQ9TYyn() {
	return q9TYyn;
}
public void setQ9TYyn(String q9tYyn) {
	q9TYyn = q9tYyn;
}
public String getQ9TPt() {
	return q9TPt;
}
public void setQ9TPt(String q9tPt) {
	q9TPt = q9tPt;
}
public String getQ10TYyn() {
	return q10TYyn;
}
public void setQ10TYyn(String q10tYyn) {
	q10TYyn = q10tYyn;
}
public String getQ10TPt() {
	return q10TPt;
}
public void setQ10TPt(String q10tPt) {
	q10TPt = q10tPt;
}
//public String getCreatedBy() {
//	return createdBy;
//}
//public void setCreatedBy(String createdBy) {
//	this.createdBy = createdBy;
//}
//public String getModifiedBy() {
//	return modifiedBy;
//}
//public void setModifiedBy(String modifiedBy) {
//	this.modifiedBy = modifiedBy;
//}
//public String getModifiedDate() {
//	return modifiedDate;
//}
//public void setModifiedDate(String modifiedDate) {
//	this.modifiedDate = modifiedDate;
//}
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

@PreUpdate
void updatedAt() {
  this.modifiedTime = new Date();
}
	
	
}
