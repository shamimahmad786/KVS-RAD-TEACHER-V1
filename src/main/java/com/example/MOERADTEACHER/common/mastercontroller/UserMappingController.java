package com.example.MOERADTEACHER.common.mastercontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.masterbean.StationBean;
import com.example.MOERADTEACHER.common.masterservice.UserMappingControllerImpl;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.example.MOERADTEACHER.security.util.CustomEncryption;
import com.example.MOERADTEACHER.security.util.GenericUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(ApiPaths.UserMappingCtrl.CTRL)
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@CrossOrigin(origins = {"https://kvsdemo.udiseplus.gov.in/","https://kvsonlinetransfer.kvs.gov.in","http://10.25.26.251:4200","http://10.25.26.10:4200","http://10.25.26.10:6200","http://demo.sdmis.gov.in","http://pgi.seshagun.gov.in","https://pgi.udiseplus.gov.in","http://pgi.udiseplus.gov.in","https://demopgi.udiseplus.gov.in","https://dashboard.seshagun.gov.in/","https://dashboard.udiseplus.gov.in"}, allowedHeaders = "*",allowCredentials = "true")
public class UserMappingController {

	@Autowired
	UserMappingControllerImpl  userMappingControllerImpl; 
	
	
	@RequestMapping(value = "/getRegionSchool", method = RequestMethod.POST)
	public ResponseEntity<?> getRegionSchool(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		CustomEncryption fObj = new CustomEncryption();
//		data = fObj.decrypt(data, "1111111111111111");
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		return ResponseEntity.ok(userMappingControllerImpl.getRegionSchool(mObj));
	}
	
	@RequestMapping(value = "/getRegionSchoolEmployee", method = RequestMethod.POST)
	public ResponseEntity<?> getRegionSchoolEmployee(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		CustomEncryption fObj = new CustomEncryption();
//		data = fObj.decrypt(data, "1111111111111111");
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		return ResponseEntity.ok(userMappingControllerImpl.getRegionSchoolEmployee(mObj));
	}
	
}
