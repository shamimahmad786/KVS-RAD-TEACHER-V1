package com.example.MOERADTEACHER.common.report.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.modal.KvsReport;
import com.example.MOERADTEACHER.common.modal.Teacher;
import com.example.MOERADTEACHER.common.report.service.ReportImpl;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.security.LoginNativeRepository;
import com.example.MOERADTEACHER.security.util.GenericUtil;

@RestController
@RequestMapping(ApiPaths.reportCtrl.CTRL)
@CrossOrigin(origins = {"https://kvsdemo.udiseplus.gov.in/","https://kvsonlinetransfer.kvs.gov.in","http://10.25.26.251:4200","http://10.25.26.10:4200","http://10.25.26.10:6200","http://demo.sdmis.gov.in","http://pgi.seshagun.gov.in","https://pgi.udiseplus.gov.in","http://pgi.udiseplus.gov.in","https://demopgi.udiseplus.gov.in","https://dashboard.seshagun.gov.in/","https://dashboard.udiseplus.gov.in"}, allowedHeaders = "*",allowCredentials = "true")
public class ReportCtrl {
	

	
	@Autowired
	ReportImpl  reportImpl;

	@RequestMapping(value = "/getSchoolListByRegion", method = RequestMethod.POST)
	public ResponseEntity<?> getSchoolListByRegion(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		return ResponseEntity.ok(reportImpl.getSchoolListByRegion(mObj));
	}
	
	@RequestMapping(value = "/getStationSchoolCountByRegion", method = RequestMethod.POST)
	public ResponseEntity<?> getStationSchoolCountByRegion() throws Exception {
		System.out.println("called");
		return ResponseEntity.ok(reportImpl.getStationSchoolCountByRegion());
	}
	
	@RequestMapping(value = "/getStationWiseSchoolCount", method = RequestMethod.POST)
	public ResponseEntity<?> getStationWiseSchoolCount() throws Exception {

//		Map<String, ArrayList<Map<String, Object>>> finalObj=null;
//		try {
//		List<Map<String,Object>>  list=reportImpl.getStationWiseSchoolCount();
//		System.out.println("list--->"+list);
//	finalObj=new HashMap<String,ArrayList<Map<String,Object>>>();
//		for(int i=0;i<list.size();i++) {
//			Iterator<Map.Entry<String, Object>>  entry =   list.get(i).entrySet().iterator();
//		System.out.println(entry);	
//			if(finalObj.containsKey(list.get(i).get("region_name"))) {
//				ArrayList<Map<String, Object>> lt=	finalObj.get(list.get(i).get("region_name"));
//				lt.add(list.get(i));
//				finalObj.put(String.valueOf(list.get(i).get("region_name")), lt);
//			}else {
//				ArrayList<Map<String, Object>> lt =new ArrayList<Map<String, Object>>();
//				System.out.println(entry.next().getKey());
//				lt.add(list.get(i));
//				finalObj.put(String.valueOf(list.get(i).get("region_name")), lt);
//			}
//		}
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}
		return ResponseEntity.ok(reportImpl.getStationWiseSchoolCount());
	}
	
	@RequestMapping(value = "/getListOfReport", method = RequestMethod.POST)
	public ResponseEntity<?> getListOfReport() {
		System.out.println("get report list");
		return ResponseEntity.ok(reportImpl.getListOfReport());
	}

	
	@RequestMapping(value = "/getUniversalReportById", method = RequestMethod.POST)
	public ResponseEntity<?> getUniversalReportById(@RequestBody String data) throws Exception {
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		return ResponseEntity.ok(reportImpl.getUniversalReportById(mObj));
	}
	
	
}
