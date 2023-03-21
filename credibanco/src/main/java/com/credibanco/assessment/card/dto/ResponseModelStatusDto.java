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
public class ResponseModelStatusDto {
	
	private String code;
	private String message;
	private String status;
	private String referenceNumber;
	
	public ResponseModelStatusDto(BussinessMessageEnum bussiness, String status, String referenceNumber) {
		this.code = bussiness.getCode();
		this.message = bussiness.getValue();
		this.status = status;
		this.referenceNumber = referenceNumber;
	}

}
