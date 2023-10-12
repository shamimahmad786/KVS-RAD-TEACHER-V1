package com.example.MOERADTEACHER.common.uneecops.exception.customException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public class ValidateDateIsInDateRangeException extends BaseException {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -5997269800496303549L;

		public ValidateDateIsInDateRangeException(String message) {
	        super(message);
	    }
	
}
