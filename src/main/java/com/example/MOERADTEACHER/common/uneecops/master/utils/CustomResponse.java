package com.example.MOERADTEACHER.common.uneecops.master.utils;

import org.springframework.http.HttpStatus;

public class CustomResponse {
	Object response;
	HttpStatus httpStatus;
	UneeApiResMsgEnum uneeResMsgEnum;
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	public UneeApiResMsgEnum getUneeResMsgEnum() {
		return uneeResMsgEnum;
	}
	public void setUneeResMsgEnum(UneeApiResMsgEnum uneeResMsgEnum) {
		this.uneeResMsgEnum = uneeResMsgEnum;
	}
	public CustomResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
