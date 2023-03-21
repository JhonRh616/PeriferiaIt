package com.credibanco.assessment.card.dto;

import com.credibanco.assessment.card.model.Card;

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
public class ResponseModelConsultCardDto {
	
	private String pan;
	private String personName;
	private String identificationNumber;
	private String phoneNumber;
	private String status;
	
	public ResponseModelConsultCardDto(Card card) {
		this.pan = card.getPan();
		this.personName = card.getUser().getName(); 
		this.identificationNumber= card.getUser().getIdentificationNumber();
		this.phoneNumber = card.getUser().getPhoneNumber();
		this.status = card.getState();
		return;
	}

}
