package com.example.MOERADTEACHER.common.survey.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.survey.bean.SurveyMasterBean;
import com.example.MOERADTEACHER.common.survey.bean.SurveyMasterQuesBean;
import com.example.MOERADTEACHER.common.survey.model.SurveyMaster;
import com.example.MOERADTEACHER.common.survey.model.SurveyMasterQues;
import com.example.MOERADTEACHER.common.survey.service.SurveyImplementation;
import com.example.MOERADTEACHER.common.survey.service.SurveyMasterQuesImpl;
import com.example.MOERADTEACHER.common.util.ApiPaths;

@RestController
@RequestMapping(ApiPaths.SurveyMaster.CTRL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SurveyMasterCtrl {
	
	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	SurveyImplementation surveyImpl;
	@Autowired
	SurveyMasterQuesImpl surveyMasterQuesImpl;

	@RequestMapping(value = "/saveSurveyMaster")
	public ResponseEntity<SurveyMaster> saveSurveyMaster(@RequestBody SurveyMaster data) {
		SurveyMaster result = surveyImpl.saveSurveyMaster(data);
		return ResponseEntity.ok(result);

	}

	@RequestMapping(value = "/getSurveyMasterBySchCode",method = RequestMethod.POST)
	public ResponseEntity<List<SurveyMasterBean>> getSurveyMasterBySchCode(@RequestBody String data) {
		List<SurveyMaster> optionalResult=surveyImpl.getSurveyMasterBySchCode(data);
		Type listType = new TypeToken<List<SurveyMaster>>(){}.getType();
		List<SurveyMasterBean> dtoSurveyMaster = modelMapper.map(optionalResult,listType);
		return ResponseEntity.ok(dtoSurveyMaster);
	}
	
	@PostMapping(value ="/saveSurveyMasterQues")
	public ResponseEntity<List<SurveyMasterQues>> saveSurveyMasterQues(@RequestBody List<SurveyMasterQues> data) {
		List<SurveyMasterQues> result = surveyMasterQuesImpl.saveSurveyMasterQues(data);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(value = "/getSurveyMasterQues")
	public ResponseEntity<List<SurveyMasterQuesBean>> getSurveyMasterQues(@RequestBody Integer data) {	
		List<SurveyMasterQues> optionalResult = surveyMasterQuesImpl.getSurveyMasterQues(data);
		Type listType = new TypeToken<List<SurveyMasterQues>>(){}.getType();
		List<SurveyMasterQuesBean> dtoSurveyMaster = modelMapper.map(optionalResult, listType);
		return ResponseEntity.ok(dtoSurveyMaster);
	}
	
	@PostMapping(value="/deleteSurveyMasterQues")
	public void deleteSurveyMasterQues(@RequestBody Integer data) {
		surveyMasterQuesImpl.deleteSurveyMasterQues(data);
	}
	
	
	

}
