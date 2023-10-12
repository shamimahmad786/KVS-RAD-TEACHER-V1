package com.example.MOERADTEACHER.common.util;

public   class ResponseEntityBeans {
public  static CustomResponse reponseBoject(Integer status, String message, Object response, String responseCode) {
	return new CustomResponse(status, message, response, responseCode);
	
} 
}
