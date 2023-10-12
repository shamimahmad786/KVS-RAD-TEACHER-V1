package com.example.MOERADTEACHER.common.uneecops.master.vo;

public class SanctionedPostRequestVo2 {

	
	private int schoolCode;
	private int staffTypeId;
	private int postId;
	private int subjectId;
	private int sanctionedPost;
	private int occupiedPost;
	private int vacant;
	private int surplus;
	
	
	
	

	

	

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

	@Override
	public String toString() {
		return "SanctionedPostRequestVo2 [schoolCode=" + schoolCode + ", staffTypeId=" + staffTypeId + ", postId="
				+ postId + ", subjectId=" + subjectId + ", sanctionedPost=" + sanctionedPost + ", occupiedPost="
				+ occupiedPost + ", vacant=" + vacant + ", surplus=" + surplus + "]";
	}
	
	

}
