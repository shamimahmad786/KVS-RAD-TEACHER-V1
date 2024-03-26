package com.example.MOERADTEACHER.common.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.MOERADTEACHER.common.bean.ListLeaveMaster;
import com.example.MOERADTEACHER.common.modal.TeacherLeave;
import com.example.MOERADTEACHER.common.modal.TeacherProfileConfirmation;
import com.example.MOERADTEACHER.common.service.LeaveManagementImpl;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.security.util.GenericUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(ApiPaths.leaveCtrl.CTRL)
@CrossOrigin(origins = { "https://kvsdemo.udiseplus.gov.in/", "https://kvsonlinetransfer.kvs.gov.in",
		"http://10.25.26.251:4200", "http://10.25.26.10:4200", "http://10.25.26.10:6200", "http://demo.sdmis.gov.in",
		"http://pgi.seshagun.gov.in", "https://pgi.udiseplus.gov.in", "http://pgi.udiseplus.gov.in",
		"https://demopgi.udiseplus.gov.in", "https://dashboard.seshagun.gov.in/",
		"https://dashboard.udiseplus.gov.in" }, allowedHeaders = "*", allowCredentials = "true")
public class LeaveManagement {
	
	@Autowired
	LeaveManagementImpl  leaveManagementImpl;

	@RequestMapping(value = "/getTeacherLeaveMaster", method = RequestMethod.POST)
	public ResponseEntity<?> getTeacherLeaveMaster(@RequestBody String data) throws Exception {
		System.out.println("called-->"+data);
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		Map<String,Object> mp=leaveManagementImpl.getTeacherLeave(Integer.parseInt(String.valueOf(mObj.get("teacherId"))));
		if(mp.get("response") !=null) {
			return	ResponseEntity.ok(mp);
		}else {
		return ResponseEntity.ok(leaveManagementImpl.getTeacherLeaveMaster(Integer.parseInt(String.valueOf(mObj.get("teacherId")))));
		}
	}
	
	@RequestMapping(value = "/saveTeacherLeave", method = RequestMethod.POST)
	public ResponseEntity<?> saveTeacherLeave(@RequestBody String data) throws Exception {
		System.out.println(data);
	ObjectMapper mapperObj = new ObjectMapper();
	List<TeacherLeave> tdata=new ArrayList<TeacherLeave>();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<ArrayList<TeacherLeave>>() {
			});
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(leaveManagementImpl.saveTeacherLeave(tdata));
	}
	
	@RequestMapping(value = "/getTeacherLeave", method = RequestMethod.POST)
	public ResponseEntity<?> getTeacherLeave(@RequestBody String data) throws Exception {
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		return ResponseEntity.ok(leaveManagementImpl.getTeacherLeave(Integer.parseInt(String.valueOf(mObj.get("teacherId")))));
	}
	@Transactional
	@RequestMapping(value = "/deleteTeacherLeave", method = RequestMethod.POST)
	public ResponseEntity<?> deleteTeacherLeave(@RequestBody String data) throws Exception {
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		return ResponseEntity.ok(leaveManagementImpl.deleteTeacherLeave(Integer.parseInt(String.valueOf(mObj.get("teacherId")))));
	}
	
	@RequestMapping(value = "/checkStationType", method = RequestMethod.POST)
	public ResponseEntity<?> checkStationType(@RequestBody String data) throws Exception {
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		return ResponseEntity.ok(leaveManagementImpl.checkStationType(String.valueOf(mObj.get("startDate")),String.valueOf(mObj.get("endDate")),String.valueOf(mObj.get("stationCode")),String.valueOf(mObj.get("category"))));
	}
	
	
	
}
