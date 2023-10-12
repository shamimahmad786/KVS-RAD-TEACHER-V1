package com.example.MOERADTEACHER.common.uneecops.master.vo;

import javax.validation.constraints.NotNull;
import lombok.Data;
@Data
public class PostSubjectMappingReqVo {
	
	@NotNull(message = "please enter post id")
	private int postId;
	@NotNull(message = "please enter subject id")
	private int subjectId;
	
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
	
	
	
	
}
