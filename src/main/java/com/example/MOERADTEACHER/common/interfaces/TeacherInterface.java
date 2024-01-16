package com.example.MOERADTEACHER.common.interfaces;

import java.util.List;
import java.util.Map;

import com.example.MOERADTEACHER.common.bean.DropedTeacherDetails;
import com.example.MOERADTEACHER.common.bean.SchoolFetchTeacherBean;
import com.example.MOERADTEACHER.common.bean.TeacherProfileBean;
import com.example.MOERADTEACHER.common.modal.Teacher;
//import com.example.MOERADTEACHER.common.modal.TeacherEducationalQualification;
import com.example.MOERADTEACHER.common.modal.TeacherFormStatus;
//import com.example.MOERADTEACHER.common.modal.TeacherProfessionalQualification;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
import com.example.MOERADTEACHER.common.modal.TeacherProfileConfirmation;
import com.example.MOERADTEACHER.common.util.QueryResult;
//import com.example.MOERADTEACHER.modal.TeacherProfileCurrectionInitiate;
import com.example.MOERADTEACHER.common.util.StaticReportBean;


public interface TeacherInterface    {
	List<Teacher> getTeacherBySchool(String udiseCode);
	TeacherProfile saveTeacher(TeacherProfile data);
	StaticReportBean verifyTeacher(TeacherProfile data);
	TeacherProfile getTeacherByTeacherId(Integer teacherId);
	TeacherProfile getTeacherByTeacherEmployeeCode(String teacherEmployeeCode);
//	TeacherProfileCurrectionInitiate getTeacherProfileQueryInitiate(Integer teacherId);
	Map<String,Object> updateTeacherSystemGeneratedCode(TeacherProfile data);
	TeacherFormStatus updatdFlag(TeacherFormStatus teacherId);
	TeacherFormStatus getUpdatdFlag(Integer teacherId);
	TeacherFormStatus updateFlagByTeachId(TeacherFormStatus data,String user);
	Map<String,List<Object>> getTeacherHistryByTeacherId(Integer data);
	TeacherFormStatus  saveStatus(TeacherProfile data);
	DropedTeacherDetails  checkEmployeeCode(String data);
	TeacherProfile changeTeacherSchool(SchoolFetchTeacherBean data);
	Map<String,Object> dropTeacherBySchool(String data);
	List<TeacherProfileBean> getOutboxTeacherByUdisecode(String data);
	Map<String,Object> getTeacherDetailsForConfirmation(Integer data);
//	TeacherEducationalQualification mapSubject(TeacherEducationalQualification data,List<Map<String,Object>> sub,List<Map<String,Object>> degree);
//	TeacherProfessionalQualification mapProSubject(TeacherProfessionalQualification data,List<Map<String,Object>> sub,List<Map<String,Object>> degree);
//	TeacherProfileCurrectionInitiate teacherProfileQueryInitiate(TeacherProfileCurrectionInitiate data); 	
	QueryResult getEmployeeStatus(Integer teacherId);
	TeacherProfile saveProfileV2(TeacherProfile data);
	TeacherProfile getEmployeeDetailV2(String teacherEmployeeCode);
	TeacherFormStatus getFormStatusV2(String teacherId);
	Map<String,Object> getConfirmedTeacherDetailsV2(Integer data);
	TeacherProfileConfirmation saveTeacherConfirmationV2(TeacherProfileConfirmation date);
	TeacherProfileConfirmation getTeacherConfirmationV2(Integer teacherId);
	Map<String,Object> getSpouseDetailsV2(Integer teacherId);
	Map<String,Object> resetProfileV2(Integer teacherId);
	
}
