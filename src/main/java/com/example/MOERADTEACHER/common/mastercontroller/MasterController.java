package com.example.MOERADTEACHER.common.mastercontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.bean.MasterBean;
import com.example.MOERADTEACHER.common.exceptions.UserNotAuthorizedException;
import com.example.MOERADTEACHER.common.masterbean.PositionType;
import com.example.MOERADTEACHER.common.masterbean.RegionMaster;
import com.example.MOERADTEACHER.common.masterbean.SchoolMaster;
import com.example.MOERADTEACHER.common.masterbean.StationBean;
import com.example.MOERADTEACHER.common.masterbean.StationMaster;
import com.example.MOERADTEACHER.common.masterbean.TeacherAwardsMaster;
import com.example.MOERADTEACHER.common.masterbean.TeacherQualification;
import com.example.MOERADTEACHER.common.masterbean.TransferRegionMaster;
import com.example.MOERADTEACHER.common.masterbean.TransferStationMaster;
import com.example.MOERADTEACHER.common.masterservice.MasterImpl;
import com.example.MOERADTEACHER.common.modal.Teacher;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
//import com.example.MOERADTEACHER.common.modal.TeacherPromotion;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;
import com.example.MOERADTEACHER.common.util.StaticReportBean;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(ApiPaths.masterCtrl.CTRL)
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@CrossOrigin(origins = {"https://kvsdemo.udiseplus.gov.in/","https://kvsonlinetransfer.kvs.gov.in","http://10.25.26.251:4200","http://10.25.26.10:4200","http://10.25.26.10:6200","http://demo.sdmis.gov.in","http://pgi.seshagun.gov.in","https://pgi.udiseplus.gov.in","http://pgi.udiseplus.gov.in","https://demopgi.udiseplus.gov.in","https://dashboard.seshagun.gov.in/","https://dashboard.udiseplus.gov.in"}, allowedHeaders = "*",allowCredentials = "true")
public class MasterController {

	@Autowired
	MasterImpl masterImpl;
	
	@Autowired
	NativeRepository nativeRepository;
	
	@RequestMapping(value = "/getMaster", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getMaster(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
		// System.out.println("::::::::::Master call:::::::::::::::");
//		CustomResponse custRes=new CustomResponse();
//		if(username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return  ResponseEntity.ok(custRes);
//		}
		System.out.println("master data--->"+data);
		ObjectMapper mapperObj = new ObjectMapper();
		MasterBean obj = mapperObj.readValue(data, new TypeReference<MasterBean>() {
		});
		
		StaticReportBean result=masterImpl.getMaster(obj);
//		custRes.setStatus(1);
//		custRes.setResponse(result);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}
	
	@RequestMapping(value = "/getMaster1/{term}", method = RequestMethod.GET)
	public ResponseEntity<CustomResponse> getMaster1(@PathVariable("term") String term) throws Exception {
		// System.out.println("::::::::::Master call:::::::::::::::");
//		CustomResponse custRes=new CustomResponse();
//		if(username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return  ResponseEntity.ok(custRes);
//		}
		String data="";
		if(term.equalsIgnoreCase("1")) {
		 data="{\"extcall\":\"MOE_EXT_GET_SCHOOL_STAFF_COUNT\",\"conditionvalue\":[]}";
		}
		System.out.println("master data--->"+data);
		
		ObjectMapper mapperObj = new ObjectMapper();
		MasterBean obj = mapperObj.readValue(data, new TypeReference<MasterBean>() {
		});
		
		StaticReportBean result=masterImpl.getMaster(obj);
//		custRes.setStatus(1);
//		custRes.setResponse(result);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}
	
	@RequestMapping(value = "/getPsitionType", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getPsitionType(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes=new CustomResponse();
//		if(username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return  ResponseEntity.ok(custRes);
//		}
		List<PositionType> result=masterImpl.getPsitionType(Integer.parseInt(data));
//		custRes.setStatus(1);
//		custRes.setResponse(result);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}
	
	@RequestMapping(value = "/getAllMaster", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getAllMaster(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes=new CustomResponse();
//		if(username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return  ResponseEntity.ok(custRes);
//		}
		HashMap<String, Object> result=masterImpl.getAllMaster(Integer.parseInt(data));
//		custRes.setStatus(1);
//		custRes.setResponse(result);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}
	
	@RequestMapping(value = "/getSubjectByTeacherTypeId", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getSubjectByTeacherTypeId(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes=new CustomResponse();
//		if(username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return  ResponseEntity.ok(custRes);
//		}
		ObjectMapper mapperObj = new ObjectMapper();
		Map<String,String> obj = mapperObj.readValue(data, new TypeReference<Map<String, String>>() {
		});
		
		// System.out.println("ApplicationId----?"+obj.get("applicationId"));
		
//		return null;
		StaticReportBean result=masterImpl.getSubjectByTeacherTypeId(obj.get("applicationId"),obj.get("teacherTypeId"));
//		custRes.setStatus(1);
//		custRes.setResponse(result);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}
	
	@RequestMapping(value = "/getSchoolDetailsByKVCode", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getSchoolDetailsByKVCode(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes=new CustomResponse();
//		if(username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return  ResponseEntity.ok(custRes);
//		}
//		custRes.setStatus(1);
//		custRes.setResponse(masterImpl.getSchoolDetailsByKVCode(data));
		return  ResponseEntity.ok(new CustomResponse(1,"sucess",masterImpl.getSchoolDetailsByKVCode(data),"200"));
	
	}
	
	@RequestMapping(value = "/getQualificationByType", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> getQualificationByType(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes=new CustomResponse();
//		if(username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return  ResponseEntity.ok(custRes);
//		}
		
//		custRes.setStatus(1);
//		custRes.setResponse(masterImpl.getQualificationByType(data));
		
		return ResponseEntity.ok(new CustomResponse(1,"sucess",masterImpl.getQualificationByType(data),"200"));
		
	}
	
	@RequestMapping(value = "/getSubjectByQualification", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> getSubjectByQualification(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes=new CustomResponse();
//		if(username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return  ResponseEntity.ok(custRes);
//		}
//		custRes.setStatus(1);
//		custRes.setResponse(masterImpl.getSubjectByQualification(data));
		return ResponseEntity.ok(new CustomResponse(1,"sucess",masterImpl.getSubjectByQualification(data),"200"));
	}

	@RequestMapping(value = "/getAwards", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getAwards(@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes=new CustomResponse();
//		if(username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return  ResponseEntity.ok(custRes);
//		}
//		custRes.setStatus(1);
//		custRes.setResponse(masterImpl.getAwards());
		return ResponseEntity.ok(new CustomResponse(1,"sucess",masterImpl.getAwards(),"200"));
	}
	
	@RequestMapping(value = "/getState", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getState(@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes=new CustomResponse();
//		if(username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return  ResponseEntity.ok(custRes);
//		}
//		custRes.setStatus(1);
//		custRes.setResponse(masterImpl.getState());
		return ResponseEntity.ok(new CustomResponse(1,"sucess",masterImpl.getState(),"200"));
	}
	
	@RequestMapping(value = "/getDistrictByStateId", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getDistrictByStateId(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes=new CustomResponse();
//		if(username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return  ResponseEntity.ok(custRes);
//		}
//		if(data !=null) {
//		custRes.setStatus(1);
//		custRes.setResponse(masterImpl.getDistrictByStateId(Integer.parseInt(data)));
//		}
		return ResponseEntity.ok(new CustomResponse(1,"sucess",masterImpl.getDistrictByStateId(Integer.parseInt(data)),"200"));
	}
	
	@RequestMapping(value = "/getKVRegion", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getKVRegion(@RequestHeader("username") String username) throws Exception {
		
		System.out.println("Get Region");
		
//		CustomResponse custRes=new CustomResponse();
//		if(username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return  ResponseEntity.ok(custRes);
//		}
//		custRes.setStatus(1);
//		custRes.setResponse(masterImpl.getKVRegion());
		return ResponseEntity.ok(new CustomResponse(1,"sucess",masterImpl.getKVRegion(),"200"));
	}
	
	
	@RequestMapping(value = "/getKVRegions", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getKVRegions(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
		
		System.out.println("Get Region");
		
//		CustomResponse custRes=new CustomResponse();
//		if(username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return  ResponseEntity.ok(custRes);
//		}
//		custRes.setStatus(1);
//		custRes.setResponse(masterImpl.getKVRegion());
		System.out.println("data--->"+data);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",masterImpl.getKVRegions(data),"200"));
	}
	
	
	
	@RequestMapping(value = "/getOnlyKVRegion", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getOnlyKVRegion(@RequestHeader("username") String username) throws Exception {

		return ResponseEntity.ok(new CustomResponse(1,"sucess",masterImpl.getOnlyKVRegion(),"200"));
	}
	
	@RequestMapping(value = "/getStationByRegion", method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<CustomResponse> getStationByRegion(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes=new CustomResponse();
//		if(username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return  ResponseEntity.ok(custRes);
//		}
//		
//		try {
//			// System.out.println("at controller");
		
//		if(true) {
//			// System.out.println("at controller");
//			throw new UserNotAuthorizedException("User unauthenticated");
//		}
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}
		// System.out.println("masterImpl.getStationByRegion(data)--->"+masterImpl.getStationByRegion(data));
//		custRes.setStatus(1);
//		custRes.setResponse(masterImpl.getStationByRegion(data));
		return ResponseEntity.ok(new CustomResponse(1,"sucess",masterImpl.getStationByRegion(data),"200"));
	}
	
	@RequestMapping(value = "/getSchoolByStation", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getSchoolByStation(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes=new CustomResponse();
//		if(username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return  ResponseEntity.ok(custRes);
//		}
//		custRes.setStatus(1);
//		custRes.setResponse(masterImpl.getSchoolByStation(data));
		return ResponseEntity.ok(new CustomResponse(1,"sucess",masterImpl.getSchoolByStation(data),"200"));
	}
	
	@RequestMapping(value = "/getSchoolByMultipleStation", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getSchoolByMultipleStation(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes=new CustomResponse();
//		if(username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return  ResponseEntity.ok(custRes);
//		}
		
		ObjectMapper mapperObj = new ObjectMapper();
		StationBean obj = mapperObj.readValue(data, new TypeReference<StationBean>() {
		});
		
	
//		custRes.setStatus(1);
//		custRes.setResponse(masterImpl.getSchoolByMultipleStation(obj));
		return ResponseEntity.ok(new CustomResponse(1,"sucess",masterImpl.getSchoolByMultipleStation(obj),"200"));
	}
	
	@RequestMapping(value = "/getTransferRegion", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getTransferRegion(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
	List<RegionMaster> regionDTOAR = new ArrayList<RegionMaster>();
//	CustomResponse custObj=new CustomResponse();
	
	ObjectMapper mapperObj = new ObjectMapper();
	TransferRegionMaster obj = mapperObj.readValue(data, new TypeReference<TransferRegionMaster>() {
	});
	
	
		   try {
//			   String QueryString = getregionQryString("64345", "N", "N", "N");
			   String QueryString = getregionQryString(obj.getTeacherID(), obj.getNerFlag(),obj.getDfpFlag(), obj.getJcmFlag());
			   QueryResult qrObj = nativeRepository.executeQueries(QueryString);
			   for(int i=0; i<qrObj.getRowValue().size();i++) {
				   RegionMaster 	regionDTO = new RegionMaster();
				   regionDTO.setRegionCode(Integer.parseInt(String.valueOf(qrObj.getRowValue().get(i).get("region_code"))));
		        	 regionDTO.setRegionName(String.valueOf(qrObj.getRowValue().get(i).get("region_name")));
		        	 regionDTOAR.add(i,regionDTO);
			   }
//			   custObj.setStatus(1);
//			   custObj.setResponse(regionDTOAR);
		         
			   
		   }catch(Exception e) {
//			   custObj.setStatus(1);
		   }
		   
		   return ResponseEntity.ok(new CustomResponse(1,"sucess",regionDTOAR,"200"));
		
		
		
	}
	
	
	@RequestMapping(value = "/getTransferStation", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getTransferStation(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
	List<StationMaster> stationDTOAR = new ArrayList<StationMaster>();
//	CustomResponse custObj=new CustomResponse();
	
	ObjectMapper mapperObj = new ObjectMapper();
	TransferStationMaster obj = mapperObj.readValue(data, new TypeReference<TransferStationMaster>() {
	});
	
	
		   try {
			   String QueryString ="select distinct  k.station_code  , k.station_name  from kv.kv_school_master k "+ 
					   " where k.region_code = '"+ obj.getRegionCode() +"' and k.station_code not in " +
					   " (select k.station_code from public.teacher_profile  twe, kv.kv_school_master k "+
					   " where twe.current_udise_sch_code  = k.udise_sch_code and twe.teacher_id = '"+obj.getTeacherId()+"' ) " ;
			   QueryResult qrObj = nativeRepository.executeQueries(QueryString);
			   for(int i=0; i<qrObj.getRowValue().size();i++) {
//				   RegionMaster 	regionDTO = new RegionMaster();
//				   regionDTO.setRegionCode(Integer.parseInt(String.valueOf(qrObj.getRowValue().get(i).get("region_code"))));
//		        	 regionDTO.setRegionName(String.valueOf(qrObj.getRowValue().get(i).get("region_name")));
//		        	 regionDTOAR.add(i,regionDTO);
		        	 
		        	 
		        	 StationMaster 	stationDTO = new StationMaster(); 
		        	 stationDTO.setStatinCode(String.valueOf(qrObj.getRowValue().get(i).get("station_code")));
		        	 stationDTO.setStationName(String.valueOf(qrObj.getRowValue().get(i).get("station_name")));
		        	 stationDTOAR.add(i,stationDTO);
			   }
//			   custObj.setStatus(1);
//			   custObj.setResponse(stationDTOAR);
		         
			   
		   }catch(Exception e) {
//			   custObj.setStatus(1);
		   }
		   
		   return ResponseEntity.ok(new CustomResponse(1,"sucess",stationDTOAR,"200"));
		
		
		
	}
	
	
	
	   public static String getregionQryString(String TeacherID,String NERFlag, String DFPFlag, String JCMFlag)
	   {
		  String SqlRegion = "";
		  
		
		  
		  try {
			
			  
			  if(JCMFlag.equalsIgnoreCase("Y")) {
				  SqlRegion = "  select distinct k.region_code , k.region_name from public.teacher_profile  twe, kv.kv_school_master k "+ 
						  	" where twe.current_udise_sch_code  = k.udise_sch_code and twe.teacher_id = '"+ TeacherID +"'";  
				  return SqlRegion;
			  }
			  
			  if(NERFlag.equals("Y")) {
				  
				  if(DFPFlag.equalsIgnoreCase("Y")) {
					  
					  SqlRegion = " select distinct k.region_code , k.region_name  from kv.kv_school_master k";
					  return SqlRegion;
					  
				  }else {
					  SqlRegion = " select  distinct  k.region_code , k.region_name  from kv.kv_school_master k where k.station_type in ('2','3')";
					  return SqlRegion;
				  }
				  
			  }else {
				  SqlRegion = " select distinct k.region_code , k.region_name  from kv.kv_school_master k";
				  return SqlRegion;
			  }
			  
		  }catch(Exception e) {
			  
		  }
		   
		   return SqlRegion;
		   
	   }
	
	
		@RequestMapping(value = "/getTransferGround", method = RequestMethod.POST)
		public ResponseEntity<CustomResponse> getTransferGround(@RequestHeader("username") String username) throws Exception {
			return ResponseEntity.ok(new CustomResponse(1,"sucess",masterImpl.getTransferGround(),"200"));
		}
		
	
	
}
