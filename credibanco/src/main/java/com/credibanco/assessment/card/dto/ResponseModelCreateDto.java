package com.credibanco.assessment.card.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseModelCreateDto {
	
	private String code;
	private String message;
	private Integer validationNumber;
	private String pan;
	
	public ResponseModelCreateDto(BussinessMessageEnum bussiness, int validationNumber, String pan) {
		this.code= bussiness.getCode();
		this.message = bussiness.getValue();
		this.validationNumber = validationNumber;
		this.pan = pan;
	}

}
