package com.example.MOERADTEACHER.common.survey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="survey_question_detail", schema = "survey")
public class SurveyMasterQues {
	
	@Id
	@SequenceGenerator(name="survey_question_detail_id_seq", sequenceName="survey_question_detail_id_seq",schema ="survey",allocationSize = 1,initialValue =1  )
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "survey_question_detail_id_seq")
	@Column(name="id")
	private Integer Id;
	
	@Column(name="survey_id")
	private Integer surveyId;
	
	@Column(name="question_id")
	private Integer questionId;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	
	

}
