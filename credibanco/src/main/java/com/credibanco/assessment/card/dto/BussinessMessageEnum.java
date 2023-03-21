package com.credibanco.assessment.card.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum BussinessMessageEnum {
	
	CARD_DELETED("00", "Se ha eliminado la tarjeta", HttpStatus.OK),
	SUCCESS_PURCHASE("00", "Compra exitosa", HttpStatus.CREATED),
	SUCCESS_CANCEL("00", "Compra anulada", HttpStatus.OK),
	SUCCESS("00", "Éxito", HttpStatus.OK);
	
	private String code;
	private String value;
	private HttpStatus httpStatus;

}
