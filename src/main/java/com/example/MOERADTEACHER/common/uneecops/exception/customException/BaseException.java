package com.example.MOERADTEACHER.common.uneecops.exception.customException;

	public abstract class BaseException extends RuntimeException {
	    BaseException(String message) {
	        super(message);
	    }
	    BaseException(Throwable e) {
	        super(e);
	    }
	    BaseException(String message, Throwable cause) {
	        super(message, cause);
	    }
	
}
