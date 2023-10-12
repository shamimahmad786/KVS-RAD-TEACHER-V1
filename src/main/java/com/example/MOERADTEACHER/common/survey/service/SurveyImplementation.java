package com.example.MOERADTEACHER.common.survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.survey.model.SurveyMaster;
import com.example.MOERADTEACHER.common.survey.repository.SurveyMasterRepository;

@Service
public class SurveyImplementation {
	
	@Autowired
	SurveyMasterRepository surveyMasterRepo;
	
	public SurveyMaster saveSurveyMaster(SurveyMaster data) {
		return surveyMasterRepo.save(data);
	}
	
	public List<SurveyMaster> getSurveyMasterBySchCode(String data) {
		return surveyMasterRepo.findAllByCreatedByUser(data);
	}

}
