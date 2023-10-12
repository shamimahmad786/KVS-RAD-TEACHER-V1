package com.example.MOERADTEACHER.common.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.modal.KVTeacher;
import com.example.MOERADTEACHER.common.modal.KvRegionMaster;
import com.example.MOERADTEACHER.common.modal.KvSchoolMaster;
import com.example.MOERADTEACHER.common.modal.KvStationMaster;
import com.example.MOERADTEACHER.common.repository.KVTeacherRepository;
import com.example.MOERADTEACHER.common.repository.KvRegionMasterRepo;
import com.example.MOERADTEACHER.common.repository.KvSchoolMasterRepo;
import com.example.MOERADTEACHER.common.repository.KvStationMasterRepo;

@Service
public class KvMasterImpl {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KvMasterImpl.class);
	
	@Autowired 
	KvRegionMasterRepo kvRegionMstRepo;
	
	@Autowired
	KvStationMasterRepo kvStationMasterRepo;
	
	@Autowired
	KvSchoolMasterRepo kvSchoolMasterRepo;
	
	@Autowired
	KVTeacherRepository kVTeacherRepository;
	

	public KvRegionMaster getRegionByCode(String data) {
		return kvRegionMstRepo.findById(data).get();
	}
	
	public List<KvStationMaster> getAllStationMasterByRegionCode(String data){
		return kvStationMasterRepo.findAllByRegionCode(data);
	}
	
	public List<KVTeacher> getKVTeacherByEmail(String data){
		return kVTeacherRepository.findAllByEmail(data);
	}
	
	public List<KVTeacher> getKVTeacherByMobile(String data){
		return kVTeacherRepository.findAllByMobile(data);
	}
	
	
	
	
	
//	public List<KvSchoolMaster> getAllSchoolMasterByStatinCode(String data){
//		return kvSchoolMasterRepo.findAllByStatinCode(data);
//	}
	
}
