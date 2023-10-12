//package com.example.MOERADTEACHER.common.interfaces;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//
//import com.example.MOERADTEACHER.common.modal.TeacherEducationalQualification;
//import com.example.MOERADTEACHER.common.modal.TeacherProfessionalQualification;
//import com.example.MOERADTEACHER.common.util.CustomResponse;
//
//public interface QualificationInterface {
//	List<TeacherEducationalQualification> saveEducationalQualification(List<TeacherEducationalQualification> listData);
//	List<TeacherProfessionalQualification> saveProfessionalQualification(List<TeacherProfessionalQualification> listData);
//	List<TeacherEducationalQualification> getEducationalQualificationByTeacherId(Integer teacherId);
//	List<TeacherProfessionalQualification> getProfesionalQualificationByTeacherId(Integer teacherId);
//	Map<String,Object> deteleEducationalQualification(Integer id);
//	Map<String,Object> deleteProfessionalQualification(Integer id);
//}
