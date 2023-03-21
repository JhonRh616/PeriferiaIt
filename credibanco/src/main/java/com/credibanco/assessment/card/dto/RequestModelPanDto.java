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
public class RequestModelPanDto {
	
	private String pan;
	private String personName;
	private String identificationNumber;
	private String cardType;
	private String phoneNumber;

}
