package com.example.MOERADTEACHER.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.modal.KvsControllerOffice;
import com.example.MOERADTEACHER.common.repository.KvsControllerOfficeRepository;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;

@Service
public class KvsOfficerCtrlImpl {

	@Autowired
	KvsControllerOfficeRepository kvsControllerOfficeRepository;
	
	@Autowired
	NativeRepository  nativeRepository;
	
	public Object saveControllerOffice(KvsControllerOffice obj) {
		return kvsControllerOfficeRepository.save(obj);
	}
	
	public Object getControllerOffice(KvsControllerOffice obj) {
		QueryResult qObj=null;
		if(obj.getControllerType().equalsIgnoreCase("R")) {
			 qObj= nativeRepository.executeQueries("select  kmr.region_name,kmr.region_code, kvf.* from kv.kv_mst_region kmr left join public.kv_controller_officer kvf on kmr.region_code =kvf.region_code::integer and kvf.is_active ='1' and kvf.controller_type ='"+obj.getControllerType()+"'");
		}else if(obj.getControllerType().equalsIgnoreCase("S")) {
//			 qObj= nativeRepository.executeQueries("select kvf.*,ksm.region_name,ksm.region_code,ksm.kv_name,ksm.kv_code from kv.kv_school_master ksm  left join public.kv_controller_officer kvf on ksm.region_code =kvf.region_code and kvf.is_active ='1' and kvf.controller_type ='S' where ksm.region_code='"+obj.getRegionCode()+"' and ksm.school_type ='1'");
			qObj= nativeRepository.executeQueries("select kvf.is_active ,kvf.*,ksm.region_name,ksm.region_code,ksm.kv_name,ksm.kv_code from kv.kv_school_master ksm left join public.kv_controller_officer kvf on ksm.kv_code =kvf.institution_code and kvf.controller_type='S' and kvf.is_active ='1'  where ksm.region_code='"+obj.getRegionCode()+"'");
			 
		}
		
		return qObj;
//		return kvsControllerOfficeRepository.findAllByControllerTypeAndIsActive(obj.getControllerType(),"1");
	}
	
	public Object getControllerOfficeHistory(KvsControllerOffice obj) {
		if(obj.getControllerType().equalsIgnoreCase("R")) {
			return kvsControllerOfficeRepository.findAllByControllerTypeAndRegionCodeOrderByStateDateDesc(obj.getControllerType(),obj.getRegionCode());
		}else if (obj.getControllerType().equalsIgnoreCase("S")) {
			System.out.println(obj.getRegionCode());
			return kvsControllerOfficeRepository.findAllByControllerTypeAndInstitutionCodeOrderByStateDateDesc(obj.getControllerType(),obj.getRegionCode());
		}
		
		return null;
		
	}
	
}
