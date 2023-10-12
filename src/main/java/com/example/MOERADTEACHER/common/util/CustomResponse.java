package com.example.MOERADTEACHER.common.util;

public class CustomResponse {
	private Integer status;
	private String message;
	private Object response;
	private String responseCode;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public CustomResponse(Integer status, String message, Object response, String responseCode) {
		super();
		this.status = status;
		this.message = message;
		this.response = response;
		this.responseCode = responseCode;
	}

//	public CustomResponse response(Integer status, String message, Object response, String responseCode) {
//		CustomResponse resObj = new CustomResponse();
//		resObj.setMessage(message);
//		resObj.setResponse(response);
//		resObj.setResponseCode(responseCode);
//		resObj.setStatus(status);
//		return resObj;
//
//	}
	
	
	
	

}
