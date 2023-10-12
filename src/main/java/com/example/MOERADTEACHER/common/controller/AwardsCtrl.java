//package com.example.MOERADTEACHER.common.controller;
//
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.MOERADTEACHER.common.interfaces.AwardsInterface;
//import com.example.MOERADTEACHER.common.modal.TeacherAwards;
//import com.example.MOERADTEACHER.common.modal.TeacherExperience;
//import com.example.MOERADTEACHER.common.modal.TeacherTraining;
//import com.example.MOERADTEACHER.common.service.AwardsImpl;
//import com.example.MOERADTEACHER.common.util.ApiPaths;
//import com.example.MOERADTEACHER.common.util.CustomResponse;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@RestController
//@RequestMapping(ApiPaths.AwardsCtrl.CTRL)
////@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = {"https://kvsdemo.udiseplus.gov.in/","https://kvsonlinetransfer.kvs.gov.in","http://10.25.26.251:4200","http://10.25.26.10:4200","http://10.25.26.10:6200","http://demo.sdmis.gov.in","http://pgi.seshagun.gov.in","https://pgi.udiseplus.gov.in","http://pgi.udiseplus.gov.in","https://demopgi.udiseplus.gov.in","https://dashboard.seshagun.gov.in/","https://dashboard.udiseplus.gov.in"}, allowedHeaders = "*",allowCredentials = "true")
//public class AwardsCtrl {
//	 private static final Logger LOGGER = LoggerFactory.getLogger(AwardsCtrl.class);
////	@Autowired
////	AwardsImpl  awardsImpl; 
//	
//	@Autowired
//	AwardsInterface awardsInterface;
//
//	@RequestMapping(value = "/saveAwards", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<CustomResponse> saveAwards(@RequestBody String data,@RequestHeader("username") String username) {
////		// System.out.println(data);
//		ObjectMapper mapperObj = new ObjectMapper();
//		List<TeacherAwards> expObj=new ArrayList<TeacherAwards>();
//		try {
//			expObj = mapperObj.readValue(data, new TypeReference<List<TeacherAwards>>() {
//			});
//		}catch(Exception ex) {
//			LOGGER.warn("--message--",ex);
//		}
//		return ResponseEntity.ok(new CustomResponse(1,"sucess",awardsInterface.saveAwards(expObj),"200"));	
//		
//	}
//	
//	@RequestMapping(value = "/deleteAwards", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<CustomResponse> deleteAwards(@RequestBody String data,@RequestHeader("username") String username) {
//	return 	ResponseEntity.ok(new CustomResponse(1,"sucess",awardsInterface.deleteAwards(Integer.parseInt(data)),"200"));
//	}
//	
//	@RequestMapping(value = "/getAwardsByTeacherId", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<CustomResponse> getAwardsByTeacherId(@RequestBody String data,@RequestHeader("username") String username) {
//		return ResponseEntity.ok(new CustomResponse(1,"sucess",awardsInterface.getAwardsByTeacherId(Integer.parseInt(data)),"200"));	
//	}
//	
//	@RequestMapping(value = "/saveTraning", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<CustomResponse> saveTraning(@RequestBody String data,@RequestHeader("username") String username) {
//		ObjectMapper mapperObj = new ObjectMapper();
//		List<TeacherTraining> expObj=new ArrayList<TeacherTraining>();
//		try {
//			expObj = mapperObj.readValue(data, new TypeReference<List<TeacherTraining>>() {
//			});
//		}catch(Exception ex) {
//			LOGGER.warn("--message--",ex);
//		}
//		return ResponseEntity.ok(new CustomResponse(1,"sucess",awardsInterface.saveTraning(expObj),"200"));	
//	}
//	
//	@RequestMapping(value = "/deleteTraning", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<CustomResponse> deleteTraning(@RequestBody String data,@RequestHeader("username") String username) {
//		return 	ResponseEntity.ok(new CustomResponse(1,"sucess",awardsInterface.deleteTraning(Integer.parseInt(data)),"200"));	
//	}
//	
//	@RequestMapping(value = "/getTraningByTeacherId", method = RequestMethod.POST)
//	public ResponseEntity<CustomResponse> getTraningByTeacherId(@RequestBody String data,@RequestHeader("username") String username) {
//		return ResponseEntity.ok(new CustomResponse(1,"sucess",awardsInterface.getTraningByTeacherId(Integer.parseInt(data)),"200"));
//	}
//	
//	
//}
