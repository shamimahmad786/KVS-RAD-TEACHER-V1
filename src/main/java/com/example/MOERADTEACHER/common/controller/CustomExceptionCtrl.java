package com.example.MOERADTEACHER.common.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.exceptions.UserNotAuthorizedException;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.CustomResponse;

@RestController
@RequestMapping(ApiPaths.ExceptionCtrl.CTRL)
public class CustomExceptionCtrl {
	@RequestMapping(value = "/exception", method = RequestMethod.POST)
	public String exception() {
		if(true) {
//			// System.out.println("called at exception");
			throw new UserNotAuthorizedException("User Unauthenticated");
			
		}
		return null;
		
		
	}
}
