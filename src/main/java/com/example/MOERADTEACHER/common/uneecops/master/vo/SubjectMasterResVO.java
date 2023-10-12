package com.example.MOERADTEACHER.common.uneecops.master.vo;

import lombok.Data;

@Data
public class SubjectMasterResVO {
	private int id;
	private String subjectCode;
	private String subjectName;
	private Boolean status;
	private String description;
	public SubjectMasterResVO(int id, String subjectCode, String subjectName, Boolean status, String description) {
		super();
		this.id = id;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.status = status;
		this.description = description;
	}
	
	
	
	
}
