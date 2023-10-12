package com.example.MOERADTEACHER.common.responsehandler;

public class ErrorResponse {
	
private Boolean success;
private String errorCode;
private String errorMessage;





public ErrorResponse(Boolean success, String errorCode, String errorMessage) {
	super();
	this.success = success;
	this.errorCode = errorCode;
	this.errorMessage = errorMessage;
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
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}



}
