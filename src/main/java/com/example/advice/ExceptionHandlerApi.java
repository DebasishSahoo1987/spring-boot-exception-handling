package com.example.advice;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerApi {
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleInvalidArguments(ConstraintViolationException ex){
		Map<String, String> errorMsg=new HashMap<String, String>();
		ex.getConstraintViolations().forEach(err-> errorMsg.put(err.getPropertyPath().toString(), err.getMessage()));
		return errorMsg;
		
	}
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public Map<String, String> handleUserNotFoundException(EmployeeNotFoundException ex){
		Map<String, String> errorMsg=new HashMap<String, String>();
		errorMsg.put("Error Message", ex.getMessage());
		return errorMsg;
		
	}

}
