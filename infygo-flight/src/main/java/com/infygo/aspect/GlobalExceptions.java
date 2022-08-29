package com.infygo.aspect;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infygo.exception.ErrorInfo;

import com.infygo.exception.flightNotExist;
import com.infygo.exception.seatNotAvailable;


import ch.qos.logback.core.status.Status;
import net.bytebuddy.description.modifier.MethodArguments;

@RestControllerAdvice
public class GlobalExceptions {

	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> handleValidationException(MethodArgumentNotValidException ex){
		ErrorInfo error = new ErrorInfo();
		error.setErrorCode(HttpStatus.BAD_GATEWAY.value());
		List<ObjectError> objectErrors = ex.getAllErrors();
		String msg = objectErrors.stream().map(ObjectError::getDefaultMessage)
				.collect(Collectors.joining(","));
		error.setErrorMsg(msg);
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorInfo> handleConstrainViolationException(ConstraintViolationException ex){
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMsg(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(",")));
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);
		
	}
	

	

	
	@ExceptionHandler(flightNotExist.class)
	public ResponseEntity<ErrorInfo> handlFlightNotExist(flightNotExist ex){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMsg(ex.getMessage());
		
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(seatNotAvailable.class)
	public ResponseEntity<ErrorInfo> handlseatNotAvailable(seatNotAvailable ex){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMsg(ex.getMessage());
		
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	}
	
}
