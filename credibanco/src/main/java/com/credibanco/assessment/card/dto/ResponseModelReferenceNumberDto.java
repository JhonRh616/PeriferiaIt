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
public class ResponseModelReferenceNumberDto {
	
	private String code;
	private String message;
	private String referenceNumber;
	
	public ResponseModelReferenceNumberDto(BussinessMessageEnum bussiness, String referenceNumber) {
		this.code = bussiness.getCode();
		this.message = bussiness.getValue();
		this.referenceNumber = referenceNumber;
	}

}
