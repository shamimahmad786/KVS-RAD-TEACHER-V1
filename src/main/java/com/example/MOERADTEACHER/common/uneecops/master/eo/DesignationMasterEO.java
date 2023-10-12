package com.example.MOERADTEACHER.common.uneecops.master.eo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="m_designation", schema="uneecops")
public class DesignationMasterEO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="post_code")
	private String postCode;
	@Column(name="post_name")
	private String postName;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="created_date")
	private Timestamp createdDate;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="updated_date")
	private Timestamp updatedDate;
	@Column(name="status")
	private boolean status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
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
