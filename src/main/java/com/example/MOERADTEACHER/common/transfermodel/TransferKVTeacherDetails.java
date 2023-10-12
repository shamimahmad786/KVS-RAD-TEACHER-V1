package com.example.MOERADTEACHER.common.transfermodel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;

@Entity
@Table(name="transfer_kvteacher_detail", schema = "transfer")
@Transactional
public class TransferKVTeacherDetails implements Serializable{

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id")
public Integer id;
@Column(name="transfer_kvteacher_detail_id")
public String transferKvteacherDetailId;
@Column(name="transfer_kv_config_id")
public String transferKvConfigId;
@Column(name="configured_date_compare")
public String configuredDateCompare;

//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transfer_application_number_seq")
@Column(name="transfer_application_number")
public String transferApplicationNumber;
@Column(name="teacher_id")
public Integer teacherId;
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
@Column(name="is_last_transfer_ground_teacher_disability_yn")
public String isLastTransferGroundTeacherDisabilityYn;
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
public Integer getId() {
	return id;
}





@Column(name="recruited_spcl_drive_ner")
private String recruitedSpclDriveNer;
@Column(name="shift_change_same_school")
private String shiftChangeSameSchool;
@Column(name="choice_kv1_udise_code_present_station")
private String choiceKv1UdiseCodePresentStation;
@Column(name="choice_kv2_udise_code_present_station")
private String choiceKv2UdiseCodePresentStation;
@Column(name="choice_kv3_udise_code_present_station")
private String choiceKv3UdiseCodePresentStation;
@Column(name="choice_kv4_udise_code_present_station")
private String choiceKv4UdiseCodePresentStation;
@Column(name="choice_kv5_udise_code_present_station")
private String choiceKv5UdiseCodePresentStation;
@Column(name="choice_kv1_station_code")
private String choiceKv1StationCode;
@Column(name="choice_kv2_station_code")
private String choiceKv2StationCode;
@Column(name="choice_kv3_station_code")
private String choiceKv3StationCode;
@Column(name="choice_kv4_station_code")
private String choiceKv4StationCode;
@Column(name="choice_kv5_station_code")
private String choiceKv5StationCode;
@Column(name="displacement1_station_code")
private String displacement1StationCode;
@Column(name="displacement2_station_code")
private String displacement2StationCode;
@Column(name="displacement3_station_code")
private String displacement3StationCode;
@Column(name="displacement4_station_code")
private String displacement4StationCode;
@Column(name="displacement5_station_code")
private String displacement5StationCode;

@Column(name="choice_kv1_udise_name_present_station")
private String choiceKv1UdiseNamePresentStation;
@Column(name="choice_kv2_udise_name_present_station")
private String choiceKv2UdiseNamePresentStation;
@Column(name="choice_kv3_udise_name_present_station")
private String choiceKv3UdiseNamePresentStation;
@Column(name="choice_kv4_udise_name_present_station")
private String choiceKv4UdiseNamePresentStation;
@Column(name="choice_kv5_udise_name_present_station")
private String choiceKv5UdiseNamePresentStation;
@Column(name="choice_kv1_station_name")
private String choiceKv1StationName;
@Column(name="choice_kv2_station_name")
private String choiceKv2StationName;
@Column(name="choice_kv3_station_name")
private String choiceKv3StationName;
@Column(name="choice_kv4_station_name")
private String choiceKv4StationName;
@Column(name="choice_kv5_station_name")
private String choiceKv5StationName;
@Column(name="displacement1_station_name")
private String displacement1StationName;
@Column(name="displacement2_station_name")
private String displacement2StationName;
@Column(name="displacement3_station_name")
private String displacement3StationName;
@Column(name="displacement4_station_name")
private String displacement4StationName;
@Column(name="displacement5_station_name")
private String displacement5StationName;

@Column(name="number_of_working_days")
private String numberOfWorkingDays;

@Column(name="absence_days_one")
private String absenceDaysOne;

@Column(name="absence_days_two")
private String absenceDaysTwo;

@Column(name="actual_number_of_working_days")
private String actualNumberOfWorkingDays;



@Column(name="personal_status_ltr")
private String personalStatusLtr;

@Column(name="personal_status_dfp")
private String personalStatusDfp;

@Column(name="personal_status_mdg")
private String personalStatusMdg;

@Column(name="personal_status_wid")
private String personalStatusWid;

@Column(name="personal_status_sp")
private String personalStatusSp;




/* Added to Displacement Count */
 
 @Column(name="personal_status_ltr_dc")
private String personalStatusLtrDc;

@Column(name="personal_status_dfp_dc")
private String personalStatusDfpDc;

@Column(name="personal_status_mdg_dc")
private String personalStatusMdgDc;

@Column(name="personal_status_wid_dc")
private String personalStatusWidDc;

@Column(name="personal_status_sp_dc")
private String personalStatusSpDc;
  
  
/* End of Add Displacement Count */



@Column(name="spouse_na")
private String spouseNa;


@Column(name="total_displacement_count")
private String totalDisplacementCount;


@Column(name="total_transfer_count")
private String totalTransferCount;

@Column(name="exemption_remarks")
private String exemptionRemarks;

@Column(name="exemption_type")
private String exemptionType;

@Column(name="station_within100km_disp_yn")
private String stationWithin100kmDispYn;



public String getPersonalStatusSp() {
	return personalStatusSp;
}
public void setPersonalStatusSp(String personalStatusSp) {
	this.personalStatusSp = personalStatusSp;
}


@Column(name="spouse_kvs_yn")
private String spouseKvsYn;

@Column(name="spouse_central_gvot_yn")
private String spouseCentralGvotYn;

@Column(name="spouse_state_gvot_yn")
private String spouseStateGvotYn;

@Column(name="unmarried_woman_yn")
private String unmarriedWomanYn;

@Column(name="absence_days_tcone")
private String absenceDaysTcone;
@Column(name="actual_number_of_working_tcdays")
private String actualNumberOfWorkingTcdays;




@Column(name="spouse_emp_code")
private String spouseEmpCode;
@Column(name="spouse_post")
private String spousePost;
@Column(name="spouse_station")
private String spouseStation;
@Column(name="patient_name")
private String patientName;
@Column(name="patient_ailment")
private String patientAilment;
@Column(name="patient_hospital")
private String patientHospital;
@Column(name="patient_medical_officer_name")
private String patientMedicalOfficerName;
@Column(name="patient_medical_officer_designation")
private String patientMedicalOfficerDesignation;
@Column(name="child_10_12_name")
private String child1012Name;
@Column(name="child_10_12_class")
private String child1012Class;
@Column(name="child_10_12_school")
private String child1012School;
@Column(name="child_10_12_board")
private String child1012Board;
@Column(name="care_giver_name")
private String careGiverName;
@Column(name="care_giver_relation")
private String careGiverRelation;
@Column(name="care_giver_disability_name")
private String careGiverDisabilityName;
@Column(name="care_giver_disability_prcnt")
private String careGiverDisabilityPrcnt;
@Column(name="child_different_name")
private String childDifferentName;
@Column(name="child_different_disability_name")
private String childDifferentDisabilityName;
@Column(name="child_different_disability_prcnt")
private String childDifferentDisabilityPrcnt;

@Column(name="choice_kv1_station_code_udise_code1")
private String choiceKv1StationCodeUdiseCode1;
@Column(name="choice_kv1_station_code_udise_code2")
private String choiceKv1StationCodeUdiseCode2;
@Column(name="choice_kv1_station_code_udise_code3")
private String choiceKv1StationCodeUdiseCode3;
@Column(name="choice_kv2_station_code_udise_code1")
private String choiceKv2StationCodeUdiseCode1;
@Column(name="choice_kv2_station_code_udise_code2")
private String choiceKv2StationCodeUdiseCode2;
@Column(name="choice_kv2_station_code_udise_code3")
private String choiceKv2StationCodeUdiseCode3;
@Column(name="choice_kv3_station_code_udise_code1")
private String choiceKv3StationCodeUdiseCode1;
@Column(name="choice_kv3_station_code_udise_code2")
private String choiceKv3StationCodeUdiseCode2;
@Column(name="choice_kv3_station_code_udise_code3")
private String choiceKv3StationCodeUdiseCode3;
@Column(name="choice_kv4_station_code_udise_code1")
private String choiceKv4StationCodeUdiseCode1;
@Column(name="choice_kv4_station_code_udise_code2")
private String choiceKv4StationCodeUdiseCode2;
@Column(name="choice_kv4_station_code_udise_code3")
private String choiceKv4StationCodeUdiseCode3;
@Column(name="choice_kv5_station_code_udise_code1")
private String choiceKv5StationCodeUdiseCode1;
@Column(name="choice_kv5_station_code_udise_code2")
private String choiceKv5StationCodeUdiseCode2;
@Column(name="choice_kv5_station_code_udise_code3")
private String choiceKv5StationCodeUdiseCode3;
@Column(name="choice_kv1_station_code_udise_name1")
private String choiceKv1StationCodeUdiseName1;
@Column(name="choice_kv1_station_code_udise_name2")
private String choiceKv1StationCodeUdiseName2;
@Column(name="choice_kv1_station_code_udise_name3")
private String choiceKv1StationCodeUdiseName3;
@Column(name="choice_kv2_station_code_udise_name1")
private String choiceKv2StationCodeUdiseName1;
@Column(name="choice_kv2_station_code_udise_name2")
private String choiceKv2StationCodeUdiseName2;
@Column(name="choice_kv2_station_code_udise_name3")
private String choiceKv2StationCodeUdiseName3;
@Column(name="choice_kv3_station_code_udise_name1")
private String choiceKv3StationCodeUdiseName1;
@Column(name="choice_kv3_station_code_udise_name2")
private String choiceKv3StationCodeUdiseName2;
@Column(name="choice_kv3_station_code_udise_name3")
private String choiceKv3StationCodeUdiseName3;
@Column(name="choice_kv4_station_code_udise_name1")
private String choiceKv4StationCodeUdiseName1;
@Column(name="choice_kv4_station_code_udise_name2")
private String choiceKv4StationCodeUdiseName2;
@Column(name="choice_kv4_station_code_udise_name3")
private String choiceKv4StationCodeUdiseName3;
@Column(name="choice_kv5_station_code_udise_name1")
private String choiceKv5StationCodeUdiseName1;
@Column(name="choice_kv5_station_code_udise_name2")
private String choiceKv5StationCodeUdiseName2;
@Column(name="choice_kv5_station_code_udise_name3")
private String choiceKv5StationCodeUdiseName3;

@Column(name="spouse_name")
private String spouseName;

@Column(name="spouse_station_name")
private String spouseStationName;
@Column(name="spouse_station_code")
private String spouseStationCode;
@Column(name="spouse_kvs_ynd")
private String spouseKvsYnd;

@Column(name="personal_status_mdgd")
private String personalStatusMdgd;

@Column(name="transfer_status")
private String transferStatus;

@Column(name="apply_transfer_yn")
private String applyTransferYn;

@Column(name="station_within100km1")
private String stationWithin100km1;
@Column(name="station_within100km2")
private String stationWithin100km2;
@Column(name="station_within100km3")
private String stationWithin100km3;
@Column(name="station_within100km4")
private String stationWithin100km4;
@Column(name="station_within100km5")
private String stationWithin100km5;

@Column(name="created_by") 
private String createdBy ;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="created_time") 
private Date createdTime ;

@Column(name="modified_by") 
private String modifiedBy ;

@Column(name="modified_time") 
private Date modifiedTime;

private String spouseStatusTransfer;

@Column(name="dopt_station_one_code") 
private String doptStationOneCode;
@Column(name="dopt_station_one_name")
private String doptStationOneName;
@Column(name="dopt_station_two_code")
private String doptStationTwoCode;
@Column(name="dopt_station_two_name")
private String doptStationTwoName;
@Column(name="spouse_status_displacement")
private String spouseStatusDisplacement;
@Column(name="teaching_non_teaching_staff")
private String teachingNonTeachingStaff;


public void setId(Integer id) {
	this.id = id;
}
public String getTransferKvteacherDetailId() {
	return transferKvteacherDetailId;
}
public void setTransferKvteacherDetailId(String transferKvteacherDetailId) {
	this.transferKvteacherDetailId = transferKvteacherDetailId;
}

public String getConfiguredDateCompare() {
	return configuredDateCompare;
}
public void setConfiguredDateCompare(String configuredDateCompare) {
	this.configuredDateCompare = configuredDateCompare;
}

public Integer getTeacherId() {
	return teacherId;
}
public void setTeacherId(Integer teacherId) {
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
public String getTransferApplicationNumber() {
	return transferApplicationNumber;
}
public void setTransferApplicationNumber(String transferApplicationNumber) {
	this.transferApplicationNumber = transferApplicationNumber;
}
public String getRecruitedSpclDriveNer() {
	return recruitedSpclDriveNer;
}
public void setRecruitedSpclDriveNer(String recruitedSpclDriveNer) {
	this.recruitedSpclDriveNer = recruitedSpclDriveNer;
}
public String getShiftChangeSameSchool() {
	return shiftChangeSameSchool;
}
public void setShiftChangeSameSchool(String shiftChangeSameSchool) {
	this.shiftChangeSameSchool = shiftChangeSameSchool;
}
public String getChoiceKv1UdiseCodePresentStation() {
	return choiceKv1UdiseCodePresentStation;
}
public void setChoiceKv1UdiseCodePresentStation(String choiceKv1UdiseCodePresentStation) {
	this.choiceKv1UdiseCodePresentStation = choiceKv1UdiseCodePresentStation;
}
public String getChoiceKv2UdiseCodePresentStation() {
	return choiceKv2UdiseCodePresentStation;
}
public void setChoiceKv2UdiseCodePresentStation(String choiceKv2UdiseCodePresentStation) {
	this.choiceKv2UdiseCodePresentStation = choiceKv2UdiseCodePresentStation;
}
public String getChoiceKv3UdiseCodePresentStation() {
	return choiceKv3UdiseCodePresentStation;
}
public void setChoiceKv3UdiseCodePresentStation(String choiceKv3UdiseCodePresentStation) {
	this.choiceKv3UdiseCodePresentStation = choiceKv3UdiseCodePresentStation;
}
public String getChoiceKv4UdiseCodePresentStation() {
	return choiceKv4UdiseCodePresentStation;
}
public void setChoiceKv4UdiseCodePresentStation(String choiceKv4UdiseCodePresentStation) {
	this.choiceKv4UdiseCodePresentStation = choiceKv4UdiseCodePresentStation;
}
public String getChoiceKv5UdiseCodePresentStation() {
	return choiceKv5UdiseCodePresentStation;
}
public void setChoiceKv5UdiseCodePresentStation(String choiceKv5UdiseCodePresentStation) {
	this.choiceKv5UdiseCodePresentStation = choiceKv5UdiseCodePresentStation;
}
public String getChoiceKv1StationCode() {
	return choiceKv1StationCode;
}
public void setChoiceKv1StationCode(String choiceKv1StationCode) {
	this.choiceKv1StationCode = choiceKv1StationCode;
}
public String getChoiceKv2StationCode() {
	return choiceKv2StationCode;
}
public void setChoiceKv2StationCode(String choiceKv2StationCode) {
	this.choiceKv2StationCode = choiceKv2StationCode;
}
public String getChoiceKv3StationCode() {
	return choiceKv3StationCode;
}
public void setChoiceKv3StationCode(String choiceKv3StationCode) {
	this.choiceKv3StationCode = choiceKv3StationCode;
}
public String getChoiceKv4StationCode() {
	return choiceKv4StationCode;
}
public void setChoiceKv4StationCode(String choiceKv4StationCode) {
	this.choiceKv4StationCode = choiceKv4StationCode;
}
public String getChoiceKv5StationCode() {
	return choiceKv5StationCode;
}
public void setChoiceKv5StationCode(String choiceKv5StationCode) {
	this.choiceKv5StationCode = choiceKv5StationCode;
}
public String getDisplacement1StationCode() {
	return displacement1StationCode;
}
public void setDisplacement1StationCode(String displacement1StationCode) {
	this.displacement1StationCode = displacement1StationCode;
}
public String getDisplacement2StationCode() {
	return displacement2StationCode;
}
public void setDisplacement2StationCode(String displacement2StationCode) {
	this.displacement2StationCode = displacement2StationCode;
}
public String getDisplacement3StationCode() {
	return displacement3StationCode;
}
public void setDisplacement3StationCode(String displacement3StationCode) {
	this.displacement3StationCode = displacement3StationCode;
}
public String getDisplacement4StationCode() {
	return displacement4StationCode;
}
public void setDisplacement4StationCode(String displacement4StationCode) {
	this.displacement4StationCode = displacement4StationCode;
}
public String getDisplacement5StationCode() {
	return displacement5StationCode;
}
public void setDisplacement5StationCode(String displacement5StationCode) {
	this.displacement5StationCode = displacement5StationCode;
}
public String getChoiceKv1UdiseNamePresentStation() {
	return choiceKv1UdiseNamePresentStation;
}
public void setChoiceKv1UdiseNamePresentStation(String choiceKv1UdiseNamePresentStation) {
	this.choiceKv1UdiseNamePresentStation = choiceKv1UdiseNamePresentStation;
}
public String getChoiceKv2UdiseNamePresentStation() {
	return choiceKv2UdiseNamePresentStation;
}
public void setChoiceKv2UdiseNamePresentStation(String choiceKv2UdiseNamePresentStation) {
	this.choiceKv2UdiseNamePresentStation = choiceKv2UdiseNamePresentStation;
}
public String getChoiceKv3UdiseNamePresentStation() {
	return choiceKv3UdiseNamePresentStation;
}
public void setChoiceKv3UdiseNamePresentStation(String choiceKv3UdiseNamePresentStation) {
	this.choiceKv3UdiseNamePresentStation = choiceKv3UdiseNamePresentStation;
}
public String getChoiceKv4UdiseNamePresentStation() {
	return choiceKv4UdiseNamePresentStation;
}
public void setChoiceKv4UdiseNamePresentStation(String choiceKv4UdiseNamePresentStation) {
	this.choiceKv4UdiseNamePresentStation = choiceKv4UdiseNamePresentStation;
}
public String getChoiceKv5UdiseNamePresentStation() {
	return choiceKv5UdiseNamePresentStation;
}
public void setChoiceKv5UdiseNamePresentStation(String choiceKv5UdiseNamePresentStation) {
	this.choiceKv5UdiseNamePresentStation = choiceKv5UdiseNamePresentStation;
}
public String getChoiceKv1StationName() {
	return choiceKv1StationName;
}
public void setChoiceKv1StationName(String choiceKv1StationName) {
	this.choiceKv1StationName = choiceKv1StationName;
}
public String getChoiceKv2StationName() {
	return choiceKv2StationName;
}
public void setChoiceKv2StationName(String choiceKv2StationName) {
	this.choiceKv2StationName = choiceKv2StationName;
}
public String getChoiceKv3StationName() {
	return choiceKv3StationName;
}
public void setChoiceKv3StationName(String choiceKv3StationName) {
	this.choiceKv3StationName = choiceKv3StationName;
}
public String getChoiceKv4StationName() {
	return choiceKv4StationName;
}
public void setChoiceKv4StationName(String choiceKv4StationName) {
	this.choiceKv4StationName = choiceKv4StationName;
}
public String getChoiceKv5StationName() {
	return choiceKv5StationName;
}
public void setChoiceKv5StationName(String choiceKv5StationName) {
	this.choiceKv5StationName = choiceKv5StationName;
}
public String getDisplacement1StationName() {
	return displacement1StationName;
}
public void setDisplacement1StationName(String displacement1StationName) {
	this.displacement1StationName = displacement1StationName;
}
public String getDisplacement2StationName() {
	return displacement2StationName;
}
public void setDisplacement2StationName(String displacement2StationName) {
	this.displacement2StationName = displacement2StationName;
}
public String getDisplacement3StationName() {
	return displacement3StationName;
}
public void setDisplacement3StationName(String displacement3StationName) {
	this.displacement3StationName = displacement3StationName;
}
public String getDisplacement4StationName() {
	return displacement4StationName;
}
public void setDisplacement4StationName(String displacement4StationName) {
	this.displacement4StationName = displacement4StationName;
}
public String getDisplacement5StationName() {
	return displacement5StationName;
}
public void setDisplacement5StationName(String displacement5StationName) {
	this.displacement5StationName = displacement5StationName;
}
public String getNumberOfWorkingDays() {
	return numberOfWorkingDays;
}
public void setNumberOfWorkingDays(String numberOfWorkingDays) {
	this.numberOfWorkingDays = numberOfWorkingDays;
}
public String getAbsenceDaysOne() {
	return absenceDaysOne;
}
public void setAbsenceDaysOne(String absenceDaysOne) {
	this.absenceDaysOne = absenceDaysOne;
}
public String getAbsenceDaysTwo() {
	return absenceDaysTwo;
}
public void setAbsenceDaysTwo(String absenceDaysTwo) {
	this.absenceDaysTwo = absenceDaysTwo;
}
public String getActualNumberOfWorkingDays() {
	return actualNumberOfWorkingDays;
}
public void setActualNumberOfWorkingDays(String actualNumberOfWorkingDays) {
	this.actualNumberOfWorkingDays = actualNumberOfWorkingDays;
}
public String getPersonalStatusLtr() {
	return personalStatusLtr;
}
public void setPersonalStatusLtr(String personalStatusLtr) {
	this.personalStatusLtr = personalStatusLtr;
}
public String getPersonalStatusDfp() {
	return personalStatusDfp;
}
public void setPersonalStatusDfp(String personalStatusDfp) {
	this.personalStatusDfp = personalStatusDfp;
}
public String getPersonalStatusMdg() {
	return personalStatusMdg;
}
public void setPersonalStatusMdg(String personalStatusMdg) {
	this.personalStatusMdg = personalStatusMdg;
}
public String getPersonalStatusWid() {
	return personalStatusWid;
}
public void setPersonalStatusWid(String personalStatusWid) {
	this.personalStatusWid = personalStatusWid;
}
public String getSpouseKvsYn() {
	return spouseKvsYn;
}
public void setSpouseKvsYn(String spouseKvsYn) {
	this.spouseKvsYn = spouseKvsYn;
}
public String getSpouseCentralGvotYn() {
	return spouseCentralGvotYn;
}
public void setSpouseCentralGvotYn(String spouseCentralGvotYn) {
	this.spouseCentralGvotYn = spouseCentralGvotYn;
}
public String getSpouseStateGvotYn() {
	return spouseStateGvotYn;
}
public void setSpouseStateGvotYn(String spouseStateGvotYn) {
	this.spouseStateGvotYn = spouseStateGvotYn;
}
public String getUnmarriedWomanYn() {
	return unmarriedWomanYn;
}
public void setUnmarriedWomanYn(String unmarriedWomanYn) {
	this.unmarriedWomanYn = unmarriedWomanYn;
}
public String getSpouseEmpCode() {
	return spouseEmpCode;
}
public void setSpouseEmpCode(String spouseEmpCode) {
	this.spouseEmpCode = spouseEmpCode;
}
public String getSpousePost() {
	return spousePost;
}
public void setSpousePost(String spousePost) {
	this.spousePost = spousePost;
}
public String getSpouseStation() {
	return spouseStation;
}
public void setSpouseStation(String spouseStation) {
	this.spouseStation = spouseStation;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public String getPatientAilment() {
	return patientAilment;
}
public void setPatientAilment(String patientAilment) {
	this.patientAilment = patientAilment;
}
public String getPatientHospital() {
	return patientHospital;
}
public void setPatientHospital(String patientHospital) {
	this.patientHospital = patientHospital;
}
public String getPatientMedicalOfficerName() {
	return patientMedicalOfficerName;
}
public void setPatientMedicalOfficerName(String patientMedicalOfficerName) {
	this.patientMedicalOfficerName = patientMedicalOfficerName;
}
public String getPatientMedicalOfficerDesignation() {
	return patientMedicalOfficerDesignation;
}
public void setPatientMedicalOfficerDesignation(String patientMedicalOfficerDesignation) {
	this.patientMedicalOfficerDesignation = patientMedicalOfficerDesignation;
}
public String getChild1012Name() {
	return child1012Name;
}
public void setChild1012Name(String child1012Name) {
	this.child1012Name = child1012Name;
}
public String getChild1012Class() {
	return child1012Class;
}
public void setChild1012Class(String child1012Class) {
	this.child1012Class = child1012Class;
}
public String getChild1012School() {
	return child1012School;
}
public void setChild1012School(String child1012School) {
	this.child1012School = child1012School;
}
public String getChild1012Board() {
	return child1012Board;
}
public void setChild1012Board(String child1012Board) {
	this.child1012Board = child1012Board;
}
public String getCareGiverName() {
	return careGiverName;
}
public void setCareGiverName(String careGiverName) {
	this.careGiverName = careGiverName;
}
public String getCareGiverRelation() {
	return careGiverRelation;
}
public void setCareGiverRelation(String careGiverRelation) {
	this.careGiverRelation = careGiverRelation;
}
public String getCareGiverDisabilityName() {
	return careGiverDisabilityName;
}
public void setCareGiverDisabilityName(String careGiverDisabilityName) {
	this.careGiverDisabilityName = careGiverDisabilityName;
}
public String getCareGiverDisabilityPrcnt() {
	return careGiverDisabilityPrcnt;
}
public void setCareGiverDisabilityPrcnt(String careGiverDisabilityPrcnt) {
	this.careGiverDisabilityPrcnt = careGiverDisabilityPrcnt;
}
public String getChildDifferentName() {
	return childDifferentName;
}
public void setChildDifferentName(String childDifferentName) {
	this.childDifferentName = childDifferentName;
}
public String getChildDifferentDisabilityName() {
	return childDifferentDisabilityName;
}
public void setChildDifferentDisabilityName(String childDifferentDisabilityName) {
	this.childDifferentDisabilityName = childDifferentDisabilityName;
}
public String getChildDifferentDisabilityPrcnt() {
	return childDifferentDisabilityPrcnt;
}
public void setChildDifferentDisabilityPrcnt(String childDifferentDisabilityPrcnt) {
	this.childDifferentDisabilityPrcnt = childDifferentDisabilityPrcnt;
}
public String getSpouseNa() {
	return spouseNa;
}
public void setSpouseNa(String spouseNa) {
	this.spouseNa = spouseNa;
}
public String getTotalDisplacementCount() {
	return totalDisplacementCount;
}
public void setTotalDisplacementCount(String totalDisplacementCount) {
	this.totalDisplacementCount = totalDisplacementCount;
}
public String getTotalTransferCount() {
	return totalTransferCount;
}
public void setTotalTransferCount(String totalTransferCount) {
	this.totalTransferCount = totalTransferCount;
}
public String getChoiceKv1StationCodeUdiseCode1() {
	return choiceKv1StationCodeUdiseCode1;
}
public void setChoiceKv1StationCodeUdiseCode1(String choiceKv1StationCodeUdiseCode1) {
	this.choiceKv1StationCodeUdiseCode1 = choiceKv1StationCodeUdiseCode1;
}
public String getChoiceKv1StationCodeUdiseCode2() {
	return choiceKv1StationCodeUdiseCode2;
}
public void setChoiceKv1StationCodeUdiseCode2(String choiceKv1StationCodeUdiseCode2) {
	this.choiceKv1StationCodeUdiseCode2 = choiceKv1StationCodeUdiseCode2;
}
public String getChoiceKv1StationCodeUdiseCode3() {
	return choiceKv1StationCodeUdiseCode3;
}
public void setChoiceKv1StationCodeUdiseCode3(String choiceKv1StationCodeUdiseCode3) {
	this.choiceKv1StationCodeUdiseCode3 = choiceKv1StationCodeUdiseCode3;
}
public String getChoiceKv2StationCodeUdiseCode1() {
	return choiceKv2StationCodeUdiseCode1;
}
public void setChoiceKv2StationCodeUdiseCode1(String choiceKv2StationCodeUdiseCode1) {
	this.choiceKv2StationCodeUdiseCode1 = choiceKv2StationCodeUdiseCode1;
}
public String getChoiceKv2StationCodeUdiseCode2() {
	return choiceKv2StationCodeUdiseCode2;
}
public void setChoiceKv2StationCodeUdiseCode2(String choiceKv2StationCodeUdiseCode2) {
	this.choiceKv2StationCodeUdiseCode2 = choiceKv2StationCodeUdiseCode2;
}
public String getChoiceKv2StationCodeUdiseCode3() {
	return choiceKv2StationCodeUdiseCode3;
}
public void setChoiceKv2StationCodeUdiseCode3(String choiceKv2StationCodeUdiseCode3) {
	this.choiceKv2StationCodeUdiseCode3 = choiceKv2StationCodeUdiseCode3;
}
public String getChoiceKv3StationCodeUdiseCode1() {
	return choiceKv3StationCodeUdiseCode1;
}
public void setChoiceKv3StationCodeUdiseCode1(String choiceKv3StationCodeUdiseCode1) {
	this.choiceKv3StationCodeUdiseCode1 = choiceKv3StationCodeUdiseCode1;
}
public String getChoiceKv3StationCodeUdiseCode2() {
	return choiceKv3StationCodeUdiseCode2;
}
public void setChoiceKv3StationCodeUdiseCode2(String choiceKv3StationCodeUdiseCode2) {
	this.choiceKv3StationCodeUdiseCode2 = choiceKv3StationCodeUdiseCode2;
}
public String getChoiceKv3StationCodeUdiseCode3() {
	return choiceKv3StationCodeUdiseCode3;
}
public void setChoiceKv3StationCodeUdiseCode3(String choiceKv3StationCodeUdiseCode3) {
	this.choiceKv3StationCodeUdiseCode3 = choiceKv3StationCodeUdiseCode3;
}
public String getChoiceKv4StationCodeUdiseCode1() {
	return choiceKv4StationCodeUdiseCode1;
}
public void setChoiceKv4StationCodeUdiseCode1(String choiceKv4StationCodeUdiseCode1) {
	this.choiceKv4StationCodeUdiseCode1 = choiceKv4StationCodeUdiseCode1;
}
public String getChoiceKv4StationCodeUdiseCode2() {
	return choiceKv4StationCodeUdiseCode2;
}
public void setChoiceKv4StationCodeUdiseCode2(String choiceKv4StationCodeUdiseCode2) {
	this.choiceKv4StationCodeUdiseCode2 = choiceKv4StationCodeUdiseCode2;
}
public String getChoiceKv4StationCodeUdiseCode3() {
	return choiceKv4StationCodeUdiseCode3;
}
public void setChoiceKv4StationCodeUdiseCode3(String choiceKv4StationCodeUdiseCode3) {
	this.choiceKv4StationCodeUdiseCode3 = choiceKv4StationCodeUdiseCode3;
}
public String getChoiceKv5StationCodeUdiseCode1() {
	return choiceKv5StationCodeUdiseCode1;
}
public void setChoiceKv5StationCodeUdiseCode1(String choiceKv5StationCodeUdiseCode1) {
	this.choiceKv5StationCodeUdiseCode1 = choiceKv5StationCodeUdiseCode1;
}
public String getChoiceKv5StationCodeUdiseCode2() {
	return choiceKv5StationCodeUdiseCode2;
}
public void setChoiceKv5StationCodeUdiseCode2(String choiceKv5StationCodeUdiseCode2) {
	this.choiceKv5StationCodeUdiseCode2 = choiceKv5StationCodeUdiseCode2;
}
public String getChoiceKv5StationCodeUdiseCode3() {
	return choiceKv5StationCodeUdiseCode3;
}
public void setChoiceKv5StationCodeUdiseCode3(String choiceKv5StationCodeUdiseCode3) {
	this.choiceKv5StationCodeUdiseCode3 = choiceKv5StationCodeUdiseCode3;
}
public String getChoiceKv1StationCodeUdiseName1() {
	return choiceKv1StationCodeUdiseName1;
}
public void setChoiceKv1StationCodeUdiseName1(String choiceKv1StationCodeUdiseName1) {
	this.choiceKv1StationCodeUdiseName1 = choiceKv1StationCodeUdiseName1;
}
public String getChoiceKv1StationCodeUdiseName2() {
	return choiceKv1StationCodeUdiseName2;
}
public void setChoiceKv1StationCodeUdiseName2(String choiceKv1StationCodeUdiseName2) {
	this.choiceKv1StationCodeUdiseName2 = choiceKv1StationCodeUdiseName2;
}
public String getChoiceKv1StationCodeUdiseName3() {
	return choiceKv1StationCodeUdiseName3;
}
public void setChoiceKv1StationCodeUdiseName3(String choiceKv1StationCodeUdiseName3) {
	this.choiceKv1StationCodeUdiseName3 = choiceKv1StationCodeUdiseName3;
}
public String getChoiceKv2StationCodeUdiseName1() {
	return choiceKv2StationCodeUdiseName1;
}
public void setChoiceKv2StationCodeUdiseName1(String choiceKv2StationCodeUdiseName1) {
	this.choiceKv2StationCodeUdiseName1 = choiceKv2StationCodeUdiseName1;
}
public String getChoiceKv2StationCodeUdiseName2() {
	return choiceKv2StationCodeUdiseName2;
}
public void setChoiceKv2StationCodeUdiseName2(String choiceKv2StationCodeUdiseName2) {
	this.choiceKv2StationCodeUdiseName2 = choiceKv2StationCodeUdiseName2;
}
public String getChoiceKv2StationCodeUdiseName3() {
	return choiceKv2StationCodeUdiseName3;
}
public void setChoiceKv2StationCodeUdiseName3(String choiceKv2StationCodeUdiseName3) {
	this.choiceKv2StationCodeUdiseName3 = choiceKv2StationCodeUdiseName3;
}
public String getChoiceKv3StationCodeUdiseName1() {
	return choiceKv3StationCodeUdiseName1;
}
public void setChoiceKv3StationCodeUdiseName1(String choiceKv3StationCodeUdiseName1) {
	this.choiceKv3StationCodeUdiseName1 = choiceKv3StationCodeUdiseName1;
}
public String getChoiceKv3StationCodeUdiseName2() {
	return choiceKv3StationCodeUdiseName2;
}
public void setChoiceKv3StationCodeUdiseName2(String choiceKv3StationCodeUdiseName2) {
	this.choiceKv3StationCodeUdiseName2 = choiceKv3StationCodeUdiseName2;
}
public String getChoiceKv3StationCodeUdiseName3() {
	return choiceKv3StationCodeUdiseName3;
}
public void setChoiceKv3StationCodeUdiseName3(String choiceKv3StationCodeUdiseName3) {
	this.choiceKv3StationCodeUdiseName3 = choiceKv3StationCodeUdiseName3;
}
public String getChoiceKv4StationCodeUdiseName1() {
	return choiceKv4StationCodeUdiseName1;
}
public void setChoiceKv4StationCodeUdiseName1(String choiceKv4StationCodeUdiseName1) {
	this.choiceKv4StationCodeUdiseName1 = choiceKv4StationCodeUdiseName1;
}
public String getChoiceKv4StationCodeUdiseName2() {
	return choiceKv4StationCodeUdiseName2;
}
public void setChoiceKv4StationCodeUdiseName2(String choiceKv4StationCodeUdiseName2) {
	this.choiceKv4StationCodeUdiseName2 = choiceKv4StationCodeUdiseName2;
}
public String getChoiceKv4StationCodeUdiseName3() {
	return choiceKv4StationCodeUdiseName3;
}
public void setChoiceKv4StationCodeUdiseName3(String choiceKv4StationCodeUdiseName3) {
	this.choiceKv4StationCodeUdiseName3 = choiceKv4StationCodeUdiseName3;
}
public String getChoiceKv5StationCodeUdiseName1() {
	return choiceKv5StationCodeUdiseName1;
}
public void setChoiceKv5StationCodeUdiseName1(String choiceKv5StationCodeUdiseName1) {
	this.choiceKv5StationCodeUdiseName1 = choiceKv5StationCodeUdiseName1;
}
public String getChoiceKv5StationCodeUdiseName2() {
	return choiceKv5StationCodeUdiseName2;
}
public void setChoiceKv5StationCodeUdiseName2(String choiceKv5StationCodeUdiseName2) {
	this.choiceKv5StationCodeUdiseName2 = choiceKv5StationCodeUdiseName2;
}
public String getChoiceKv5StationCodeUdiseName3() {
	return choiceKv5StationCodeUdiseName3;
}
public void setChoiceKv5StationCodeUdiseName3(String choiceKv5StationCodeUdiseName3) {
	this.choiceKv5StationCodeUdiseName3 = choiceKv5StationCodeUdiseName3;
}
public String getAbsenceDaysTcone() {
	return absenceDaysTcone;
}
public void setAbsenceDaysTcone(String absenceDaysTcone) {
	this.absenceDaysTcone = absenceDaysTcone;
}
public String getActualNumberOfWorkingTcdays() {
	return actualNumberOfWorkingTcdays;
}
public void setActualNumberOfWorkingTcdays(String actualNumberOfWorkingTcdays) {
	this.actualNumberOfWorkingTcdays = actualNumberOfWorkingTcdays;
}
public String getSpouseName() {
	return spouseName;
}
public void setSpouseName(String spouseName) {
	this.spouseName = spouseName;
}
public String getSpouseStationName() {
	return spouseStationName;
}
public void setSpouseStationName(String spouseStationName) {
	this.spouseStationName = spouseStationName;
}
public String getSpouseStationCode() {
	return spouseStationCode;
}
public void setSpouseStationCode(String spouseStationCode) {
	this.spouseStationCode = spouseStationCode;
}
public String getSpouseKvsYnd() {
	return spouseKvsYnd;
}
public void setSpouseKvsYnd(String spouseKvsYnd) {
	this.spouseKvsYnd = spouseKvsYnd;
}
public String getPersonalStatusMdgd() {
	return personalStatusMdgd;
}
public void setPersonalStatusMdgd(String personalStatusMdgd) {
	this.personalStatusMdgd = personalStatusMdgd;
}
public String getTransferStatus() {
	return transferStatus;
}
public void setTransferStatus(String transferStatus) {
	this.transferStatus = transferStatus;
}
public String getApplyTransferYn() {
	return applyTransferYn;
}
public void setApplyTransferYn(String applyTransferYn) {
	this.applyTransferYn = applyTransferYn;
}
public String getStationWithin100km1() {
	return stationWithin100km1;
}
public void setStationWithin100km1(String stationWithin100km1) {
	this.stationWithin100km1 = stationWithin100km1;
}
public String getStationWithin100km2() {
	return stationWithin100km2;
}
public void setStationWithin100km2(String stationWithin100km2) {
	this.stationWithin100km2 = stationWithin100km2;
}
public String getStationWithin100km3() {
	return stationWithin100km3;
}
public void setStationWithin100km3(String stationWithin100km3) {
	this.stationWithin100km3 = stationWithin100km3;
}
public String getStationWithin100km4() {
	return stationWithin100km4;
}
public void setStationWithin100km4(String stationWithin100km4) {
	this.stationWithin100km4 = stationWithin100km4;
}
public String getStationWithin100km5() {
	return stationWithin100km5;
}
public void setStationWithin100km5(String stationWithin100km5) {
	this.stationWithin100km5 = stationWithin100km5;
}

public String getIsLastTransferGroundTeacherDisabilityYn() {
	return isLastTransferGroundTeacherDisabilityYn;
}
public void setIsLastTransferGroundTeacherDisabilityYn(String isLastTransferGroundTeacherDisabilityYn) {
	this.isLastTransferGroundTeacherDisabilityYn = isLastTransferGroundTeacherDisabilityYn;
}
public String getTransferKvConfigId() {
	return transferKvConfigId;
}
public void setTransferKvConfigId(String transferKvConfigId) {
	this.transferKvConfigId = transferKvConfigId;
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
public String getExemptionRemarks() {
	return exemptionRemarks;
}
public void setExemptionRemarks(String exemptionRemarks) {
	this.exemptionRemarks = exemptionRemarks;
}
public String getExemptionType() {
	return exemptionType;
}
public void setExemptionType(String exemptionType) {
	this.exemptionType = exemptionType;
}



public String getSpouseStatusTransfer() {
	return spouseStatusTransfer;
}
public void setSpouseStatusTransfer(String spouseStatusTransfer) {
	this.spouseStatusTransfer = spouseStatusTransfer;
}
@PrePersist
protected void onCreate() {
    if (createdTime == null) { createdTime = new Date(); }
}
public String getStationWithin100kmDispYn() {
	return stationWithin100kmDispYn;
}
public void setStationWithin100kmDispYn(String stationWithin100kmDispYn) {
	this.stationWithin100kmDispYn = stationWithin100kmDispYn;
}
public String getPersonalStatusLtrDc() {
	return personalStatusLtrDc;
}
public void setPersonalStatusLtrDc(String personalStatusLtrDc) {
	this.personalStatusLtrDc = personalStatusLtrDc;
}
public String getPersonalStatusDfpDc() {
	return personalStatusDfpDc;
}
public void setPersonalStatusDfpDc(String personalStatusDfpDc) {
	this.personalStatusDfpDc = personalStatusDfpDc;
}
public String getPersonalStatusMdgDc() {
	return personalStatusMdgDc;
}
public void setPersonalStatusMdgDc(String personalStatusMdgDc) {
	this.personalStatusMdgDc = personalStatusMdgDc;
}
public String getPersonalStatusWidDc() {
	return personalStatusWidDc;
}
public void setPersonalStatusWidDc(String personalStatusWidDc) {
	this.personalStatusWidDc = personalStatusWidDc;
}
public String getPersonalStatusSpDc() {
	return personalStatusSpDc;
}
public void setPersonalStatusSpDc(String personalStatusSpDc) {
	this.personalStatusSpDc = personalStatusSpDc;
}
public String getDoptStationOneCode() {
	return doptStationOneCode;
}
public void setDoptStationOneCode(String doptStationOneCode) {
	this.doptStationOneCode = doptStationOneCode;
}
public String getDoptStationOneName() {
	return doptStationOneName;
}
public void setDoptStationOneName(String doptStationOneName) {
	this.doptStationOneName = doptStationOneName;
}
public String getDoptStationTwoCode() {
	return doptStationTwoCode;
}
public void setDoptStationTwoCode(String doptStationTwoCode) {
	this.doptStationTwoCode = doptStationTwoCode;
}
public String getDoptStationTwoName() {
	return doptStationTwoName;
}
public void setDoptStationTwoName(String doptStationTwoName) {
	this.doptStationTwoName = doptStationTwoName;
}
public String getSpouseStatusDisplacement() {
	return spouseStatusDisplacement;
}
public void setSpouseStatusDisplacement(String spouseStatusDisplacement) {
	this.spouseStatusDisplacement = spouseStatusDisplacement;
}
public String getTeachingNonTeachingStaff() {
	return teachingNonTeachingStaff;
}
public void setTeachingNonTeachingStaff(String teachingNonTeachingStaff) {
	this.teachingNonTeachingStaff = teachingNonTeachingStaff;
}




}
