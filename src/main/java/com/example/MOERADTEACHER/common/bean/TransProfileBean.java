package com.example.MOERADTEACHER.common.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransProfileBean {
	
private Integer	spouseKvsYnD;
private Integer	personalStatusMdgD;
private Integer	personalStatusSpD;
private Integer	personalStatusDfpD;
private Integer	careGiverFaimlyYnD;
private Integer	memberJCM;
private Integer	absenceDaysOne;
private Integer	disciplinaryYn;
private Integer	surveHardYn;

@JsonProperty(value="spouseKvsYnD", access=JsonProperty.Access.READ_ONLY)
public Integer getSpouseKvsYnD() {
	return spouseKvsYnD;
}
@JsonProperty(value="spouse_kvs_ynd", access=JsonProperty.Access.WRITE_ONLY)
public void setSpouseKvsYnD(Integer spouseKvsYnD) {
	this.spouseKvsYnD = spouseKvsYnD;
}
@JsonProperty(value="personalStatusMdgD", access=JsonProperty.Access.READ_ONLY)
public Integer getPersonalStatusMdgD() {
	return personalStatusMdgD;
}
@JsonProperty(value="personal_status_mdgd", access=JsonProperty.Access.WRITE_ONLY)
public void setPersonalStatusMdgD(Integer personalStatusMdgD) {
	this.personalStatusMdgD = personalStatusMdgD;
}
@JsonProperty(value="personalStatusSpD", access=JsonProperty.Access.READ_ONLY)
public Integer getPersonalStatusSpD() {
	return personalStatusSpD;
}
@JsonProperty(value="personal_status_spd", access=JsonProperty.Access.WRITE_ONLY)
public void setPersonalStatusSpD(Integer personalStatusSpD) {
	this.personalStatusSpD = personalStatusSpD;
}
@JsonProperty(value="personalStatusDfpD", access=JsonProperty.Access.READ_ONLY)
public Integer getPersonalStatusDfpD() {
	return personalStatusDfpD;
}
@JsonProperty(value="personal_status_dfpd", access=JsonProperty.Access.WRITE_ONLY)
public void setPersonalStatusDfpD(Integer personalStatusDfpD) {
	this.personalStatusDfpD = personalStatusDfpD;
}
@JsonProperty(value="careGiverFaimlyYnD", access=JsonProperty.Access.READ_ONLY)
public Integer getCareGiverFaimlyYnD() {
	return careGiverFaimlyYnD;
}
@JsonProperty(value="care_giver_faimly_ynd", access=JsonProperty.Access.WRITE_ONLY)
public void setCareGiverFaimlyYnD(Integer careGiverFaimlyYnD) {
	this.careGiverFaimlyYnD = careGiverFaimlyYnD;
}
@JsonProperty(value="memberJCM", access=JsonProperty.Access.READ_ONLY)
public Integer getMemberJCM() {
	return memberJCM;
}
@JsonProperty(value="memberjcm", access=JsonProperty.Access.WRITE_ONLY)
public void setMemberJCM(Integer memberJCM) {
	this.memberJCM = memberJCM;
}
@JsonProperty(value="absenceDaysOne", access=JsonProperty.Access.READ_ONLY)
public Integer getAbsenceDaysOne() {
	return absenceDaysOne;
}
@JsonProperty(value="absence_days_one", access=JsonProperty.Access.WRITE_ONLY)
public void setAbsenceDaysOne(Integer absenceDaysOne) {
	this.absenceDaysOne = absenceDaysOne;
}
@JsonProperty(value="disciplinaryYn", access=JsonProperty.Access.READ_ONLY)
public Integer getDisciplinaryYn() {
	return disciplinaryYn;
}
@JsonProperty(value="disciplinary_yn", access=JsonProperty.Access.WRITE_ONLY)
public void setDisciplinaryYn(Integer disciplinaryYn) {
	this.disciplinaryYn = disciplinaryYn;
}
@JsonProperty(value="surveHardYn", access=JsonProperty.Access.READ_ONLY)
public Integer getSurveHardYn() {
	return surveHardYn;
}
@JsonProperty(value="surve_hard_yn", access=JsonProperty.Access.WRITE_ONLY)
public void setSurveHardYn(Integer surveHardYn) {
	this.surveHardYn = surveHardYn;
}



}
