package com.example.MOERADTEACHER.common.uneecops.master.vo;

import lombok.Data;

@Data
public class SchoolMasterResVO {
	private Integer id;
	private Integer schoolCode;
	private String schoolName;
	private Boolean schoolStatus;
	private String shift;
	private Integer schoolType;
	private String schoolAddress;
	public SchoolMasterResVO(Integer id, Integer schoolCode, String schoolName, Boolean schoolStatus, String shift,
			Integer schoolType,String  schoolAddress) {
		super();
		this.id = id;
		this.schoolCode = schoolCode;
		this.schoolName = schoolName;
		this.schoolStatus = schoolStatus;
		this.shift = shift;
		this.schoolType = schoolType;
		this.schoolAddress=schoolAddress;
	}

	
	
	
	
//	public SchoolMasterResVO(Integer id, Integer schoolCode, String schoolName, Boolean schoolStatus, String shift,Integer schoolType) {
//		super();
//		this.id = id;
//		this.schoolCode = schoolCode;
//		this.schoolName = schoolName;
//		this.schoolStatus = schoolStatus;
//		this.shift = shift;
//		this.schoolType=schoolType;
//	}
	
}
