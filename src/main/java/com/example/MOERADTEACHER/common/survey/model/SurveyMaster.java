package com.example.MOERADTEACHER.common.survey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="survey_master", schema = "survey")
public class SurveyMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="survey_id")
	private Integer surveyId;
	
	@Column(name="survey_code")
	private String surveyCode;
	
	@Column(name="survey_name")
	private String surveyName;
	
	@Column(name="survey_start_date")
	private String surveyStartDate;
	
	@Column(name="survey_end_date")
	private String surveyEndDate;
	
	@Column(name="survey_description")
	private String surveyDescription;
	
	@Column(name="survey_upload_document")
	private String surveyUploadDocument;
	
	@Column(name="created_by_user")
	private String createdByUser;

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyCode() {
		return surveyCode;
	}

	public void setSurveyCode(String surveyCode) {
		this.surveyCode = surveyCode;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getSurveyStartDate() {
		return surveyStartDate;
	}

	public void setSurveyStartDate(String surveyStartDate) {
		this.surveyStartDate = surveyStartDate;
	}

	public String getSurveyEndDate() {
		return surveyEndDate;
	}

	public void setSurveyEndDate(String surveyEndDate) {
		this.surveyEndDate = surveyEndDate;
	}

	public String getSurveyDescription() {
		return surveyDescription;
	}

	public void setSurveyDescription(String surveyDescription) {
		this.surveyDescription = surveyDescription;
	}

	public String getSurveyUploadDocument() {
		return surveyUploadDocument;
	}

	public void setSurveyUploadDocument(String surveyUploadDocument) {
		this.surveyUploadDocument = surveyUploadDocument;
	}

	public String getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}
	
}
