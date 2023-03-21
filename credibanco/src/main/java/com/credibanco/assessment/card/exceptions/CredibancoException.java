package com.credibanco.assessment.card.exceptions;

import org.springframework.http.HttpStatus;

import com.credibanco.assessment.card.dto.BussinessErrorEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CredibancoException extends Exception {
	
	private static final long serialVersionUID = 1089473901732824342L;
	private final String code;
	private final String message;
	private final HttpStatus status;
	
	public CredibancoException(BussinessErrorEnum bussinessErrorEnum, Exception e) {
		super(e);
		this.code = bussinessErrorEnum.getCode();
		this.message = bussinessErrorEnum.getValue();
		this.status = bussinessErrorEnum.getHttpStatus();
	}
	
	public CredibancoException(BussinessErrorEnum bussinessErrorEnum) {
		super(new Exception(bussinessErrorEnum.getValue()));
		this.code = bussinessErrorEnum.getCode();
		this.message = bussinessErrorEnum.getValue();
		this.status = bussinessErrorEnum.getHttpStatus();
	}
	

}
