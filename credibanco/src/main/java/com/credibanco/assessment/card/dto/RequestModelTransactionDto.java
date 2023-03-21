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
public class RequestModelTransactionDto {
	
	private String pan;
	private String referenceNumber;
	private Long total;
	private String address;

}
