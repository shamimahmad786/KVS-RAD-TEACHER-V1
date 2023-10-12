package com.example.MOERADTEACHER.common.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestContextHolder;

import com.example.MOERADTEACHER.common.modal.KvRegionMaster;
import com.example.MOERADTEACHER.common.util.NativeRepository;

@Service
public class HistoryImpl {

	@Autowired
	NativeRepository nativeRepository;

	public void updateProfileHistory(Integer teacherId, String updateby) {
		 RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		 // Get from RequestAttributes In order to get HttpServletRequest Information about 
		 HttpServletRequest request = (HttpServletRequest)requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
			
		 
		 // System.out.println("updateby------------------->"+updateby);
		 
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    // System.out.println(request.getRemoteAddr());
		try {
			try {
			
		String	query1="insert into  history.teacher_profile_history (teacher_id,teacher_name,teacher_gender,teacher_dob,teacher_employee_code,teacher_social_category,teacher_mobile,teacher_email,teacher_religion,teacher_nationality,teacher_blood_group,teacher_permanent_address "
				+ ",teacher_parmanent_state,teacher_permanent_district,teacher_permanent_pin,teacher_correspondence_address,teacher_correspondence_state,teacher_correspondence_district,teacher_correspondence_pin,teacher_personnel_identification "
				+ ",teacher_pan_number,teacher_aadhaar_number,teacher_passport_number,teacher_disability_yn,teacher_disability_type,teacher_disability_from_birth_yn,teacher_disability_date,teacher_disability_prcnt,teacher_disability_cert_authority "
				+ ",teacher_disability_cert_number,work_experience_position_type_present_kv,work_experience_work_start_date_present_kv,work_experience_id_present_kv,work_experience_position_type_present_station_start_date,work_experience_appointed_for_subject "
				+ ",last_promotion_id,last_promotion_position_type,last_promotion_position_date,tet_qualified_yn,tet_qualifing_year,teacher_temp_id,tid,teacher_system_generated_code,teacher_account_id,current_udise_sch_code,school_id "
				+ ",drop_box_flag,verify_flag,transfered_udise_sch_code,dropbox_feedback,modified_by,modified_time,verified_type,teaching_nonteaching,version_no,nature_of_appointment,teacher_profile_teacher_id,spouse_emp_code "
				+ ",spouse_post,spouse_station_code,spouse_status,spouse_name,spouse_station_name,marital_status,school_remarks,teacher_remarks,dropbox_date,ipaddress,created_by,created_time ) select teacher_id,teacher_name,teacher_gender,teacher_dob,teacher_employee_code,teacher_social_category,teacher_mobile,teacher_email,teacher_religion,teacher_nationality,teacher_blood_group,teacher_permanent_address "
				+ ",teacher_parmanent_state,teacher_permanent_district,teacher_permanent_pin,teacher_correspondence_address,teacher_correspondence_state,teacher_correspondence_district,teacher_correspondence_pin,teacher_personnel_identification "
				+ ",teacher_pan_number,teacher_aadhaar_number,teacher_passport_number,teacher_disability_yn,teacher_disability_type,teacher_disability_from_birth_yn,teacher_disability_date,teacher_disability_prcnt,teacher_disability_cert_authority "
				+ ",teacher_disability_cert_number,work_experience_position_type_present_kv,work_experience_work_start_date_present_kv,work_experience_id_present_kv,work_experience_position_type_present_station_start_date,work_experience_appointed_for_subject "
				+ ",last_promotion_id,last_promotion_position_type,last_promotion_position_date,tet_qualified_yn,tet_qualifing_year,teacher_temp_id,tid,teacher_system_generated_code,teacher_account_id,current_udise_sch_code,school_id "
				+ ",drop_box_flag,verify_flag,transfered_udise_sch_code,dropbox_feedback,modified_by,modified_time,verified_type,teaching_nonteaching,version_no,nature_of_appointment,teacher_profile_teacher_id,spouse_emp_code "
				+ ",spouse_post,spouse_station_code,spouse_status,spouse_name,spouse_station_name,marital_status,school_remarks,teacher_remarks,dropbox_date,"
				//+ "'10.25.26.10','kv_9999,kv_9999','Tue May 24 11:28:49 IST 2022' from teacher_profile where teacher_id=84794"
							
										+ "'"+request.getRemoteAddr()+"','"+updateby+"','"+date+"' from teacher_profile where teacher_id="+teacherId;
											
				nativeRepository.insertQueries(query1);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
//			
//			try {
//		
//		
//		String query2="insert into  history.teacher_awards_history (id,award_by,award_name,award_year,remarks,teacher_id,award_id,verify_flag,modified_by,modified_time,ipaddress,created_by,created_time)  select id,award_by,award_name,award_year,remarks,teacher_id,award_id,verify_flag,modified_by,modified_time,'"+request.getRemoteAddr()+"','"+updateby+"','"+date+"' from public.teacher_awards where teacher_id="+teacherId;
//	
//		
//				nativeRepository.insertQueries(query2);
//			}catch(Exception ex) {
//				ex.printStackTrace();
//			}
////			
//			try {
//		
//		String query3="insert into  history.teacher_educational_qualification_detail_history (teacher_educational_qualification_id,teacher_id,teacher_qualification_type,qualification_degree_id,qualification_degree_major,qualification_degree_minor,board_university,institution "
//										+ ",year_of_passing,total_marks,marks_obtaioned,verify_flag,verified_type,modified_by,modified_time,ipaddress,created_by,created_time) select teacher_educational_qualification_id,teacher_id,teacher_qualification_type,qualification_degree_id,qualification_degree_major,qualification_degree_minor,board_university,institution "
//										+ ",year_of_passing,total_marks,marks_obtaioned,verify_flag,verified_type,modified_by,modified_time,'"+request.getRemoteAddr()+"','"+updateby+"','"+date+"' from public.teacher_educational_qualification_detail where teacher_id="+teacherId;
//		
//		
//		
//				nativeRepository.insertQueries(query3);
//
//			}catch(Exception ex) {
//				ex.printStackTrace();
//			}
////			
//			try {
//		
//		String query4="insert into history.teacher_professional_qualification_detail_history (teacher_professional_qualification_id,teacher_id,qualification_degree_id,qualification_degree_major,qualification_degree_minor,board_university,institution,year_of_passing "
//									+ "	,total_marks,marks_obtaioned,teacher_qualification_type,verify_flag,verified_type,modified_by,modified_time,ipaddress,created_by,created_time) select  teacher_professional_qualification_id,teacher_id,qualification_degree_id,qualification_degree_major,qualification_degree_minor,board_university,institution,year_of_passing "
//										+ "	,total_marks,marks_obtaioned,teacher_qualification_type,verify_flag,verified_type,modified_by,modified_time,'"+request.getRemoteAddr()+"','"+updateby+"','"+date+"' from public.teacher_professional_qualification_detail  where teacher_id ="+teacherId;
//
//		
//				nativeRepository.insertQueries(query4);
//
//				
//			}catch(Exception ex) {
//				ex.printStackTrace();
//			}
////			
////			
//			try {
//		
//		String query5="insert into history.teacher_promotion_detail_history (promotion_id,teacher_id,udise_sch_code,school_id,business_unit_code,business_unit_type_id,currently_working_yn,work_start_date,work_end_date,position_type "
//										+ "	,nature_of_appontment,verify_flag,verified_type,modified_by,modified_time,ipaddress,created_by,created_time) select promotion_id,teacher_id,udise_sch_code,school_id,business_unit_code,business_unit_type_id,currently_working_yn,work_start_date,work_end_date,position_type "
//										+ ",nature_of_appontment,verify_flag,verified_type,modified_by,modified_time,'"+request.getRemoteAddr()+"','"+updateby+"','"+date+"' from  public.teacher_promotion_detail where teacher_id ="+teacherId;
//				
//				nativeRepository.insertQueries(query5);
//				
//				
//				
//			}catch(Exception ex) {
//				ex.printStackTrace();
//			}
//			
			try {
		
		String query6="insert into history.teacher_work_experience_history (work_experience_id,teacher_id,udise_sch_code,school_id,work_start_date,work_end_date,position_type,nature_of_appointment,appointed_for_subject "
										+ "						,udise_school_name,shift_type,verify_flag,verified_type,modified_by,modified_time,ground_for_transfer,currently_active_yn "
									+ "						,ipaddress,created_by,created_time) select  work_experience_id,teacher_id,udise_sch_code,school_id,work_start_date,work_end_date,position_type,nature_of_appointment,appointed_for_subject "
										+ "						,udise_school_name,shift_type,verify_flag,verified_type,modified_by,modified_time,ground_for_transfer,currently_active_yn "
										+ "						,'"+request.getRemoteAddr()+"','"+updateby+"','"+date+"' from public.teacher_work_experience where teacher_id ="+teacherId;

//		System.out.println("query6--->"+query6);
						
				nativeRepository.insertQueries(query6);
				
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
//			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
