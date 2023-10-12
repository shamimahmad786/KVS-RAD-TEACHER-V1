package com.example.MOERADTEACHER.common.survey.controller;


import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.survey.bean.QuestionMaster;
import com.example.MOERADTEACHER.common.survey.model.Question_Master;
//import com.example.MOERADTEACHER.survey.model.Question_Master;
import com.example.MOERADTEACHER.common.survey.service.QuestionImplement;

//import com.example.MOERADTEACHER.servey.model.Question_Master;


//import com.example.MOERADTEACHER.modal.Teacher;

import com.example.MOERADTEACHER.common.util.ApiPaths;

@RestController
@RequestMapping(ApiPaths.QuestionCtrl.CTRL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionCtrl {
	
	// Added by Bibek For conversion of Entity  and DTO
	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	QuestionImplement questionImplement;
	
//	@RequestMapping(value = "/getTeacherBySchool", method = RequestMethod.POST)
//	public ResponseEntity<List<Question_Master>> getTeacherBySchool(@RequestBody Question_Master data) throws Exception {
//	//	// System.out.println(data.getUdiseSchCode());
//		//List<Question_Master> result=questionImpl.getTeacherBySchool(data.getUdiseSchCode());
//	//	return ResponseEntity.ok(result);
//	}
	
	@RequestMapping(value = "/saveQuestion", method = RequestMethod.POST)
	public ResponseEntity<Question_Master> saveQuestion(@RequestBody Question_Master data) throws Exception {
		Question_Master result=questionImplement.saveQuestion(data);
		return ResponseEntity.ok(result);
//		return null;
	}
	
	@RequestMapping(value = "/getQuestionByID/{questionId}", method = RequestMethod.POST)
	public ResponseEntity<QuestionMaster> getQuestionByID(@PathVariable("questionId") Integer id) throws Exception {
		Optional<Question_Master> optionalResult=questionImplement.getQuestionMasterByID(id);
		Question_Master result= optionalResult.get();
		QuestionMaster dtoQuestionMaster = modelMapper.map(result, QuestionMaster.class);
		return ResponseEntity.ok(dtoQuestionMaster);
	}
	
	//PathVariable("businessUnitcode")
	@RequestMapping(value = "/getAllQuestionByBusinessUnit", method = RequestMethod.POST)
	public ResponseEntity<List<QuestionMaster>> getAllQuestionByBusinessUnit(@RequestBody String businessUnitcode) throws Exception {
		// System.out.println(businessUnitcode);
		List<Question_Master> optionalResult=questionImplement.getAllQuestionByBusinessUnit(businessUnitcode);
//		List<Question_Master> optionalResult=questionImplement.getAllQuestionByBusinessUnit(businessUnitcode);
		//// System.out.println(optionalResult.size());
		
		Type listType = new TypeToken<List<QuestionMaster>>(){}.getType();
		List<QuestionMaster> questionMasterDtoList = modelMapper.map(optionalResult,listType);
		return ResponseEntity.ok(questionMasterDtoList);

//		return ResponseEntity.ok(optionalResult);
//		return null;
	}
	
	
}
