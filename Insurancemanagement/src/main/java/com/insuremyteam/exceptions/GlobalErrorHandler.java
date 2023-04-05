package com.insuremyteam.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalErrorHandler {
		
	@ExceptionHandler(NoClientFound.class)
	public ResponseEntity<MyErrorDetails> NoClientFoundException(NoClientFound ncf, WebRequest wr){
		
		MyErrorDetails med = new MyErrorDetails(LocalDateTime.now(),ncf.getMessage(),wr.getDescription(false));
		ResponseEntity<MyErrorDetails> myerr = new ResponseEntity<MyErrorDetails>(med, HttpStatus.BAD_REQUEST);
		return myerr;
		
		
	}
	
	@ExceptionHandler(NoPolicyFound.class)
	public ResponseEntity<MyErrorDetails> NoPolicyFoundException(NoPolicyFound npf, WebRequest wr){
		
		MyErrorDetails med = new MyErrorDetails(LocalDateTime.now(),npf.getMessage(),wr.getDescription(false));
		ResponseEntity<MyErrorDetails> myerr = new ResponseEntity<MyErrorDetails>(med, HttpStatus.BAD_REQUEST);
		return myerr;
		
		
	}
	
	@ExceptionHandler(NoClaimFound.class)
	public ResponseEntity<MyErrorDetails> NoClaimFoundException(NoClaimFound ncf, WebRequest wr){
		
		MyErrorDetails med = new MyErrorDetails(LocalDateTime.now(),ncf.getMessage(),wr.getDescription(false));
		ResponseEntity<MyErrorDetails> myerr = new ResponseEntity<MyErrorDetails>(med, HttpStatus.BAD_REQUEST);
		return myerr;
		
		
	}
	
}
