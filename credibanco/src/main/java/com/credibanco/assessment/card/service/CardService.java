package com.credibanco.assessment.card.service;

import com.credibanco.assessment.card.dto.ResponseModelConsultCardDto;

import java.util.List;

import com.credibanco.assessment.card.dto.RequestModelPanDto;
import com.credibanco.assessment.card.dto.RequestModelValidationNumberDto;
import com.credibanco.assessment.card.dto.ResponseHeaderDto;
import com.credibanco.assessment.card.dto.ResponseModelCreateDto;
import com.credibanco.assessment.card.dto.ResponseModelPanDto;
import com.credibanco.assessment.card.exceptions.CredibancoException;
import com.credibanco.assessment.card.model.Card;

public interface CardService {
	
	public ResponseModelConsultCardDto consultCard(String pan) throws CredibancoException;
	public ResponseModelCreateDto createCard(RequestModelPanDto request) throws CredibancoException;
	public ResponseHeaderDto deleteCard(RequestModelValidationNumberDto request) throws CredibancoException;
	public ResponseModelPanDto enrollCard(RequestModelValidationNumberDto request) throws CredibancoException;
	public List<Card> consultAllCards() throws CredibancoException;

}
