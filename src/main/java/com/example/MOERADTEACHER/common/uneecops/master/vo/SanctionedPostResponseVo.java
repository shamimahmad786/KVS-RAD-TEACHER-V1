package com.example.MOERADTEACHER.common.uneecops.master.vo;

import lombok.Data;

@Data
public class SanctionedPostResponseVo {

	private int sanctionedPostid;
	private String postName;
	private String postCode;
	private String subjectCode;
	private String subjectName;
	private Integer sanctionedPost;
	private Integer occupiedPost;
	private Integer vacant;
	private Integer surplus;
	private String staffType;
	private Integer freezedSanctionPost;
	
	public SanctionedPostResponseVo(int sactionedPostid,String postName, String postCode, String subjectCode, String subjectName, String staffType,
			Integer sanctionedPost, Integer occupiedPost, Integer vacant, Integer surplus, Integer freezedSanctionPost) {
		super();
		this.sanctionedPostid=sactionedPostid;
		this.postName = postName;
		this.postCode = postCode;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.staffType = staffType;
		this.sanctionedPost = sanctionedPost;
		this.occupiedPost = occupiedPost;
		this.vacant = vacant;
		this.surplus = surplus;
		this.freezedSanctionPost=freezedSanctionPost;
	}
	
	

	}
