package com.example.MOERADTEACHER.common.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.MOERADTEACHER.common.bean.DropedTeacherDetails;
import com.example.MOERADTEACHER.common.bean.KVSchoolBean;
import com.example.MOERADTEACHER.common.bean.SchoolFetchTeacherBean;
import com.example.MOERADTEACHER.common.bean.TeacherProfileBean;
import com.example.MOERADTEACHER.common.bean.TeacherProfileBeanV2;
import com.example.MOERADTEACHER.common.bean.TransProfileBean;
import com.example.MOERADTEACHER.common.bean.TransferSpouseBean;
import com.example.MOERADTEACHER.common.bean.WorkExperienceBean;
import com.example.MOERADTEACHER.common.interfaces.TeacherInterface;
import com.example.MOERADTEACHER.common.master.GroundForTransfer;
import com.example.MOERADTEACHER.common.modal.Teacher;
//import com.example.MOERADTEACHER.common.modal.TeacherEducationalQualification;
import com.example.MOERADTEACHER.common.modal.TeacherFormStatus;
//import com.example.MOERADTEACHER.common.modal.TeacherProfessionalQualification;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
import com.example.MOERADTEACHER.common.modal.TeacherProfileConfirmation;
//import com.example.MOERADTEACHER.modal.TeacherProfileCurrectionInitiate;
//import com.example.MOERADTEACHER.modal.TeacherProfileHistory;
//import com.example.MOERADTEACHER.common.repository.TeacherAwardsRepository;
//import com.example.MOERADTEACHER.common.repository.TeacherEducationQualificationRepository;
import com.example.MOERADTEACHER.common.repository.TeacherExperienceRepository;
import com.example.MOERADTEACHER.common.repository.TeacherFormStatusRepository;
import com.example.MOERADTEACHER.common.repository.TeacherProfileConfirmationRepository;
//import com.example.MOERADTEACHER.common.repository.TeacherProfessionalQualificationRepository;
//import com.example.MOERADTEACHER.repository.TeacherProfileCurrectionInitiateRepository;
//import com.example.MOERADTEACHER.repository.TeacherProfileHistoryRepository;
import com.example.MOERADTEACHER.common.repository.TeacherProfileRepository;
import com.example.MOERADTEACHER.common.repository.TeacherRepository;
//import com.example.MOERADTEACHER.common.repository.TeacherTrainingRepository;
import com.example.MOERADTEACHER.common.repository.TeacherTransferProfileRepository;
import com.example.MOERADTEACHER.common.util.CustomFilter;
import com.example.MOERADTEACHER.common.util.FixHashing;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;
import com.example.MOERADTEACHER.common.util.RestService;
import com.example.MOERADTEACHER.common.util.StaticReportBean;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.me.user.UserService.user.service.RestMailService;

//import aj.org.objectweb.asm.TypeReference;

@Service
public class TeacherImpl implements TeacherInterface {

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	NativeRepository nativeRepository;

	@Autowired
	TeacherProfileRepository teacherProfileRepository;

//	@Autowired
//	TeacherTrainingRepository teacherTrainingRepository;

//	@Autowired
//	TeacherAwardsRepository teacherAwardsRepository;

//	@Autowired
//	TeacherEducationQualificationRepository teacherEducationalQualificationRepository;
//	@Autowired
//	TeacherProfessionalQualificationRepository teacherProfessionalQualificationRepository;
	@Autowired
	TeacherExperienceRepository teacherExperienceRepository;

//	@Autowired
//	TeacherProfileCurrectionInitiateRepository teacherProfileCurrectionInitiateRepository;

	@Autowired
	TeacherFormStatusRepository teacherFormStatusRepository;

//	@Autowired
//	TeacherProfileHistoryRepository teacherProfileHistoryRepository;
	
	@Autowired
	HistoryImpl historyImpl;
	
	@Autowired
	RestService restService;
	
	@Autowired
	TeacherTransferProfileRepository   teacherTransferProfileRepository;
	
	@Autowired
	TeacherProfileConfirmationRepository teacherProfileConfirmationRepository;
	
//	private final RestTemplate restTemplate = new RestTemplate();

	private static final Logger LOGGER = LoggerFactory.getLogger(TeacherImpl.class);

	@Override
	public List<Teacher> getTeacherBySchool(String udiseCode) {
		return teacherRepository.findAllByUdiseSchCode(udiseCode);
	}

//	public Teacher saveTeacher(Teacher data) throws Exception {
//		// System.out.println("update---->"+data.getName());
//		return teacherRepository.save(data);
//	}
	@Override
//	 @Transactional("commonTransactionManager")
	public TeacherProfile saveTeacher(TeacherProfile data) {
//		Integer teacherId = 0;
//		if (data.getTeacherId() == null || !(data.getTeacherId() > 0)) {
//			QueryResult qrObj = nativeRepository.executeQueries("select  max(teacher_id)  from public.teacher_profile");
//			  System.out.println(qrObj);
//			if(qrObj.getRowValue().size()>0 && qrObj.getRowValue().get(0).get("max")!=null) {
//			teacherId = Integer.parseInt(String.valueOf(qrObj.getRowValue().get(0).get("max")));
//			}else if(qrObj.getRowValue().get(0).get("max")==null) {
//			teacherId=1;	
//			}
//			teacherId = teacherId + 1;
//			data.setTeacherId(teacherId);
//		}
		
		return teacherProfileRepository.save(data);
	}

	@Override
	public StaticReportBean verifyTeacher(TeacherProfile data) {
//		Teacher result=teacherImpl.verifyTeacher(data);
		StaticReportBean sObj = new StaticReportBean();

//		try {
//			if(data.getVerifyFlag() !=null) {
//			if(data.getVerifyFlag().equalsIgnoreCase("Q")) {
//				nativeRepository.executeQueries("INSERT INTO teacher_profile_currection_initiate_history SELECT * FROM teacher_profile_currection_initiate where teacherId="+data.getTeacherId());			
//			}
//			}
//		}catch(Exception ex) {
//			// System.out.println("Error in teacher profile correction initiate");
//			ex.printStackTrace();
//		}

		try {
//			historyImpl.updateProfileHistory(data.getTeacherId(), data.getCurrentUdiseSchCode());
//			nativeRepository
//					.insertQueries("insert into teacher_profile_history select * from teacher_profile where teacher_id="
//							+ data.getTeacherId());
		} catch (Exception ex) {
			LOGGER.warn("message", ex);
//			LOGGER.error();
		}

//		try {
//			nativeRepository.updateQueries("update teacher_profile set verify_flag='" + data.getFinalStatus()
//					+ "'  where teacher_id=" + data.getTeacherId() + " and current_udise_sch_code='"
//					+ data.getCurrentUdiseSchCode() + "'");
//		} catch (Exception ex) {
//			LOGGER.warn("--message--", ex);
////			ex.printStackTrace();
//		}

		QueryResult qrObj1 = nativeRepository.executeQueries(
				"select teacher_system_generated_code,verify_flag from teacher_profile where teacher_id="
						+ data.getTeacherId());
		// System.out.println(qrObj1.getRowValue());
		sObj.setColumnName(qrObj1.getColumnName());
		sObj.setRowValue(qrObj1.getRowValue());
		sObj.setColumnDataType(qrObj1.getColumnDataType());
		sObj.setStatus("1");
		return sObj;

		// return ResponseEntity.ok(result);9/38 /
	}

	@Override
	public TeacherProfile getTeacherByTeacherId(Integer teacherId) {
//		// System.out.println("update---->"+data.getName());
		return teacherProfileRepository.findAllByTeacherId(teacherId);
	}
	
	@Override
	public TeacherProfile getTeacherByTeacherEmployeeCode(String teacherEmployeeCode) {
//		// System.out.println("update---->"+data.getName());
		return teacherProfileRepository.findAllByTeacherEmployeeCode(teacherEmployeeCode);
	}

//	@Override
//	public TeacherProfileCurrectionInitiate teacherProfileQueryInitiate(TeacherProfileCurrectionInitiate data) {
//
//		try {
//			nativeRepository.updateQueries(
//					"update teacher_profile set verify_flag='Q'  where teacher_id=" + data.getTeacherId());
//		} catch (Exception ex) {
//			LOGGER.warn("--message--", ex);
//		}
//		return teacherProfileCurrectionInitiateRepository.save(data);
//	}
//
//	@Override
//	public TeacherProfileCurrectionInitiate getTeacherProfileQueryInitiate(Integer teacherId) {
//
//		return teacherProfileCurrectionInitiateRepository.findAllByTeacherId(teacherId);
//	}

	@Override
	public Map<String, Object> updateTeacherSystemGeneratedCode(TeacherProfile data) {
		Map<String, Object> statusObj = new HashMap<String, Object>();
		FixHashing hashObj = null;
		try {
			hashObj = new FixHashing();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
		//	// System.out.println(hashObj.decrypt(String.valueOf(data.getTeacherAccountId())));
			if (data.getTeacherSystemGeneratedCode() != null && data.getTeacherAccountId() != null
					&& data.getTeacherId() != null) {
				nativeRepository.updateQueries("update teacher_profile set teacher_system_generated_code='"
						+ data.getTeacherSystemGeneratedCode() + "' ,verify_flag='SI',  teacher_account_id='"
//						+ hashObj.decrypt(String.valueOf(data.getTeacherAccountId())) + "'  where teacher_id="						
                        + String.valueOf(data.getTeacherAccountId()) + "'  where teacher_id="
						+ data.getTeacherId());
			}
		} catch (Exception ex) {
			LOGGER.warn("--message--", ex);
		}

		statusObj.put("status", 1);
		statusObj.put("verifyFlag", "SI");

		return statusObj;
	}

	@Override
	public TeacherFormStatus updatdFlag(TeacherFormStatus teacherId) {
		try {
			nativeRepository.updateQueries("update teacher_profile set verify_flag='" + teacherId.getFinalStatus()
					+ "' where teacher_id=" + teacherId.getTeacherId());
		} catch (Exception ex) {
			LOGGER.warn("--message--", ex);
		}
		
//		try {
//			historyImpl.updateProfileHistory(teacherId.getTeacherId(), "12345");
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}

		return teacherFormStatusRepository.save(teacherId);
	}

	@Override
	public TeacherFormStatus getUpdatdFlag(Integer teacherId) {
		 System.out.println("Get updated flag--->"+teacherId);
		return teacherFormStatusRepository.findAllByTeacherId(teacherId);
	}

	@Override
	public TeacherFormStatus updateFlagByTeachId(TeacherFormStatus data,String username) {

		try {

//		if(data.getTeacherSystemGeneratedCode() !=null && data.getTeacherAccountId() !=null && data.getTeacherId() !=null) {
			nativeRepository.updateQueries("update public.teacher_form_status set form1_status='" + data.getForm1Status()
					+ "',form2_status='" + data.getForm2Status() + "',form3_status='" + data.getForm3Status()
					+ "',form4_status='" + data.getForm4Status() 
					+ "',final_status='" + data.getFinalStatus() + "' where teacher_id=" + data.getTeacherId());
//		}
		} catch (Exception ex) {
			LOGGER.warn("--message--", ex);
		}

		try {
			// System.out.println("data.getFinalStatus()--->" + data.getFinalStatus());
			nativeRepository.updateQueries("update public.teacher_profile set verify_flag='" + data.getFinalStatus()
					+ "' where teacher_id=" + data.getTeacherId());
		} catch (Exception ex) {
			LOGGER.warn("--message--", ex);
		}

		try {
			historyImpl.updateProfileHistory(data.getTeacherId(), username);
//			nativeRepository
//					.insertQueries("insert into teacher_profile_history select * from teacher_profile where teacher_id="
//							+ data.getTeacherId());
		} catch (Exception ex) {
			LOGGER.warn("--message--", ex);
		}

		return teacherFormStatusRepository.findAllByTeacherId(data.getTeacherId());
	}

	@Override
	public Map<String, List<Object>> getTeacherHistryByTeacherId(Integer data) {

		List<Object> profileMap = new ArrayList<Object>();
		Map<String, List<Object>> obj = new HashMap<String, List<Object>>();
//		TeacherProfileHistory profileObj = teacherProfileHistoryRepository
//				.findFirst1ByTeacherIdOrderByModifiedTimeAsc(data);
//		profileMap.add(profileObj);
		obj.put("profileHistor", profileMap);
		return obj;
	}

	@Override
	public TeacherFormStatus saveStatus(TeacherProfile data) {
		TeacherFormStatus status = new TeacherFormStatus();
		status.setTeacherId(data.getTeacherId());
		return teacherFormStatusRepository.save(status);
	}

	@Override
	public DropedTeacherDetails checkEmployeeCode(String data) {
		StaticReportBean sb = new StaticReportBean();
		DropedTeacherDetails dp = new DropedTeacherDetails();
		QueryResult qrObj = nativeRepository.executeQueries(
				"select tp.teacher_id,tp.drop_box_flag,tp.teacher_name,tp.teacher_mobile,tp.teacher_email,tp.teacher_dob ,tp.current_udise_sch_code ,tfs.final_status ,k.kv_name,k.station_name from public.teacher_profile tp,public.teacher_form_status tfs,kv.kv_school_master k where tp.teacher_id=tfs.teacher_id and tp.current_udise_sch_code =k.udise_sch_code  and tp.teacher_employee_code='"
						+ data + "'");

		ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
		if(qrObj.getRowValue().size()>0) {
		dp = mapper.convertValue(qrObj.getRowValue().get(0), DropedTeacherDetails.class);
		}else {
			
		}

		return dp;
	}

	@Override
	public TeacherProfile changeTeacherSchool(SchoolFetchTeacherBean data) {
		Map<String, Object> mp = new HashMap<String, Object>();
		try {
			
			System.out.println(data.getTeacherId());
			System.out.println(data.getCurrentUdiseSchCode());
//			System.out.println(data.get);
			
			nativeRepository.updateQueries(
					"update public.teacher_profile set drop_box_flag =0 , \r\n" + "kv_code = '"
							+ data.getCurrentUdiseSchCode() + "' , current_udise_sch_code='" +data.getCurrentUdiseSchCode()+"' " + "where teacher_id = " + data.getTeacherId());

			nativeRepository.updateQueries("update public.teacher_work_experience wk\r\n" + "set kv_code ='"
					+ data.getCurrentUdiseSchCode() + "', udise_school_name='"+data.getKvName()+"' ,  udise_sch_code='" +data.getCurrentUdiseSchCode()+"' "+ ",    currently_active_yn = '1'\r\n"
					+ "from public.teacher_profile tp \r\n"
					+ "where tp.work_experience_id_present_kv = wk.work_experience_id and tp.teacher_id="
					+ data.getTeacherId());
			
			
			try {
//				this.restTemplate = restTemplateBuilder.build();
	         	HttpHeaders headers = new HttpHeaders();
	    	    headers.setAccept(Collections.singletonList(MediaType.TEXT_PLAIN));
	    	    
	    	    String requestJson="{\"teacherId\":'"+data.getTeacherId()+"',\"currentUdiseSchCode\":'"+data.getCurrentUdiseSchCode()+"',\"businessUnitTypeCode\":'"+data.getBusinessUnitTypeCode()+"'}".replaceAll("'", "\"");
//                String smsJSON="{ \"mobile\":'"+data.getMobile()+"', \"otpId\":\"OTP-2\", \"applicationId\":1, \"dynamicData\":['"+data.getName()+"',\"https://kvsonlinetransfer.kvs.gov.in\",'"+data.getUserid()+"',\"system123#\"] }".replaceAll("'", "\"");
	    	    //	    	    headers.set("Authorization", "Basic YXBpYXV0aDpwaW4=");
//	    	    HttpEntity request = new HttpEntity(headers);
//	    	    HttpEntity<MailBean> request = new HttpEntity<>(data, headers);
                requestJson=requestJson.replaceAll("'", "\"");
//                smsJSON=smsJSON.replaceAll("'", "\"");
                
                try {
	    	    HttpEntity<String> request = new HttpEntity<String>(requestJson,headers);
	    	    
//	    	    String url = "http://10.25.26.251:8090/api/user/updateRoleOnDropbox";
	    	    
//	            String url = "http://10.247.141.216:8080/UserService/api/user/updateRoleOnDropbox";
	    	    
	    	    
//	    	    
//	            this.restService.updateRole(requestJson);  // commented by shamim
                
                
                }catch(Exception ex) {
                	System.out.println("::::::::::::Error in get teacher from other school::::::::::::::::::::");
                	ex.printStackTrace();
                }

			}catch(Exception ex) {
				ex.printStackTrace();
			}
			

			return teacherProfileRepository.findAllByTeacherId(data.getTeacherId());
		} catch (Exception ex) {
			LOGGER.warn("--message--", ex);
		}

		return null;
//	return teacherFormStatusRepository.findAllByTeacherId(data.getTeacherId());
	}

	@Override
	public Map<String, Object> dropTeacherBySchool(String data) {
		Map<String, Object> mp = new HashMap<String, Object>();
		try {
			 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			    Date date = new Date();
			nativeRepository.updateQueries(
					"update public.teacher_profile set drop_box_flag=1, dropbox_date='"+dateFormat.format(date)+"' where teacher_id=" + Integer.parseInt(data));
			mp.put("status", 1);
		} catch (Exception ex) {
			mp.put("status", 0);
			LOGGER.warn("--message--", ex);
		}
		return mp;
	}

	@Override
	public List<TeacherProfileBean> getOutboxTeacherByUdisecode(String data) {
		final ObjectMapper mapper = new ObjectMapper();
		List<TeacherProfileBean> profilePojo = null;
		// System.out.println(data);
		
//		String profileQuery = "select tp.*,TO_CHAR(dropbox_date, 'DD/MM/YYYY') as dropboxdate ,public.get_film6('kv.kv_school_master','kv_name','udise_sch_code=''"+data+"''') as school_name from teacher_profile tp where tp.current_udise_sch_code='"+data+"'  and tp.drop_box_flag=1";
//		String profileQuery = "select tp.*,TO_CHAR(dropbox_date, 'DD/MM/YYYY') as dropboxdate ,public.get_film6('kv.kv_school_master','kv_name','udise_sch_code=''"+data+"''') as school_name from teacher_profile tp where  tp.drop_box_flag=1";
		String profileQuery  ="select TO_CHAR(dropbox_date, 'DD/MM/YYYY') as dropboxdate ,tp.teacher_employee_code, tp.teacher_id,tp.teacher_name,tp.teacher_gender,tp.teacher_dob,tp.teaching_nonteaching,tp.dropbox_date,kvs.kv_name as school_name from public.teacher_profile tp, kv.kv_school_master kvs where tp.current_udise_sch_code=kvs.udise_sch_code and  tp.drop_box_flag=1";

		try {
// System.out.println("Query--->"+profileQuery);
TypeReference<List<TeacherProfileBean>> typeRef = new TypeReference<List<TeacherProfileBean>>() {
};
			QueryResult qrObj = nativeRepository.executeQueries(profileQuery);
			profilePojo = mapper.convertValue(qrObj.getRowValue(),typeRef);
		} catch (Exception ex) {
			ex.printStackTrace();
			LOGGER.warn("--message--", ex);
		}
		
//		// System.out.println(profilePojo.get(0).getTeacher_id());
//		return teacherProfileRepository.findByCurrentUdiseSchCodeAndDropBoxFlag(data, 1);
		return profilePojo;
	}

	@Override
	public Map<String, Object> getTeacherDetailsForConfirmation(Integer data) {
		final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
		TeacherProfileBean profilePojo = null;
		QueryResult subjectMap = null;
		QueryResult degreeMap = null;
		KVSchoolBean kvPojo=null;
		TransProfileBean transPojo=null;
		String profileQuery = "\r\n"
				+ "select teacher_id,kv_code,teacher_name,teacher_gender,teacher_dob,teacher_employee_code,teacher_social_category,teacher_mobile,teacher_email,teacher_religion,teacher_nationality,teacher_blood_group,teacher_permanent_address,public.get_film6('master.mst_state_live','state_name','state_id::varchar = ( select teacher_parmanent_state  from public.teacher_profile tp where teacher_id="
				+ data + " )') as teacher_parmanent_state\r\n"
				+ ",public.get_film6('master.mst_district_live','district_name','district_id::varchar = ( select teacher_permanent_district  from public.teacher_profile tp where teacher_id="
				+ data
				+ " )') as teacher_permanent_district,teacher_permanent_pin,teacher_correspondence_address,public.get_film6('master.mst_state_live','state_name','state_id::varchar = ( select teacher_correspondence_state  from public.teacher_profile tp where teacher_id="
				+ data
				+ " )') as teacher_correspondence_state, public.get_film6('master.mst_district_live','district_name','district_id::varchar = ( select teacher_correspondence_district  from public.teacher_profile tp where teacher_id="
				+ data
				+ " )') as teacher_correspondence_district,teacher_correspondence_pin,teacher_personnel_identification,teacher_pan_number\r\n"
				+ ",teacher_aadhaar_number,teacher_passport_number,teacher_disability_yn,teacher_disability_type,teacher_disability_from_birth_yn,teacher_disability_date,teacher_disability_prcnt,teacher_disability_cert_authority\r\n"
				+ ",teacher_disability_cert_number,work_experience_work_start_date_present_kv, work_experience_id_present_kv,work_experience_position_type_present_station_start_date\r\n"
				+ ",public.get_film6('master.mst_teacher_subject','subject_name','subject_id::varchar in ( select work_experience_appointed_for_subject from teacher_profile where teacher_id="
				+ data
				+ " )') as  work_experience_appointed_for_subject,last_promotion_id, public.get_film6('master.mst_teacher_position_type','organization_teacher_type_name','teacher_type_id::varchar = ( select last_promotion_position_type  from public.teacher_profile tp where teacher_id="
				+ data
				+ " )') as last_promotion_position_type,last_promotion_position_date,tet_qualified_yn,tet_qualifing_year,teacher_temp_id\r\n"
				+ ",tid,teacher_system_generated_code,teacher_account_id,current_udise_sch_code,school_id,drop_box_flag,verify_flag,transfered_udise_sch_code,dropbox_feedback,created_by\r\n"
				+ ",created_time,modified_by,modified_time,verified_type,teaching_nonteaching,version_no,nature_of_appointment,teacher_profile_teacher_id,spouse_emp_code, public.get_film6('master.mst_teacher_position_type','organization_teacher_type_name','teacher_type_id::varchar = ( select spouse_post  from public.teacher_profile tp where teacher_id="
				+ data + " )') as spouse_post,spouse_station_code\r\n"
				+ ",spouse_status,spouse_name,spouse_station_name,marital_status,school_remarks,teacher_remarks from teacher_profile where teacher_id="
				+ data + "\r\n" + "";

		try {
 System.out.println("profileQuery Query--->"+profileQuery);
			QueryResult qrObj = nativeRepository.executeQueries(profileQuery);
			profilePojo = mapper.convertValue(qrObj.getRowValue().get(0), TeacherProfileBean.class);
		} catch (Exception ex) {
			LOGGER.warn("--message--", ex);
		}
//		List<TeacherEducationalQualification> teacherObj = null;
//		List<TeacherProfessionalQualification> professionalSubject = null;
		List<WorkExperienceBean> wb = null;
//		try {
//			subjectMap = nativeRepository.executeQueries("select * from master.teacher_qual_subject");
//			degreeMap = nativeRepository.executeQueries("select * from master.teacher_qual_master");
//		} catch (Exception ex) {
//			LOGGER.warn("--message--", ex);
//		}
//		try {
//			teacherObj = teacherEducationalQualificationRepository.findAllByTeacherId(data);
//			for (int i = 0; i < teacherObj.size(); i++) {
//				mapSubject(teacherObj.get(i), subjectMap.getRowValue(), degreeMap.getRowValue());
//			}
//
//		} catch (Exception ex) {
//			LOGGER.warn("--message--", ex);
//		}

//		try {
//			professionalSubject = teacherProfessionalQualificationRepository.findAllByTeacherId(data);
//
//			for (int i = 0; i < professionalSubject.size(); i++) {
//				mapProSubject(professionalSubject.get(i), subjectMap.getRowValue(), degreeMap.getRowValue());
//			}
//
//		} catch (Exception ex) {
//			LOGGER.warn("--message--", ex);
//		}

		try {
			QueryResult qrObj = nativeRepository.executeQueries(
					"select  work_experience_id,teacher_id,udise_sch_code,school_id,TO_CHAR(work_start_date,'DD-MM-YYYY') as work_start_date,TO_CHAR(work_end_date,'DD-MM-YYYY') as work_end_date ,mtpt.organization_teacher_type_name as position_type,nature_of_appointment,udise_school_name,shift_type,verify_flag,verified_type\r\n"
							+ ",created_by,created_time,modified_by,modified_time,ground_for_transfer,currently_active_yn,mts.subject_name as appointed_for_subject from teacher_work_experience tws,master.mst_teacher_subject mts, master.mst_teacher_position_type mtpt where tws.teacher_id ="
							+ data
							+ " and tws.appointed_for_subject::numeric =mts.subject_id and mtpt.teacher_type_id::varchar=tws.position_type  order by work_start_date::date desc \r\n"
							+ "");
			TypeReference<LinkedList<WorkExperienceBean>> typeRef = new TypeReference<LinkedList<WorkExperienceBean>>() {
			};
			wb = mapper.convertValue(qrObj.getRowValue(), typeRef);
			
			
			
			for(int i=0;i<wb.size();i++) {
				
				System.out.println(wb.get(i).getWork_start_date());
			String groundForTransfer="";
//				QueryResult qrObj1 = nativeRepository.executeQueries("select * from public.teacher_transfer_ground where work_experienceid="+wb.get(i).getWork_experience_id());
//				for(int j=0;j<qrObj1.getRowValue().size();j++) {
//					groundForTransfer += GroundForTransfer.getGroundTransfer().get("G"+qrObj1.getRowValue().get(j).get("transfer_ground_id"))+",";
//				}
			groundForTransfer += GroundForTransfer.getGroundTransfer().get("G"+wb.get(i).getGround_for_transfer());
			System.out.println("groundForTransfer--->"+groundForTransfer);
				wb.get(i).setGround_for_transfer(groundForTransfer.replaceAll(",$", "") !=null?groundForTransfer.replaceAll(",$", ""):"");
			}
			
		} catch (Exception ex) {
			LOGGER.warn("--message--", ex);
		}

		
		try {
			QueryResult qrObj = nativeRepository.executeQueries("select station_name,station_code,kv_name,kv_code from  kv.kv_school_master where kv_code='"+profilePojo.getKvCode()+"'");
			kvPojo = mapper.convertValue(qrObj.getRowValue().get(0), KVSchoolBean.class);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		try {
			QueryResult qrObj = nativeRepository.executeQueries("select spouse_kvs_ynd,personal_status_mdgd,personal_status_spd,personal_status_dfpd,care_giver_faimly_ynd,memberjcm,absence_days_one,disciplinary_yn,surve_hard_yn from teacher_transfer_profile where teacher_id="+data);
			transPojo = mapper.convertValue(qrObj.getRowValue().get(0), TransProfileBean.class);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
//	// System.out.println(profilePojo.getWork_experience_position_type_present_kv());

		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("teacherProfile", profilePojo);
//		mp.put("awards", teacherAwardsRepository.findAllByTeacherId(data));
//		mp.put("training", teacherTrainingRepository.findAllByTeacherId(data));
//		mp.put("educationalQualification", teacherObj);
		mp.put("schoolDetails",kvPojo);
		mp.put("teacherTrainingProfile", teacherTransferProfileRepository.findByTeacherId(data));
		mp.put("experience", wb);
		mp.put("transDetails", transPojo);
		return mp;

	}

	@Override
	public QueryResult getEmployeeStatus(Integer teacherId) {
		// TODO Auto-generated method stub
		QueryResult qrObj = nativeRepository.executeQueries("select spouse_kvs_ynd,personal_status_mdgd,personal_status_spd,personal_status_dfpd,care_giver_faimly_ynd,memberjcm,absence_days_one,disciplinary_yn,surve_hard_yn from teacher_transfer_profile where teacher_id="+teacherId);
//		transPojo = mapper.convertValue(qrObj.getRowValue().get(0), TransProfileBean.class);
		return null;
	}


	
	
	public TeacherProfile saveProfileV2(TeacherProfile data) {
		
		if(data.getTeacherId() !=null) {
			TeacherProfile  tp=	teacherProfileRepository.findAllByTeacherId(data.getTeacherId());
			data.setWorkExperienceWorkStartDatePresentKv(tp.getWorkExperienceWorkStartDatePresentKv());
		}
		
		
		System.out.println("check dob before save--->"+data.getTeacherDob());
		
		TeacherProfile saveedObj= teacherProfileRepository.save(data);
		TeacherFormStatus statusObj=teacherFormStatusRepository.findAllByTeacherId(saveedObj.getTeacherId());
	  if(statusObj !=null && statusObj.getTeacherId() !=null) {
		statusObj.setProfileFinalStatus("SP");
		statusObj.setProfile1FormStatus("SP");
		teacherFormStatusRepository.save(statusObj);
	  }else {
		  statusObj.setTeacherId(saveedObj.getTeacherId());
		  statusObj.setProfileFinalStatus("SP");
		  statusObj.setProfile1FormStatus("SP");
		  teacherFormStatusRepository.save(statusObj);
	  }
		
		return saveedObj;
	}
	
	public TeacherProfile getEmployeeDetailV2(String teacherEmployeeCode){
		return teacherProfileRepository.findAllByTeacherEmployeeCode(teacherEmployeeCode);
	}
	
    public TeacherFormStatus getFormStatusV2(String teacherId) {
      return	teacherFormStatusRepository.findAllByTeacherId(Integer.parseInt(teacherId));
    }
    
    
    @Override
	public Map<String, Object> getConfirmedTeacherDetailsV2(Integer data) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
		TeacherProfileBeanV2 profilePojo = null;
		QueryResult subjectMap = null;
		QueryResult degreeMap = null;
		KVSchoolBean kvPojo=null;
		TransProfileBean transPojo=null;
		String profileQuery = "\r\n"
				+ "select teacher_id,kv_code,teacher_name,teacher_gender,TO_CHAR(teacher_dob,'dd-MM-yyyy') as teacher_dob,teacher_employee_code,teacher_mobile,teacher_email,teacher_permanent_address,public.get_film6('master.mst_state_live','state_name','state_id::varchar = ( select teacher_parmanent_state  from public.teacher_profile tp where teacher_id="
				+ data + " )') as teacher_parmanent_state\r\n"
				+ ",public.get_film6('master.mst_district_live','district_name','district_id::varchar = ( select teacher_permanent_district  from public.teacher_profile tp where teacher_id="
				+ data
				+ " )') as teacher_permanent_district,teacher_permanent_pin,teacher_correspondence_address,public.get_film6('master.mst_state_live','state_name','state_id::varchar = ( select teacher_correspondence_state  from public.teacher_profile tp where teacher_id="
				+ data
				+ " )') as teacher_correspondence_state, public.get_film6('master.mst_district_live','district_name','district_id::varchar = ( select teacher_correspondence_district  from public.teacher_profile tp where teacher_id="
				+ data
				+ " )') as teacher_correspondence_district,teacher_correspondence_pin \r\n"
				+ ",teacher_disability_yn,teacher_disability_type\r\n"
				+ ",TO_CHAR(work_experience_work_start_date_present_kv,'dd-MM-yyyy') as work_experience_work_start_date_present_kv, work_experience_id_present_kv,work_experience_position_type_present_station_start_date\r\n"
				+ ",public.get_film6('master.mst_teacher_subject','subject_name','subject_id::varchar in ( select work_experience_appointed_for_subject from teacher_profile where teacher_id="
				+ data
				+ " )') as  work_experience_appointed_for_subject, public.get_film6('master.mst_teacher_position_type','organization_teacher_type_name','teacher_type_id::varchar = ( select last_promotion_position_type  from public.teacher_profile tp where teacher_id="
				+ data
				+ " )') as last_promotion_position_type,last_promotion_position_date\r\n"
				+ ",teacher_system_generated_code,teacher_account_id,current_udise_sch_code,school_id,drop_box_flag,verify_flag,created_by\r\n"
				+ ",created_time,modified_by,modified_time,verified_type,teaching_nonteaching, nature_of_appointment "
				+ " from teacher_profile where teacher_id="
				+ data + "\r\n" + "";

		try {
			QueryResult qrObj = nativeRepository.executeQueries(profileQuery);
			profilePojo = mapper.convertValue(qrObj.getRowValue().get(0), TeacherProfileBeanV2.class);
		} catch (Exception ex) {
			LOGGER.warn("--message--", ex);
		}
//		profilePojo.setTeacherDob(dateFormat.parse(String.valueOf(profilePojo.getTeacherDob())));
		List<WorkExperienceBean> wb = null;


		try {
			QueryResult qrObj = nativeRepository.executeQueries(
					"select  work_experience_id,teacher_id,udise_sch_code,work_start_date,work_end_date,mtpt.organization_teacher_type_name as position_type,nature_of_appointment,udise_school_name,shift_type\r\n"
							+ ",created_by,created_time,modified_by,modified_time,ground_for_transfer,currently_active_yn,mts.subject_name as appointed_for_subject from teacher_work_experience tws,master.mst_teacher_subject mts, master.mst_teacher_position_type mtpt where tws.teacher_id ="
							+ data
							+ " and tws.appointed_for_subject::numeric =mts.subject_id and mtpt.teacher_type_id::varchar=tws.position_type  order by work_start_date::date desc \r\n"
							+ "");
			
			System.out.println("Work Experience--->"+qrObj.getRowValue());
			
			TypeReference<LinkedList<WorkExperienceBean>> typeRef = new TypeReference<LinkedList<WorkExperienceBean>>() {
			};
			wb = mapper.convertValue(qrObj.getRowValue(), typeRef);
			
			
			
			for(int i=0;i<wb.size();i++) {
				
				System.out.println(wb.get(i).getWork_start_date());
			String groundForTransfer="";
			groundForTransfer += GroundForTransfer.getGroundTransfer().get("G"+wb.get(i).getGround_for_transfer());
			System.out.println("groundForTransfer--->"+groundForTransfer);
				wb.get(i).setGround_for_transfer(groundForTransfer.replaceAll(",$", "") !=null?groundForTransfer.replaceAll(",$", ""):"");
			}
			
		} catch (Exception ex) {
			LOGGER.warn("--message--", ex);
		}

		
		try {
			QueryResult qrObj = nativeRepository.executeQueries("select station_name,station_code,kv_name,kv_code from  kv.kv_school_master where kv_code='"+profilePojo.getKvCode()+"'");
			kvPojo = mapper.convertValue(qrObj.getRowValue().get(0), KVSchoolBean.class);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
//		try {
//			QueryResult qrObj = nativeRepository.executeQueries("select spouse_kvs_ynd,personal_status_mdgd,personal_status_spd,personal_status_dfpd,care_giver_faimly_ynd,memberjcm,absence_days_one,disciplinary_yn,surve_hard_yn from teacher_transfer_profile where teacher_id="+data);
//			transPojo = mapper.convertValue(qrObj.getRowValue().get(0), TransProfileBean.class);
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}

		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("teacherProfile", profilePojo);
		mp.put("schoolDetails",kvPojo);
//		mp.put("teacherTrainingProfile", teacherTransferProfileRepository.findByTeacherId(data));
		mp.put("experience", wb);
//		mp.put("transDetails", transPojo);
		return mp;

	}
    
    public TeacherProfileConfirmation saveTeacherConfirmationV2(TeacherProfileConfirmation data) {
    	TeacherFormStatus statusObj=teacherFormStatusRepository.findAllByTeacherId(data.getTeacherId());
    	statusObj.setProfile1FormStatus("SA");
    	statusObj.setProfile2FormStatus("SA");
    	statusObj.setProfile3FormStatus("SA");
    	statusObj.setProfileFinalStatus("SA");
    	teacherFormStatusRepository.save(statusObj);
    	
    	TeacherProfileConfirmation tObj=	teacherProfileConfirmationRepository.findAllByTeacherId(data.getTeacherId());
    	if(tObj !=null) {
    		nativeRepository.insertQueries(" insert into teacher_profile_confirmation_history select * from teacher_profile_confirmation where teacher_id="+data.getTeacherId());
    		teacherProfileConfirmationRepository.deleteById(Integer.parseInt(String.valueOf(tObj.getTeacherId())));
    	}
		return teacherProfileConfirmationRepository.save(data);
    }
    
   public TeacherProfileConfirmation getTeacherConfirmationV2(Integer teacherId) {
    	return teacherProfileConfirmationRepository.findAllByTeacherId(teacherId);
    }
   
  public Map<String,Object> getSpouseDetailsV2(Integer teacherId) {
	return teacherProfileRepository.getSpouseByTeacherId(teacherId);
  }
  
  public Map<String,Object> resetProfileV2(Integer teacherId){
	Map<String,Object> hs=new HashMap<String,Object>();
	TeacherFormStatus statusObj=teacherFormStatusRepository.findAllByTeacherId(teacherId);
	statusObj.setProfile1FormStatus("SP");
  	statusObj.setProfile2FormStatus("SP");
  	statusObj.setProfile3FormStatus("SP");
  	statusObj.setProfileFinalStatus("SP");
  	teacherFormStatusRepository.save(statusObj);
  	hs.put("status", "1");
  	return hs;
  }
    
	
	

}
