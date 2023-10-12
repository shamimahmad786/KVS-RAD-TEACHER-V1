package com.example.MOERADTEACHER.common.modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "teacher_profile", schema="public")

public class TeacherProfile implements Serializable{

//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_id_seq")
	
//	@SequenceGenerator(name = "teacherIdSeq", sequenceName = "teacher_id_seq")
//	@GeneratedValue(generator = "teacherIdSeq")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="teacher_id")
	private Integer teacherId;
	
	
	 @Pattern(regexp = "^[a-zA-Z0-9.\\-\\/+=@_ ]*$")
	    @NotEmpty
	@Column(name="teacher_name")
	private String teacherName ;
	@Column(name="teacher_gender")
	private String teacherGender ;
	@Column(name="teacher_dob")
	private String teacherDob ;
	@Column(name="teacher_employee_code")
	private String teacherEmployeeCode ;
	@Column(name="teacher_social_category")
	private String teacherSocialCategory ;
	
	
	
	@Column(name="teacher_mobile")
	private String teacherMobile ;
	@Column(name="teacher_email")
	private String teacherEmail ;
	@Column(name="teacher_religion")
	private String teacherReligion ;
	@Column(name="teacher_nationality")
	private String teacherNationality ;
	
	
	
	@Column(name="teacher_blood_group")
	private String teacherBloodGroup ;
	@Column(name="teacher_permanent_address")
	private String teacherPermanentAddress ;
	@Column(name="teacher_parmanent_state")
	private String teacherParmanentState ;
	
	
	@Column(name="teacher_permanent_district")
	private String teacherPermanentDistrict ;
	@Column(name="teacher_permanent_pin")
	private String teacherPermanentPin ;
	@Column(name="teacher_correspondence_address")
	private String teacherCorrespondenceAddress ;
	
	
	@Column(name="teacher_correspondence_state")
	private String teacherCorrespondenceState ;
	@Column(name="teacher_correspondence_district")
	private String teacherCorrespondenceDistrict ;
	@Column(name="teacher_correspondence_pin")
	private String teacherCorrespondencePin ;
	@Column(name="teacher_personnel_identification")
	private String teacherPersonnelIdentification ;
	
	
	@Column(name="teacher_pan_number")
	private String  teacherPanNumber ;
	@Column(name="teacher_aadhaar_number")
	private String  teacherAadhaarNumber ;
	@Column(name="teacher_passport_number")
	private String teacherPassportNumber ;
	@Column(name="teacher_disability_yn")
	private String teacherDisabilityYn ;
	@Column(name="teacher_disability_type")
	private String teacherDisabilityType ;
	@Column(name="teacher_disability_from_birth_yn")
	private String teacherDisabilityFromBirthYn ;
	@Column(name="teacher_disability_date")
	private String teacherDisabilityDate ;
	@Column(name="teacher_disability_prcnt")
	private String teacherDisabilityPrcnt ;
	@Column(name="teacher_disability_cert_authority")
	private String teacherDisabilityCertAuthority ;
	@Column(name="teacher_disability_cert_number")
	private String teacherDisabilityCertNumber ;
	@Column(name="teacher_temp_id")
	private String teacherTempId ;
	@Column(name="teacher_system_generated_code")
	private String teacherSystemGeneratedCode ;
	@Column(name="current_udise_sch_code")
	private String currentUdiseSchCode ;
	
	@Column(name="kv_code")
	private String kvCode ;
	
	@Column(name="school_id")
	private String schoolId ;
	@Column(name="teacher_account_id")
	private String teacherAccountId ;
	
	@Column(name="created_by") 
	private String createdBy ;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time") 
	private Date createdTime ;
	
	@Column(name="modified_by") 
	private String modifiedBy ;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_time") 
	private Date modifiedTime;
	
	@Column(name="verified_type") 
	private String verifiedType;
	
	@Column(name="version_no")
	private Integer versionNo;
	
	@Column(name="teaching_nonteaching") 
	private String teachingNonteaching;
	
	@Transient
	private String udiseSchoolName;
	
	
	
	@Transient
	private String teacherAge;
	
	
	
//	@OneToOne
//    @JoinColumn(name = "teacher_id")
//	private  TeacherFormStatus teacherFormStatus;
	
//	@Column(name="tid")
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Transient	
//	private Integer tid;
	
	//** Experience Detail \\
	// ** Post in present KV also the Last Promotion Post **\\
	@Column(name="work_experience_position_type_present_kv") 
	private String workExperiencePositionTypePresentKv;
	//** Present School Work Start Date-- Last Work Experience  Start Date
	@Column(name="work_experience_work_start_date_present_kv")
	private String workExperienceWorkStartDatePresentKv;
	//** Foreign Key of the Work Experience Table only Last Record
	@Column(name="work_experience_id_present_kv")
	private Integer workExperienceIdPresentKv;
	// ** KV Specific Present Station	
	@Column(name="work_experience_position_type_present_station_start_date")
	private String workExperiencePositionTypePresentStationStartDate;
	
	//** End of Experience Detail \\
	
	//** Promotion Detail and Map With Promotion Table
	
	//** Foreign Key from Promotion Table
	@Column(name="last_promotion_id")
	private String lastPromotionId;
//	@Column(name="last_promotion_date")
//	private String lastPromotionDate;
	
	@Column(name="last_promotion_position_type")
	private String lastPromotionPositionType;
	
	@Column(name="last_promotion_position_date")
	private String lastPromotionPositionDate;
	
	//** End of  Promotion Detail and Map With Promotion Table
	
	@Column(name="work_experience_appointed_for_subject")
	private String workExperienceAppointedForSubject;
	
	@Column(name="drop_box_flag",columnDefinition = "Integer default 0")
	private Integer dropBoxFlag;
	@Column(name="verify_flag")
	private String verifyFlag;
	@Column(name="transferedUdiseSchCode")
	private String transfered_udise_sch_code;
	@Column(name="dropboxFeedback")
	private String dropbox_feedback;
	
	
	@Column(name="dropbox_date", columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private java.sql.Date dropboxDate;
	
	
	@Column(name="tet_qualified_yn")
	private String tetQualifiedYn;
	@Column(name="tet_qualifing_year")
	private String tetQualifingYear;
	
	@Column(name="nature_of_appointment")
	private String natureOfAppointment;
	
	@Column(name="spouse_name")
	private String spouseName;
	
	@Column(name="spouse_emp_code")
	private String spouseEmpCode;
	
	@Column(name="spouse_post")
	private String spousePost;
	
	@Column(name="spouse_station_code")
	private String spouseStationCode;
	
	
	@Column(name="spouse_station_name")
	private String spouseStationName;
	
	@Column(name="spouse_status")
	private String spouseStatus;
	
	@Column(name="marital_status")
	private String maritalStatus;
	
	@Column(name="school_remarks")
	private String schoolRemarks;
	
	@Column(name="teacher_remarks")
	private String teacherRemarks;
	
	@Column(name="single_parent_status_yn")
	private String singleParentStatusYn;
	
	@Column(name="special_recruitment_yn")
	private String specialRecruitmentYn;
	
	@Column(name="shift_change_same_school")
	private String shiftChangeSameSchool;
	
	
	@Transient
	private String postName;
	
	@Transient
	private String subjectName;
	
	
		
	public String getSpouseName() {
		return spouseName;
	}
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
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
	public String getSpouseStationCode() {
		return spouseStationCode;
	}
	public void setSpouseStationCode(String spouseStationCode) {
		this.spouseStationCode = spouseStationCode;
	}
	public String getSpouseStationName() {
		return spouseStationName;
	}
	public void setSpouseStationName(String spouseStationName) {
		this.spouseStationName = spouseStationName;
	}
	public String getSpouseStatus() {
		return spouseStatus;
	}
	public void setSpouseStatus(String spouseStatus) {
		this.spouseStatus = spouseStatus;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	@Transient
	private String form1Status;
	@Transient
	private String form2Status;
	@Transient
	private String form3Status;
	@Transient
	private String form4Status;
	@Transient
	private String form5Status;
	@Transient
	private String form6Status;
	@Transient
	private String form7Status;
	@Transient
	private String finalStatus;
	@Transient
	private Integer id;
	
	
	
	
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
	public String getTeacherSocialCategory() {
		return teacherSocialCategory;
	}
	public void setTeacherSocialCategory(String teacherSocialCategory) {
		this.teacherSocialCategory = teacherSocialCategory;
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
	public String getTeacherReligion() {
		return teacherReligion;
	}
	public void setTeacherReligion(String teacherReligion) {
		this.teacherReligion = teacherReligion;
	}
	public String getTeacherNationality() {
		return teacherNationality;
	}
	public void setTeacherNationality(String teacherNationality) {
		this.teacherNationality = teacherNationality;
	}
	public String getTeacherBloodGroup() {
		return teacherBloodGroup;
	}
	public void setTeacherBloodGroup(String teacherBloodGroup) {
		this.teacherBloodGroup = teacherBloodGroup;
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
	public String getTeacherPersonnelIdentification() {
		return teacherPersonnelIdentification;
	}
	public void setTeacherPersonnelIdentification(String teacherPersonnelIdentification) {
		this.teacherPersonnelIdentification = teacherPersonnelIdentification;
	}
	public String getTeacherPanNumber() {
		return teacherPanNumber;
	}
	public void setTeacherPanNumber(String teacherPanNumber) {
		this.teacherPanNumber = teacherPanNumber;
	}
	public String getTeacherAadhaarNumber() {
		return teacherAadhaarNumber;
	}
	public void setTeacherAadhaarNumber(String teacherAadhaarNumber) {
		this.teacherAadhaarNumber = teacherAadhaarNumber;
	}
	public String getTeacherPassportNumber() {
		return teacherPassportNumber;
	}
	public void setTeacherPassportNumber(String teacherPassportNumber) {
		this.teacherPassportNumber = teacherPassportNumber;
	}
	public String getTeacherDisabilityYn() {
		return teacherDisabilityYn;
	}
	public void setTeacherDisabilityYn(String teacherDisabilityYn) {
		this.teacherDisabilityYn = teacherDisabilityYn;
	}
	public String getTeacherDisabilityType() {
		return teacherDisabilityType;
	}
	public void setTeacherDisabilityType(String teacherDisabilityType) {
		this.teacherDisabilityType = teacherDisabilityType;
	}
	public String getTeacherDisabilityFromBirthYn() {
		return teacherDisabilityFromBirthYn;
	}
	public void setTeacherDisabilityFromBirthYn(String teacherDisabilityFromBirthYn) {
		this.teacherDisabilityFromBirthYn = teacherDisabilityFromBirthYn;
	}
	public String getTeacherDisabilityDate() {
		return teacherDisabilityDate;
	}
	public void setTeacherDisabilityDate(String teacherDisabilityDate) {
		this.teacherDisabilityDate = teacherDisabilityDate;
	}
	public String getTeacherDisabilityPrcnt() {
		return teacherDisabilityPrcnt;
	}
	public void setTeacherDisabilityPrcnt(String teacherDisabilityPrcnt) {
		this.teacherDisabilityPrcnt = teacherDisabilityPrcnt;
	}
	public String getTeacherDisabilityCertAuthority() {
		return teacherDisabilityCertAuthority;
	}
	public void setTeacherDisabilityCertAuthority(String teacherDisabilityCertAuthority) {
		this.teacherDisabilityCertAuthority = teacherDisabilityCertAuthority;
	}
	public String getTeacherDisabilityCertNumber() {
		return teacherDisabilityCertNumber;
	}
	public void setTeacherDisabilityCertNumber(String teacherDisabilityCertNumber) {
		this.teacherDisabilityCertNumber = teacherDisabilityCertNumber;
	}
	public String getTeacherTempId() {
		return teacherTempId;
	}
	public void setTeacherTempId(String teacherTempId) {
		this.teacherTempId = teacherTempId;
	}
	public String getTeacherSystemGeneratedCode() {
		return teacherSystemGeneratedCode;
	}
	public void setTeacherSystemGeneratedCode(String teacherSystemGeneratedCode) {
		this.teacherSystemGeneratedCode = teacherSystemGeneratedCode;
	}
	public String getCurrentUdiseSchCode() {
		return currentUdiseSchCode;
	}
	public void setCurrentUdiseSchCode(String currentUdiseSchCode) {
		this.currentUdiseSchCode = currentUdiseSchCode;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getTeacherAccountId() {
		return teacherAccountId;
	}
	public void setTeacherAccountId(String teacherAccountId) {
		this.teacherAccountId = teacherAccountId;
	}
	
//	public Integer getTid() {
//		return tid;
//	}
//	
//	public void setTid(Integer tid) {
//		this.tid = tid;
//	}
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
	public Integer getWorkExperienceIdPresentKv() {
		return workExperienceIdPresentKv;
	}
	public void setWorkExperienceIdPresentKv(Integer workExperienceIdPresentKv) {
		this.workExperienceIdPresentKv = workExperienceIdPresentKv;
	}
	public String getWorkExperiencePositionTypePresentStationStartDate() {
		return workExperiencePositionTypePresentStationStartDate;
	}
	public void setWorkExperiencePositionTypePresentStationStartDate(
			String workExperiencePositionTypePresentStationStartDate) {
		this.workExperiencePositionTypePresentStationStartDate = workExperiencePositionTypePresentStationStartDate;
	}
	public String getLastPromotionId() {
		return lastPromotionId;
	}
	public void setLastPromotionId(String lastPromotionId) {
		this.lastPromotionId = lastPromotionId;
	}
//	public String getLastPromotionDate() {
//		return lastPromotionDate;
//	}
//	public void setLastPromotionDate(String lastPromotionDate) {
//		this.lastPromotionDate = lastPromotionDate;
//	}
	public String getWorkExperienceAppointedForSubject() {
		return workExperienceAppointedForSubject;
	}
	public void setWorkExperienceAppointedForSubject(String workExperienceAppointedForSubject) {
		this.workExperienceAppointedForSubject = workExperienceAppointedForSubject;
	}
	public Integer getDropBoxFlag() {
		return dropBoxFlag;
	}
	public void setDropBoxFlag(Integer dropBoxFlag) {
		this.dropBoxFlag = dropBoxFlag;
	}
	public String getVerifyFlag() {
		return verifyFlag;
	}
	public void setVerifyFlag(String verifyFlag) {
		this.verifyFlag = verifyFlag;
	}
	public String getTransfered_udise_sch_code() {
		return transfered_udise_sch_code;
	}
	public void setTransfered_udise_sch_code(String transfered_udise_sch_code) {
		this.transfered_udise_sch_code = transfered_udise_sch_code;
	}
	public String getDropbox_feedback() {
		return dropbox_feedback;
	}
	public void setDropbox_feedback(String dropbox_feedback) {
		this.dropbox_feedback = dropbox_feedback;
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
	public String getUdiseSchoolName() {
		return udiseSchoolName;
	}
	public void setUdiseSchoolName(String udiseSchoolName) {
		this.udiseSchoolName = udiseSchoolName;
	}
	public String getTetQualifiedYn() {
		return tetQualifiedYn;
	}
	public void setTetQualifiedYn(String tetQualifiedYn) {
		this.tetQualifiedYn = tetQualifiedYn;
	}
	public String getTetQualifingYear() {
		return tetQualifingYear;
	}
	public void setTetQualifingYear(String tetQualifingYear) {
		this.tetQualifingYear = tetQualifingYear;
	}
	public String getTeacherAge() {
		return teacherAge;
	}
	public void setTeacherAge(String teacherAge) {
		this.teacherAge = teacherAge;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public String getVerifiedType() {
		return verifiedType;
	}
	public void setVerifiedType(String verifiedType) {
		this.verifiedType = verifiedType;
	}
	public Integer getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}
	public String getTeachingNonteaching() {
		return teachingNonteaching;
	}
	public void setTeachingNonteaching(String teachingNonteaching) {
		this.teachingNonteaching = teachingNonteaching;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getNatureOfAppointment() {
		return natureOfAppointment;
	}
	public void setNatureOfAppointment(String natureOfAppointment) {
		this.natureOfAppointment = natureOfAppointment;
	}
//	public TeacherFormStatus getTeacherFormStatus() {
//		return teacherFormStatus;
//	}
//	public void setTeacherFormStatus(TeacherFormStatus teacherFormStatus) {
//		this.teacherFormStatus = teacherFormStatus;
//	}
////	
//	public TeacherFormStatus getTeacherFormStatus() {
//		return teacherFormStatus;
//	}
//	public void setTeacherFormStatus(TeacherFormStatus teacherFormStatus) {
//		this.teacherFormStatus = teacherFormStatus;
//	}
//	
//	
	public String getForm1Status() {
		return form1Status;
	}
	public void setForm1Status(String form1Status) {
		this.form1Status = form1Status;
	}
	public String getForm2Status() {
		return form2Status;
	}
	public void setForm2Status(String form2Status) {
		this.form2Status = form2Status;
	}
	public String getForm3Status() {
		return form3Status;
	}
	public void setForm3Status(String form3Status) {
		this.form3Status = form3Status;
	}
	public String getForm4Status() {
		return form4Status;
	}
	public void setForm4Status(String form4Status) {
		this.form4Status = form4Status;
	}
	public String getForm5Status() {
		return form5Status;
	}
	public void setForm5Status(String form5Status) {
		this.form5Status = form5Status;
	}
	public String getForm6Status() {
		return form6Status;
	}
	public void setForm6Status(String form6Status) {
		this.form6Status = form6Status;
	}
	public String getForm7Status() {
		return form7Status;
	}
	public void setForm7Status(String form7Status) {
		this.form7Status = form7Status;
	}
	public String getFinalStatus() {
		return finalStatus;
	}
	public void setFinalStatus(String finalStatus) {
		this.finalStatus = finalStatus;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSchoolRemarks() {
		return schoolRemarks;
	}
	public void setSchoolRemarks(String schoolRemarks) {
		this.schoolRemarks = schoolRemarks;
	}
	public String getTeacherRemarks() {
		return teacherRemarks;
	}
	public void setTeacherRemarks(String teacherRemarks) {
		this.teacherRemarks = teacherRemarks;
	}
	public java.sql.Date getDropboxDate() {
		return dropboxDate;
	}
	public void setDropboxDate(java.sql.Date dropboxDate) {
		this.dropboxDate = dropboxDate;
	}
	
	
	@PrePersist
	protected void onCreate() {
	    if (modifiedTime == null) { modifiedTime = new Date(); }
	}
	public String getSingleParentStatusYn() {
		return singleParentStatusYn;
	}
	public void setSingleParentStatusYn(String singleParentStatusYn) {
		this.singleParentStatusYn = singleParentStatusYn;
	}
	public String getSpecialRecruitmentYn() {
		return specialRecruitmentYn;
	}
	public void setSpecialRecruitmentYn(String specialRecruitmentYn) {
		this.specialRecruitmentYn = specialRecruitmentYn;
	}
	public String getShiftChangeSameSchool() {
		return shiftChangeSameSchool;
	}
	public void setShiftChangeSameSchool(String shiftChangeSameSchool) {
		this.shiftChangeSameSchool = shiftChangeSameSchool;
	}
	public String getKvCode() {
		return kvCode;
	}
	public void setKvCode(String kvCode) {
		this.kvCode = kvCode;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	
	
	
}
