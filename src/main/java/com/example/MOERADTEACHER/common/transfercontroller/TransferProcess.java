package com.example.MOERADTEACHER.common.transfercontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.repository.TeacherFormStatusRepository;
import com.example.MOERADTEACHER.common.transferbean.SearchBeans;
import com.example.MOERADTEACHER.common.transferbean.TeacherTransferBean;
import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferConfirmation;
import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferedDetails;
import com.example.MOERADTEACHER.common.transfermodel.TransferKVTeacherDetails;
import com.example.MOERADTEACHER.common.transfermodel.TransferQuery;
import com.example.MOERADTEACHER.common.transferservice.TransferProcessImpl;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.CustomObjectMapper;
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
	
	@Autowired
	CustomObjectMapper customObjectMapper;
	
	
	
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
	
	
	@RequestMapping(value = "/queryRaised", method = RequestMethod.POST)
	public ResponseEntity<?> queryRaised(@RequestBody String data) throws Exception {	
		ObjectMapper mapperObj = new ObjectMapper();
		List<TransferQuery> tdata = new ArrayList<TransferQuery>();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<List<TransferQuery>>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(transferProcessImpl.queryRaised(tdata));
	}
	
	
	@RequestMapping(value = "/getRaisedQueryByEmpCode", method = RequestMethod.POST)
	public ResponseEntity<?> getRaisedQueryByEmpCode(@RequestBody String data) throws Exception {	
		ObjectMapper mapperObj = new ObjectMapper();
		TransferQuery tdata = new TransferQuery();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TransferQuery>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(transferProcessImpl.getRaisedQueryByEmpCode(tdata.getTeacherEmployeeCode()));
	}
	
	
	@RequestMapping(value = "/transferModification", method = RequestMethod.POST)
	public ResponseEntity<?> transferModification(@RequestBody String data) throws Exception {	
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherTransferedDetails tdata = new TeacherTransferedDetails();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TeacherTransferedDetails>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(transferProcessImpl.transferModification(tdata));
	}
	
	@RequestMapping(value = "/getModifiedTransferDetails", method = RequestMethod.POST)
	public ResponseEntity<?> getModifiedTransferDetails(@RequestBody String data) throws Exception {	
		ObjectMapper mapperObj = new ObjectMapper();
		Map<String,Object> obj=customObjectMapper.getMapObject(data);
		return ResponseEntity.ok(transferProcessImpl.getModifiedTransferDetails(obj));
	}
	
	@RequestMapping(value = "/transferCancelation", method = RequestMethod.POST)
	public ResponseEntity<?> transferCancelation(@RequestBody String data) throws Exception {	
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherTransferedDetails tdata = new TeacherTransferedDetails();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TeacherTransferedDetails>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(transferProcessImpl.transferCancelation(tdata));
	}
	
	@RequestMapping(value = "/getTransferedList", method = RequestMethod.POST)
	public ResponseEntity<?> getTransferedList(@RequestBody String data) throws Exception {	
		Map<String,Object> obj=customObjectMapper.getMapObject(data);
		return ResponseEntity.ok(transferProcessImpl.getTransferedList(obj));
	}
	
	@RequestMapping(value = "/getTransferDeailsByEmployeeCode", method = RequestMethod.POST)
	public ResponseEntity<?> getTransferDeailsByEmployeeCode() throws Exception {	
		ObjectMapper mapperObj = new ObjectMapper();
//		return ResponseEntity.ok(transferProcessImpl.getTransferedList());
		return null;
	}
	
	@RequestMapping(value = "/saveTransferConfirmation", method = RequestMethod.POST)
	public ResponseEntity<?> saveTransferConfirmation(@RequestBody String data) throws Exception {	
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherTransferConfirmation tdata = new TeacherTransferConfirmation();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TeacherTransferConfirmation>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(transferProcessImpl.saveTransferConfirmation(tdata));
	}
	
	
	@RequestMapping(value = "/confirmTransferBySchool", method = RequestMethod.POST)
	public ResponseEntity<?> confirmTransferBySchool(@RequestBody String data,@RequestHeader("username") String username) throws Exception {	
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherTransferConfirmation tdata = new TeacherTransferConfirmation();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TeacherTransferConfirmation>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		tdata.setConfirmBy(username);
		
		
		return ResponseEntity.ok(transferProcessImpl.confirmTransferBySchool(tdata));
	}
	
	
	
}
