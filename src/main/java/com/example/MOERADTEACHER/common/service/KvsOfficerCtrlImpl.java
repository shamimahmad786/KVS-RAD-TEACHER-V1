package com.example.MOERADTEACHER.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.modal.KvsControllerOffice;
import com.example.MOERADTEACHER.common.repository.KvsControllerOfficeRepository;

@Service
public class KvsOfficerCtrlImpl {

	@Autowired
	KvsControllerOfficeRepository kvsControllerOfficeRepository;
	
	public Object saveControllerOffice(KvsControllerOffice obj) {
		return kvsControllerOfficeRepository.save(obj);
	}
	
	public Object getControllerOffice(KvsControllerOffice obj) {
		return kvsControllerOfficeRepository.findAllByControllerTypeAndIsActive(obj.getControllerType(),"1");
	}
	
}
