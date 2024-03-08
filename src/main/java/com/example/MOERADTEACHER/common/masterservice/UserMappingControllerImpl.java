package com.example.MOERADTEACHER.common.masterservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.dropboxbean.DropboxMaster;
import com.example.MOERADTEACHER.common.masterbean.RegionMaster;
import com.example.MOERADTEACHER.common.modal.KvSchoolMaster;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
import com.example.MOERADTEACHER.common.repository.KvSchoolMasterRepo;
import com.example.MOERADTEACHER.common.repository.TeacherProfileRepository;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserMappingControllerImpl {
	
	@Autowired
	KvSchoolMasterRepo kvSchoolMasterRepo;
	
	@Autowired
	TeacherProfileRepository teacherProfileRepository;
	@Autowired
	NativeRepository  nativeRepository;
	
	
	public Object getRegionSchool(Map<String,Object> mp) throws Exception {
		if(String.valueOf(mp.get("schoolType")).equalsIgnoreCase("4")) {
			return kvSchoolMasterRepo.findAllBySchoolType(String.valueOf(mp.get("schoolType")));
		}else if (String.valueOf(mp.get("schoolType")).equalsIgnoreCase("1")){
			QueryResult qs=new QueryResult();
			qs=nativeRepository.executeQueries("select kv_code,region_code,station_code,station_name,kv_name,state_name,district_name,udise_sch_code,station_type,remarks,id,school_type,shift_type from kv.kv_school_master where school_type in ('1','3') and region_code ='"+String.valueOf(mp.get("regionCode"))+"'");
			ObjectMapper mapperObj = new ObjectMapper();
			List<KvSchoolMaster> tdata=new ArrayList<KvSchoolMaster>();
			try {
				tdata = mapperObj.convertValue(qs.getRowValue(), new TypeReference<List<KvSchoolMaster>>() {
				});
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		return 	tdata;
		}else{
		return kvSchoolMasterRepo.findAllByRegionCodeAndSchoolType(String.valueOf(mp.get("regionCode")), String.valueOf(mp.get("schoolType")));
		}
	}
	
	
	public Object getRegionSchoolEmployee(Map<String,Object> mp) throws Exception {
		System.out.println("region code--->"+String.valueOf(mp.get("regionCode")));
		List<TeacherProfile>  tpObj=teacherProfileRepository.getTeacherByKvCode(String.valueOf(mp.get("kvCode")));
		QueryResult contObj=new QueryResult();
		try {
//			contObj=nativeRepository.executeQueries("select * from master.mst_controller_officer_employee mcoe where mcoe.kv_code='"+String.valueOf(mp.get("kvCode"))+"'");
			contObj=nativeRepository.executeQueries("select tp.teacher_name,tp.teacher_employee_code from master.mst_controller_officer_employee mcoe left join public.teacher_profile tp on mcoe.teacher_employee_code =tp.teacher_employee_code  where mcoe.kv_code='"+String.valueOf(mp.get("kvCode"))+"'");
			if(contObj !=null && contObj.getRowValue().size()>0) {
				for(int i=0;i<contObj.getRowValue().size();i++) {
				TeacherProfile tp=new TeacherProfile();
				tp.setTeacherEmployeeCode(String.valueOf(contObj.getRowValue().get(i).get("teacher_employee_code")));
				tp.setTeacherName(String.valueOf(contObj.getRowValue().get(i).get("teacher_name")));
				tpObj.add(tp);
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return tpObj;
	}
	
	
}
