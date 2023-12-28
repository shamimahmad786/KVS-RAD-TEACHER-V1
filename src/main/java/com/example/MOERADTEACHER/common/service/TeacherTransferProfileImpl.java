package com.example.MOERADTEACHER.common.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.MOERADTEACHER.common.modal.TeacherFormStatus;
import com.example.MOERADTEACHER.common.modal.TeacherTransferProfile;
import com.example.MOERADTEACHER.common.repository.TeacherFormStatusRepository;
import com.example.MOERADTEACHER.common.repository.TeacherTransferProfileRepository;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;

@Service
public class TeacherTransferProfileImpl {

	@Autowired
	TeacherTransferProfileRepository teacherTransferProfileRepository;
	
	@Autowired
	TeacherFormStatusRepository teacherFormStatusRepository;
	
	
	@Autowired
	NativeRepository nativeRepository;

	
	public TeacherTransferProfile saveTeacher(TeacherTransferProfile data) throws Exception {
		TeacherTransferProfile tpObj=teacherTransferProfileRepository.findAllByTeacherIdAndInityear(data.getTeacherId(), data.getInityear());
		System.out.println("id---->"+tpObj.getId());
		data.setId(tpObj.getId());
		data.setTransEmpDeclarationIp(tpObj.getTransEmpDeclarationIp());
		data.setTransEmpDeclaraionDate(tpObj.getTransEmpDeclaraionDate());
		data.setChoiceKv1StationName(tpObj.getChoiceKv1StationName());
		data.setChoiceKv2StationName(tpObj.getChoiceKv2StationName());
		data.setChoiceKv3StationName(tpObj.getChoiceKv3StationName());
		data.setChoiceKv4StationName(tpObj.getChoiceKv4StationName());
		data.setChoiceKv5StationName(tpObj.getChoiceKv5StationName());
		data.setChoiceKv1StationCode(tpObj.getChoiceKv1StationCode());
		data.setChoiceKv2StationCode(tpObj.getChoiceKv2StationCode());
		data.setChoiceKv3StationCode(tpObj.getChoiceKv3StationCode());
		data.setChoiceKv4StationCode(tpObj.getChoiceKv4StationCode());
		data.setChoiceKv5StationCode(tpObj.getChoiceKv5StationCode());
		
		TeacherFormStatus tfs= teacherFormStatusRepository.findAllByTeacherId(data.getTeacherId());
		tfs.setForm2Status("1");
		teacherFormStatusRepository.save(tfs);
		return teacherTransferProfileRepository.saveAndFlush(data);
	}
	
	public TeacherTransferProfile getTransProfile(TeacherTransferProfile data) throws Exception {
		System.out.println(data);
		System.out.println("data-->"+data.getTeacherId());
		return teacherTransferProfileRepository.findByTeacherId(data.getTeacherId());
	}
	
	public TeacherTransferProfile getTransProfileV2(TeacherTransferProfile data) throws Exception {
		return teacherTransferProfileRepository.findAllByTeacherIdAndInityear(data.getTeacherId(),data.getInityear());
	}
	
	public Map<String,Object> saveStationChoice(TeacherTransferProfile data) {
		Map<String,Object> mp=new HashMap<String,Object>();
		try {
			System.out.println("Station choice called"+data);
			String query="update teacher_transfer_profile set apply_transfer_yn='"+data.getApplyTransferYn()+"', choice_kv1_station_code='"+data.getChoiceKv1StationCode()+"',choice_kv1_station_name='"+data.getChoiceKv1StationName()+"',choice_kv2_station_code='"+data.getChoiceKv2StationCode()+"',choice_kv2_station_name='"+data.getChoiceKv2StationName()+"',choice_kv3_station_code='"+data.getChoiceKv3StationCode()+"',choice_kv3_station_name='"+data.getChoiceKv3StationName()+"',choice_kv4_station_code='"+data.getChoiceKv4StationCode()+"',choice_kv4_station_name='"+data.getChoiceKv4StationName()+"',choice_kv5_station_code='"+data.getChoiceKv5StationCode()+"',choicekv5_station_name='"+data.getChoiceKv5StationName()+"' where teacher_id="+data.getTeacherId()+" and inityear='"+data.getInityear()+"'";
			System.out.println(query);
			nativeRepository.updateQueries(query);		
			TeacherFormStatus tfs= teacherFormStatusRepository.findAllByTeacherId(data.getTeacherId());
			tfs.setForm3Status("1");
			teacherFormStatusRepository.save(tfs);
			mp.put("status", 1);
		}catch(Exception ex) {
			mp.put("status", 0);
			ex.printStackTrace();
		}
		
		return mp;
		
	}
	
	
public QueryResult	getEmployeeStatus(Integer teacherId){
	
	try {
		QueryResult qs=nativeRepository.executeQueries("select tp.verify_flag as final_status,tp.spouse_station_code,tp.spouse_status,"
				+ "ttc.valid_post_for_transfer, ttc.valid_location_for_transfer , ttc.court_case_flag,ttc.disciplinary_yn,"
				+" ttc.dctenure_year, ttc.activestay,ttc.nature_of_stn_at_join ,ttc.unfrez_flag , ttc.teacher_disability_yn , ttc.teacher_age   , ttc.personal_status_dfpd , ttc.personal_status_mdgd ,"
				+ "ttp.trans_emp_is_declaration from public.teacher_profile tp, public.teacher_transfer_profile ttp,transfer.transfer_teacher_check ttc  where tp.teacher_id=ttp.teacher_id and ttc.teacher_id=tp.teacher_id and ttp.teacher_id="+teacherId);		
		return qs;
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	return null;
	}
	



public HashMap<String,String> saveEmployeeTransferDeclaration(Map<String,String> empMap){
	HashMap<String,String> mp=new HashMap<String,String>();
	try {
		LocalDateTime time = LocalDateTime.now();
		String query="update public.teacher_transfer_profile set trans_emp_declaraion_date='"+time+"'  ,trans_emp_is_declaration="+empMap.get("transEmpIsDeclaration")+",trans_emp_declaration_ip='"+empMap.get("ip")+"' where teacher_id="+empMap.get("teacherId");
		nativeRepository.updateQueries(query);
		
		nativeRepository.updateQueries("update public.teacher_profile set verify_flag='TTD' where teacher_id="+empMap.get("teacherId"));
		nativeRepository.updateQueries("update public.teacher_form_status set final_status='TTD' where teacher_id="+empMap.get("teacherId"));
		
		mp.put("status", "1");
	}catch(Exception ex) {
		mp.put("status", "0");
		ex.printStackTrace();
		}
	return mp;
	
	}


public HashMap<String,String> saveEmployeeTransferDeclarationV2(Map<String,String> empMap){
	HashMap<String,String> mp=new HashMap<String,String>();
	try {
		LocalDateTime time = LocalDateTime.now();
	  TeacherTransferProfile tfObj=teacherTransferProfileRepository.findAllByTeacherIdAndInityear(Integer.parseInt(String.valueOf(empMap.get("teacherId"))),String.valueOf(empMap.get("inityear")));
		
	  if(tfObj ==null) {
		  TeacherTransferProfile ttfObj=new TeacherTransferProfile();
		  ttfObj.setTransEmpDeclaraionDate( new Date());
		  ttfObj.setTeacherId(Integer.parseInt(String.valueOf(empMap.get("teacherId"))));
		  ttfObj.setTransEmpIsDeclaration(Integer.parseInt(String.valueOf(empMap.get("transEmpIsDeclaration"))));
		  ttfObj.setTransEmpDeclarationIp(empMap.get("ip"));
		  ttfObj.setInityear(empMap.get("inityear"));
		  teacherTransferProfileRepository.save(ttfObj);
		  TeacherFormStatus tfsObj= teacherFormStatusRepository.findAllByTeacherId(Integer.parseInt(String.valueOf(empMap.get("teacherId"))));
		  tfsObj.setForm1Status("1");
		  teacherFormStatusRepository.save(tfsObj);
	  }
	  
//		String query="update public.teacher_transfer_profile set trans_emp_declaraion_date='"+time+"'  ,trans_emp_is_declaration="+empMap.get("transEmpIsDeclaration")+",trans_emp_declaration_ip='"+empMap.get("ip")+"' where teacher_id="+empMap.get("teacherId");

		mp.put("status", "1");
	}catch(Exception ex) {
		mp.put("status", "0");
		ex.printStackTrace();
		}
	return mp;
	}
}


