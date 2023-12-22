package com.example.MOERADTEACHER.common.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.modal.TeacherExperience;
import com.example.MOERADTEACHER.common.modal.TeacherFormStatus;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
//import com.example.MOERADTEACHER.common.modal.TeacherPromotion;
import com.example.MOERADTEACHER.common.modal.TeacherTransferProfile;
import com.example.MOERADTEACHER.common.service.TeacherTransferProfileImpl;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(ApiPaths.TeacherTransProCtrl.CTRL)
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TeacherTransferProfileCtrl {

	@Autowired
	TeacherTransferProfileImpl  teacherTransferProfileImpl;
	
	
	@RequestMapping(value = "/saveTransProfile", method = RequestMethod.POST)
	@Transactional(rollbackFor = {Exception.class})
	public ResponseEntity<CustomResponse> saveTeacher(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
		System.out.println(data);
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherTransferProfile tdata=new TeacherTransferProfile();
		TeacherFormStatus formData=new TeacherFormStatus();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TeacherTransferProfile>() {
			});
		}catch(Exception ex) {
			ex.printStackTrace();
//			LOGGER.warn("--message--",ex);
		}
	
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherTransferProfileImpl.saveTeacher(tdata),"200"));
	}
	
	@RequestMapping(value = "/getTransProfile", method = RequestMethod.POST)
	@Transactional(rollbackFor = {Exception.class})
	public ResponseEntity<CustomResponse> getTransProfile(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
	System.out.println("Calleded");
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherTransferProfile tdata=new TeacherTransferProfile();
		TeacherFormStatus formData=new TeacherFormStatus();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TeacherTransferProfile>() {
			});
		}catch(Exception ex) {
			ex.printStackTrace();
//			LOGGER.warn("--message--",ex);
		}
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherTransferProfileImpl.getTransProfile(tdata),"200"));
	}
	
	
	
	@RequestMapping(value = "/saveStationChoice", method = RequestMethod.POST)
//	@Transactional(rollbackFor = {Exception.class})
	public ResponseEntity<CustomResponse> saveStationChoice(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
	System.out.println("Calleded");
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherTransferProfile tdata=new TeacherTransferProfile();
		TeacherFormStatus formData=new TeacherFormStatus();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TeacherTransferProfile>() {
			});
		}catch(Exception ex) {
			ex.printStackTrace();
//			LOGGER.warn("--message--",ex);
		}
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherTransferProfileImpl.saveStationChoice(tdata),"200"));
	}
	
	
	@RequestMapping(value = "/getEmployeeStatus", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getEmployeeStatus(@RequestBody String data) throws Exception {
		ObjectMapper mapperObj = new ObjectMapper();
		Map<String,String> mp=new HashMap<String,String>();
		try {
			mp = mapperObj.readValue(data, new TypeReference<HashMap<String,String>>() {
			});
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherTransferProfileImpl.getEmployeeStatus(Integer.parseInt(mp.get("teacher_id"))),"200"));
	}
	
	
	@RequestMapping(value = "/saveEmployeeTransferDeclaration", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> saveEmployeeTransferDeclaration(@RequestBody String data,HttpServletRequest rq) throws Exception {
		ObjectMapper mapperObj = new ObjectMapper();
		Map<String,String> mp=new HashMap<String,String>();
		try {
			mp = mapperObj.readValue(data, new TypeReference<HashMap<String,String>>() {
			});
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(mp.get("transEmpIsDeclaration"));
		System.out.println("Ip----->"+rq.getRemoteHost());
		try {
			System.out.println(rq.getHeader("X-Forwarded-For"));
		mp.put("ip", rq.getHeader("X-Forwarded-For"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
//		return null;
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherTransferProfileImpl.saveEmployeeTransferDeclaration(mp),"200"));
	}
	
	@RequestMapping(value = "/saveEmployeeTransferDeclarationV2", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> saveEmployeeTransferDeclarationV2(@RequestBody String data,HttpServletRequest rq) throws Exception {
		ObjectMapper mapperObj = new ObjectMapper();
		Map<String,String> mp=new HashMap<String,String>();
		try {
			mp = mapperObj.readValue(data, new TypeReference<HashMap<String,String>>() {
			});
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		try {
		mp.put("ip", rq.getHeader("X-Forwarded-For"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherTransferProfileImpl.saveEmployeeTransferDeclarationV2(mp),"200"));
	}
	
	
	@RequestMapping(value = "/getTransProfileV2", method = RequestMethod.POST)
	@Transactional(rollbackFor = {Exception.class})
	public ResponseEntity<CustomResponse> getTransProfileV2(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
	System.out.println("Calleded");
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherTransferProfile tdata=new TeacherTransferProfile();
		TeacherFormStatus formData=new TeacherFormStatus();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TeacherTransferProfile>() {
			});
		}catch(Exception ex) {
			ex.printStackTrace();
//			LOGGER.warn("--message--",ex);
		}
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherTransferProfileImpl.getTransProfileV2(tdata),"200"));
	}
	
}
