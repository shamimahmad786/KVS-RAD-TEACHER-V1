package com.example.MOERADTEACHER.common.masterbean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_qual_master", schema = "master")
public class TeacherQualification {

	@Id
	@Column(name = "qualification_degree_id")
	private Integer qualificationDegreeId;
	@Column(name = "acad_qual_name")
	private String acadQualName;
	@Column(name = "qualification_type")
	private String qualificationType;

	public Integer getQualificationDegreeId() {
		return qualificationDegreeId;
	}

	public void setQualificationDegreeId(Integer qualificationDegreeId) {
		this.qualificationDegreeId = qualificationDegreeId;
	}

	public String getAcadQualName() {
		return acadQualName;
	}

	public void setAcadQualName(String acadQualName) {
		this.acadQualName = acadQualName;
	}

	public String getQualificationType() {
		return qualificationType;
	}

	public void setQualificationType(String qualificationType) {
		this.qualificationType = qualificationType;
	}

}
