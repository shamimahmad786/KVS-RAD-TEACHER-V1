package com.example.MOERADTEACHER.common.mastercontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.masterbean.RegionMaster;
import com.example.MOERADTEACHER.common.masterbean.StationBean;
import com.example.MOERADTEACHER.common.masterbean.StationManagementMaster;
import com.example.MOERADTEACHER.common.masterbean.StationMaster;
import com.example.MOERADTEACHER.common.masterrepository.RegionMasterRepository;
import com.example.MOERADTEACHER.common.masterservice.MasterManagementImpl;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping(ApiPaths.MasterManagementCtrl.CTRL)
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@CrossOrigin(origins = {"https://kvsdemo.udiseplus.gov.in/","https://kvsonlinetransfer.kvs.gov.in","http://10.25.26.251:4200","http://10.25.26.10:4200","http://10.25.26.10:6200","http://demo.sdmis.gov.in","http://pgi.seshagun.gov.in","https://pgi.udiseplus.gov.in","http://pgi.udiseplus.gov.in","https://demopgi.udiseplus.gov.in","https://dashboard.seshagun.gov.in/","https://dashboard.udiseplus.gov.in"}, allowedHeaders = "*",allowCredentials = "true")
public class MasterManagementController {
	
	@Autowired
	MasterManagementImpl masterManagementImpl;
	
	@RequestMapping(value = "/saveStationMaster", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> saveStationMaster(@RequestHeader("username") String username,@RequestBody String data) throws Exception {
		ObjectMapper mapperObj = new ObjectMapper();
		StationMaster obj = mapperObj.readValue(data, new TypeReference<StationMaster>() {
		});
		return ResponseEntity.ok(new CustomResponse(1,"sucess",masterManagementImpl.saveStationMaster(obj),"200"));
	}
	
	@RequestMapping(value = "/getStationMaster", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getStationMaster(@RequestHeader("username") String username) throws Exception {
		
		System.out.println("called for master");
		
		return ResponseEntity.ok(new CustomResponse(1,"sucess",masterManagementImpl.getStationMaster(),"200"));
	}
	
	@RequestMapping(value = "/deleteStationMaster", method = RequestMethod.POST)
	public ResponseEntity<HashMap<String,Integer>> deleteStationMaster(@RequestHeader("username") String username,@RequestBody String data) throws Exception {
		
		System.out.println("called for master--->"+data);
		HashMap<String,Integer> mp=new HashMap<String,Integer>();
		try {
			masterManagementImpl.deleteStationMaster(data);
		mp.put("status", 1);
		}catch(Exception ex) {
		mp.put("status", 0);
			ex.printStackTrace();
		}
	
		
		return ResponseEntity.ok(mp);
	}
	
	
	
	
	@RequestMapping(value = "/getRegionMaster", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getRegionMaster(@RequestHeader("username") String username) throws Exception {
		return ResponseEntity.ok(new CustomResponse(1,"sucess",masterManagementImpl.getRegionMaster(),"200"));
	}
	
	
	@RequestMapping(value = "/saveRegionMaster", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> saveRegionMaster(@RequestHeader("username") String username,@RequestBody String data) throws Exception {
		ObjectMapper mapperObj = new ObjectMapper();
		RegionMaster obj = mapperObj.readValue(data, new TypeReference<RegionMaster>() {
		});
		return ResponseEntity.ok(new CustomResponse(1,"sucess",masterManagementImpl.saveRegionMaster(obj),"200"));
	}
	
	@RequestMapping(value = "/deleteRegionMaster", method = RequestMethod.POST)
	public ResponseEntity<HashMap<String,Integer>> deleteRegionMaster(@RequestBody String data) throws Exception {
		HashMap<String,Integer> mp=new HashMap<String,Integer>();
		try {
		masterManagementImpl.deleteRegionMaster(Integer.parseInt(data));
		mp.put("status", 1);
		}catch(Exception ex) {
		mp.put("status", 0);
			ex.printStackTrace();
		}
		return ResponseEntity.ok(mp);
	}
	
	
	
	
}
