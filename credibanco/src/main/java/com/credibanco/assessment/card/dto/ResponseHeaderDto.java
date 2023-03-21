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
public class ResponseHeaderDto {
	
	private String code;
	private String message;
	
	public ResponseHeaderDto(BussinessMessageEnum error) {
		this.code = error.getCode();
		this.message = error.getValue();
	}
	
	//Sería ideal usar este header para todas las peticiones, puesto que responden siempre con un código y un mensaje, bien sea
	//un mensaje exitoso o un mensaje de error, eso centralizaría las respuestas de la aplicación.

}
