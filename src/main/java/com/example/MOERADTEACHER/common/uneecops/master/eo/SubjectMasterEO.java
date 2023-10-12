package com.example.MOERADTEACHER.common.uneecops.master.eo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "m_subject", schema = "uneecops")
public class SubjectMasterEO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "subject_code")
	private String subjectCode;
	@Column(name = "subject_name")
	private String subjectName;
	@Column(name="description")
	private String description;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_date")
	private Timestamp createdDate;
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "updated_date")
	private Timestamp updatedDate;
	@Column(name = "status")
	private boolean status;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

	
}
