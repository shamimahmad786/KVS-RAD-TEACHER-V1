//package com.example.MOERADTEACHER.common.service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.example.MOERADTEACHER.common.interfaces.PromotionInterface;
//import com.example.MOERADTEACHER.common.modal.TeacherPromotion;
//import com.example.MOERADTEACHER.common.repository.TeacherPromotionRepository;
//
//@Service
//public class PromotionImpl implements PromotionInterface{
//	
//	private static final Logger LOGGER = LoggerFactory.getLogger(PromotionImpl.class);
//
//	@Autowired
//	TeacherPromotionRepository teacherPromotionRepository;
//	
//	
//	
//	public ResponseEntity<TeacherPromotion> findAllByPositionTypeAndWorkStartDate(TeacherPromotion data) {
//		return null;	
//	
//	}
//	
//	
//	public List<TeacherPromotion> findAllByTeacherId(Integer teacherId) {
//	
//	List<TeacherPromotion>	protonList=teacherPromotionRepository.findAllByTeacherId(teacherId);
//		return protonList;	
//	
//	}
//	
//	public List<TeacherPromotion> savePromotion(List<TeacherPromotion> data) {
//		
//		List<TeacherPromotion>	dataObj=teacherPromotionRepository.saveAll(data);
//			return dataObj;	
//		
//		}
//	
//public TeacherPromotion savePromotion(TeacherPromotion data) {
//		
//		TeacherPromotion	dataObj=teacherPromotionRepository.save(data);
//			return dataObj;	
//		
//		}
//	
//	public List<TeacherPromotion> getPromotionByTeacherId(String teacherId){
//		return teacherPromotionRepository.findAllByTeacherId(Integer.parseInt(teacherId));
//	}
//	 
//	public Map<String,Object> deletePromotion(Integer teacherId){
//		Map<String,Object> mp=new HashMap<String,Object>();
//		try {
//		 teacherPromotionRepository.deleteById(teacherId);
//		 mp.put("status", "1");
//		}catch(Exception ex) {
//			mp.put("status", "0");
//			ex.printStackTrace();
//		}
//		return mp;
//	}
//	
//	
//}
