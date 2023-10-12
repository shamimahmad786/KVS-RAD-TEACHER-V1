package com.example.MOERADTEACHER.common.modal;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//import org.hibernate.type.BigIntegerType;

//import lombok.Data;


@Entity
@Table(name = "udise_tch_profile")
public class Teacher implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_id_seq")
	@Column(name="teacher_id")
	private BigInteger  teacherId;
	@Column(name="school_id")
	private Integer schoolId;
	@Column(name="udise_sch_code")
	private String udiseSchCode;
	@Column(name="ac_year")
	private String acYear;
	@Column(name="tch_code_state")
	private String tchCodeState;
	@Column(name="tch_code")
	private String tchCode;
	@Column(name="name")
	private String name;
	@Column(name="gender")
	private Integer gender;
	@Column(name="dob")
	private Date dob;
	@Column(name="social_cat")
	private Integer socialCat;
	@Column(name="tch_type")
	private Integer tchType;
	@Column(name="nature_of_appt")
	private Integer natureOfAppt;
	@Column(name="doj_service")
	private Date dojService;
	@Column(name="qual_acad")
	private Integer qualAcad;
	@Column(name="qual_prof")
	private Integer qualProf;
	@Column(name="class_taught")
	private Integer classTaught;
	@Column(name="appt_sub")
	private Integer apptSub;
	@Column(name="sub_taught1")
	private Integer subTaught1;
	@Column(name="sub_taught2")
	private Integer subTaught2;
	@Column(name="trn_brc")
	private Integer trnBrc;
	@Column(name="trn_crc")
	private Integer trnCrc;
	@Column(name="trn_diet")
	private Integer trnDiet;
	@Column(name="trn_other")
	private Integer trnOther;
	@Column(name="trng_needed")
	private Integer trngNeeded;
	@Column(name="nontch_days")
	private Integer nontchDays;
	@Column(name="math_upto")
	private Integer mathUpto;
	@Column(name="science_upto")
	private Integer scienceUpto;
	@Column(name="english_upto")
	private Integer englishUpto;
	@Column(name="soc_study_upto")
	private Integer soc_studyUpto;
	@Column(name="yoj_pres_sch")
	private String yoj_presSch;
	@Column(name="disability_type")
	private Integer disabilityType;
	@Column(name="trained_cwsn")
	private Integer trainedCwsn;
	@Column(name="trained_comp")
	private Integer trainedComp;
	@Column(name="modified_by")
	private String modifiedBy;
	@Column(name="modified_time")
	private Date modifiedTime;
	@Column(name="trng_rcvd")
	private Integer trngRcvd;
	@Column(name="lang_study_upto")
	private Integer langStudyUpto;
	@Column(name="state_id")
	private Integer stateId;
	@Column(name="tch_type_org")
	private Integer tchTypeOrg;
	@Column(name="tch_social_cat_org")
	private Integer tchSocialCatOrg;
	@Column(name="nature_appt_org")
	private Integer natureApptOrg;
	@Column(name="email")
	private String email;
	@Column(name="mobile")
	private String mobile;
	@Column(name="s_no")
	private BigInteger sNo;
	@Column(name="checkbit")
	private Integer checkbit;
	@Column(name="verify_flag")
	private String verifyFlag;
	@Column(name="system_teacher_code")
	private String systemTeacherCode;
	@Column(name="transfered_udise_sch_code")
	private String transferedUdiseSchCode;
	@Column(name="drop_box_flag")
	private String dropBoxFlag;
	@Column(name="dropbox_feedback")
	private String dropboxFeedback;
	
	@Column(name="created_by") 
	private String createdBy ;
	
	@Column(name="created_time") 
	private Date createdTime ;
	

	
	
	
	
	public BigInteger getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(BigInteger teacherId) {
		this.teacherId = teacherId;
	}	
	public String getDropboxFeedback() {
		return dropboxFeedback;
	}
	public void setDropboxFeedback(String dropboxFeedback) {
		this.dropboxFeedback = dropboxFeedback;
	}
	public String getDropBoxFlag() {
		return dropBoxFlag;
	}
	public void setDropBoxFlag(String dropBoxFlag) {
		this.dropBoxFlag = dropBoxFlag;
	}
	public String getTransferedUdiseSchCode() {
		return transferedUdiseSchCode;
	}
	public void setTransferedUdiseSchCode(String transferedUdiseSchCode) {
		this.transferedUdiseSchCode = transferedUdiseSchCode;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public String getUdiseSchCode() {
		return udiseSchCode;
	}
	public void setUdiseSchCode(String udiseSchCode) {
		this.udiseSchCode = udiseSchCode;
	}
	public String getAcYear() {
		return acYear;
	}
	public void setAcYear(String acYear) {
		this.acYear = acYear;
	}
	public String getTchCodeState() {
		return tchCodeState;
	}
	public void setTchCodeState(String tchCodeState) {
		this.tchCodeState = tchCodeState;
	}
	public String getTchCode() {
		return tchCode;
	}
	public void setTchCode(String tchCode) {
		this.tchCode = tchCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Integer getSocialCat() {
		return socialCat;
	}
	public void setSocialCat(Integer socialCat) {
		this.socialCat = socialCat;
	}
	public Integer getTchType() {
		return tchType;
	}
	public void setTchType(Integer tchType) {
		this.tchType = tchType;
	}
	public Integer getNatureOfAppt() {
		return natureOfAppt;
	}
	public void setNatureOfAppt(Integer natureOfAppt) {
		this.natureOfAppt = natureOfAppt;
	}
	public Date getDojService() {
		return dojService;
	}
	public void setDojService(Date dojService) {
		this.dojService = dojService;
	}
	public Integer getQualAcad() {
		return qualAcad;
	}
	public void setQualAcad(Integer qualAcad) {
		this.qualAcad = qualAcad;
	}
	public Integer getQualProf() {
		return qualProf;
	}
	public void setQualProf(Integer qualProf) {
		this.qualProf = qualProf;
	}
	public Integer getClassTaught() {
		return classTaught;
	}
	public void setClassTaught(Integer classTaught) {
		this.classTaught = classTaught;
	}
	public Integer getApptSub() {
		return apptSub;
	}
	public void setApptSub(Integer apptSub) {
		this.apptSub = apptSub;
	}
	public Integer getSubTaught1() {
		return subTaught1;
	}
	public void setSubTaught1(Integer subTaught1) {
		this.subTaught1 = subTaught1;
	}
	public Integer getSubTaught2() {
		return subTaught2;
	}
	public void setSubTaught2(Integer subTaught2) {
		this.subTaught2 = subTaught2;
	}
	public Integer getTrnBrc() {
		return trnBrc;
	}
	public void setTrnBrc(Integer trnBrc) {
		this.trnBrc = trnBrc;
	}
	public Integer getTrnCrc() {
		return trnCrc;
	}
	public void setTrnCrc(Integer trnCrc) {
		this.trnCrc = trnCrc;
	}
	public Integer getTrnDiet() {
		return trnDiet;
	}
	public void setTrnDiet(Integer trnDiet) {
		this.trnDiet = trnDiet;
	}
	public Integer getTrnOther() {
		return trnOther;
	}
	public void setTrnOther(Integer trnOther) {
		this.trnOther = trnOther;
	}
	public Integer getTrngNeeded() {
		return trngNeeded;
	}
	public void setTrngNeeded(Integer trngNeeded) {
		this.trngNeeded = trngNeeded;
	}
	public Integer getNontchDays() {
		return nontchDays;
	}
	public void setNontchDays(Integer nontchDays) {
		this.nontchDays = nontchDays;
	}
	public Integer getMathUpto() {
		return mathUpto;
	}
	public void setMathUpto(Integer mathUpto) {
		this.mathUpto = mathUpto;
	}
	public Integer getScienceUpto() {
		return scienceUpto;
	}
	public void setScienceUpto(Integer scienceUpto) {
		this.scienceUpto = scienceUpto;
	}
	public Integer getEnglishUpto() {
		return englishUpto;
	}
	public void setEnglishUpto(Integer englishUpto) {
		this.englishUpto = englishUpto;
	}
	public Integer getSoc_studyUpto() {
		return soc_studyUpto;
	}
	public void setSoc_studyUpto(Integer soc_studyUpto) {
		this.soc_studyUpto = soc_studyUpto;
	}
	public String getYoj_presSch() {
		return yoj_presSch;
	}
	public void setYoj_presSch(String yoj_presSch) {
		this.yoj_presSch = yoj_presSch;
	}
	public Integer getDisabilityType() {
		return disabilityType;
	}
	public void setDisabilityType(Integer disabilityType) {
		this.disabilityType = disabilityType;
	}
	public Integer getTrainedCwsn() {
		return trainedCwsn;
	}
	public void setTrainedCwsn(Integer trainedCwsn) {
		this.trainedCwsn = trainedCwsn;
	}
	public Integer getTrainedComp() {
		return trainedComp;
	}
	public void setTrainedComp(Integer trainedComp) {
		this.trainedComp = trainedComp;
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
	public Integer getTrngRcvd() {
		return trngRcvd;
	}
	public void setTrngRcvd(Integer trngRcvd) {
		this.trngRcvd = trngRcvd;
	}
	public Integer getLangStudyUpto() {
		return langStudyUpto;
	}
	public void setLangStudyUpto(Integer langStudyUpto) {
		this.langStudyUpto = langStudyUpto;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public Integer getTchTypeOrg() {
		return tchTypeOrg;
	}
	public void setTchTypeOrg(Integer tchTypeOrg) {
		this.tchTypeOrg = tchTypeOrg;
	}
	public Integer getTchSocialCatOrg() {
		return tchSocialCatOrg;
	}
	public void setTchSocialCatOrg(Integer tchSocialCatOrg) {
		this.tchSocialCatOrg = tchSocialCatOrg;
	}
	public Integer getNatureApptOrg() {
		return natureApptOrg;
	}
	public void setNatureApptOrg(Integer natureApptOrg) {
		this.natureApptOrg = natureApptOrg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public BigInteger getsNo() {
		return sNo;
	}
	public void setsNo(BigInteger sNo) {
		this.sNo = sNo;
	}
	public Integer getCheckbit() {
		return checkbit;
	}
	public void setCheckbit(Integer checkbit) {
		this.checkbit = checkbit;
	}
	public String getVerifyFlag() {
		return verifyFlag;
	}
	public void setVerifyFlag(String verifyFlag) {
		this.verifyFlag = verifyFlag;
	}
	public String getSystemTeacherCode() {
		return systemTeacherCode;
	}
	public void setSystemTeacherCode(String systemTeacherCode) {
		this.systemTeacherCode = systemTeacherCode;
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
	
	
	
	
	
	
}
