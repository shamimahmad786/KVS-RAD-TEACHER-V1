package com.example.MOERADTEACHER.common.survey.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.survey.model.Question_Master;
import com.example.MOERADTEACHER.common.survey.repository.Question_MasterRepository;
//import com.example.MOERADTEACHER.survey.repository.QuestionRepository;
//import com.example.MOERADTEACHER.survey.model.Question_Master;
//import com.example.MOERADTEACHER.survey.repository.QuestionRepository;
//import com.example.MOERADTEACHER.servey.model.Question_Master;
//import com.example.MOERADTEACHER.servey.repository.QuestionRepository;
import com.example.MOERADTEACHER.common.util.NativeRepository;

@Service
public class QuestionImplement {

//	
	@Autowired
	Question_MasterRepository question_MasterRepository;
	
	@Autowired
	NativeRepository nativeRepository;
	
//	public List<Question_Master> getTeacherBySchool(String udiseCode) throws Exception {
//		return questionRepository.findAll();
//	}
	
	public Question_Master  saveQuestion(Question_Master data) throws Exception {
		System.out.print("Inside save Question");
//		return null;
		return question_MasterRepository.save(data);
	}
	public Optional<Question_Master>  getQuestionMasterByID(Integer id) throws Exception {
		System.out.print("Inside Question_Master");
//		return null;
		return question_MasterRepository.findById(id);
	}
	public List<Question_Master>  getAllQuestionByBusinessUnit(String  businessUnitcode) throws Exception {
		System.out.print("Inside Question_Master");
//		return null;
		return question_MasterRepository.findAllByBusinessUnitIdentityCode(businessUnitcode);
//		return question_MasterRepository.findAll();
	}

}
