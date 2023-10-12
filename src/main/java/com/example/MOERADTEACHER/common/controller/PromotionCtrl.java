//package com.example.MOERADTEACHER.common.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.MOERADTEACHER.common.interfaces.PromotionInterface;
////import com.example.MOERADTEACHER.interfaces.PromotionInterface;
//import com.example.MOERADTEACHER.common.modal.KVTeacher;
//import com.example.MOERADTEACHER.common.modal.TeacherProfile;
//import com.example.MOERADTEACHER.common.modal.TeacherPromotion;
//import com.example.MOERADTEACHER.common.repository.TeacherPromotionRepository;
//import com.example.MOERADTEACHER.common.service.PromotionImpl;
//import com.example.MOERADTEACHER.common.util.ApiPaths;
//import com.example.MOERADTEACHER.common.util.CustomResponse;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@RestController
//@RequestMapping(ApiPaths.PromotionCtrl.CTRL)
////@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = {"https://kvsdemo.udiseplus.gov.in/","https://kvsonlinetransfer.kvs.gov.in","http://10.25.26.251:4200","http://10.25.26.10:4200","http://10.25.26.10:6200","http://demo.sdmis.gov.in","http://pgi.seshagun.gov.in","https://pgi.udiseplus.gov.in","http://pgi.udiseplus.gov.in","https://demopgi.udiseplus.gov.in","https://dashboard.seshagun.gov.in/","https://dashboard.udiseplus.gov.in"}, allowedHeaders = "*",allowCredentials = "true")
//public class PromotionCtrl {
//
////	@Autowired
////	TeacherPromotionRepository teacherPromotionRepository;
//	 private static final Logger LOGGER = LoggerFactory.getLogger(PromotionCtrl.class);
////	@Autowired
////	PromotionImpl promotionImpl;
//	 @Autowired 
//	 PromotionInterface promotionInterface;
//	
//	@RequestMapping(value = "/savePromotion", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<CustomResponse> savePromotion(@RequestBody String data,@RequestHeader("username") String username) {	
////		// System.out.println("promotionImpl data---->"+data);
//		ObjectMapper mapperObj = new ObjectMapper();
//		List<TeacherPromotion> promotionData=new ArrayList<TeacherPromotion>();
//		TeacherPromotion pObj = null;
//		try {
//			promotionData = mapperObj.readValue(data, new TypeReference<List<TeacherPromotion>>() {
//			});
//		}catch(Exception ex) {
//			LOGGER.warn("--message--",ex);
//		}
//		try {
//			
//			// find By  PositionType and teacherId
//			
////			List<TeacherPromotion> findObj=	promotionImpl.findAllByTeacherId(promotionData.getTeacherId());
//			
//			
////			TeacherPromotion findObj=	teacherPromotionRepository.findAllByPositionTypeAndWorkStartDate(promotionData.getPositionType(), promotionData.getWorkStartDate());			
////			if(findObj.size() ==0) {
////				 pObj=	promotionImpl.savePromotion(promotionData);
////			}else {
////				for(int i=0;i<findObj.size();i++) {
////					if(findObj.get(i).getPositionType().equalsIgnoreCase(promotionData.getPositionType()) && !findObj.get(i).getWorkStartDate().equalsIgnoreCase(promotionData.getWorkStartDate())) {
////						promotionData.setPromotionId(findObj.get(i).getPromotionId());
////						pObj=	promotionImpl.savePromotion(promotionData);	
////					}else if(!findObj.get(i).getPositionType().equalsIgnoreCase(promotionData.getPositionType()) && findObj.get(i).getWorkStartDate().equalsIgnoreCase(promotionData.getWorkStartDate())) {
////						promotionData.setPromotionId(findObj.get(i).getPromotionId());
////						pObj=	promotionImpl.savePromotion(promotionData);	
////					}else if(!findObj.get(i).getPositionType().equalsIgnoreCase(promotionData.getPositionType()) && !findObj.get(i).getWorkStartDate().equalsIgnoreCase(promotionData.getWorkStartDate())) {
////						pObj=	promotionImpl.savePromotion(promotionData);	
////					}
////				}
////			}
//			
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		
//		return  ResponseEntity.ok(new CustomResponse(1,"sucess",promotionInterface.savePromotion(promotionData),"200"));
////		List<TeacherProfile> listtData = kvTeacherImpl.getTeacherByMobile(userData.getTeacherMobile());
////		return ResponseEntity.ok(listtData);
//	}
//	
//	
//	public TeacherPromotion savePromotion(TeacherProfile promotion) {	
//		
//		
////		// System.out.println("data---->"+data);
//		ObjectMapper mapperObj = new ObjectMapper();
//		TeacherPromotion promotionData=new TeacherPromotion();
//		
//		promotionData.setTeacherId(promotion.getTeacherId());
//		promotionData.setPositionType(promotion.getLastPromotionPositionType());
//		promotionData.setWorkStartDate(promotion.getLastPromotionPositionDate());
////		// System.out.println("check null----->"+promotion.getLastPromotionId());
//		if(promotion.getLastPromotionId() !=null && promotion.getLastPromotionId() !="" && !promotion.getLastPromotionId().equalsIgnoreCase("null") ) {
//			if(Integer.parseInt(promotion.getLastPromotionId())>1) {
//		promotionData.setPromotionId(Integer.parseInt(promotion.getLastPromotionId()));
//			}
//		}
//		TeacherPromotion pObj = null;
//		Integer promotionId = null;
//		Boolean updateFlag = false;
//		Boolean addFlag = null;
////		try {
////			promotionData = mapperObj.readValue(data, new TypeReference<TeacherPromotion>() {
////			});
////		}catch(Exception ex) {
////			ex.printStackTrace();
////		}
////		// System.out.println("teacherId--->"+promotionData.getTeacherId());
////		// System.out.println("promotionData---->"+promotionData.getPositionType());
//		
//		try {
//			pObj=	promotionInterface.savePromotion(promotionData);
//			// find By  PositionType and teacherId
////			List<String> promoFlag=new ArrayList<String>();
////			
////			List<TeacherPromotion> findObj=	promotionImpl.findAllByTeacherId(promotionData.getTeacherId());
////
////			if(findObj.size() ==0) {
////				 pObj=	promotionImpl.savePromotion(promotionData);
////			}else {
////				for(int i=0;i<findObj.size();i++) {
////					
////					
////					
////					if(findObj.get(i).getPositionType().equalsIgnoreCase(promotionData.getPositionType()) && !findObj.get(i).getWorkStartDate().equalsIgnoreCase(promotionData.getWorkStartDate())) {
//////						promotionData.setPromotionId(findObj.get(i).getPromotionId());
//////						pObj=	promotionImpl.savePromotion(promotionData);	
////						promotionId=findObj.get(i).getPromotionId();
////						promoFlag.add("U");
//////						break;
////					}else if(!findObj.get(i).getPositionType().equalsIgnoreCase(promotionData.getPositionType()) && findObj.get(i).getWorkStartDate().equalsIgnoreCase(promotionData.getWorkStartDate())) {
//////						promotionData.setPromotionId(findObj.get(i).getPromotionId());
//////						pObj=	promotionImpl.savePromotion(promotionData);	
////						promotionId=findObj.get(i).getPromotionId();
////						promoFlag.add("U");
////						// System.out.println("2");
//////						break;
////					}else if(!findObj.get(i).getPositionType().equalsIgnoreCase(promotionData.getPositionType()) && !findObj.get(i).getWorkStartDate().equalsIgnoreCase(promotionData.getWorkStartDate())) {
//////						pObj=	promotionImpl.savePromotion(promotionData);	
////						promoFlag.add("A");
////						// System.out.println("3");
////					
//////						break;
////					}
////				}
////				
////				for(int j=0;j<promoFlag.size();j++) {
////					
////					if(promoFlag.get(j).equalsIgnoreCase("U")) {
////						// System.out.println("in U--");
////						promotionData.setPromotionId(promotionId);
////						pObj=	promotionImpl.savePromotion(promotionData);	
////						updateFlag=true;
////						break;
////					}else if(promoFlag.get(j).equalsIgnoreCase("A")) {
////						// System.out.println("in A");
////						addFlag=true;
////					}
////				}
////				
////				if(updateFlag !=true && addFlag==true) {
////					// System.out.println("final add");
////					pObj=	promotionImpl.savePromotion(promotionData);
////				}
////			}
//			
//		}catch(Exception ex) {
//			LOGGER.warn("--message--",ex);
//		}
//		
//		return pObj;
//	}
//	
//	
//	@RequestMapping(value = "/getPromotionByTeacherId", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<CustomResponse> getPromotionByTeacherId(@RequestBody String data,@RequestHeader("username") String username) {
//		return ResponseEntity.ok(new CustomResponse(1,"sucess",promotionInterface.getPromotionByTeacherId(data),"200"));
//	}
//	
//	@RequestMapping(value = "/deletePromotion", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<CustomResponse> deletePromotion(@RequestBody String data,@RequestHeader("username") String username) {	
//		return ResponseEntity.ok(new CustomResponse(1,"sucess",promotionInterface.deletePromotion(Integer.parseInt(data)),"200"));
//	}
//	
//	
//}
