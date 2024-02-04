package com.example.MOERADTEACHER.common.responsehandler;

public class ErrorResponse {
	
private Boolean success;
private String errorCode;
private String message;





public ErrorResponse(Boolean success, String errorCode, String message) {
	super();
	this.success = success;
	this.errorCode = errorCode;
	this.message = message;
}
public Boolean getSuccess() {
	return success;
}
public void setSuccess(Boolean success) {
	this.success = success;
}
public String getErrorCode() {
	return errorCode;
}
public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}
public String getErrorMessage() {
	return message;
}
public void setErrorMessage(String message) {
	this.message = message;
}



}
