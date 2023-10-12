//package com.example.MOERADTEACHER.common.service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.MOERADTEACHER.common.interfaces.QualificationInterface;
//import com.example.MOERADTEACHER.common.modal.Teacher;
//import com.example.MOERADTEACHER.common.modal.TeacherEducationalQualification;
//import com.example.MOERADTEACHER.common.modal.TeacherProfessionalQualification;
//import com.example.MOERADTEACHER.common.repository.TeacherEducationQualificationRepository;
//import com.example.MOERADTEACHER.common.repository.TeacherProfessionalQualificationRepository;
//import com.example.MOERADTEACHER.common.util.NativeRepository;
//import com.example.MOERADTEACHER.common.util.QueryResult;
//
//@Service
//public class QualificationImpl implements QualificationInterface {
//
//	@Autowired
//	TeacherEducationQualificationRepository teacherEducationQualificationRepository;
//
//	@Autowired
//	TeacherProfessionalQualificationRepository teacherProfessionalQualificationRepository;
//
//	@Autowired
//	NativeRepository nativeRepository;
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(QualificationImpl.class);
//
////	TeacherProfessionalQualification
//
//	@Override
//	public List<TeacherEducationalQualification> saveEducationalQualification(
//			List<TeacherEducationalQualification> listData) {
//
//		List<TeacherEducationalQualification> lt = new ArrayList<TeacherEducationalQualification>();
//		for (int i = 0; i < listData.size(); i++) {
//
//			Integer teacherEducationalQualificationId = 0;
//			if (listData.get(i).getTeacherEducationalQualificationId() == null
//					|| !(listData.get(i).getTeacherEducationalQualificationId() > 0)) {
//				QueryResult qrObj = nativeRepository.executeQueries(
//						"select  max(teacher_educational_qualification_id)  from public.teacher_educational_qualification_detail");
//				// System.out.println(qrObj);
//				if(qrObj.getRowValue().size()>0) {
//				teacherEducationalQualificationId = Integer
//						.parseInt(String.valueOf(qrObj.getRowValue().get(0).get("max")));
//				}
//				teacherEducationalQualificationId = teacherEducationalQualificationId + 1;
//				listData.get(i).setTeacherEducationalQualificationId(teacherEducationalQualificationId);
//			}
//
//			lt.add(teacherEducationQualificationRepository.save(listData.get(i)));
//		}
//
//		return lt;
//	}
//
//	@Override
//	public List<TeacherProfessionalQualification> saveProfessionalQualification(
//			List<TeacherProfessionalQualification> listData) {
//
//		List<TeacherProfessionalQualification> lt = new ArrayList<TeacherProfessionalQualification>();
//		for (int i = 0; i < listData.size(); i++) {
//			try {
//				Integer teacherProfesitionalQualificationId = 0;
//				if (listData.get(i).getTeacherProfessionalQualificationId() == null
//						|| (!(listData.get(i).getTeacherProfessionalQualificationId() > 0)
//								|| String.valueOf(listData.get(i).getTeacherProfessionalQualificationId()) == "")) {
////					// System.out.println("in if condition--->" + i);
//					QueryResult qrObj = nativeRepository.executeQueries(
//							"select  max(teacher_professional_qualification_id)  from public.teacher_professional_qualification_detail");
//					// System.out.println(qrObj);
//					
//					if(qrObj.getRowValue().size()>0) {
//					teacherProfesitionalQualificationId = Integer
//							.parseInt(String.valueOf(qrObj.getRowValue().get(0).get("max")));
//					}
//					teacherProfesitionalQualificationId = teacherProfesitionalQualificationId + 1;
//					listData.get(i).setTeacherProfessionalQualificationId(teacherProfesitionalQualificationId);
////				teacherProfessionalQualificationRepository.save(listData.get(i));
//				}
//				// System.out.println(listData.get(i).getQualificationDegreeMajor());
//
//				lt.add(teacherProfessionalQualificationRepository.save(listData.get(i)));
//			} catch (Exception ex) {
//				LOGGER.warn("message", ex);
//			}
//		}
//
//		return lt;
//
////		return teacherProfessionalQualificationRepository.saveAll(listData);
//	}
//
//	@Override
//	public List<TeacherEducationalQualification> getEducationalQualificationByTeacherId(Integer teacherId) {
//		List<TeacherEducationalQualification> listObj = teacherEducationQualificationRepository
//				.findAllByTeacherId(teacherId);
//
//		for (int i = 0; i < listObj.size(); i++) {
//			listObj.get(i).setQualificationDegreeMajorList(
//					Arrays.asList(listObj.get(i).getQualificationDegreeMajor().split("\\s*,\\s*")));
//			listObj.get(i).setQualificationDegreeMinorList(
//					Arrays.asList(listObj.get(i).getQualificationDegreeMinor().split("\\s*,\\s*")));
//		}
//
//		return listObj;
//	}
//
//	@Override
//	public List<TeacherProfessionalQualification> getProfesionalQualificationByTeacherId(Integer teacherId) {
//		List<TeacherProfessionalQualification> listObj = teacherProfessionalQualificationRepository
//				.findAllByTeacherId(teacherId);
//
//		for (int i = 0; i < listObj.size(); i++) {
//			listObj.get(i).setQualificationDegreeMajorList(
//					Arrays.asList(listObj.get(i).getQualificationDegreeMajor().split("\\s*,\\s*")));
//
//		}
//
//		return listObj;
//	}
//
//	@Override
//	public Map<String, Object> deteleEducationalQualification(Integer id) {
//		Map<String, Object> mp = new HashMap<String, Object>();
//		try {
//			teacherEducationQualificationRepository.deleteById(id);
//			mp.put("status", 1);
//		} catch (Exception ex) {
//			mp.put("status", 0);
//			LOGGER.warn("message", ex);
//		}
//		return mp;
//	}
//
//	@Override
//	public Map<String, Object> deleteProfessionalQualification(Integer id) {
//		Map<String, Object> mp = new HashMap<String, Object>();
//		try {
//			teacherProfessionalQualificationRepository.deleteById(id);
//			mp.put("status", 1);
//		} catch (Exception ex) {
//			mp.put("status", 0);
//			LOGGER.warn("message", ex);
//		}
//		return mp;
//	}
//
//}
