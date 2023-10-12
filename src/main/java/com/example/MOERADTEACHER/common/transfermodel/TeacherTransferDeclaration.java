package com.example.MOERADTEACHER.common.transfermodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_transfer_declaration", schema="transfer")
public class TeacherTransferDeclaration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "teacher_id")
	private Integer teacherId;
	@Column(name = "transfer_gone_through")
	private String transferGoneThrough;
	@Column(name = "filled_case")
	private String filledCase;
	@Column(name = "declaration_str")
	private String declarationStr;
	@Column(name = "ldce_yn")
	private String ldceYn;
//	@Column(name = "kv_code")
//	private String kvCode;
	@Column(name = "created_date_time")
	private Date createdDateTime;
	@Column(name = "created_by")
	private String createdBy;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getTransferGoneThrough() {
		return transferGoneThrough;
	}
	public void setTransferGoneThrough(String transferGoneThrough) {
		this.transferGoneThrough = transferGoneThrough;
	}
	public String getFilledCase() {
		return filledCase;
	}
	public void setFilledCase(String filledCase) {
		this.filledCase = filledCase;
	}
	public String getDeclarationStr() {
		return declarationStr;
	}
	public void setDeclarationStr(String declarationStr) {
		this.declarationStr = declarationStr;
	}
	public String getLdceYn() {
		return ldceYn;
	}
	public void setLdceYn(String ldceYn) {
		this.ldceYn = ldceYn;
	}
	public Date getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@PrePersist
	protected void onCreate() {
	    if (createdDateTime == null) { createdDateTime = new Date(); }
	}
	
}
