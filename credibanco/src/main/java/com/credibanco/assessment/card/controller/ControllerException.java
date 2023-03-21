package com.credibanco.assessment.card.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.credibanco.assessment.card.dto.ResponseHeaderDto;
import com.credibanco.assessment.card.exceptions.CredibancoException;

@ControllerAdvice
public class ControllerException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = CredibancoException.class)
	public @ResponseBody
	ResponseEntity<ResponseHeaderDto> handleCredibancoException(CredibancoException e){
		return new ResponseEntity<>(new ResponseHeaderDto(e.getCode(), e.getMessage()), e.getStatus());
	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody
	ResponseEntity<ResponseHeaderDto> handleException(Exception e){
		return new ResponseEntity<>(new ResponseHeaderDto("01", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
