package com.example.MOERADTEACHER.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.bean.MailBean;
import com.example.MOERADTEACHER.common.modal.KVTeacher;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.CommonMailRequest;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.moe.rad.beans.MailBean;

@RestController
@RequestMapping(ApiPaths.MailOtpCtrl.CTRL)
@CrossOrigin(origins = { "https://kvsdemo.udiseplus.gov.in/", "https://kvsonlinetransfer.kvs.gov.in",
		"http://10.25.26.251:4200", "http://10.25.26.10:4200", "http://10.25.26.10:6200", "http://demo.sdmis.gov.in",
		"http://pgi.seshagun.gov.in", "https://pgi.udiseplus.gov.in", "http://pgi.udiseplus.gov.in",
		"https://demopgi.udiseplus.gov.in", "https://dashboard.seshagun.gov.in/",
		"https://dashboard.udiseplus.gov.in" }, allowedHeaders = "*", allowCredentials = "true")
public class MailOtpCtrl {

	@Autowired
	CommonMailRequest commonMailRequest;

	@RequestMapping(value = "/sentConfirmProfileData", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> sentConfirmProfileData(@RequestBody String data,
			@RequestHeader("username") String username) throws Exception {
		MailBean dataObj = new MailBean();
		ObjectMapper mapperObj = new ObjectMapper();
		try {
			dataObj = mapperObj.readValue(data, new TypeReference<MailBean>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return ResponseEntity
				.ok(new CustomResponse(1, "sucess", commonMailRequest.teacherConfirmationData(data), "200"));
	}

}
