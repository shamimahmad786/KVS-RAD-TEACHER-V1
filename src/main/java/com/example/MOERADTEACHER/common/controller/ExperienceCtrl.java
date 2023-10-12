package com.example.MOERADTEACHER.common.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.interfaces.ExperienceInterface;
import com.example.MOERADTEACHER.common.modal.TeacherExperience;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
//import com.example.MOERADTEACHER.common.modal.TeacherPromotion;
import com.example.MOERADTEACHER.common.service.ExperienceImpl;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(ApiPaths.ExperienceCtrl.CTRL)
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@CrossOrigin(origins = {"https://kvsdemo.udiseplus.gov.in/","https://kvsonlinetransfer.kvs.gov.in","http://10.25.26.251:4200","http://10.25.26.10:4200","http://10.25.26.10:6200","http://demo.sdmis.gov.in","http://pgi.seshagun.gov.in","https://pgi.udiseplus.gov.in","http://pgi.udiseplus.gov.in","https://demopgi.udiseplus.gov.in","https://dashboard.seshagun.gov.in/","https://dashboard.udiseplus.gov.in"}, allowedHeaders = "*",allowCredentials = "true")
public class ExperienceCtrl {
	 private static final Logger LOGGER = LoggerFactory.getLogger(ExperienceCtrl.class);
//	@Autowired
//	ExperienceImpl  experienceImpl;
	
	@Autowired
	ExperienceInterface  experienceInterface;
	
	@RequestMapping(value = "/saveExperience", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> saveExperience(@RequestBody String data,@RequestHeader("username") String username) {
		
		 System.out.println("save experience data---->"+data);
		
		ObjectMapper mapperObj = new ObjectMapper();
		List<TeacherExperience> expObj=new ArrayList<TeacherExperience>();
		try {
			expObj = mapperObj.readValue(data, new TypeReference<List<TeacherExperience>>() {
			});
		}catch(Exception ex) {
			LOGGER.warn("--message--",ex);
		}
		
		
		
		
		return ResponseEntity.ok(new CustomResponse(1,"sucess",experienceInterface.saveExperience(expObj),"200"));	
		
	}
	
	public TeacherExperience saveExperience(TeacherProfile data) throws ParseException {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD", Locale.ENGLISH);
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMdd");
//		LocalDate date = LocalDate.parse(string, formatter);s
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data.getWorkExperienceWorkStartDatePresentKv());
		
//		// System.out.println(date);
		
//		// System.out.println("experirnrcr date--->"+data.getWorkExperienceWorkStartDatePresentKv());
//		// System.out.println(formatter1.parse(data.getWorkExperienceWorkStartDatePresentKv()));
		
		Date d1= formatter1.parse(data.getWorkExperienceWorkStartDatePresentKv());
		
		System.out.println("data.getCurrentUdiseSchCode()---->"+data.getCurrentUdiseSchCode());
		System.out.println("data.getSchoolId()-->"+data.getSchoolId());
		try {
		TeacherExperience expObj=new TeacherExperience();
		expObj.setTeacherId((data.getTeacherId()));
		expObj.setSchoolId(data.getSchoolId());
		expObj.setUdiseSchCode(data.getCurrentUdiseSchCode());
		expObj.setUdiseSchoolName(data.getUdiseSchoolName());
		expObj.setKvCode(data.getKvCode());
		
//		// System.out.println("experirnrcr date--->"+d1);
		
		
		
		
		expObj.setWorkStartDate(date);
//		expObj.setWorkStartDate(data.getWorkExperienceWorkStartDatePresentKv());
//		expObj.setWorkStartDate(new SimpleDateFormat("dd/MM/yyyy").parse(data.getWorkExperienceWorkStartDatePresentKv()));
		expObj.setAppointedForSubject(data.getWorkExperienceAppointedForSubject());
		expObj.setPositionType(data.getLastPromotionPositionType());
		expObj.setNatureOfAppointment(data.getNatureOfAppointment());
		expObj.setUdiseSchoolName(data.getUdiseSchoolName());
		
		
//		if(promotion.getLastPromotionId() !=null && promotion.getLastPromotionId() !="" && !promotion.getLastPromotionId().equalsIgnoreCase("null") ) {
//			if(Integer.parseInt(promotion.getLastPromotionId())>1) {
//		promotionData.setPromotionId(Integer.parseInt(promotion.getLastPromotionId()));
//			}
//		}
		
//		// System.out.println("work experience--->"+data.getWorkExperienceIdPresentKv());
		
		if(data.getWorkExperienceIdPresentKv() !=null  &&  data.getWorkExperienceIdPresentKv() >1 ) {
		expObj.setWorkExperienceId(data.getWorkExperienceIdPresentKv());
		}
//		expObj.set
		
		List<TeacherExperience> lt=new ArrayList<TeacherExperience>();
		lt.add(expObj);
		
				
		List<TeacherExperience>	expList=	experienceInterface.saveExperience(lt);	
		return expList.get(0);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return null;
	}
	
	
	@RequestMapping(value = "/getExperienceByTeacherId", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> getExperienceByTeacherId(@RequestBody String data,@RequestHeader("username") String username) {
		return  ResponseEntity.ok(new CustomResponse(1,"sucess",experienceInterface.getExperienceByTeacherId(Integer.parseInt(data)),"200"));
	}
	
	@RequestMapping(value = "/deleteByWorkExperienceId", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> deleteByWorkExperienceId(@RequestBody String data,@RequestHeader("username") String username) {
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherExperience expObj=new TeacherExperience();
		try {
			expObj = mapperObj.readValue(data, new TypeReference<TeacherExperience>() {
			});
		}catch(Exception ex) {
			LOGGER.warn("--message--",ex);
		}
//		// System.out.println(expObj.getWorkExperienceId());
		return  ResponseEntity.ok(new CustomResponse(1,"sucess",experienceInterface.deleteByWorkExperienceId(expObj.getWorkExperienceId()),"200"));
	}
	
	
	
	
	
}
