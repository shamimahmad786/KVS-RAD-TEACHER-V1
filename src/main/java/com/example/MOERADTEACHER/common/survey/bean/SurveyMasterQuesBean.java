package com.example.MOERADTEACHER.common.survey.bean;

public class SurveyMasterQuesBean {
	
	private Integer Id;
	private Integer surveyId;
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
