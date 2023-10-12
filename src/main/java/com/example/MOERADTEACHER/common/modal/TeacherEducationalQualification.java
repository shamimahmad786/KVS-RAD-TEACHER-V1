//package com.example.MOERADTEACHER.common.modal;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//
//@Entity
////@Table(name = "teacher_educational_qualification_detail", schema="public")
//public class TeacherEducationalQualification implements Serializable{
//
////	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_educational_qualification_id_seq")
//	
////	@GeneratedValue(strategy = GenerationType.AUTO, generator = "teacher_educational_qualification_id_seq")
////	@SequenceGenerator(name = "teacher_educational_qualification_id_seq", sequenceName = "teacher_educational_qualification_id_seq")
//	@Id
//	@Column(name = "teacher_educational_qualification_id")
//	private Integer teacherEducationalQualificationId;
//	@Column(name = "teacher_id")
//	private Integer teacherId;
//	@Column(name = "teacher_qualification_type")
//	private String teacherQualificationType;
//	@Column(name = "qualification_degree_id")
//	private Integer qualificationDegreeId;
//	@Column(name = "qualification_degree_major")
//	private String qualificationDegreeMajor;
//	@Column(name = "qualification_degree_minor")
//	private String qualificationDegreeMinor;
//	@Column(name = "board_university")
//	private String boardUniversity;
//	@Column(name = "institution")
//	private String institution;
//	@Column(name = "year_of_passing")
//	private String yearOfPassing;
//	@Column(name = "total_marks")
//	private String totalMarks;
//	@Column(name = "marks_obtaioned")
//	private String marksObtaioned;
//	
//	@Transient
//	private String degreeName;
//	
//	@Transient
//	private List<Object> qualificationDegreeMajorList;
//	
//	@Transient
//	private List<Object> qualificationDegreeMinorList;
//	
//	@Column(name="created_by") 
//	private String createdBy ;
//	
//	@Column(name="created_time") 
//	private Date createdTime ;
//	
//	@Column(name="modified_by") 
//	private String modifiedBy ;
//	
//	@Column(name="modified_time") 
//	private Date modifiedTime;
//	
//	
//	
//	
//	public Integer getTeacherEducationalQualificationId() {
//		return teacherEducationalQualificationId;
//	}
//	public void setTeacherEducationalQualificationId(Integer teacherEducationalQualificationId) {
//		this.teacherEducationalQualificationId = teacherEducationalQualificationId;
//	}
//	public Integer getTeacherId() {
//		return teacherId;
//	}
//	public void setTeacherId(Integer teacherId) {
//		this.teacherId = teacherId;
//	}
//	public String getTeacherQualificationType() {
//		return teacherQualificationType;
//	}
//	public void setTeacherQualificationType(String teacherQualificationType) {
//		this.teacherQualificationType = teacherQualificationType;
//	}
//	public Integer getQualificationDegreeId() {
//		return qualificationDegreeId;
//	}
//	public void setQualificationDegreeId(Integer qualificationDegreeId) {
//		this.qualificationDegreeId = qualificationDegreeId;
//	}
//	public String getQualificationDegreeMajor() {
//		return qualificationDegreeMajor;
//	}
//	public void setQualificationDegreeMajor(String qualificationDegreeMajor) {
//		this.qualificationDegreeMajor = qualificationDegreeMajor;
//	}
//	public String getQualificationDegreeMinor() {
//		return qualificationDegreeMinor;
//	}
//	public void setQualificationDegreeMinor(String qualificationDegreeMinor) {
//		this.qualificationDegreeMinor = qualificationDegreeMinor;
//	}
//	public String getBoardUniversity() {
//		return boardUniversity;
//	}
//	public void setBoardUniversity(String boardUniversity) {
//		this.boardUniversity = boardUniversity;
//	}
//	public String getInstitution() {
//		return institution;
//	}
//	public void setInstitution(String institution) {
//		this.institution = institution;
//	}
//	public String getYearOfPassing() {
//		return yearOfPassing;
//	}
//	public void setYearOfPassing(String yearOfPassing) {
//		this.yearOfPassing = yearOfPassing;
//	}
//	public String getTotalMarks() {
//		return totalMarks;
//	}
//	public void setTotalMarks(String totalMarks) {
//		this.totalMarks = totalMarks;
//	}
//	public String getMarksObtaioned() {
//		return marksObtaioned;
//	}
//	public void setMarksObtaioned(String marksObtaioned) {
//		this.marksObtaioned = marksObtaioned;
//	}
//	
//	
//	public List<Object> getQualificationDegreeMajorList() {
//		return qualificationDegreeMajorList;
//	}
//	public void setQualificationDegreeMajorList(List<Object> qualificationDegreeMajorList) {
//		this.qualificationDegreeMajorList = qualificationDegreeMajorList;
//	}
//	public List<Object> getQualificationDegreeMinorList() {
//		return qualificationDegreeMinorList;
//	}
//	public void setQualificationDegreeMinorList(List<Object> qualificationDegreeMinorList) {
//		this.qualificationDegreeMinorList = qualificationDegreeMinorList;
//	}
//	public String getDegreeName() {
//		return degreeName;
//	}
//	public void setDegreeName(String degreeName) {
//		this.degreeName = degreeName;
//	}
//	public String getCreatedBy() {
//		return createdBy;
//	}
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//	public Date getCreatedTime() {
//		return createdTime;
//	}
//	public void setCreatedTime(Date createdTime) {
//		this.createdTime = createdTime;
//	}
//	public String getModifiedBy() {
//		return modifiedBy;
//	}
//	public void setModifiedBy(String modifiedBy) {
//		this.modifiedBy = modifiedBy;
//	}
//	public Date getModifiedTime() {
//		return modifiedTime;
//	}
//	public void setModifiedTime(Date modifiedTime) {
//		this.modifiedTime = modifiedTime;
//	}
//
//	
//	
//	
//}
