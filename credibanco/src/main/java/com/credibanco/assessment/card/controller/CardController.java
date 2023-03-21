package com.credibanco.assessment.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.card.dto.ResponseModelConsultCardDto;
import com.credibanco.assessment.card.dto.RequestModelPanDto;
import com.credibanco.assessment.card.dto.RequestModelValidationNumberDto;
import com.credibanco.assessment.card.dto.ResponseHeaderDto;
import com.credibanco.assessment.card.dto.ResponseModelCreateDto;
import com.credibanco.assessment.card.dto.ResponseModelPanDto;
import com.credibanco.assessment.card.exceptions.CredibancoException;
import com.credibanco.assessment.card.model.Card;
import com.credibanco.assessment.card.service.CardService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/card")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseModelCreateDto> createCard(@RequestBody RequestModelPanDto request) throws CredibancoException {
		return new ResponseEntity<>(cardService.createCard(request), HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/consult", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseModelConsultCardDto> consultCard(@RequestParam(value = "pan") String pan) throws CredibancoException {
		return new ResponseEntity<>(cardService.consultCard(pan), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseHeaderDto> deleteCard(@RequestBody RequestModelValidationNumberDto request) throws CredibancoException {
		return new ResponseEntity<>(cardService.deleteCard(request), HttpStatus.OK);
	}
	
	@PutMapping(path = "/enroll", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseModelPanDto> enrollCard(@RequestBody RequestModelValidationNumberDto request) throws CredibancoException {
		return new ResponseEntity<>(cardService.enrollCard(request), HttpStatus.OK);
	}
	
	@GetMapping(path = "/consult/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Card>> consultTransactions() throws CredibancoException {
		return new ResponseEntity<>(cardService.consultAllCards(), HttpStatus.OK);
	}

}
