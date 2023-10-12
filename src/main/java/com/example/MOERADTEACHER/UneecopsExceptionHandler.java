package com.example.MOERADTEACHER;



import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.MOERADTEACHER.common.uneecops.exception.customException.RegionNameAlreadyExistException;
import com.example.MOERADTEACHER.common.uneecops.exception.customException.SchoolCodeAlreadyExistException;
import com.example.MOERADTEACHER.common.uneecops.exception.customException.ValidateDateIsInDateRangeException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class UneecopsExceptionHandler {
	
	@ExceptionHandler(SchoolCodeAlreadyExistException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> schoolCodeFind(SchoolCodeAlreadyExistException ex){
		System.out.println(" schoolCodeFind");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
				.body(ex.getMessage());
		
	}
	
	@ExceptionHandler(ValidateDateIsInDateRangeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> validateDateIsInDateRange(ValidateDateIsInDateRangeException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
				.body(ex.getMessage());
	}
	//RegionNameAlreadyExistException
	

	@ExceptionHandler(RegionNameAlreadyExistException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> regionNameAlreadyExistException(RegionNameAlreadyExistException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
				.body(ex.getMessage());
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> globalExcetionHanlder(Exception ex){
		//log.debug("Gloabal Excepiton handler called ------->   "+ex.getMessage());
		String errorMsg = "Request can not be processed, please try again.";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
				.body(errorMsg);
	}
}
