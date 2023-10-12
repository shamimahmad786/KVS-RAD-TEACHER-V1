package com.example.MOERADTEACHER.common.responsehandler;


public class SucessReponse {
private Boolean status;
private String message;
private Object response;
public SucessReponse(Boolean status, String message, Object response) {
	super();
	this.status = status;
	this.message = message;
	this.response = response;
}
public Boolean getStatus() {
	return status;
}
public void setStatus(Boolean status) {
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




}
