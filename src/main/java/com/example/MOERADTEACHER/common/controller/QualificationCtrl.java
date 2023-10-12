//package com.example.MOERADTEACHER.common.controller;
//
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
//import com.example.MOERADTEACHER.common.interfaces.QualificationInterface;
//import com.example.MOERADTEACHER.common.modal.TeacherEducationalQualification;
//import com.example.MOERADTEACHER.common.modal.TeacherProfessionalQualification;
//import com.example.MOERADTEACHER.common.modal.TeacherPromotion;
//import com.example.MOERADTEACHER.common.service.QualificationImpl;
//import com.example.MOERADTEACHER.common.util.ApiPaths;
//import com.example.MOERADTEACHER.common.util.CustomResponse;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@RestController
//@RequestMapping(ApiPaths.QualificationCtrl.CTRL)
////@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = {"https://kvsdemo.udiseplus.gov.in/","https://kvsonlinetransfer.kvs.gov.in","http://10.25.26.251:4200","http://10.25.26.10:4200","http://10.25.26.10:6200","http://demo.sdmis.gov.in","http://pgi.seshagun.gov.in","https://pgi.udiseplus.gov.in","http://pgi.udiseplus.gov.in","https://demopgi.udiseplus.gov.in","https://dashboard.seshagun.gov.in/","https://dashboard.udiseplus.gov.in"}, allowedHeaders = "*",allowCredentials = "true")
//public class QualificationCtrl {
//	
//	 private static final Logger LOGGER = LoggerFactory.getLogger(QualificationCtrl.class);
////	@Autowired
////	QualificationImpl  qualificationImpl;
//	@Autowired
//	QualificationInterface qualificationInterface;
//	
//	
//	@RequestMapping(value = "/saveEducationalQualification", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<CustomResponse> saveEducationalQualification(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		String minorSubject="";
//		String majorSubject="";
//		ObjectMapper mapperObj = new ObjectMapper();
//		List<TeacherEducationalQualification> qualificationData=new ArrayList<TeacherEducationalQualification>();
//		TeacherPromotion pObj = null;
//		try {
//			qualificationData = mapperObj.readValue(data, new TypeReference<List<TeacherEducationalQualification>>() {
//			});
//		}catch(Exception ex) {
//			LOGGER.warn("--message--",ex);
//		}
//		
//		
//		for(int j=0;j<qualificationData.size();j++) {
//			majorSubject="";
//			minorSubject="";
//		for(int i=0;i<qualificationData.get(j).getQualificationDegreeMajorList().size();i++) {
//			majorSubject +=qualificationData.get(j).getQualificationDegreeMajorList().get(i) +",";
//		}
//		majorSubject = majorSubject.replaceAll(",$", "");
//		qualificationData.get(j).setQualificationDegreeMajor(majorSubject);
//		
//		
//		for(int i=0;i<qualificationData.get(j).getQualificationDegreeMinorList().size();i++) {
//			minorSubject +=qualificationData.get(j).getQualificationDegreeMinorList().get(i) +",";
//		}
//		minorSubject = minorSubject.replaceAll(",$", "");
//		qualificationData.get(j).setQualificationDegreeMinor(minorSubject);
//		
//		}
//		return ResponseEntity.ok(new CustomResponse(1,"sucess",qualificationInterface.saveEducationalQualification(qualificationData),"200"));
//	}
//	
//	
//	@RequestMapping(value = "/deteleEducationalQualification", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<CustomResponse> deteleEducationalQualification(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//	return ResponseEntity.ok(new CustomResponse(1,"sucess",qualificationInterface.deteleEducationalQualification(Integer.parseInt(data)),"200"));	
//	}
//	
//	
//	@RequestMapping(value = "/getEducationalQualificationByTeacherId", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<CustomResponse> getEducationalQualificationByTeacherId(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		return ResponseEntity.ok(new CustomResponse(1,"sucess",qualificationInterface.getEducationalQualificationByTeacherId(Integer.parseInt(data)),"200"));
//	}
//	
//	
//	@RequestMapping(value = "/saveProfessionalQualification", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<CustomResponse> saveProfessionalQualification(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		String minorSubject="";
//		String majorSubject="";
//		ObjectMapper mapperObj = new ObjectMapper();
//		
//	
//		
//		List<TeacherProfessionalQualification> qualificationData=new ArrayList<TeacherProfessionalQualification>();
//		TeacherPromotion pObj = null;
//		try {
//			qualificationData = mapperObj.readValue(data, new TypeReference<List<TeacherProfessionalQualification>>() {
//			});
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		for(int j=0;j<qualificationData.size();j++) {
//			majorSubject="";
//		for(int i=0;i<qualificationData.get(j).getQualificationDegreeMajorList().size();i++) {
//			majorSubject +=qualificationData.get(j).getQualificationDegreeMajorList().get(i) +",";
//		}
//		majorSubject = majorSubject.replaceAll(",$", "");
//		qualificationData.get(j).setQualificationDegreeMajor(majorSubject);
//		
//		}
//		return ResponseEntity.ok(new CustomResponse(1,"sucess",qualificationInterface.saveProfessionalQualification(qualificationData),"200"));
//	}
//	
//	@RequestMapping(value = "/deleteProfessionalQualification", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<CustomResponse> deleteProfessionalQualification(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//	return ResponseEntity.ok(new CustomResponse(1,"sucess",qualificationInterface.deleteProfessionalQualification(Integer.parseInt(data)),"200"));	
//	}
//	
//	
//	@RequestMapping(value = "/getProfesionalQualificationByTeacherId", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<CustomResponse> getProfesionalQualificationByTeacherId(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		return ResponseEntity.ok(new CustomResponse(1,"sucess",qualificationInterface.getProfesionalQualificationByTeacherId(Integer.parseInt(data)),"200"));
//	}
//	
//	
//	
//}
