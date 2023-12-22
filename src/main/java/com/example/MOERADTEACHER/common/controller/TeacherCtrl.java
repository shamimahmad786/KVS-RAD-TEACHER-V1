package com.example.MOERADTEACHER.common.controller;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.bean.KVTeacherBean;
import com.example.MOERADTEACHER.common.bean.SchoolFetchTeacherBean;
import com.example.MOERADTEACHER.common.bean.TeacherProfileBeans;
import com.example.MOERADTEACHER.common.bean.UpdateFlag;
import com.example.MOERADTEACHER.common.interfaces.TeacherInterface;
import com.example.MOERADTEACHER.common.modal.KVTeacher;
import com.example.MOERADTEACHER.common.modal.KvRegionMaster;
import com.example.MOERADTEACHER.common.modal.KvSchoolMaster;
import com.example.MOERADTEACHER.common.modal.KvStationMaster;
import com.example.MOERADTEACHER.common.modal.Teacher;
import com.example.MOERADTEACHER.common.modal.TeacherExperience;
import com.example.MOERADTEACHER.common.modal.TeacherFormStatus;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
import com.example.MOERADTEACHER.common.modal.TeacherProfileConfirmation;
//import com.example.MOERADTEACHER.modal.TeacherProfileCurrectionInitiate;
//import com.example.MOERADTEACHER.modal.TeacherProfileHistory;
//import com.example.MOERADTEACHER.common.modal.TeacherPromotion;
import com.example.MOERADTEACHER.common.service.KVTeacherImpl;
import com.example.MOERADTEACHER.common.service.KvMasterImpl;
import com.example.MOERADTEACHER.common.service.TeacherImpl;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.CommonMailRequest;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.example.MOERADTEACHER.common.util.FixHashing;
import com.example.MOERADTEACHER.common.util.HandlingNull;
import com.example.MOERADTEACHER.common.util.StaticReportBean;
import com.example.MOERADTEACHER.security.util.GenericUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(ApiPaths.teachCtrl.CTRL)
//@CrossOrigin(origins = "*", allowedHeaders = "*")

@CrossOrigin(origins = {"https://kvsdemo.udiseplus.gov.in/","https://kvsonlinetransfer.kvs.gov.in","http://10.25.26.251:4200","http://10.25.26.10:4200","http://10.25.26.10:6200","http://demo.sdmis.gov.in","http://pgi.seshagun.gov.in","https://pgi.udiseplus.gov.in","http://pgi.udiseplus.gov.in","https://demopgi.udiseplus.gov.in","https://dashboard.seshagun.gov.in/","https://dashboard.udiseplus.gov.in"}, allowedHeaders = "*",allowCredentials = "true")

//@Validated
public class TeacherCtrl {
	 private static final Logger LOGGER = LoggerFactory.getLogger(TeacherCtrl.class);
	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	TeacherImpl teacherImpl;
	
	@Autowired
	TeacherInterface teacherInterface;
	
	@Autowired
	KVTeacherImpl kvTeacherImpl;
	
	@Autowired
	KvMasterImpl kvMasterImpl;
	
//	@Autowired
//	PromotionCtrl promotionCtrl;
	
	@Autowired
	ExperienceCtrl  experienceCtrl; 
	

	
	@RequestMapping(value = "/getTeacherBySchool", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getTeacherBySchool(@RequestBody Teacher data,@RequestHeader("username") String username) throws Exception {
		List<Teacher> result=teacherInterface.getTeacherBySchool(data.getUdiseSchCode());
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}
	
//	@RequestMapping(value = "/saveTeacher", method = RequestMethod.POST)
//	public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher data) throws Exception {
//		Teacher result=teacherImpl.saveTeacher(data);
//		return ResponseEntity.ok(result);
//	}
	
	@RequestMapping(value = "/saveTeacher", method = RequestMethod.POST)
	@Transactional(rollbackFor = {Exception.class})
	public ResponseEntity<CustomResponse> saveTeacher(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
		
		System.out.println("profile save-->"+data);
		
		Integer statusFlag=0;
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherProfile tdata=new TeacherProfile();
		TeacherFormStatus formData=new TeacherFormStatus();
		TeacherProfile result = null;
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TeacherProfile>() {
			});
		}catch(Exception ex) {
			LOGGER.warn("--message--",ex);
		}
		
		
		System.out.println("tdata--->"+tdata.getTeacherDob());
		
	    Date date = new Date(); 
	    
//	    String formattedDate = tdata.getTeacherDob();
//	    tdata.setTeacherDob(tdata.getTeacherDob());
//	    tdata.setWorkExperienceWorkStartDatePresentKv(tdata.getWorkExperienceWorkStartDatePresentKv());
//	    tdata.setWorkExperiencePositionTypePresentStationStartDate(convertToDate(tdata.getWorkExperiencePositionTypePresentStationStartDate()));
//	    tdata.setLastPromotionPositionDate(tdata.getLastPromotionPositionDate());
	    
	    
	    
//	   ;
	    
		if(tdata.getTeacherId() ==null) {
			tdata.setCreatedBy(username);
			tdata.setCreatedTime(date);
			/* Added By Bibek*/
//			tdata.setKvCode(tdata.getCurrentUdiseSchCode());
			statusFlag=1;
		}
		tdata.setModifiedBy(username);
		tdata.setModifiedTime(date);
		tdata.setDropBoxFlag(0);
		
		try {
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
//		try {
////			workExperienceWorkStartDatePresentKv
//			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//			Date workExperienceWorkStartDatePresentKv = formatter.parse(tdata.getWorkExperienceWorkStartDatePresentKv());
//			Date workExperiencePositionTypePresentStationStartDate = formatter.parse(tdata.getWorkExperienceWorkStartDatePresentKv());
//			Date lastPromotionPositionDate = formatter.parse(tdata.getWorkExperienceWorkStartDatePresentKv());
//			if((lastPromotionPositionDate.getDate()<=workExperiencePositionTypePresentStationStartDate.getDate())  && (workExperiencePositionTypePresentStationStartDate.getDate()<=workExperienceWorkStartDatePresentKv.getDate())) {
//				
//			}else {
//				return ResponseEntity.ok(new CustomResponse(0,"error","","500"));	
//			}
//			
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}
		
		
		
		try {
			
//			 System.out.println("spouse status--->"+tdata.getSpouseStatus());
//			 System.out.println(tdata.getId());
			
		result=teacherInterface.saveTeacher(tdata);
		
		System.out.println("result");
		tdata.setTeacherId(result.getTeacherId());
		System.out.println("experience");
//		TeacherPromotion proObj=promotionCtrl.savePromotion(tdata);
		TeacherExperience expObj= experienceCtrl.saveExperience(tdata);
//		result.setWorkExperienceIdPresentKv(expObj.getWorkExperienceId());
//		result.setLastPromotionId(String.valueOf(proObj.getPromotionId()));
		
		System.out.println("dasdasd--->"+expObj.getWorkExperienceId());
		
		result.setWorkExperienceIdPresentKv(expObj.getWorkExperienceId());
		result=teacherInterface.saveTeacher(result);
		
		System.out.println("result-->"+result);
		}catch(Exception ex){
			ex.printStackTrace();
			LOGGER.warn("--message--",ex);
		}
		if(statusFlag==1) {
			teacherInterface.saveStatus(tdata);
		}
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}
	
	@RequestMapping(value = "/getTeacherByTeacherId", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getTeacherByTeacherId(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
		HandlingNull hObj=new HandlingNull();	
		TeacherProfile result=teacherInterface.getTeacherByTeacherId(Integer.parseInt(data));
		LOGGER.warn("##################################"+String.valueOf(result.getTeacherId()));
		 ObjectMapper objectMapper = new ObjectMapper();
		 Map<Object, Object> map = objectMapper.convertValue(result, Map.class);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",hObj.handling(map),"200"));
	}
	
	
	@RequestMapping(value = "/verifyTeacher", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> verifyTeacher(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
		FixHashing hashObj= new FixHashing();
		
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherProfile tdata=new TeacherProfile();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TeacherProfile>() {
			});
		}catch(Exception ex) {
			LOGGER.warn("--message--",ex);
		}
		StaticReportBean result=teacherInterface.verifyTeacher(tdata);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}
	
	@RequestMapping(value = "/saveKvTeacher", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> saveKvTeacher(@RequestBody KVTeacher data,@RequestHeader("username") String username) throws Exception {
		KVTeacher result = kvTeacherImpl.saveKvTeacher(data);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}
	
	@RequestMapping(value = "/getKvTeacherByKvCode", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getKvTeacherByKvCode(@RequestBody String data,@RequestHeader("username") String username) {	
		List<KVTeacher> optionalResult = kvTeacherImpl.getKvTeacherByKvCode(data);
		Type listType = new TypeToken<List<KVTeacher>>(){}.getType();
		List<KVTeacherBean> dtoSurveyMaster = modelMapper.map(optionalResult, listType);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",dtoSurveyMaster,"200"));
	}
	
	@RequestMapping(value = "/getKvTeacherByUdiseCode", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getKvTeacherByUdiseCode(@RequestBody String data,@RequestHeader("username") String username) {	
		List<Map<Object,Object>> ltmp=new LinkedList<Map<Object,Object>>();
		List<TeacherProfile> result =kvTeacherImpl.getKvTeacherByUdiseCode(data);
		HandlingNull hObj=new HandlingNull();
		ObjectMapper objectMapper = new ObjectMapper();
		for(int i=0;i<result.size();i++) {
			 Map<Object, Object> map = objectMapper.convertValue(result.get(i), Map.class);
			 ltmp.add(hObj.handling(map));
		}
		
		return ResponseEntity.ok(new CustomResponse(1,"sucess",ltmp,"200"));
	}
	
	
	
	@RequestMapping(value = "/getRegionMasterByCode", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getRegionMasterByCode(@RequestBody String data,@RequestHeader("username") String username) {
		KvRegionMaster optionalResult = kvMasterImpl.getRegionByCode(data);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",optionalResult,"200"));
	}
	
	@RequestMapping(value = "/getAllKvStationByRegionCode", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getAllKvStationByRegionCode(@RequestBody String data,@RequestHeader("username") String username) {	
		List<KvStationMaster> optionalResult = kvMasterImpl.getAllStationMasterByRegionCode(data);
		Type listType = new TypeToken<List<KvStationMaster>>(){}.getType();
		List<KvStationMaster> dtoSurveyMaster = modelMapper.map(optionalResult, listType);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",dtoSurveyMaster,"200"));
	}
	
//	@RequestMapping(value = "/getAllKvStationByStatinCode", method = RequestMethod.POST)
//	public ResponseEntity<List<KvSchoolMaster>> getAllKvStationByStatinCode(@RequestBody String data) {	
//		List<KvSchoolMaster> optionalResult = kvMasterImpl.getAllSchoolMasterByStatinCode(data);
//		Type listType = new TypeToken<List<KvSchoolMaster>>(){}.getType();
//		List<KvSchoolMaster> dtoSurveyMaster = modelMapper.map(optionalResult, listType);
//		return ResponseEntity.ok(dtoSurveyMaster);
//	}
	
	@RequestMapping(value = "/getKVTeacherByEmail", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getKVTeacherByEmail(@RequestBody String data,@RequestHeader("username") String username) {	
		List<KVTeacher> listtData = kvMasterImpl.getKVTeacherByEmail(data);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",listtData,"200"));
	}
	
	@RequestMapping(value = "/getKVTeacherByMobile", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> getKVTeacherByMobile(@RequestBody String data,@RequestHeader("username") String username) {	
		ObjectMapper mapperObj = new ObjectMapper();
		KVTeacher userData=new KVTeacher();
		try {
			userData = mapperObj.readValue(data, new TypeReference<KVTeacher>() {
			});
		}catch(Exception ex) {
			
		}
		List<KVTeacher> listtData = kvMasterImpl.getKVTeacherByMobile(userData.getMobile());
		return ResponseEntity.ok(new CustomResponse(1,"sucess",listtData,"200"));
	}
	
	@RequestMapping(value = "/getTeacherByMobile", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> getTeacherByMobile(@RequestBody String data,@RequestHeader("username") String username) {	
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherProfile userData=new TeacherProfile();
		try {
			userData = mapperObj.readValue(data, new TypeReference<TeacherProfile>() {
			});
		}catch(Exception ex) {
			
		}
		List<TeacherProfile> listtData = kvTeacherImpl.getTeacherByMobile(userData.getTeacherMobile());
		return ResponseEntity.ok(new CustomResponse(1,"sucess",listtData,"200"));
	}
	
	@RequestMapping(value = "/getTeacherDublicateMobile", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> getTeacherDublicateMobile(@RequestBody String data,@RequestHeader("username") String username) {
		return  ResponseEntity.ok(new CustomResponse(1,"sucess",kvTeacherImpl.getTeacherDublicateMobile(data),"200"));
	}
	
	
	@RequestMapping(value = "/getTeacherByAccountId", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> getTeacherByAccountId(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
		
		System.out.println("data payload--->"+data);
		
		TeacherProfile result=	kvTeacherImpl.getTeacherByAccountId(data);
		 ObjectMapper objectMapper = new ObjectMapper();
//		 objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		 Map<Object, Object> map = objectMapper.convertValue(result, 
				    Map.class);
		 // System.out.println(map);
		 HandlingNull hObj=new HandlingNull();
		return  ResponseEntity.ok(new CustomResponse(1,"sucess",hObj.handling(map),"200"));
	}
	
//	@RequestMapping(value = "/teacherProfileQueryInitiate", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<CustomResponse> teacherProfileQueryInitiate(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		ObjectMapper mapperObj = new ObjectMapper();
//		TeacherProfileCurrectionInitiate tdata=new TeacherProfileCurrectionInitiate();
//		try {
//			tdata = mapperObj.readValue(data, new TypeReference<TeacherProfileCurrectionInitiate>() {
//			});
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		return  ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.teacherProfileQueryInitiate(tdata),"200"));
//	}
	
//	@RequestMapping(value = "/getTeacherProfileQueryInitiate", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<CustomResponse> getTeacherProfileQueryInitiate(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
//		return  ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.getTeacherProfileQueryInitiate(Integer.parseInt(data)),"200"));
//	}
	
	
	@RequestMapping(value = "/updateTeacherSystemGeneratedCode", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> updateTeacherSystemGeneratedCode(@RequestBody String data,@RequestHeader("username") String username) throws Exception {		
		FixHashing hashObj= new FixHashing();
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherProfile tdata=new TeacherProfile();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TeacherProfile>() {
			});
		}catch(Exception ex) {
			LOGGER.warn("--message--",ex);
		}
		return  ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.updateTeacherSystemGeneratedCode(tdata),"200"));
	}
	
//	
//	@RequestMapping(value = "/updatdFlag", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<Map<String,Object>> updatdFlag(@RequestBody String data) throws Exception {		
//		FixHashing hashObj= new FixHashing();
//		ObjectMapper mapperObj = new ObjectMapper();
//		UpdateFlag tdata=new UpdateFlag();
//		try {
//			tdata = mapperObj.readValue(data, new TypeReference<UpdateFlag>() {
//			});
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		return  ResponseEntity.ok(teacherImpl.updatdFlag(tdata));
//	}
	
	@RequestMapping(value = "/updatdFlag", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> updatdFlag(@RequestBody String data,@RequestHeader("username") String username) throws Exception {	
		// System.out.println(data);
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherFormStatus tdata=new TeacherFormStatus();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TeacherFormStatus>() {
			});
		}catch(Exception ex) {
			LOGGER.warn("--message--",ex);
		}
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.updatdFlag(tdata),"200"));
}
	
	@RequestMapping(value = "/getUpdatdFlag", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> getUpdatdFlag(@RequestBody String data,@RequestHeader("username") String username) throws Exception {	
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.getUpdatdFlag(Integer.parseInt(data)),"200"));
}

	@RequestMapping(value = "/updateFlagByTeachId", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> getUpdateFlagByTeachId(@RequestBody String data,@RequestHeader("username") String username) throws Exception {	
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherFormStatus tdata=new TeacherFormStatus();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TeacherFormStatus>() {
			});
		}catch(Exception ex) {
			LOGGER.warn("--message--",ex);
		}
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.updateFlagByTeachId(tdata,username),"200"));
}
	
	
	@RequestMapping(value = "/getChangeHistory", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> getChangeHistory(@RequestBody String data,@RequestHeader("username") String username) throws Exception {	
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherFormStatus tdata=new TeacherFormStatus();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TeacherFormStatus>() {
			});
		}catch(Exception ex) {
			LOGGER.warn("--message--",ex);
		}
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.updateFlagByTeachId(tdata,username),"200"));
}
	
	

	@RequestMapping(value = "/getTeacherHistryByTeacherId", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> getTeacherHistryByTeacherId(@RequestBody String data,@RequestHeader("username") String username) throws Exception {	
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.getTeacherHistryByTeacherId(Integer.parseInt(data)),"200"));
}
	
	@RequestMapping(value = "/checkEmployeeCode", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> checkEmployeeCode(@RequestBody String data,@RequestHeader("username") String username) throws Exception {	
		if(teacherInterface.checkEmployeeCode(data).getTeacher_id() != null) {
			
			LOGGER.warn("-----------------message--",teacherInterface.checkEmployeeCode(data));
			
//			// System.out.println(teacherInterface.checkEmployeeCode(data));
			return ResponseEntity.ok(new CustomResponse(0,"Empoyee Exist",teacherInterface.checkEmployeeCode(data),"200"));
		}else {
			
			LOGGER.warn("-----------------message--1");
			return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.checkEmployeeCode(data),"200"));
		}
		
		
}
	
	
	@RequestMapping(value = "/changeTeacherSchool", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> changeTeacherSchool(@RequestBody String data,@RequestHeader("username") String username) throws Exception {	
		// System.out.println(data);
		ObjectMapper mapperObj = new ObjectMapper();
		SchoolFetchTeacherBean tdata=new SchoolFetchTeacherBean();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<SchoolFetchTeacherBean>() {
			});
		}catch(Exception ex) {
			LOGGER.warn("--message--",ex);
		}
		if(teacherInterface.changeTeacherSchool(tdata) != null) {
			new CustomResponse(0,"Empoyee Exist",teacherInterface.changeTeacherSchool(tdata),"200");
		}
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.changeTeacherSchool(tdata),"200"));
}
	
	@RequestMapping(value = "/dropTeacherBySchool", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> dropTeacherBySchool(@RequestBody String data,@RequestHeader("username") String username) throws Exception {		
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.dropTeacherBySchool(data),"200"));
}
	

	@RequestMapping(value = "/getOutboxTeacherByUdisecode", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> getOutboxTeacherByUdisecode(@RequestBody String data,@RequestHeader("username") String username) throws Exception {	
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.getOutboxTeacherByUdisecode(data),"200"));
}
	
	@RequestMapping(value = "/getConfirmedTeacherDetails", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> getTeacherDetailsForConfirmation(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.getTeacherDetailsForConfirmation(Integer.parseInt(data)),"200"));
	}
	
	
	public static String convertToDate(String dateString) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = inputFormat.parse(dateString.split("\\+")[0]);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	
//	::::::::::::::::::::::::::::::::::::New Service:::::::::::::::::::::::::::::::::: 06-12-2013
		
		
	@RequestMapping(value = "/saveProfileV2", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> saveProfileV2(@RequestBody String data,@RequestHeader("username") String username ,@RequestHeader("ipaddress") String ipaddress) throws Exception {	
		TeacherProfile tdata=new TeacherProfile();
		ObjectMapper mapperObj = new ObjectMapper();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TeacherProfile>() {
			});
		}catch(Exception ex) {
			LOGGER.warn("--message--",ex);
		}
		tdata.setCreatedBy(username);
		tdata.setModifiedBy(username);
		tdata.setIpAddress(ipaddress);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.saveProfileV2(tdata),"200"));
      }
	
	
	@RequestMapping(value = "/getEmployeeDetailV2", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> getEmployeeDetailV2(@RequestBody String data,@RequestHeader("username") String username ,@RequestHeader("ipaddress") String ipaddress) throws Exception {	
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.getEmployeeDetailV2(String.valueOf(mObj.get("teacherEmployeeCode"))),"200"));
    }
	
	
	@RequestMapping(value = "/getFormStatusV2", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> saveFormStatusV2(@RequestBody String data,@RequestHeader("username") String username ,@RequestHeader("ipaddress") String ipaddress) throws Exception {	
		TeacherFormStatus tdata=new TeacherFormStatus();
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.getFormStatusV2(String.valueOf(mObj.get("teacherId"))),"200"));
      }
	
	
	@RequestMapping(value = "/getConfirmedTeacherDetailsV2", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> getConfirmedTeacherDetailsV2(@RequestBody String data,@RequestHeader("username") String username) throws Exception {
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.getConfirmedTeacherDetailsV2(Integer.parseInt(data)),"200"));
	}
	
	@RequestMapping(value = "/saveTeacherConfirmationV2", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> saveTeacherConfirmationV2(@RequestBody String data,@RequestHeader("username") String username, @RequestHeader("ipaddress") String ipaddress) throws Exception {
		TeacherProfileConfirmation tdata=new TeacherProfileConfirmation();
		ObjectMapper mapperObj = new ObjectMapper();
		try {
			System.out.println(data);
			tdata = mapperObj.readValue(data, new TypeReference<TeacherProfileConfirmation>() {
			});
		}catch(Exception ex) {
			LOGGER.warn("--message--",ex);
		}
		tdata.setIp(ipaddress);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.saveTeacherConfirmationV2(tdata),"200"));
	}
	
	
	@RequestMapping(value = "/getTeacherConfirmationV2", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> getTeacherConfirmationV2(@RequestBody String data,@RequestHeader("username") String username, @RequestHeader("ipaddress") String ipaddress) throws Exception {
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.getTeacherConfirmationV2(Integer.parseInt(String.valueOf(mObj.get("teacherId")))),"200"));
	}
	
	@RequestMapping(value = "/getSpouseDetailsV2", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<CustomResponse> getSpouseDetailsV2(@RequestBody String data,@RequestHeader("username") String username, @RequestHeader("ipaddress") String ipaddress) throws Exception {
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",teacherInterface.getSpouseDetailsV2(Integer.parseInt(String.valueOf(mObj.get("teacherId")))),"200"));
	}

	
}
	
	
	
	
	
	


