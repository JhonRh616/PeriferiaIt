package com.credibanco.assessment.card.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.dto.BussinessErrorEnum;
import com.credibanco.assessment.card.dto.BussinessMessageEnum;
import com.credibanco.assessment.card.dto.ResponseModelConsultCardDto;
import com.credibanco.assessment.card.dto.RequestModelPanDto;
import com.credibanco.assessment.card.dto.RequestModelValidationNumberDto;
import com.credibanco.assessment.card.dto.ResponseHeaderDto;
import com.credibanco.assessment.card.dto.ResponseModelCreateDto;
import com.credibanco.assessment.card.dto.ResponseModelPanDto;
import com.credibanco.assessment.card.dto.StatusTypeEnum;
import com.credibanco.assessment.card.exceptions.CredibancoException;
import com.credibanco.assessment.card.model.Card;
import com.credibanco.assessment.card.model.User;
import com.credibanco.assessment.card.repository.CardRepository;
import com.credibanco.assessment.card.repository.UserRepository;
import com.credibanco.assessment.card.service.CardService;
import com.credibanco.assessment.card.util.Util;

import static java.util.Objects.*;

import java.util.List;

@Service
public class CardServiceImpl implements CardService{
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private UserRepository userRepository; 

	@Override
	public ResponseModelConsultCardDto consultCard(String pan) throws CredibancoException {
		Card card = cardRepository.findByPan(pan);
		
		if (isNull(card)) {
			throw new CredibancoException(BussinessErrorEnum.NOT_FOUND_CARD);
		}
		card.setPan(Util.transformPan(card.getPan()));
		
		return new ResponseModelConsultCardDto(card);
	}

	@Override
	public ResponseModelCreateDto createCard(RequestModelPanDto request) throws CredibancoException {
		
		User user =  userRepository.findByIdentificationNumber(request.getIdentificationNumber());
		Card card = cardRepository.findByPan(request.getPan());
		
		if(nonNull(card))
			throw new CredibancoException(BussinessErrorEnum.FAILED);
		if(isNull(user))
			user = new User(null, request.getIdentificationNumber(), request.getPersonName(), request.getPhoneNumber());
		
		try {
			
			userRepository.save(user);
			card = new Card(null, request.getPan(), StatusTypeEnum.CREATED.getValue(), request.getCardType(), (int)(Math.random() * 100 + 1), user);
			card = cardRepository.save(card);
			
		}catch (Exception e) {
			throw new CredibancoException(BussinessErrorEnum.FAILED);
		}
		
		return new ResponseModelCreateDto(BussinessMessageEnum.SUCCESS, card.getValidationNumber(), Util.transformPan(card.getPan()));
	}

	@Override
	public ResponseHeaderDto deleteCard(RequestModelValidationNumberDto request) throws CredibancoException {
		Card card = cardRepository.findByPan(request.getPan());
		
		if(isNull(card))
			throw new CredibancoException(BussinessErrorEnum.CARD_NOT_DELETED);
		
		try {
			cardRepository.deleteById(card.getId());
		} catch (Exception e) {
			throw new CredibancoException(BussinessErrorEnum.CARD_NOT_DELETED);
		}
		 
			
		return new ResponseHeaderDto(BussinessMessageEnum.CARD_DELETED);
	}

	@Override
	public ResponseModelPanDto enrollCard(RequestModelValidationNumberDto request) throws CredibancoException {
		Card card = cardRepository.findByPan(request.getPan());
		
		if(isNull(card))
			throw new CredibancoException(BussinessErrorEnum.NOT_FOUND_CARD);
		
		if(card.getValidationNumber()!=request.getValidationNumber())
			throw new CredibancoException(BussinessErrorEnum.INVALID_VALIDATION_NUMBER);
		
		if(card.getState().equals(StatusTypeEnum.ENROLLED.getValue()))
			throw new CredibancoException(BussinessErrorEnum.ALREADY_ENROLLED);
		
		card.setState(StatusTypeEnum.ENROLLED.getValue());
		cardRepository.save(card);
		
		return new ResponseModelPanDto(BussinessMessageEnum.SUCCESS, Util.transformPan(card.getPan()));
	}

	@Override
	public List<Card> consultAllCards() throws CredibancoException {
		List<Card> res = cardRepository.findAll();
		for (Card card : res) {
			card.setPan(Util.transformPan(card.getPan()));
		}
		return res;
	}
	
	

}
