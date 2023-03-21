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
public class ResponseModelPanDto {
	
	private String code;
	private String message;
	private String pan;
	
	public ResponseModelPanDto(BussinessMessageEnum bussiness, String pan) {
		this.code = bussiness.getCode();
		this.message = bussiness.getValue();
		this.pan = pan;
	}

}
