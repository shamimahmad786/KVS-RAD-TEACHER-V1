package com.example.MOERADTEACHER.security.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.security.UserRepository;
import com.example.MOERADTEACHER.security.service.UserAuthServiceImpl;
import com.example.MOERADTEACHER.security.util.CustomEncryption;
import com.example.MOERADTEACHER.security.util.GenericUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(ApiPaths.UserManagementCtrl.CTRL)
@CrossOrigin(origins = { "https://kvsdemo.udiseplus.gov.in/", "https://kvsonlinetransfer.kvs.gov.in",
		"http://10.25.26.251:4200", "http://10.25.26.10:4200", "http://10.25.26.10:6200", "http://demo.sdmis.gov.in",
		"http://pgi.seshagun.gov.in", "https://pgi.udiseplus.gov.in", "http://pgi.udiseplus.gov.in",
		"https://demopgi.udiseplus.gov.in", "https://dashboard.seshagun.gov.in/",
		"https://dashboard.udiseplus.gov.in" }, allowedHeaders = "*", allowCredentials = "true")
public class UserManagementCtrl {
	
	@Autowired
	UserAuthServiceImpl userAuthServiceImpl;

	@RequestMapping(value = "/getChildUser", method = RequestMethod.POST)
	public ResponseEntity<?> getChildUser(@RequestBody String data, HttpServletRequest request)
			throws Exception {
//		CustomEncryption fObj = new CustomEncryption();
//		data = fObj.decrypt(data, "1111111111111111");
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		return ResponseEntity.ok(userAuthServiceImpl.getChildUser(String.valueOf(mObj.get("username"))));
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestBody String data, HttpServletRequest request)
			throws Exception {
//		CustomEncryption fObj = new CustomEncryption();
//		data = fObj.decrypt(data, "1111111111111111");
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		
		return ResponseEntity.ok(userAuthServiceImpl.updateUser(mObj));
	}
	

	
}
