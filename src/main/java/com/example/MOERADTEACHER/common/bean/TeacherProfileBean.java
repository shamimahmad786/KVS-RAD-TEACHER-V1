package com.example.MOERADTEACHER.common.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeacherProfileBean implements Serializable{
	public Integer teacher_id;
	public String teacher_name;
	public String teacher_gender;
	public String teacher_dob;
	public String teacher_employee_code;
	public String teacher_social_category;
	public String teacher_mobile;
	public String teacher_email;
	public String teacher_religion;
	public String teacher_nationality;
	public String teacher_blood_group;
	public String teacher_permanent_address;
	public String teacher_parmanent_state;
	public String teacher_permanent_district;
	public String teacher_permanent_pin;
	public String teacher_correspondence_address;
	public String teacher_correspondence_state;
	public String teacher_correspondence_district;
	public String teacher_correspondence_pin;
	public String teacher_personnel_identification;
	public String teacher_pan_number;
	public String teacher_aadhaar_number;
	public String teacher_passport_number;
	public String teacher_disability_yn;
	public String teacher_disability_type;
	public String teacher_disability_from_birth_yn;
	public String teacher_disability_date;
	public String teacher_disability_prcnt;
	public String teacher_disability_cert_authority;
	public String teacher_disability_cert_number;
	public String work_experience_position_type_present_kv;
	public String work_experience_work_start_date_present_kv;
	public Integer work_experience_id_present_kv;
	public String work_experience_position_type_present_station_start_date;
	public String work_experience_appointed_for_subject;
	public String last_promotion_id;
	public String last_promotion_position_type;
	public String last_promotion_position_date;
	public String tet_qualified_yn;
	public String tet_qualifing_year;
	public String teacher_temp_id;
	public Integer tid;
	public String teacher_system_generated_code;
	public String teacher_account_id;
	public String current_udise_sch_code;
	public String school_id;
	public Integer drop_box_flag;
	public String verify_flag;
	public String transfered_udise_sch_code;
	public String dropbox_feedback;
	public String created_by;
	public Date created_time;
	public String modified_by;
	public Date modified_time;
	public String verified_type;
	public String teaching_nonteaching;
	public Integer version_no;
	public String nature_of_appointment;
	public Integer teacher_profile_teacher_id;
	public String spouse_emp_code;
	public String spouse_post;
	public String spouse_station_code;
	public String spouse_status;
	public String spouse_name;
	public String spouse_station_name;
	public String marital_status;
	public String school_remarks;
	public String teacher_remarks;
	public String school_name;
	@Temporal(TemporalType.DATE)
	public Date dropbox_date;
	
	public String dropboxdate;
	
	public String care_giver_disability_name;
	public String care_giver_disability_prcnt;
	public String kvCode;
	
	@JsonProperty(value="teacherId", access=JsonProperty.Access.READ_ONLY)
	public Integer getTeacher_id() {
		return teacher_id;
	}
	@JsonProperty(value="teacher_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}
	@JsonProperty(value="teacherName", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_name() {
		return teacher_name;
	}
	@JsonProperty(value="teacher_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	@JsonProperty(value="teacherGender", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_gender() {
		return teacher_gender;
	}
	@JsonProperty(value="teacher_gender", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_gender(String teacher_gender) {
		this.teacher_gender = teacher_gender;
	}
	@JsonProperty(value="teacherDob", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_dob() {
		return teacher_dob;
	}
	@JsonProperty(value="teacher_dob", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_dob(String teacher_dob) {
		this.teacher_dob = teacher_dob;
	}
	@JsonProperty(value="teacherEmployeeCode", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_employee_code() {
		return teacher_employee_code;
	}
	@JsonProperty(value="teacher_employee_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_employee_code(String teacher_employee_code) {
		this.teacher_employee_code = teacher_employee_code;
	}
	@JsonProperty(value="teacherSocialCategory", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_social_category() {
		return teacher_social_category;
	}
	@JsonProperty(value="teacher_social_category", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_social_category(String teacher_social_category) {
		this.teacher_social_category = teacher_social_category;
	}
	@JsonProperty(value="teacherMobile", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_mobile() {
		return teacher_mobile;
	}
	@JsonProperty(value="teacher_mobile", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_mobile(String teacher_mobile) {
		this.teacher_mobile = teacher_mobile;
	}
	@JsonProperty(value="teacherEmail", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_email() {
		return teacher_email;
	}
	@JsonProperty(value="teacher_email", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_email(String teacher_email) {
		this.teacher_email = teacher_email;
	}
	@JsonProperty(value="teacherReligion", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_religion() {
		return teacher_religion;
	}
	@JsonProperty(value="teacher_religion", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_religion(String teacher_religion) {
		this.teacher_religion = teacher_religion;
	}
	@JsonProperty(value="teacherNationality", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_nationality() {
		return teacher_nationality;
	}
	@JsonProperty(value="teacher_nationality", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_nationality(String teacher_nationality) {
		this.teacher_nationality = teacher_nationality;
	}
	@JsonProperty(value="teacherBloodGroup", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_blood_group() {
		return teacher_blood_group;
	}
	@JsonProperty(value="teacher_blood_group", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_blood_group(String teacher_blood_group) {
		this.teacher_blood_group = teacher_blood_group;
	}
	@JsonProperty(value="teacherPermanentAddress", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_permanent_address() {
		return teacher_permanent_address;
	}
	@JsonProperty(value="teacher_permanent_address", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_permanent_address(String teacher_permanent_address) {
		this.teacher_permanent_address = teacher_permanent_address;
	}
	@JsonProperty(value="teacherParmanentState", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_parmanent_state() {
		return teacher_parmanent_state;
	}
	@JsonProperty(value="teacher_parmanent_state", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_parmanent_state(String teacher_parmanent_state) {
		this.teacher_parmanent_state = teacher_parmanent_state;
	}
	@JsonProperty(value="teacherPermanentDistrict", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_permanent_district() {
		return teacher_permanent_district;
	}
	@JsonProperty(value="teacher_permanent_district", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_permanent_district(String teacher_permanent_district) {
		this.teacher_permanent_district = teacher_permanent_district;
	}
	@JsonProperty(value="teacherPermanentPin", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_permanent_pin() {
		return teacher_permanent_pin;
	}
	@JsonProperty(value="teacher_permanent_pin", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_permanent_pin(String teacher_permanent_pin) {
		this.teacher_permanent_pin = teacher_permanent_pin;
	}
	@JsonProperty(value="teacherCorrespondenceAddress", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_correspondence_address() {
		return teacher_correspondence_address;
	}
	@JsonProperty(value="teacher_correspondence_address", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_correspondence_address(String teacher_correspondence_address) {
		this.teacher_correspondence_address = teacher_correspondence_address;
	}
	@JsonProperty(value="teacherCorrespondenceState", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_correspondence_state() {
		return teacher_correspondence_state;
	}
	@JsonProperty(value="teacher_correspondence_state", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_correspondence_state(String teacher_correspondence_state) {
		this.teacher_correspondence_state = teacher_correspondence_state;
	}
	@JsonProperty(value="teacherCorrespondenceDistrict", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_correspondence_district() {
		return teacher_correspondence_district;
	}
	@JsonProperty(value="teacher_correspondence_district", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_correspondence_district(String teacher_correspondence_district) {
		this.teacher_correspondence_district = teacher_correspondence_district;
	}
	@JsonProperty(value="teacherCorrespondencePin", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_correspondence_pin() {
		return teacher_correspondence_pin;
	}
	@JsonProperty(value="teacher_correspondence_pin", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_correspondence_pin(String teacher_correspondence_pin) {
		this.teacher_correspondence_pin = teacher_correspondence_pin;
	}
	@JsonProperty(value="teacherPersonnelIdentification", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_personnel_identification() {
		return teacher_personnel_identification;
	}
	@JsonProperty(value="teacher_personnel_identification", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_personnel_identification(String teacher_personnel_identification) {
		this.teacher_personnel_identification = teacher_personnel_identification;
	}
	@JsonProperty(value="teacherPanNumber", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_pan_number() {
		return teacher_pan_number;
	}
	@JsonProperty(value="teacher_pan_number", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_pan_number(String teacher_pan_number) {
		this.teacher_pan_number = teacher_pan_number;
	}
	@JsonProperty(value="teacherAadhaarNumber", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_aadhaar_number() {
		return teacher_aadhaar_number;
	}
	@JsonProperty(value="teacher_aadhaar_number", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_aadhaar_number(String teacher_aadhaar_number) {
		this.teacher_aadhaar_number = teacher_aadhaar_number;
	}
	@JsonProperty(value="teacherPassportNumber", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_passport_number() {
		return teacher_passport_number;
	}
	@JsonProperty(value="teacher_passport_number", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_passport_number(String teacher_passport_number) {
		this.teacher_passport_number = teacher_passport_number;
	}
	@JsonProperty(value="teacherDisabilityYn", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_disability_yn() {
		return teacher_disability_yn;
	}
	@JsonProperty(value="teacher_disability_yn", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_disability_yn(String teacher_disability_yn) {
		this.teacher_disability_yn = teacher_disability_yn;
	}
	@JsonProperty(value="teacherDisabilityType", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_disability_type() {
		return teacher_disability_type;
	}
	@JsonProperty(value="teacher_disability_type", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_disability_type(String teacher_disability_type) {
		this.teacher_disability_type = teacher_disability_type;
	}
	@JsonProperty(value="teacherDisabilityFromBirthYn", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_disability_from_birth_yn() {
		return teacher_disability_from_birth_yn;
	}
	@JsonProperty(value="teacher_disability_from_birth_yn", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_disability_from_birth_yn(String teacher_disability_from_birth_yn) {
		this.teacher_disability_from_birth_yn = teacher_disability_from_birth_yn;
	}
	@JsonProperty(value="teacherDisabilityDate", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_disability_date() {
		return teacher_disability_date;
	}
	@JsonProperty(value="teacher_disability_date", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_disability_date(String teacher_disability_date) {
		this.teacher_disability_date = teacher_disability_date;
	}
	@JsonProperty(value="teacherDisabilityPrcnt", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_disability_prcnt() {
		return teacher_disability_prcnt;
	}
	@JsonProperty(value="teacher_disability_prcnt", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_disability_prcnt(String teacher_disability_prcnt) {
		this.teacher_disability_prcnt = teacher_disability_prcnt;
	}
	@JsonProperty(value="teacherDisabilityCertAuthority", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_disability_cert_authority() {
		return teacher_disability_cert_authority;
	}
	@JsonProperty(value="teacher_disability_cert_authority", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_disability_cert_authority(String teacher_disability_cert_authority) {
		this.teacher_disability_cert_authority = teacher_disability_cert_authority;
	}
	@JsonProperty(value="teacherDisabilityCertNumber", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_disability_cert_number() {
		return teacher_disability_cert_number;
	}
	@JsonProperty(value="teacher_disability_cert_number", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_disability_cert_number(String teacher_disability_cert_number) {
		this.teacher_disability_cert_number = teacher_disability_cert_number;
	}
	@JsonProperty(value="workExperiencePositionTypePresentKv", access=JsonProperty.Access.READ_ONLY)
	public String getWork_experience_position_type_present_kv() {
		return work_experience_position_type_present_kv;
	}
	@JsonProperty(value="work_experience_position_type_present_kv", access=JsonProperty.Access.WRITE_ONLY)
	public void setWork_experience_position_type_present_kv(String work_experience_position_type_present_kv) {
		this.work_experience_position_type_present_kv = work_experience_position_type_present_kv;
	}
	@JsonProperty(value="workExperienceWorkStartDatePresentKv", access=JsonProperty.Access.READ_ONLY)
	public String getWork_experience_work_start_date_present_kv() {
		return work_experience_work_start_date_present_kv;
	}
	@JsonProperty(value="work_experience_work_start_date_present_kv", access=JsonProperty.Access.WRITE_ONLY)
	public void setWork_experience_work_start_date_present_kv(String work_experience_work_start_date_present_kv) {
		this.work_experience_work_start_date_present_kv = work_experience_work_start_date_present_kv;
	}
	@JsonProperty(value="workExperienceIdPresentKv", access=JsonProperty.Access.READ_ONLY)
	public Integer getWork_experience_id_present_kv() {
		return work_experience_id_present_kv;
	}
	@JsonProperty(value="work_experience_id_present_kv", access=JsonProperty.Access.WRITE_ONLY)
	public void setWork_experience_id_present_kv(Integer work_experience_id_present_kv) {
		this.work_experience_id_present_kv = work_experience_id_present_kv;
	}
	@JsonProperty(value="workExperiencePositionTypePresentStationStartDate", access=JsonProperty.Access.READ_ONLY)
	public String getWork_experience_position_type_present_station_start_date() {
		return work_experience_position_type_present_station_start_date;
	}
	@JsonProperty(value="work_experience_position_type_present_station_start_date", access=JsonProperty.Access.WRITE_ONLY)
	public void setWork_experience_position_type_present_station_start_date(
			String work_experience_position_type_present_station_start_date) {
		this.work_experience_position_type_present_station_start_date = work_experience_position_type_present_station_start_date;
	}
	@JsonProperty(value="workExperienceAppointedForSubject", access=JsonProperty.Access.READ_ONLY)
	public String getWork_experience_appointed_for_subject() {
		return work_experience_appointed_for_subject;
	}
	@JsonProperty(value="work_experience_appointed_for_subject", access=JsonProperty.Access.WRITE_ONLY)
	public void setWork_experience_appointed_for_subject(String work_experience_appointed_for_subject) {
		this.work_experience_appointed_for_subject = work_experience_appointed_for_subject;
	}
	@JsonProperty(value="lastPromotionId", access=JsonProperty.Access.READ_ONLY)
	public String getLast_promotion_id() {
		return last_promotion_id;
	}
	@JsonProperty(value="last_promotion_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setLast_promotion_id(String last_promotion_id) {
		this.last_promotion_id = last_promotion_id;
	}
	@JsonProperty(value="lastPromotionPositionType", access=JsonProperty.Access.READ_ONLY)
	public String getLast_promotion_position_type() {
		return last_promotion_position_type;
	}
	@JsonProperty(value="last_promotion_position_type", access=JsonProperty.Access.WRITE_ONLY)
	public void setLast_promotion_position_type(String last_promotion_position_type) {
		this.last_promotion_position_type = last_promotion_position_type;
	}
	@JsonProperty(value="lastPromotionPositionDate", access=JsonProperty.Access.READ_ONLY)
	public String getLast_promotion_position_date() {
		return last_promotion_position_date;
	}
	@JsonProperty(value="last_promotion_position_date", access=JsonProperty.Access.WRITE_ONLY)
	public void setLast_promotion_position_date(String last_promotion_position_date) {
		this.last_promotion_position_date = last_promotion_position_date;
	}
	@JsonProperty(value="tetQualifiedYn", access=JsonProperty.Access.READ_ONLY)
	public String getTet_qualified_yn() {
		return tet_qualified_yn;
	}
	@JsonProperty(value="tet_qualified_yn", access=JsonProperty.Access.WRITE_ONLY)
	public void setTet_qualified_yn(String tet_qualified_yn) {
		this.tet_qualified_yn = tet_qualified_yn;
	}
	@JsonProperty(value="tetQualifingYear", access=JsonProperty.Access.READ_ONLY)
	public String getTet_qualifing_year() {
		return tet_qualifing_year;
	}
	@JsonProperty(value="tet_qualifing_year", access=JsonProperty.Access.WRITE_ONLY)
	public void setTet_qualifing_year(String tet_qualifing_year) {
		this.tet_qualifing_year = tet_qualifing_year;
	}
	@JsonProperty(value="teacherTempId", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_temp_id() {
		return teacher_temp_id;
	}
	@JsonProperty(value="teacher_temp_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_temp_id(String teacher_temp_id) {
		this.teacher_temp_id = teacher_temp_id;
	}
	@JsonProperty(value="tid", access=JsonProperty.Access.READ_ONLY)
	public Integer getTid() {
		return tid;
	}
	@JsonProperty(value="tid", access=JsonProperty.Access.WRITE_ONLY)
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	@JsonProperty(value="teacherSystemGeneratedCode", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_system_generated_code() {
		return teacher_system_generated_code;
	}
	@JsonProperty(value="teacher_system_generated_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_system_generated_code(String teacher_system_generated_code) {
		this.teacher_system_generated_code = teacher_system_generated_code;
	}
	@JsonProperty(value="teacherAccountId", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_account_id() {
		return teacher_account_id;
	}
	@JsonProperty(value="teacher_account_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_account_id(String teacher_account_id) {
		this.teacher_account_id = teacher_account_id;
	}
	@JsonProperty(value="currentUdiseSchCode", access=JsonProperty.Access.READ_ONLY)
	public String getCurrent_udise_sch_code() {
		return current_udise_sch_code;
	}
	@JsonProperty(value="current_udise_sch_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setCurrent_udise_sch_code(String current_udise_sch_code) {
		this.current_udise_sch_code = current_udise_sch_code;
	}
	@JsonProperty(value="schoolId", access=JsonProperty.Access.READ_ONLY)
	public String getSchool_id() {
		return school_id;
	}
	@JsonProperty(value="school_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setSchool_id(String school_id) {
		this.school_id = school_id;
	}
	@JsonProperty(value="dropBoxFlag", access=JsonProperty.Access.READ_ONLY)
	public Integer getDrop_box_flag() {
		return drop_box_flag;
	}
	@JsonProperty(value="drop_box_flag", access=JsonProperty.Access.WRITE_ONLY)
	public void setDrop_box_flag(Integer drop_box_flag) {
		this.drop_box_flag = drop_box_flag;
	}
	@JsonProperty(value="verifyFlag", access=JsonProperty.Access.READ_ONLY)
	public String getVerify_flag() {
		return verify_flag;
	}
	@JsonProperty(value="verify_flag", access=JsonProperty.Access.WRITE_ONLY)
	public void setVerify_flag(String verify_flag) {
		this.verify_flag = verify_flag;
	}
	@JsonProperty(value="transferedUdiseSchCode", access=JsonProperty.Access.READ_ONLY)
	public String getTransfered_udise_sch_code() {
		return transfered_udise_sch_code;
	}
	@JsonProperty(value="transfered_udise_sch_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setTransfered_udise_sch_code(String transfered_udise_sch_code) {
		this.transfered_udise_sch_code = transfered_udise_sch_code;
	}
	@JsonProperty(value="dropboxFeedback", access=JsonProperty.Access.READ_ONLY)
	public String getDropbox_feedback() {
		return dropbox_feedback;
	}
	@JsonProperty(value="dropbox_feedback", access=JsonProperty.Access.WRITE_ONLY)
	public void setDropbox_feedback(String dropbox_feedback) {
		this.dropbox_feedback = dropbox_feedback;
	}
	@JsonProperty(value="createdBy", access=JsonProperty.Access.READ_ONLY)
	public String getCreated_by() {
		return created_by;
	}
	@JsonProperty(value="created_by", access=JsonProperty.Access.WRITE_ONLY)
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	@JsonProperty(value="createdTime", access=JsonProperty.Access.READ_ONLY)
	public Date getCreated_time() {
		return created_time;
	}
	@JsonProperty(value="created_time", access=JsonProperty.Access.WRITE_ONLY)
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	@JsonProperty(value="modifiedBy", access=JsonProperty.Access.READ_ONLY)
	public String getModified_by() {
		return modified_by;
	}
	@JsonProperty(value="modified_by", access=JsonProperty.Access.WRITE_ONLY)
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	@JsonProperty(value="modifiedTime", access=JsonProperty.Access.READ_ONLY)
	public Date getModified_time() {
		return modified_time;
	}
	@JsonProperty(value="modified_time", access=JsonProperty.Access.WRITE_ONLY)
	public void setModified_time(Date modified_time) {
		this.modified_time = modified_time;
	}
	@JsonProperty(value="verifiedType", access=JsonProperty.Access.READ_ONLY)
	public String getVerified_type() {
		return verified_type;
	}
	@JsonProperty(value="verified_type", access=JsonProperty.Access.WRITE_ONLY)
	public void setVerified_type(String verified_type) {
		this.verified_type = verified_type;
	}
	@JsonProperty(value="teachingNonteaching", access=JsonProperty.Access.READ_ONLY)
	public String getTeaching_nonteaching() {
		return teaching_nonteaching;
	}
	@JsonProperty(value="teaching_nonteaching", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeaching_nonteaching(String teaching_nonteaching) {
		this.teaching_nonteaching = teaching_nonteaching;
	}
	@JsonProperty(value="versionNo", access=JsonProperty.Access.READ_ONLY)
	public Integer getVersion_no() {
		return version_no;
	}
	@JsonProperty(value="version_no", access=JsonProperty.Access.WRITE_ONLY)
	public void setVersion_no(Integer version_no) {
		this.version_no = version_no;
	}
	@JsonProperty(value="natureOfAppointment", access=JsonProperty.Access.READ_ONLY)
	public String getNature_of_appointment() {
		return nature_of_appointment;
	}
	@JsonProperty(value="nature_of_appointment", access=JsonProperty.Access.WRITE_ONLY)
	public void setNature_of_appointment(String nature_of_appointment) {
		this.nature_of_appointment = nature_of_appointment;
	}
	@JsonProperty(value="teacherProfileTeacherId", access=JsonProperty.Access.READ_ONLY)
	public Integer getTeacher_profile_teacher_id() {
		return teacher_profile_teacher_id;
	}
	@JsonProperty(value="teacher_profile_teacher_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_profile_teacher_id(Integer teacher_profile_teacher_id) {
		this.teacher_profile_teacher_id = teacher_profile_teacher_id;
	}
	@JsonProperty(value="spouseEmpCode", access=JsonProperty.Access.READ_ONLY)
	public String getSpouse_emp_code() {
		return spouse_emp_code;
	}
	@JsonProperty(value="spouse_emp_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setSpouse_emp_code(String spouse_emp_code) {
		this.spouse_emp_code = spouse_emp_code;
	}
	@JsonProperty(value="spousePost", access=JsonProperty.Access.READ_ONLY)
	public String getSpouse_post() {
		return spouse_post;
	}
	@JsonProperty(value="spouse_post", access=JsonProperty.Access.WRITE_ONLY)
	public void setSpouse_post(String spouse_post) {
		this.spouse_post = spouse_post;
	}
	@JsonProperty(value="spouseStationCode", access=JsonProperty.Access.READ_ONLY)
	public String getSpouse_station_code() {
		return spouse_station_code;
	}
	@JsonProperty(value="spouse_station_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setSpouse_station_code(String spouse_station_code) {
		this.spouse_station_code = spouse_station_code;
	}
	@JsonProperty(value="spouseStatus", access=JsonProperty.Access.READ_ONLY)
	public String getSpouse_status() {
		return spouse_status;
	}
	@JsonProperty(value="spouse_status", access=JsonProperty.Access.WRITE_ONLY)
	public void setSpouse_status(String spouse_status) {
		this.spouse_status = spouse_status;
	}
	@JsonProperty(value="spouseName", access=JsonProperty.Access.READ_ONLY)
	public String getSpouse_name() {
		return spouse_name;
	}
	@JsonProperty(value="spouse_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setSpouse_name(String spouse_name) {
		this.spouse_name = spouse_name;
	}
	@JsonProperty(value="spouseStationName", access=JsonProperty.Access.READ_ONLY)
	public String getSpouse_station_name() {
		return spouse_station_name;
	}
	@JsonProperty(value="spouse_station_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setSpouse_station_name(String spouse_station_name) {
		this.spouse_station_name = spouse_station_name;
	}
	@JsonProperty(value="maritalStatus", access=JsonProperty.Access.READ_ONLY)
	public String getMarital_status() {
		return marital_status;
	}
	@JsonProperty(value="marital_status", access=JsonProperty.Access.WRITE_ONLY)
	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}
	@JsonProperty(value="schoolRemarks", access=JsonProperty.Access.READ_ONLY)
	public String getSchool_remarks() {
		return school_remarks;
	}
	@JsonProperty(value="school_remarks", access=JsonProperty.Access.WRITE_ONLY)
	public void setSchool_remarks(String school_remarks) {
		this.school_remarks = school_remarks;
	}
	@JsonProperty(value="teacherRemarks", access=JsonProperty.Access.READ_ONLY)
	public String getTeacher_remarks() {
		return teacher_remarks;
	}
	@JsonProperty(value="teacher_remarks", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacher_remarks(String teacher_remarks) {
		this.teacher_remarks = teacher_remarks;
	}
	
	@JsonProperty(value="schoolName", access=JsonProperty.Access.READ_ONLY)
	public String getSchool_name() {
		return school_name;
	}
	@JsonProperty(value="school_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	
	@JsonProperty(value="dropboxDate", access=JsonProperty.Access.READ_ONLY)
	public Date getDropbox_date() {
		return dropbox_date;
	}
	
	@JsonProperty(value="dropbox_date", access=JsonProperty.Access.WRITE_ONLY)
	public void setDropbox_date(Date dropbox_date) {
		this.dropbox_date = dropbox_date;
	}
	
	@JsonProperty(value="dropboxdate", access=JsonProperty.Access.READ_ONLY)
	public String getDropboxdate() {
		return dropboxdate;
	}
	
	@JsonProperty(value="dropboxdate", access=JsonProperty.Access.WRITE_ONLY)
	public void setDropboxdate(String dropboxdate) {
		this.dropboxdate = dropboxdate;
	}
	@JsonProperty(value="careGiverDisabilityPrcnt", access=JsonProperty.Access.READ_ONLY)
	public String getCare_giver_disability_prcnt() {
		return care_giver_disability_prcnt;
	}
	
	@JsonProperty(value="care_giver_disability_prcnt", access=JsonProperty.Access.WRITE_ONLY)
	public void setCare_giver_disability_prcnt(String care_giver_disability_prcnt) {
		this.care_giver_disability_prcnt = care_giver_disability_prcnt;
	}
	
	@JsonProperty(value="careGiverDisabilityName", access=JsonProperty.Access.READ_ONLY)
	public String getCare_giver_disability_name() {
		return care_giver_disability_name;
	}
	@JsonProperty(value="care_giver_disability_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setCare_giver_disability_name(String care_giver_disability_name) {
		this.care_giver_disability_name = care_giver_disability_name;
	}
	
	@JsonProperty(value="kvCode", access=JsonProperty.Access.READ_ONLY)
	public String getKvCode() {
		return kvCode;
	}
	@JsonProperty(value="kv_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setKvCode(String kvCode) {
		this.kvCode = kvCode;
	}
	
	
	
	
	
}
