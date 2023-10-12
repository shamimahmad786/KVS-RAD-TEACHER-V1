package com.example.MOERADTEACHER.common.masterbean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_teacher_subject", schema = "master")
public class SubjectMaster {

@Id
@Column(name = "subject_id")	
private Integer	subjectId;
@Column(name = "subject_name")	
private String	subjectName;
@Column(name = "subject_code")	
private String	subjectCode;
@Column(name = "subject_description")	
private String	subjectDescription;
public Integer getSubjectId() {
	return subjectId;
}
public void setSubjectId(Integer subjectId) {
	this.subjectId = subjectId;
}
public String getSubjectName() {
	return subjectName;
}
public void setSubjectName(String subjectName) {
	this.subjectName = subjectName;
}
public String getSubjectCode() {
	return subjectCode;
}
public void setSubjectCode(String subjectCode) {
	this.subjectCode = subjectCode;
}
public String getSubjectDescription() {
	return subjectDescription;
}
public void setSubjectDescription(String subjectDescription) {
	this.subjectDescription = subjectDescription;
}




}
