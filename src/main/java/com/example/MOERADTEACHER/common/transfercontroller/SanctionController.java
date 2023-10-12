package com.example.MOERADTEACHER.common.transfercontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.transferinterface.SanctionInterface;
import com.example.MOERADTEACHER.common.transfermodel.SanctionDetails;
import com.example.MOERADTEACHER.common.transfermodel.TransferKVTeacherDetails;
import com.example.MOERADTEACHER.common.transferservice.SanctionImpl;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//import antlr.collections.List;


@RestController
@RequestMapping(ApiPaths.TransferSanctionCtrl.CTRL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SanctionController {
	@Autowired
	SanctionImpl sanctionImpl;
	@Autowired
	SanctionInterface sanctionInterface;
	
	@RequestMapping(value = "/getSanctionData", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getSanctionData(@RequestBody String data,
			@RequestHeader("username") String username) throws Exception {
		List<SanctionDetails> result=	sanctionInterface.getSanctionData(data);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}
	
	@RequestMapping(value = "/saveSanctionData", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> saveSanctionData(@RequestBody String data,
			@RequestHeader("username") String username) throws Exception {
		ObjectMapper mapperObj = new ObjectMapper();
		ArrayList<SanctionDetails> tdata = new ArrayList<SanctionDetails>();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<ArrayList<SanctionDetails>>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		List<SanctionDetails> result=	sanctionInterface.saveSanctionData(tdata);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}
	
	
}
