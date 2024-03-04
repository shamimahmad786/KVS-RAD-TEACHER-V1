package com.example.MOERADTEACHER.common.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.bean.LeaveMaster;
import com.example.MOERADTEACHER.common.bean.ListLeaveMaster;
import com.example.MOERADTEACHER.common.dropboxbean.DropboxMaster;
import com.example.MOERADTEACHER.common.modal.TeacherExperience;
import com.example.MOERADTEACHER.common.modal.TeacherLeave;
import com.example.MOERADTEACHER.common.repository.TeacherExperienceRepository;
import com.example.MOERADTEACHER.common.repository.TeacherLeaveRepository;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LeaveManagementImpl {

	@Autowired
	NativeRepository nativeRepository;
	
	@Autowired
	TeacherExperienceRepository teacherExperienceRepository;
	
	@Autowired
	TeacherLeaveRepository teacherLeaveRepository;
	
	public Object getTeacherLeaveMaster(Integer teacherId) {
		String stationCode = null;
		Integer stationIndex = null;
		Map<String,Object> result =new HashMap<String,Object>();
		ObjectMapper mapper=new ObjectMapper();
		List<LeaveMaster>  lm=new ArrayList<LeaveMaster>();
		try {
			QueryResult qr=new QueryResult();
			 LinkedList<TeacherExperience> workExperienceObj=teacherExperienceRepository.findWorkStartDate(teacherId);

				// find work start date in same station 
				for(int i=0;i<workExperienceObj.size();i++) {
					QueryResult qs=nativeRepository.executeQueries("select station_code from kv.kv_school_master where kv_code='"+workExperienceObj.get(i).getKvCode()+"'");				  
					if(i==0) {
				    	stationCode=String.valueOf(qs.getRowValue().get(0).get("station_code"));
				    	stationIndex=i;
				    }else {
				    	if(!stationCode.equalsIgnoreCase(String.valueOf(qs.getRowValue().get(0).get("station_code")))) {
				    		break;
				    	}else {
				    		stationIndex=i;
				    	}
				    }
				    
				}
				
				qr=	nativeRepository.executeQueries("SELECT * FROM get_financial_year_dates('"+workExperienceObj.get(stationIndex).getWorkStartDate()+"')  order by  1 desc");
				lm=mapper.convertValue(qr.getRowValue() , new TypeReference<List<LeaveMaster>>() {
				});
			
			result.put("status", 1);
			result.put("response", lm);
			
		}catch(Exception ex) {
			result.put("status", 0);
			ex.printStackTrace();
		}
		return result;
		
	}
	
	public Object saveTeacherLeave(List<TeacherLeave> tdata) {
		Map<String,Object> result=new HashMap<String,Object>();
		try {
			result.put("status", 1);
			result.put("response", teacherLeaveRepository.saveAll(tdata));
		}catch(Exception ex) {
			result.put("status", 0);
			ex.printStackTrace();
		}
		return result;
		
	}
	
	public Map<String,Object> getTeacherLeave(Integer teacherId) {
		Map<String,Object> result=new HashMap<String,Object>();
		try {
			result.put("status", 1);
			List<TeacherLeave> tl=teacherLeaveRepository.findAllByTeacherIdOrderByStartDateDesc(teacherId);
			if(tl.size()>0) {
			result.put("response", tl);
			}else {
				result.put("response", null);
			}
		}catch(Exception ex) {
			result.put("status", 0);
			ex.printStackTrace();
		}
		return result;
	}
	
	public Object deleteTeacherLeave(Integer teacherId) {
		Map<String,Object> result=new HashMap<String,Object>();
		try {
			nativeRepository.insertQueries("insert into audit_tray.kvs_teacher_leave_history (id,created_date_time,end_date,is_continious_leave,no_of_leave,start_date,teacher_id) \r\n"
					+ "select id,created_date_time,end_date,is_continious_leave,no_of_leave,start_date,teacher_id from public.kvs_teacher_leave where teacher_id="+teacherId);
			teacherLeaveRepository.deleteAllByTeacherId(teacherId);
			result.put("status", 1);
		}catch(Exception ex) {
			result.put("status", 0);
			ex.printStackTrace();
		}
		return result;
	}
	
	
}
