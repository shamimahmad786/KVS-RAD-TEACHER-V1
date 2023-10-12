package com.example.MOERADTEACHER.common.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.survey.model.SurveyMasterQues;

@Repository
public interface SurveyMasterQuesRepo extends JpaRepository<SurveyMasterQues, Integer>{

	List<SurveyMasterQues> findBySurveyId(Integer surveyId);
	
	public void deleteAllBySurveyId(Integer surveyId);
	
}
