package com.example.MOERADTEACHER.common.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.json.JsonType;

import lombok.Data;

@Entity
//@Data
@Table(name = "teacher_transfer_profile", schema="public")
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@TypeDefs({
    @TypeDef(name = "json", typeClass = JsonType.class),
    @TypeDef(name = "string-array", typeClass = IntArrayType.class)
})
public class TeacherTransferProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "teacher_id")
	private Integer teacherId;
	@Column(name = "apply_transfer_yn")
	private Integer applyTransferYn;	
	@Column(name = "choice_kv1_station_code")
	private String choiceKv1StationCode;
	@Column(name = "choice_kv1_station_name")
	private String choiceKv1StationName;
	@Column(name = "choice_kv2_station_code")
	private String choiceKv2StationCode;
	@Column(name = "choice_kv2_station_name")
	private String choiceKv2StationName;
	@Column(name = "choice_kv3_station_code")
	private String choiceKv3StationCode;
	@Column(name = "choice_kv3_station_name")
	private String choiceKv3StationName;
	@Column(name = "choice_kv4_station_code")
	private String choiceKv4StationCode;
	@Column(name = "choice_kv4_station_name")
	private String choiceKv4StationName;
	@Column(name = "choice_kv5_station_code")
	private String choiceKv5StationCode;
	@Column(name = "choiceKv5_station_name")
	private String choiceKv5StationName;
	@Column(name = "displacement1_station_code")
	private String displacement1StationCode;
	@Column(name = "displacement1_station_name")
	private String displacement1StationName;
	@Column(name = "displacement2_station_code")
	private String displacement2StationCode;
	@Column(name = "displacement2_station_name")
	private String displacement2StationName;
	@Column(name = "displacement3_station_code")
	private String displacement3StationCode;
	@Column(name = "displacement3_station_name")
	private String displacement3StationName;
	@Column(name = "displacement4_station_code")
	private String displacement4StationCode;
	@Column(name = "displacement4_station_name")
	private String displacement4StationName;
	@Column(name = "displacement5_station_code")
	private String displacement5StationCode;
	@Column(name = "displacement5_station_name")
	private String displacement5StationName;
	@Column(name = "spouse_kvs_ynD")
	private Integer spouseKvsYnD;
	@Column(name = "spouse_emp_code")
	private String spouseEmpCode;
	@Column(name = "spouse_post")
	private String spousePost;
	@Column(name = "spouse_station_name")
	private String spouseStationName;
	@Column(name = "personal_status_mdgD")
	private Integer personalStatusMdgD;
	@Column(name = "patient_name")
	private String patientName;
	@Column(name = "patient_ailment")
	private String patientAilment;
	@Column(name = "patient_hospital")
	private String patientHospital;
	@Column(name = "patient_medical_officer_name")
	private String patientMedicalOfficerName;
	@Column(name = "patient_medical_officer_designation")
	private String patientMedicalOfficerDesignation;
	@Column(name = "medical_certificate_issue_date")
	private Date medicalCertificateIssueDate;
	@Column(name = "personal_status_spD")
	private Integer personalStatusSpD;
	@Column(name = "single_parent_ground")
	private String singleParentGround;  
	@Column(name = "single_parent_certificate_issue_date")
	private Date singleParentCertificateIssueDate; 
	@Column(name = "personal_status_dfpD")
	private Integer personalStatusDfpD;
	
	@Column(name = "death_of_family_ground")
	private String deathOfFamilyGround;
	
	@Column(name = "name_of_family_member")
	private String nameOfFamilyMember;
	
	@Column(name = "death_certificate_issue_date")
	private Date deathCertificateIssueDate;
	
	@Column(name = "relation_of_death_person")
	private String relationOfDeathPerson;
	
	
	
	@Column(name = "child_different_name")
	private String childDifferentName;
	@Column(name = "child_different_disability_name")
	private String childDifferentDisabilityName;
	@Column(name = "child_different_disability_prcnt")
	private Integer childDifferentDisabilityPrcnt;
	@Column(name = "memberJCM")
	private Integer memberJCM;
	@Column(name = "position_of_njcm_rjcm")
	private String positionOfNjcmRjcm;
	@Column(name = "child_10_12_ynD")
	private Integer child_10_12YnD;
	@Column(name = "care_giver_ynD")
	private Integer careGiverYnD;
	@Column(name = "care_giver_name")
	private String careGiverName;
	@Column(name = "care_giver_relation")
	private String careGiverRelation;
	@Column(name = "care_giver_disability_name")
	private String careGiverDisabilityName;
	@Column(name = "care_giver_disability_prcnt")
	private Integer careGiverDisabilityPrcnt;
	@Column(name = "child_different_able_ynD")
	private Integer childDifferentAbleYnD;
	@Column(name = "child_10_12_name")
	private String child1012Name;
	@Column(name = "child_10_12_class")
	private Integer child1012Class;
	@Column(name = "child_10_12_school")
	private String child1012School;
	@Column(name = "child_10_12_board")
	private String child1012Board;
	@Column(name = "shift_change_same_school")
	private String shiftChangeSameSchool;
	@Column(name = "care_giver_faimly_ynD")
	private String careGiverFaimlyYnD;
	@Column(name = "disciplinary_yn")
	private Integer disciplinaryYn;
	@Column(name = "absence_days_one")
	private Integer absenceDaysOne;
	@Column(name = "transfer_status")
	private Integer transferStatus;
	@Column(name = "transfer_id")
	private String transferId;
	@Column(name = "teacher_employee_code")
	private String teacherEmployeeCode;
	@Column(name = "surve_hard_yn")
	private Integer surveHardYn;
	
//	  @Type(type = "string-array")
//	    @Column(name = "period_absent", columnDefinition = "string[]")
	@Type(type = "jsonb") // See (2)
    @Column(name = "period_absent", columnDefinition = "jsonb")
	private String periodAbsent;
	
	@Column(name = "relation_with_empl_mdg")
	private String relationWithEmplMdg;
	
	@Column(name = "trans_emp_is_declaration")
	private Integer transEmpIsDeclaration;
	
	@Column(name = "trans_emp_declaraion_date")
	private Date transEmpDeclaraionDate;
	
	@Column(name = "trans_emp_declaration_ip")
	private String transEmpDeclarationIp;
	
	@Column(name = "inityear")
	private String inityear;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getApplyTransferYn() {
		return applyTransferYn;
	}
	public void setApplyTransferYn(Integer applyTransferYn) {
		this.applyTransferYn = applyTransferYn;
	}
	public String getChoiceKv1StationCode() {
		return choiceKv1StationCode;
	}
	public void setChoiceKv1StationCode(String choiceKv1StationCode) {
		this.choiceKv1StationCode = choiceKv1StationCode;
	}
	public String getChoiceKv1StationName() {
		return choiceKv1StationName;
	}
	public void setChoiceKv1StationName(String choiceKv1StationName) {
		this.choiceKv1StationName = choiceKv1StationName;
	}
	public String getChoiceKv2StationCode() {
		return choiceKv2StationCode;
	}
	public void setChoiceKv2StationCode(String choiceKv2StationCode) {
		this.choiceKv2StationCode = choiceKv2StationCode;
	}
	public String getChoiceKv2StationName() {
		return choiceKv2StationName;
	}
	public void setChoiceKv2StationName(String choiceKv2StationName) {
		this.choiceKv2StationName = choiceKv2StationName;
	}
	public String getChoiceKv3StationCode() {
		return choiceKv3StationCode;
	}
	public void setChoiceKv3StationCode(String choiceKv3StationCode) {
		this.choiceKv3StationCode = choiceKv3StationCode;
	}
	public String getChoiceKv3StationName() {
		return choiceKv3StationName;
	}
	public void setChoiceKv3StationName(String choiceKv3StationName) {
		this.choiceKv3StationName = choiceKv3StationName;
	}
	public String getChoiceKv4StationCode() {
		return choiceKv4StationCode;
	}
	public void setChoiceKv4StationCode(String choiceKv4StationCode) {
		this.choiceKv4StationCode = choiceKv4StationCode;
	}
	public String getChoiceKv4StationName() {
		return choiceKv4StationName;
	}
	public void setChoiceKv4StationName(String choiceKv4StationName) {
		this.choiceKv4StationName = choiceKv4StationName;
	}
	public String getChoiceKv5StationCode() {
		return choiceKv5StationCode;
	}
	public void setChoiceKv5StationCode(String choiceKv5StationCode) {
		this.choiceKv5StationCode = choiceKv5StationCode;
	}
	public String getChoiceKv5StationName() {
		return choiceKv5StationName;
	}
	public void setChoiceKv5StationName(String choiceKv5StationName) {
		this.choiceKv5StationName = choiceKv5StationName;
	}
	public String getDisplacement1StationCode() {
		return displacement1StationCode;
	}
	public void setDisplacement1StationCode(String displacement1StationCode) {
		this.displacement1StationCode = displacement1StationCode;
	}
	public String getDisplacement1StationName() {
		return displacement1StationName;
	}
	public void setDisplacement1StationName(String displacement1StationName) {
		this.displacement1StationName = displacement1StationName;
	}
	public String getDisplacement2StationCode() {
		return displacement2StationCode;
	}
	public void setDisplacement2StationCode(String displacement2StationCode) {
		this.displacement2StationCode = displacement2StationCode;
	}
	public String getDisplacement2StationName() {
		return displacement2StationName;
	}
	public void setDisplacement2StationName(String displacement2StationName) {
		this.displacement2StationName = displacement2StationName;
	}
	public String getDisplacement3StationCode() {
		return displacement3StationCode;
	}
	public void setDisplacement3StationCode(String displacement3StationCode) {
		this.displacement3StationCode = displacement3StationCode;
	}
	public String getDisplacement3StationName() {
		return displacement3StationName;
	}
	public void setDisplacement3StationName(String displacement3StationName) {
		this.displacement3StationName = displacement3StationName;
	}
	public String getDisplacement4StationCode() {
		return displacement4StationCode;
	}
	public void setDisplacement4StationCode(String displacement4StationCode) {
		this.displacement4StationCode = displacement4StationCode;
	}
	public String getDisplacement4StationName() {
		return displacement4StationName;
	}
	public void setDisplacement4StationName(String displacement4StationName) {
		this.displacement4StationName = displacement4StationName;
	}
	public String getDisplacement5StationCode() {
		return displacement5StationCode;
	}
	public void setDisplacement5StationCode(String displacement5StationCode) {
		this.displacement5StationCode = displacement5StationCode;
	}
	public String getDisplacement5StationName() {
		return displacement5StationName;
	}
	public void setDisplacement5StationName(String displacement5StationName) {
		this.displacement5StationName = displacement5StationName;
	}
	public Integer getSpouseKvsYnD() {
		return spouseKvsYnD;
	}
	public void setSpouseKvsYnD(Integer spouseKvsYnD) {
		this.spouseKvsYnD = spouseKvsYnD;
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
	public String getSpouseStationName() {
		return spouseStationName;
	}
	public void setSpouseStationName(String spouseStationName) {
		this.spouseStationName = spouseStationName;
	}
	public Integer getPersonalStatusMdgD() {
		return personalStatusMdgD;
	}
	public void setPersonalStatusMdgD(Integer personalStatusMdgD) {
		this.personalStatusMdgD = personalStatusMdgD;
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
	public Integer getPersonalStatusSpD() {
		return personalStatusSpD;
	}
	public void setPersonalStatusSpD(Integer personalStatusSpD) {
		this.personalStatusSpD = personalStatusSpD;
	}
	public Integer getPersonalStatusDfpD() {
		return personalStatusDfpD;
	}
	public void setPersonalStatusDfpD(Integer personalStatusDfpD) {
		this.personalStatusDfpD = personalStatusDfpD;
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
	public Integer getChildDifferentDisabilityPrcnt() {
		return childDifferentDisabilityPrcnt;
	}
	public void setChildDifferentDisabilityPrcnt(Integer childDifferentDisabilityPrcnt) {
		this.childDifferentDisabilityPrcnt = childDifferentDisabilityPrcnt;
	}
	public Integer getMemberJCM() {
		return memberJCM;
	}
	public void setMemberJCM(Integer memberJCM) {
		this.memberJCM = memberJCM;
	}
	public Integer getChild_10_12YnD() {
		return child_10_12YnD;
	}
	public void setChild_10_12YnD(Integer child_10_12YnD) {
		this.child_10_12YnD = child_10_12YnD;
	}
	public Integer getCareGiverYnD() {
		return careGiverYnD;
	}
	public void setCareGiverYnD(Integer careGiverYnD) {
		this.careGiverYnD = careGiverYnD;
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
	public Integer getCareGiverDisabilityPrcnt() {
		return careGiverDisabilityPrcnt;
	}
	public void setCareGiverDisabilityPrcnt(Integer careGiverDisabilityPrcnt) {
		this.careGiverDisabilityPrcnt = careGiverDisabilityPrcnt;
	}
	public Integer getChildDifferentAbleYnD() {
		return childDifferentAbleYnD;
	}
	public void setChildDifferentAbleYnD(Integer childDifferentAbleYnD) {
		this.childDifferentAbleYnD = childDifferentAbleYnD;
	}
	public String getChild1012Name() {
		return child1012Name;
	}
	public void setChild1012Name(String child1012Name) {
		this.child1012Name = child1012Name;
	}
	public Integer getChild1012Class() {
		return child1012Class;
	}
	public void setChild1012Class(Integer child1012Class) {
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
	public String getShiftChangeSameSchool() {
		return shiftChangeSameSchool;
	}
	public void setShiftChangeSameSchool(String shiftChangeSameSchool) {
		this.shiftChangeSameSchool = shiftChangeSameSchool;
	}
	public String getCareGiverFaimlyYnD() {
		return careGiverFaimlyYnD;
	}
	public void setCareGiverFaimlyYnD(String careGiverFaimlyYnD) {
		this.careGiverFaimlyYnD = careGiverFaimlyYnD;
	}
	public Integer getDisciplinaryYn() {
		return disciplinaryYn;
	}
	public void setDisciplinaryYn(Integer disciplinaryYn) {
		this.disciplinaryYn = disciplinaryYn;
	}
	public Integer getAbsenceDaysOne() {
		return absenceDaysOne;
	}
	public void setAbsenceDaysOne(Integer absenceDaysOne) {
		this.absenceDaysOne = absenceDaysOne;
	}
	public Date getMedicalCertificateIssueDate() {
		return medicalCertificateIssueDate;
	}
	public void setMedicalCertificateIssueDate(Date medicalCertificateIssueDate) {
		this.medicalCertificateIssueDate = medicalCertificateIssueDate;
	}
	public String getSingleParentGround() {
		return singleParentGround;
	}
	public void setSingleParentGround(String singleParentGround) {
		this.singleParentGround = singleParentGround;
	}
	public Date getSingleParentCertificateIssueDate() {
		return singleParentCertificateIssueDate;
	}
	public void setSingleParentCertificateIssueDate(Date singleParentCertificateIssueDate) {
		this.singleParentCertificateIssueDate = singleParentCertificateIssueDate;
	}
	public String getDeathOfFamilyGround() {
		return deathOfFamilyGround;
	}
	public void setDeathOfFamilyGround(String deathOfFamilyGround) {
		this.deathOfFamilyGround = deathOfFamilyGround;
	}
	public Date getDeathCertificateIssueDate() {
		return deathCertificateIssueDate;
	}
	public void setDeathCertificateIssueDate(Date deathCertificateIssueDate) {
		this.deathCertificateIssueDate = deathCertificateIssueDate;
	}
	public String getRelationOfDeathPerson() {
		return relationOfDeathPerson;
	}
	public void setRelationOfDeathPerson(String relationOfDeathPerson) {
		this.relationOfDeathPerson = relationOfDeathPerson;
	}
	public String getPositionOfNjcmRjcm() {
		return positionOfNjcmRjcm;
	}
	public void setPositionOfNjcmRjcm(String positionOfNjcmRjcm) {
		this.positionOfNjcmRjcm = positionOfNjcmRjcm;
	}
	public Integer getTransferStatus() {
		return transferStatus;
	}
	public void setTransferStatus(Integer transferStatus) {
		this.transferStatus = transferStatus;
	}
	public String getTransferId() {
		return transferId;
	}
	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}
	public String getNameOfFamilyMember() {
		return nameOfFamilyMember;
	}
	public void setNameOfFamilyMember(String nameOfFamilyMember) {
		this.nameOfFamilyMember = nameOfFamilyMember;
	}
	public String getTeacherEmployeeCode() {
		return teacherEmployeeCode;
	}
	public void setTeacherEmployeeCode(String teacherEmployeeCode) {
		this.teacherEmployeeCode = teacherEmployeeCode;
	}
	public Integer getSurveHardYn() {
		return surveHardYn;
	}
	public void setSurveHardYn(Integer surveHardYn) {
		this.surveHardYn = surveHardYn;
	}
//	public String[] getPeriodAbsent() {
//		return periodAbsent;
//	}
//	public void setPeriodAbsent(String[] periodAbsent) {
//		this.periodAbsent = periodAbsent;
//	}
	public String getPeriodAbsent() {
		return periodAbsent;
	}
	public void setPeriodAbsent(String periodAbsent) {
		this.periodAbsent = periodAbsent;
	}
	public String getRelationWithEmplMdg() {
		return relationWithEmplMdg;
	}
	public void setRelationWithEmplMdg(String relationWithEmplMdg) {
		this.relationWithEmplMdg = relationWithEmplMdg;
	}
	public Integer getTransEmpIsDeclaaration() {
		return transEmpIsDeclaration;
	}
	public void setTransEmpIsDeclaaration(Integer transEmpIsDeclaaration) {
		this.transEmpIsDeclaration = transEmpIsDeclaaration;
	}
	public Integer getTransEmpIsDeclaration() {
		return transEmpIsDeclaration;
	}
	public void setTransEmpIsDeclaration(Integer transEmpIsDeclaration) {
		this.transEmpIsDeclaration = transEmpIsDeclaration;
	}
	public Date getTransEmpDeclaraionDate() {
		return transEmpDeclaraionDate;
	}
	public void setTransEmpDeclaraionDate(Date transEmpDeclaraionDate) {
		this.transEmpDeclaraionDate = transEmpDeclaraionDate;
	}
	public String getTransEmpDeclarationIp() {
		return transEmpDeclarationIp;
	}
	public void setTransEmpDeclarationIp(String transEmpDeclarationIp) {
		this.transEmpDeclarationIp = transEmpDeclarationIp;
	}
	
	@PrePersist
	protected void onCreate() {
	    if (transEmpDeclaraionDate == null) { transEmpDeclaraionDate = new Date(); }
	}
	public String getInityear() {
		return inityear;
	}
	public void setInityear(String inityear) {
		this.inityear = inityear;
	}
	

}
