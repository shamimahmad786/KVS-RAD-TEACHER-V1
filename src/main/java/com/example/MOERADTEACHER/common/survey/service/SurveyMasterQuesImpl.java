package com.example.MOERADTEACHER.common.survey.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.survey.model.SurveyMasterQues;
import com.example.MOERADTEACHER.common.survey.repository.SurveyMasterQuesRepo;

@Service
@Transactional
public class SurveyMasterQuesImpl {
	
	@Autowired
	SurveyMasterQuesRepo surveyMasterQuesRepo;

	public List<SurveyMasterQues> saveSurveyMasterQues(List<SurveyMasterQues> data ) {
		return surveyMasterQuesRepo.saveAll(data);
	}
	
	public List<SurveyMasterQues> getSurveyMasterQues(Integer data) {
		return surveyMasterQuesRepo.findBySurveyId(data);
	}
	
	public void deleteSurveyMasterQues(Integer data) {
			surveyMasterQuesRepo.deleteAllBySurveyId(data);			
	}
}
