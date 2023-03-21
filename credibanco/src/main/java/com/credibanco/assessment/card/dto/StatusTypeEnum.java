package com.credibanco.assessment.card.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum StatusTypeEnum {
	
	CREATED("Creada"),
	ENROLLED("Enrolada"),
	APPROVED("Aprobada"),
	REJECTED("Rechazada");
	
	private String value;

}
