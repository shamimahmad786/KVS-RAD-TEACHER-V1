package com.example.MOERADTEACHER.common.transfercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.transferbean.SearchBeans;
import com.example.MOERADTEACHER.common.transferbean.TeacherTransferBean;
import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferedDetails;
import com.example.MOERADTEACHER.common.transfermodel.TransferKVTeacherDetails;
import com.example.MOERADTEACHER.common.transferservice.TransferProcessImpl;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.example.MOERADTEACHER.common.util.ResponseEntityBeans;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(ApiPaths.TransferProcessCtrl.CTRL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransferProcess {

	@Autowired
	TransferProcessImpl transferProcessImpl;
	
	@RequestMapping(value = "/searchEmployeeForTransfer", method = RequestMethod.POST)
	public ResponseEntity<?> searchEmployeeForTransfer(@RequestBody String data) throws Exception {	
		ObjectMapper mapperObj = new ObjectMapper();
		SearchBeans tdata = new SearchBeans();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<SearchBeans>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(transferProcessImpl.searchEmployeeForTransfer(tdata));
	}
	
	
	@RequestMapping(value = "/adminTransfer", method = RequestMethod.POST)
	public ResponseEntity<?> adminTransfer(@RequestBody String data) throws Exception {	
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherTransferedDetails tdata = new TeacherTransferedDetails();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TeacherTransferedDetails>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(transferProcessImpl.adminTransfer(tdata));
	}
	
	
	
	
	
	
	
	
}
