package com.example.MOERADTEACHER.common.uneecops.master.vo;

import java.util.Date;

public class SchoolCodeOrToDateResVO {

	private Integer schoolCode;
	private Date toDate;
	private Date fromDate;
	public Integer getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(Integer schoolCode) {
		this.schoolCode = schoolCode;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public SchoolCodeOrToDateResVO(Integer schoolCode, Date toDate, Date fromDate) {
		super();
		this.schoolCode = schoolCode;
		this.toDate = toDate;
		this.fromDate = fromDate;
	}
	
	
}
