package com.example.MOERADTEACHER.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.bean.MailBean;
import com.example.MOERADTEACHER.common.modal.KvsControllerOffice;
import com.example.MOERADTEACHER.common.modal.Teacher;
import com.example.MOERADTEACHER.common.responsehandler.ManageResponseCode;
import com.example.MOERADTEACHER.common.responsehandler.SucessReponse;
import com.example.MOERADTEACHER.common.service.KvsOfficerCtrlImpl;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(ApiPaths.kvsOfficeCtrl.CTRL)
@CrossOrigin(origins = { "https://kvsdemo.udiseplus.gov.in/", "https://kvsonlinetransfer.kvs.gov.in",
		"http://10.25.26.251:4200", "http://10.25.26.10:4200", "http://10.25.26.10:6200", "http://demo.sdmis.gov.in",
		"http://pgi.seshagun.gov.in", "https://pgi.udiseplus.gov.in", "http://pgi.udiseplus.gov.in",
		"https://demopgi.udiseplus.gov.in", "https://dashboard.seshagun.gov.in/",
		"https://dashboard.udiseplus.gov.in" }, allowedHeaders = "*", allowCredentials = "true")
public class KvsOfficerCtrl {
	
	@Autowired
	KvsOfficerCtrlImpl kvsOfficerCtrlImpl;

	@RequestMapping(value = "/saveControllerOffice", method = RequestMethod.POST)
	public ResponseEntity<?> saveControllerOffice(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
		System.out.println("data");
		ObjectMapper mapperObj = new ObjectMapper();
		KvsControllerOffice dataObj=new KvsControllerOffice();
		try {
			dataObj = mapperObj.readValue(data, new TypeReference<KvsControllerOffice>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(new SucessReponse(true, ManageResponseCode.RES0014.getStatusCode(),
				kvsOfficerCtrlImpl.saveControllerOffice(dataObj)));
	}
	
	
	@RequestMapping(value = "/getControllerOffice", method = RequestMethod.POST)
	public ResponseEntity<?> getControllerOffice(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
		ObjectMapper mapperObj = new ObjectMapper();
		KvsControllerOffice dataObj=new KvsControllerOffice();
		try {
			dataObj = mapperObj.readValue(data, new TypeReference<KvsControllerOffice>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(new SucessReponse(true, ManageResponseCode.RES0015.getStatusDesc(),
				kvsOfficerCtrlImpl.getControllerOffice(dataObj)));
	}
	
	
}
