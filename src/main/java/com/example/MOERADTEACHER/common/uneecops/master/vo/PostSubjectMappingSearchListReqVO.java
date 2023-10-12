package com.example.MOERADTEACHER.common.uneecops.master.vo;

import lombok.Data;

@Data
public class PostSubjectMappingSearchListReqVO {
	private String postName;
	private String subjectName;
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	

}
