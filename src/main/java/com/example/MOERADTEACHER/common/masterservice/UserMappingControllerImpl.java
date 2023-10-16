package com.example.MOERADTEACHER.common.masterservice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.masterbean.RegionMaster;
import com.example.MOERADTEACHER.common.repository.KvSchoolMasterRepo;
import com.example.MOERADTEACHER.common.repository.TeacherProfileRepository;

@Service
public class UserMappingControllerImpl {
	
	@Autowired
	KvSchoolMasterRepo kvSchoolMasterRepo;
	
	@Autowired
	TeacherProfileRepository teacherProfileRepository;
	
	public Object getRegionSchool(Map<String,Object> mp) throws Exception {
		System.out.println("region code--->"+String.valueOf(mp.get("regionCode")));
		return kvSchoolMasterRepo.findAllByRegionCodeAndSchoolType(String.valueOf(mp.get("regionCode")), "3");
	}
	
	
	public Object getRegionSchoolEmployee(Map<String,Object> mp) throws Exception {
		System.out.println("region code--->"+String.valueOf(mp.get("regionCode")));
		try {
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return teacherProfileRepository.getTeacherByKvCode(String.valueOf(mp.get("kvCode")));
	}
	
	
}
