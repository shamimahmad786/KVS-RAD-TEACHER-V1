package com.example.MOERADTEACHER.common.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.bean.ExperienceBean;
import com.example.MOERADTEACHER.common.bean.TeacherProfileBeans;
import com.example.MOERADTEACHER.common.masterservice.MasterImpl;
import com.example.MOERADTEACHER.common.modal.KVTeacher;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
import com.example.MOERADTEACHER.common.repository.KVTeacherRepository;
import com.example.MOERADTEACHER.common.repository.TeacherFormStatusRepository;
import com.example.MOERADTEACHER.common.repository.TeacherProfileRepository;
import com.example.MOERADTEACHER.common.util.FixHashing;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;
import com.example.MOERADTEACHER.common.util.StaticReportBean;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KVTeacherImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(KVTeacherImpl.class);

	@Autowired
	KVTeacherRepository kvTeacherRepo;

	@Autowired
	TeacherProfileRepository teacherProfileRepository;

	@Autowired
	TeacherFormStatusRepository teacherFormStatusRepository;

	@Autowired
	NativeRepository nativeRepository;

	@Autowired
	MasterImpl masterImpl;

	public KVTeacher saveKvTeacher(KVTeacher data) {
		return kvTeacherRepo.save(data);
	}

	public List<KVTeacher> getKvTeacherByKvCode(String data) {
		return kvTeacherRepo.findByPresentKvCode(data);
	}

	public List<TeacherProfile> getKvTeacherByUdiseCode(String data) {
		// System.out.println("Udise--->"+data);

		Map<Integer, String> post = masterImpl.getPostNameAndTeacherTypeId();
		Map<Integer, String> subject = masterImpl.getSubjectName();

		System.out.println("data--->"+data);

		StaticReportBean sObj = new StaticReportBean();
		String query = "select tp.*, tfs.form1_status, tfs.form2_status , tfs.form3_status ,tfs.form4_status , tfs.form5_status ,\r\n"
				+ "tfs.form6_status , tfs.form7_status , tfs.final_status ,tfs.id \r\n"
				+ "from public.teacher_profile tp , public.teacher_form_status tfs \r\n"
				+ "where tp.teacher_id = tfs.teacher_id  \r\n"
				+ "and tp.kv_code ='" + data + "'  order by teacher_name";
		
		
		
		
		QueryResult qrObj = nativeRepository.executeQueries(query);
		sObj.setRowValue(qrObj.getRowValue());
		List<TeacherProfile> tp = new ArrayList<TeacherProfile>();
		
//		final ObjectMapper mapper = new ObjectMapper();
//	for(int i=0;i<qrObj.getRowValue().size();i++) {
//		final TeacherProfileBeans pojo = mapper.convertValue(qrObj.getRowValue().get(i), TeacherProfileBeans.class);
//		tp.add(pojo);
//	}
		
		for (int i = 0; i < qrObj.getRowValue().size(); i++) {
			TeacherProfile tps = new TeacherProfile();
			try {
				tps.setTeacherId(Integer.parseInt(String.valueOf(qrObj.getRowValue().get(i).get("teacher_id"))));
				tps.setTeacherName(String.valueOf(qrObj.getRowValue().get(i).get("teacher_name")));
				tps.setTeacherGender(String.valueOf(qrObj.getRowValue().get(i).get("teacher_gender")));
				tps.setTeacherDob(String.valueOf(qrObj.getRowValue().get(i).get("teacher_dob")));
				tps.setTeacherEmployeeCode(String.valueOf(qrObj.getRowValue().get(i).get("teacher_employee_code")));
				tps.setTeacherSocialCategory(String.valueOf(qrObj.getRowValue().get(i).get("teacher_social_category")));
				tps.setTeacherMobile(String.valueOf(qrObj.getRowValue().get(i).get("teacher_mobile")));
				tps.setTeacherEmail(String.valueOf(qrObj.getRowValue().get(i).get("teacher_email")));
				tps.setTeacherReligion(String.valueOf(qrObj.getRowValue().get(i).get("teacher_religion")));
				tps.setTeacherNationality(String.valueOf(qrObj.getRowValue().get(i).get("teacher_nationality")));
				tps.setTeacherBloodGroup(String.valueOf(qrObj.getRowValue().get(i).get("teacher_blood_group")));
				tps.setTeacherPermanentAddress(
						String.valueOf(qrObj.getRowValue().get(i).get("teacher_permanent_address")));
				tps.setTeacherParmanentState(String.valueOf(qrObj.getRowValue().get(i).get("teacher_parmanent_state")));
				tps.setTeacherPermanentDistrict(
						String.valueOf(qrObj.getRowValue().get(i).get("teacher_permanent_district")));
				tps.setTeacherPermanentPin(String.valueOf(qrObj.getRowValue().get(i).get("teacher_permanent_pin")));
				tps.setTeacherCorrespondenceAddress(
						String.valueOf(qrObj.getRowValue().get(i).get("teacher_correspondence_address")));
				tps.setTeacherCorrespondenceState(
						String.valueOf(qrObj.getRowValue().get(i).get("teacher_correspondence_state")));
				tps.setTeacherCorrespondenceDistrict(
						String.valueOf(qrObj.getRowValue().get(i).get("teacher_correspondence_district")));
				tps.setTeacherCorrespondencePin(
						String.valueOf(qrObj.getRowValue().get(i).get("teacher_correspondence_pin")));
				tps.setTeacherPersonnelIdentification(
						String.valueOf(qrObj.getRowValue().get(i).get("teacher_personnel_identification")));
				tps.setTeacherPanNumber(String.valueOf(qrObj.getRowValue().get(i).get("teacher_pan_number")));
				tps.setTeacherAadhaarNumber(String.valueOf(qrObj.getRowValue().get(i).get("teacher_aadhaar_number")));
				tps.setTeacherPassportNumber(String.valueOf(qrObj.getRowValue().get(i).get("teacher_passport_number")));
				tps.setTeacherDisabilityYn(String.valueOf(qrObj.getRowValue().get(i).get("teacher_disability_yn")));
				tps.setTeacherDisabilityType(String.valueOf(qrObj.getRowValue().get(i).get("teacher_disability_type")));
				tps.setTeacherDisabilityFromBirthYn(
						String.valueOf(qrObj.getRowValue().get(i).get("teacher_disability_from_birth_yn")));
				tps.setTeacherDisabilityDate(String.valueOf(qrObj.getRowValue().get(i).get("teacher_disability_date")));
				tps.setTeacherDisabilityPrcnt(
						String.valueOf(qrObj.getRowValue().get(i).get("teacher_disability_prcnt")));
				tps.setTeacherDisabilityCertAuthority(
						String.valueOf(qrObj.getRowValue().get(i).get("teacher_disability_cert_authority")));
				tps.setTeacherDisabilityCertNumber(
						String.valueOf(qrObj.getRowValue().get(i).get("teacher_disability_cert_number")));
				tps.setWorkExperiencePositionTypePresentKv(
						String.valueOf(qrObj.getRowValue().get(i).get("work_experience_position_type_present_kv")));
				tps.setWorkExperienceWorkStartDatePresentKv(
						String.valueOf(qrObj.getRowValue().get(i).get("work_experience_work_start_date_present_kv")));

//				// System.out.println(qrObj.getRowValue().get(i).get("work_experience_id_present_kv"));

				tps.setWorkExperienceIdPresentKv(Integer
						.parseInt(String.valueOf(qrObj.getRowValue().get(i).get("work_experience_id_present_kv"))));
				tps.setWorkExperiencePositionTypePresentStationStartDate(String.valueOf(
						qrObj.getRowValue().get(i).get("work_experience_position_type_present_station_start_date")));
				tps.setWorkExperienceAppointedForSubject(
						String.valueOf(qrObj.getRowValue().get(i).get("work_experience_appointed_for_subject")));
				tps.setLastPromotionId(String.valueOf(qrObj.getRowValue().get(i).get("last_promotion_id")));
				tps.setLastPromotionPositionType(
						String.valueOf(qrObj.getRowValue().get(i).get("last_promotion_position_type")));
				tps.setLastPromotionPositionDate(
						String.valueOf(qrObj.getRowValue().get(i).get("last_promotion_position_date")));
				tps.setTetQualifiedYn(String.valueOf(qrObj.getRowValue().get(i).get("tet_qualified_yn")));
				tps.setTetQualifingYear(String.valueOf(qrObj.getRowValue().get(i).get("tet_qualifing_year")));
				tps.setTeacherTempId(String.valueOf(qrObj.getRowValue().get(i).get("teacher_temp_id")));
//				tps.setTid(Integer.parseInt(String.valueOf(qrObj.getRowValue().get(i).get("tid"))));
				tps.setTeacherSystemGeneratedCode(
						String.valueOf(qrObj.getRowValue().get(i).get("teacher_system_generated_code")));
				tps.setTeacherAccountId(String.valueOf(qrObj.getRowValue().get(i).get("teacher_account_id")));
				tps.setCurrentUdiseSchCode(String.valueOf(qrObj.getRowValue().get(i).get("current_udise_sch_code")));
				tps.setSchoolId(String.valueOf(qrObj.getRowValue().get(i).get("school_id")));
				tps.setDropBoxFlag(Integer.parseInt(String.valueOf(qrObj.getRowValue().get(i).get("drop_box_flag"))));
				tps.setVerifyFlag(String.valueOf(qrObj.getRowValue().get(i).get("verify_flag")));
//				tps.setTransferedUdiseSchCode(String.valueOf(qrObj.getRowValue().get(i).get("transfered_udise_sch_code")));
//				tps.setDropboxFeedback(String.valueOf(qrObj.getRowValue().get(i).get("dropbox_feedback")));
				tps.setCreatedBy(String.valueOf(qrObj.getRowValue().get(i).get("created_by")));
//				tps.setCreatedTime(Date.parse(String.valueOf(qrObj.getRowValue().get(i).get("created_time"))));
				tps.setModifiedBy(String.valueOf(qrObj.getRowValue().get(i).get("modified_by")));
//				tps.setModifiedTime(String.valueOf(qrObj.getRowValue().get(i).get("modified_time")));
				tps.setVerifiedType(String.valueOf(qrObj.getRowValue().get(i).get("verified_type")));
				tps.setTeachingNonteaching(String.valueOf(qrObj.getRowValue().get(i).get("teaching_nonteaching")));
//				tps.setVersionNo(Integer.parseInt(String.valueOf(qrObj.getRowValue().get(i).get("version_no"))));
				tps.setNatureOfAppointment(String.valueOf(qrObj.getRowValue().get(i).get("nature_of_appointment")));
//				tps.setTeacherProfileTeacherId(String.valueOf(qrObj.getRowValue().get(i).get("teacher_profile_teacher_id")));
				tps.setForm1Status(String.valueOf(qrObj.getRowValue().get(i).get("form1_status")));
				tps.setForm2Status(String.valueOf(qrObj.getRowValue().get(i).get("form2_status")));
				tps.setForm3Status(String.valueOf(qrObj.getRowValue().get(i).get("form3_status")));
				tps.setForm4Status(String.valueOf(qrObj.getRowValue().get(i).get("form4_status")));
				tps.setForm5Status(String.valueOf(qrObj.getRowValue().get(i).get("form5_status")));
				tps.setForm6Status(String.valueOf(qrObj.getRowValue().get(i).get("form6_status")));
				tps.setForm7Status(String.valueOf(qrObj.getRowValue().get(i).get("form7_status")));
				tps.setFinalStatus(String.valueOf(qrObj.getRowValue().get(i).get("final_status")));
				tps.setId(Integer.parseInt(String.valueOf(qrObj.getRowValue().get(i).get("id"))));
				tps.setMaritalStatus(String.valueOf(qrObj.getRowValue().get(i).get("marital_status")));
				tps.setSpouseStatus(String.valueOf(qrObj.getRowValue().get(i).get("spouse_status")));
				tps.setSpouseEmpCode(String.valueOf(qrObj.getRowValue().get(i).get("spouse_emp_code")));
				tps.setSpouseName(String.valueOf(qrObj.getRowValue().get(i).get("spouse_name")));
				tps.setSpousePost(String.valueOf(qrObj.getRowValue().get(i).get("spouse_post")));
				tps.setSpouseStationName(String.valueOf(qrObj.getRowValue().get(i).get("spouse_station_name")));
				tps.setSpouseStationCode(String.valueOf(qrObj.getRowValue().get(i).get("spouse_station_code")));
				tps.setSpecialRecruitmentYn(String.valueOf(qrObj.getRowValue().get(i).get("special_recruitment_yn")));
//                
				tps.setShiftChangeSameSchool(
						String.valueOf(qrObj.getRowValue().get(i).get("shift_change_same_school")));
				tps.setSingleParentStatusYn(String.valueOf(qrObj.getRowValue().get(i).get("single_parent_status_yn")));
				tps.setPostName(post.get(Integer
						.parseInt(String.valueOf(qrObj.getRowValue().get(i).get("last_promotion_position_type")))));

				if (!String.valueOf(qrObj.getRowValue().get(i).get("work_experience_appointed_for_subject"))
						.equalsIgnoreCase("")
						&& !String.valueOf(qrObj.getRowValue().get(i).get("work_experience_appointed_for_subject"))
								.equalsIgnoreCase(null)) {
					tps.setSubjectName(subject.get(Integer.parseInt(
							String.valueOf(qrObj.getRowValue().get(i).get("work_experience_appointed_for_subject")))));
			
				}

				tp.add(tps);
			} catch (Exception ex) {
				LOGGER.warn("message", ex);
			}
		}

		return tp;

//			return sObj;
//		teacherFormStatusRepository.findAllByTeacherId(teacherId)
//		return teacherProfileRepository.findAllByCurrentUdiseSchCodeOrderByTeacherNameAsc(data);
	}

	public List<TeacherProfile> getTeacherByMobile(String data) {
		return teacherProfileRepository.findAllByTeacherMobile(data);
	}

	public Map<String, Object> getTeacherDublicateMobile(String data) {
//		// System.out.println("data---->"+data);
		List<TeacherProfile> teacherObj = teacherProfileRepository.findAllByTeacherMobile(data);
		Map<String, Object> obj = new HashMap<String, Object>();
		if (teacherObj.size() > 1) {
			obj.put("status", 0);
		} else {
			obj.put("status", 1);
		}
		return obj;
	}

	public TeacherProfile getTeacherByAccountId(String data) throws Exception {
//		// System.out.println("data---->"+data);
		FixHashing hashObj = new FixHashing();
		System.out.println("DecryptedHash---->" + hashObj.decrypt(data));
		TeacherProfile teacherObj = teacherProfileRepository.findAllByTeacherAccountId(hashObj.decrypt(data));
		return teacherObj;
	}

}
