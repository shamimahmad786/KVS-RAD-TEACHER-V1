package com.example.MOERADTEACHER.common.uneecops.master.vo;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SubjectMasterReqVO {
	
@NotNull(message="Please enter subject code.")
private String subjectCode;
@NotNull(message="Please enter subject name.")
private String subjectName;
public String getSubjectCode() {
	return subjectCode;
}
public void setSubjectCode(String subjectCode) {
	this.subjectCode = subjectCode;
}
public String getSubjectName() {
	return subjectName;
}
public void setSubjectName(String subjectName) {
	this.subjectName = subjectName;
}

}
