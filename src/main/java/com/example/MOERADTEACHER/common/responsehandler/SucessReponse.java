package com.example.MOERADTEACHER.common.responsehandler;


public class SucessReponse {
private Boolean success;
private String message;
private Object response;
public SucessReponse(Boolean success, String message, Object response) {
	super();
	this.success = success;
	this.message = message;
	this.response = response;
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

public Boolean getSuccess() {
	return success;
}

public void setSuccess(Boolean success) {
	this.success = success;
}





}
