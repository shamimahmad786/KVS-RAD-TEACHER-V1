package com.example.MOERADTEACHER.common.dropboxcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.dropboxbean.EmployeeDropbox;
import com.example.MOERADTEACHER.common.dropboxbean.EmployeeSearch;
import com.example.MOERADTEACHER.common.dropboxmodal.TeacherDropBox;
import com.example.MOERADTEACHER.common.dropboxservice.TeacherDropBoxImpl;
import com.example.MOERADTEACHER.common.modal.Teacher;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
import com.example.MOERADTEACHER.common.modal.TeacherTransferProfile;
import com.example.MOERADTEACHER.common.repository.TeacherProfileRepository;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.example.MOERADTEACHER.security.util.GenericUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(ApiPaths.dropboxCtrl.CTRL)
@CrossOrigin(origins = {"https://kvsdemo.udiseplus.gov.in/","https://kvsonlinetransfer.kvs.gov.in","http://10.25.26.251:4200","http://10.25.26.10:4200","http://10.25.26.10:6200","http://demo.sdmis.gov.in","http://pgi.seshagun.gov.in","https://pgi.udiseplus.gov.in","http://pgi.udiseplus.gov.in","https://demopgi.udiseplus.gov.in","https://dashboard.seshagun.gov.in/","https://dashboard.udiseplus.gov.in"}, allowedHeaders = "*",allowCredentials = "true")
public class TeacherDropboxCtrl {

	@Autowired
	TeacherProfileRepository  teacherProfileRepository;
	
	@Autowired
	TeacherDropBoxImpl teacherDropBoxImpl;
	
	@RequestMapping(value = "/dropEmployeeToDropbox", method = RequestMethod.POST)
	public ResponseEntity<?> dropEmployeeToDropbox(@RequestBody String data,@RequestHeader("username") String username,@RequestHeader("ipaddress") String ipaddress) throws Exception {
		ObjectMapper mapperObj = new ObjectMapper();
		EmployeeDropbox tdata=new EmployeeDropbox();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<EmployeeDropbox>() {
			});
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		TeacherProfile tpObj=teacherProfileRepository.findAllByTeacherId(tdata.getTeacherId());
		return ResponseEntity.ok(teacherDropBoxImpl.dropEmployeeToDropbox(tpObj,tdata,username,ipaddress));
	}
	
	@RequestMapping(value = "/getDroboxMaster", method = RequestMethod.POST)
	public ResponseEntity<?> getDroboxMaster() throws Exception {
		return ResponseEntity.ok(teacherDropBoxImpl.getDroboxMaster());
	}
	
	@RequestMapping(value = "/getDropedEmployeeByKvCode", method = RequestMethod.POST)
	public ResponseEntity<?> getDropedEmployeeByKvCode(@RequestBody String data) throws Exception {
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		return ResponseEntity.ok(teacherDropBoxImpl.getDropedEmployeeByKvCode(String.valueOf(mObj.get("kvCode"))));
	}
	
	@RequestMapping(value = "/searchEmployeeForImport", method = RequestMethod.POST)
	public ResponseEntity<?> searchEmployeeForImport(@RequestBody String data) throws Exception {
		ObjectMapper mapperObj = new ObjectMapper();
		EmployeeSearch usrList =new EmployeeSearch();
		try {
			usrList = mapperObj.readValue(data, new TypeReference<EmployeeSearch>() {
			});
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(teacherDropBoxImpl.searchEmployeeForImport(usrList.getEmpCode()));
	}
	
	@RequestMapping(value = "/importEmployeeFromDropbox", method = RequestMethod.POST)
	public ResponseEntity<?> importEmployeeFromDropbox(@RequestBody String data) throws Exception {
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		return ResponseEntity.ok(teacherDropBoxImpl.importEmployeeFromDropbox(mObj));
	}	
	
	
	@RequestMapping(value = "/revokeEmployeeFromDropbox", method = RequestMethod.POST)
	public ResponseEntity<?> revokeEmployeeFromDropbox(@RequestBody String data) throws Exception {
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		return ResponseEntity.ok(teacherDropBoxImpl.revokeEmployeeFromDropbox(mObj));
	}	
	
	
	
	
	
}
