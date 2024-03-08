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
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "teacher_profile", schema="public")

public class TeacherProfile implements Serializable{

//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_id_seq")	
//	@SequenceGenerator(name = "teacherIdSeq", sequenceName = "teacher_id_seq")
//	@GeneratedValue(generator = "teacherIdSeq")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="teacherProfileTeacherIdSeq")
	@SequenceGenerator(name="teacherProfileTeacherIdSeq",sequenceName="teacher_profile_teacher_id_seq", allocationSize=1)
	@Column(name="teacher_id")
	private Integer teacherId;
	
	
	 @Pattern(regexp = "^[a-zA-Z0-9.\\-\\/+=@_ ]*$")
	    @NotEmpty
	@Column(name="teacher_name")
	private String teacherName ;
	@Column(name="teacher_gender")
	private String teacherGender ;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
	@Temporal(TemporalType.DATE)
	@Column(name="teacher_dob")
	private Date teacherDob ;
	@Column(name="teacher_employee_code")
	private String teacherEmployeeCode ;
	
	
	@Column(name="teacher_mobile")
	private String teacherMobile ;
	@Column(name="teacher_email")
	private String teacherEmail ;


	
	
	

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


	@Column(name="teacher_disability_yn")
	private String teacherDisabilityYn ;
	@Column(name="teacher_disability_type")
	private String teacherDisabilityType ;




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

	//** Present School Work Start Date-- Last Work Experience  Start Date
	@Temporal(TemporalType.DATE)
	@Column(name="work_experience_work_start_date_present_kv")
	private Date workExperienceWorkStartDatePresentKv;
	//** Foreign Key of the Work Experience Table only Last Record
	@Column(name="work_experience_id_present_kv")
	private Integer workExperienceIdPresentKv;
	// ** KV Specific Present Station	
	@Temporal(TemporalType.DATE)
	@Column(name="work_experience_position_type_present_station_start_date")
	private Date workExperiencePositionTypePresentStationStartDate;  //changes string to date
	
	//** End of Experience Detail \\
	
	//** Promotion Detail and Map With Promotion Table
	
	//** Foreign Key from Promotion Table

//	@Column(name="last_promotion_date")
//	private String lastPromotionDate;
	
	@Column(name="last_promotion_position_type")
	private String lastPromotionPositionType;
	
	@Temporal(TemporalType.DATE)
	@Column(name="last_promotion_position_date")
	private Date lastPromotionPositionDate;
	
	//** End of  Promotion Detail and Map With Promotion Table
	
	@Column(name="work_experience_appointed_for_subject")
	private String workExperienceAppointedForSubject;
	
	@Column(name="drop_box_flag",columnDefinition = "Integer default 0")
	private Integer dropBoxFlag;
	@Column(name="verify_flag")
	private String verifyFlag;


	
	
	@Column(name="dropbox_date", columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private java.sql.Date dropboxDate;
	
	

	
	
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
	


	
	@Column(name="single_parent_status_yn")
	private String singleParentStatusYn;
	
	@Column(name="special_recruitment_yn")
	private String specialRecruitmentYn;
	
	@Column(name="shift_change_same_school")
	private String shiftChangeSameSchool;
	
	@Column(name="ip_address")
	private String ipAddress;
	
	@Transient
	private String postName;
	
	@Transient
	private String subjectName;
	
	@Column(name="social_categories")
	private String socialCategories;
	
	@Column(name="social_sub_categories")
	private String socialSubCategories;
	
	@Column(name="home_town_address",length=1000)
	private String homeTownAddress;
		
//	public String getSpouseName() {
//		return spouseName;
//	}
//	public void setSpouseName(String spouseName) {
//		this.spouseName = spouseName;
//	}
//	public String getSpouseEmpCode() {
//		return spouseEmpCode;
//	}
//	public void setSpouseEmpCode(String spouseEmpCode) {
//		this.spouseEmpCode = spouseEmpCode;
//	}
//	public String getSpousePost() {
//		return spousePost;
//	}
//	public void setSpousePost(String spousePost) {
//		this.spousePost = spousePost;
//	}
//	public String getSpouseStationCode() {
//		return spouseStationCode;
//	}
//	public void setSpouseStationCode(String spouseStationCode) {
//		this.spouseStationCode = spouseStationCode;
//	}
//	public String getSpouseStationName() {
//		return spouseStationName;
//	}
//	public void setSpouseStationName(String spouseStationName) {
//		this.spouseStationName = spouseStationName;
//	}
//	public String getSpouseStatus() {
//		return spouseStatus;
//	}
//	public void setSpouseStatus(String spouseStatus) {
//		this.spouseStatus = spouseStatus;
//	}
//	public String getMaritalStatus() {
//		return maritalStatus;
//	}
//	public void setMaritalStatus(String maritalStatus) {
//		this.maritalStatus = maritalStatus;
//	}
	
	
//	@Transient
//	private String form1Status;
//	@Transient
//	private String form2Status;
//	@Transient
//	private String form3Status;
//	@Transient
//	private String form4Status;
//	@Transient
//	private String form5Status;
//	@Transient
//	private String form6Status;
//	@Transient
//	private String form7Status;
//	@Transient
//	private String finalStatus;
//	@Transient
//	private Integer id;
//	
	
	@Transient
	private String profileFinalStatus;
	
	@Transient
	private String transferFinalStatus;
	
	
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
	public String getTeacherDisabilityType() {
		return teacherDisabilityType;
	}
	public void setTeacherDisabilityType(String teacherDisabilityType) {
		this.teacherDisabilityType = teacherDisabilityType;
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

	public Date getWorkExperienceWorkStartDatePresentKv() {
		return workExperienceWorkStartDatePresentKv;
	}
	public void setWorkExperienceWorkStartDatePresentKv(Date workExperienceWorkStartDatePresentKv) {
		this.workExperienceWorkStartDatePresentKv = workExperienceWorkStartDatePresentKv;
	}
	public Integer getWorkExperienceIdPresentKv() {
		return workExperienceIdPresentKv;
	}
	public void setWorkExperienceIdPresentKv(Integer workExperienceIdPresentKv) {
		this.workExperienceIdPresentKv = workExperienceIdPresentKv;
	}
	public Date getWorkExperiencePositionTypePresentStationStartDate() {
		return workExperiencePositionTypePresentStationStartDate;
	}
	public void setWorkExperiencePositionTypePresentStationStartDate(
			Date workExperiencePositionTypePresentStationStartDate) {
		this.workExperiencePositionTypePresentStationStartDate = workExperiencePositionTypePresentStationStartDate;
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

	public String getLastPromotionPositionType() {
		return lastPromotionPositionType;
	}
	public void setLastPromotionPositionType(String lastPromotionPositionType) {
		this.lastPromotionPositionType = lastPromotionPositionType;
	}
	public Date getLastPromotionPositionDate() {
		return lastPromotionPositionDate;
	}
	public void setLastPromotionPositionDate(Date lastPromotionPositionDate) {
		this.lastPromotionPositionDate = lastPromotionPositionDate;
	}
	public String getUdiseSchoolName() {
		return udiseSchoolName;
	}
	public void setUdiseSchoolName(String udiseSchoolName) {
		this.udiseSchoolName = udiseSchoolName;
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
//	public String getForm1Status() {
//		return form1Status;
//	}
//	public void setForm1Status(String form1Status) {
//		this.form1Status = form1Status;
//	}
//	public String getForm2Status() {
//		return form2Status;
//	}
//	public void setForm2Status(String form2Status) {
//		this.form2Status = form2Status;
//	}
//	public String getForm3Status() {
//		return form3Status;
//	}
//	public void setForm3Status(String form3Status) {
//		this.form3Status = form3Status;
//	}
//	public String getForm4Status() {
//		return form4Status;
//	}
//	public void setForm4Status(String form4Status) {
//		this.form4Status = form4Status;
//	}
//	public String getForm5Status() {
//		return form5Status;
//	}
//	public void setForm5Status(String form5Status) {
//		this.form5Status = form5Status;
//	}
//	public String getForm6Status() {
//		return form6Status;
//	}
//	public void setForm6Status(String form6Status) {
//		this.form6Status = form6Status;
//	}
//	public String getForm7Status() {
//		return form7Status;
//	}
//	public void setForm7Status(String form7Status) {
//		this.form7Status = form7Status;
//	}
//	public String getFinalStatus() {
//		return finalStatus;
//	}
//	public void setFinalStatus(String finalStatus) {
//		this.finalStatus = finalStatus;
//	}
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}

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
	
	@PreUpdate
	protected void onUpdate() {
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
	public Date getTeacherDob() {
		return teacherDob;
	}
	public void setTeacherDob(Date teacherDob) {
		this.teacherDob = teacherDob;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
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
	public String getProfileFinalStatus() {
		return profileFinalStatus;
	}
	public void setProfileFinalStatus(String profileFinalStatus) {
		this.profileFinalStatus = profileFinalStatus;
	}
	public String getTransferFinalStatus() {
		return transferFinalStatus;
	}
	public void setTransferFinalStatus(String transferFinalStatus) {
		this.transferFinalStatus = transferFinalStatus;
	}
	public String getSocialCategories() {
		return socialCategories;
	}
	public void setSocialCategories(String socialCategories) {
		this.socialCategories = socialCategories;
	}
	public String getSocialSubCategories() {
		return socialSubCategories;
	}
	public void setSocialSubCategories(String socialSubCategories) {
		this.socialSubCategories = socialSubCategories;
	}
	
	public String getHomeTownAddress() {
		return homeTownAddress;
	}
	public void setHomeTownAddress(String homeTownAddress) {
		this.homeTownAddress = homeTownAddress;
	}
	
	
	
	
}
