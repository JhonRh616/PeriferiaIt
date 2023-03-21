package com.credibanco.assessment.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.card.dto.RequestModelCancelDto;
import com.credibanco.assessment.card.dto.RequestModelTransactionDto;
import com.credibanco.assessment.card.dto.ResponseModelReferenceNumberDto;
import com.credibanco.assessment.card.dto.ResponseModelStatusDto;
import com.credibanco.assessment.card.exceptions.CredibancoException;
import com.credibanco.assessment.card.model.Transaction;
import com.credibanco.assessment.card.service.TransactionService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseModelStatusDto> createCard(@RequestBody RequestModelTransactionDto request) throws CredibancoException {
		return new ResponseEntity<>(transactionService.createTransaction(request), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/cancel", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseModelReferenceNumberDto> consultCard(@RequestBody RequestModelCancelDto request) throws CredibancoException {
		return new ResponseEntity<>(transactionService.cancelTransaction(request), HttpStatus.OK);
	}
	
	@GetMapping(path = "/consult/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Transaction>> consultTransactions() throws CredibancoException {
		return new ResponseEntity<>(transactionService.consultAllTransactions(), HttpStatus.OK);
	}
	
}
