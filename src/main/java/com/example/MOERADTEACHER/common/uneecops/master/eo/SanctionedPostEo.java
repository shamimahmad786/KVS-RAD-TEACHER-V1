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
@Table(name="sanctioned_post_mapping", schema = "uneecops")
public class SanctionedPostEo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	

	public int getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(int schoolCode) {
		this.schoolCode = schoolCode;
	}

	public int getStaffTypeId() {
		return staffTypeId;
	}

	public void setStaffTypeId(int staffTypeId) {
		this.staffTypeId = staffTypeId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getSanctionedPost() {
		return sanctionedPost;
	}

	public void setSanctionedPost(int sanctionedPost) {
		this.sanctionedPost = sanctionedPost;
	}

	public int getOccupiedPost() {
		return occupiedPost;
	}

	public void setOccupiedPost(int occupiedPost) {
		this.occupiedPost = occupiedPost;
	}

	public int getVacant() {
		return vacant;
	}

	public void setVacant(int vacant) {
		this.vacant = vacant;
	}

	public int getSurplus() {
		return surplus;
	}

	public void setSurplus(int surplus) {
		this.surplus = surplus;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	
	
	
	@Column(name="school_code")
	private int schoolCode;
	
	@Column(name="staff_type_Id")
	private int staffTypeId;
	@Column(name="post_Id")
	private int postId;
	
	@Column(name="subject_Id")
	private int subjectId;
	
	@Column(name="sanctioned_post")
	private int sanctionedPost;
	
	@Column(name="occupied_post")
	private int occupiedPost;
	
	@Column(name="vacant")
	private int vacant;
	
	@Column(name="surplus")
	private int surplus;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="created_date")
	private Timestamp createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_date")
	private Timestamp updatedDate;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Column(name="freezed_sanction_post")
	private Integer freezedSanctionPost;

	public Integer getFreezedSanctionPost() {
		return freezedSanctionPost;
	}

	public void setFreezedSanctionPost(Integer freezedSanctionPost) {
		this.freezedSanctionPost = freezedSanctionPost;
	}
	

	}
