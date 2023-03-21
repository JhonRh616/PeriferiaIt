package com.credibanco.assessment.card.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum BussinessErrorEnum {
	
	GENERAL_ERROR("01", "Error general en la aplicación", HttpStatus.INTERNAL_SERVER_ERROR),
	CARD_NOT_DELETED("01", "No se ha eliminado la tarjeta", HttpStatus.INTERNAL_SERVER_ERROR),
	FAILED("01", "Fallido", HttpStatus.INTERNAL_SERVER_ERROR),
	INVALID_VALIDATION_NUMBER("02","Número de validación inválido", HttpStatus.NOT_FOUND),
	ALREADY_ENROLLED("01","Esta tarjeta ya se encuentra enrolada", HttpStatus.INTERNAL_SERVER_ERROR),
	TRANSACTION_EXIST("01","Ya existe una transacción con esa referencia", HttpStatus.INTERNAL_SERVER_ERROR),
	NOT_ENROLLED("02","Tarjeta no enrolada", HttpStatus.INTERNAL_SERVER_ERROR),
	NOT_FOUND_TRANSACTION("01","Número de referencia inválido", HttpStatus.NOT_FOUND),
	CANT_CANCEL_TRANSACTION("02","No se puede anular transacción", HttpStatus.INTERNAL_SERVER_ERROR),
	NOT_FOUND_CARD("01", "Tarjeta no existe", HttpStatus.NOT_FOUND);
	
	private String code;
	private String value;
	private HttpStatus httpStatus;

}
