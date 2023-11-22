package com.example.MOERADTEACHER.common.masterservice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.masterbean.RegionMaster;
import com.example.MOERADTEACHER.common.repository.KvSchoolMasterRepo;
import com.example.MOERADTEACHER.common.repository.TeacherProfileRepository;
import com.example.MOERADTEACHER.common.util.NativeRepository;

@Service
public class UserMappingControllerImpl {
	
	@Autowired
	KvSchoolMasterRepo kvSchoolMasterRepo;
	
	@Autowired
	TeacherProfileRepository teacherProfileRepository;
	@Autowired
	NativeRepository  nativeRepository;
	
	
	public Object getRegionSchool(Map<String,Object> mp) throws Exception {
		System.out.println("region code--->"+String.valueOf(mp.get("regionCode")));
		System.out.println("schoolType---->"+String.valueOf(mp.get("schoolType")));
		if(String.valueOf(mp.get("schoolType")).equalsIgnoreCase("4")) {
			return kvSchoolMasterRepo.findAllBySchoolType(String.valueOf(mp.get("schoolType")));
		}else {
		return kvSchoolMasterRepo.findAllByRegionCodeAndSchoolType(String.valueOf(mp.get("regionCode")), String.valueOf(mp.get("schoolType")));
		}
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
