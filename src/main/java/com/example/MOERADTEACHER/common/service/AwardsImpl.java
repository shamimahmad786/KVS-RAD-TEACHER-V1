//package com.example.MOERADTEACHER.common.service;
//
//import java.math.BigInteger;
//import java.util.ArrayList;
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
//import com.example.MOERADTEACHER.common.interfaces.AwardsInterface;
//import com.example.MOERADTEACHER.common.modal.KvRegionMaster;
//import com.example.MOERADTEACHER.common.modal.TeacherAwards;
//import com.example.MOERADTEACHER.common.modal.TeacherTraining;
//import com.example.MOERADTEACHER.common.repository.TeacherAwardsRepository;
//import com.example.MOERADTEACHER.common.repository.TeacherTrainingRepository;
//
//@Service
//
//public class AwardsImpl implements AwardsInterface{
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(AwardsImpl.class);
//	@Autowired
//	TeacherAwardsRepository  teacherAwardsRepository;
//	
//	@Autowired
//	TeacherTrainingRepository teacherTrainingRepository;
//	
//	public List<TeacherAwards> saveAwards(List<TeacherAwards> data) {
//		List<TeacherAwards>  ltTeacher=new ArrayList<TeacherAwards>();
//		for(int i=0;i<data.size();i++) {
//			ltTeacher.add(teacherAwardsRepository.save(data.get(i)));
//		}
//		return ltTeacher;
//	}
//	
//	
//	public List<TeacherAwards> getAwardsByTeacherId(Integer data) {
//		
//		return teacherAwardsRepository.findAllByTeacherId(data);
//	}
//	
//	public List<TeacherTraining> saveTraning(List<TeacherTraining> data) {
//		List<TeacherTraining>  ltTeacher=new ArrayList<TeacherTraining>();
//		for(int i=0;i<data.size();i++) {
//			ltTeacher.add(teacherTrainingRepository.save(data.get(i)));
//		}
//		return ltTeacher;
//	}
//	
//	public List<TeacherTraining> getTraningByTeacherId(Integer teacherId) {
//		return teacherTrainingRepository.findAllByTeacherId(teacherId);
//	}
//	
//	public Map<String,Object> deleteAwards(Integer teacherId) {
//		Map<String,Object> mp=new HashMap<String,Object>();
//		try {
//			 teacherAwardsRepository.deleteById(teacherId);
//			 mp.put("status", 1);
//		}catch(Exception ex) {
//			ex.printStackTrace();
//			mp.put("status", 0);
//		}
//		return mp;
//		
//	}
//	
//	public Map<String,Object> deleteTraning(Integer bigInteger) {
//		Map<String,Object> mp=new HashMap<String,Object>();
//		try {
//			teacherTrainingRepository.deleteById(bigInteger);;
//			 mp.put("status", 1);
//		}catch(Exception ex) {
//			ex.printStackTrace();
//			mp.put("status", 0);
//		}
//		return mp;
//		
//	}
//	
//	
//	
//	
//}
