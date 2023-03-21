package com.credibanco.assessment.card.service;

import java.util.List;

import com.credibanco.assessment.card.dto.RequestModelCancelDto;
import com.credibanco.assessment.card.dto.RequestModelTransactionDto;
import com.credibanco.assessment.card.dto.ResponseModelReferenceNumberDto;
import com.credibanco.assessment.card.dto.ResponseModelStatusDto;
import com.credibanco.assessment.card.exceptions.CredibancoException;
import com.credibanco.assessment.card.model.Transaction;

public interface TransactionService {
	
	public ResponseModelStatusDto createTransaction(RequestModelTransactionDto request) throws CredibancoException;
	public ResponseModelReferenceNumberDto cancelTransaction(RequestModelCancelDto request) throws CredibancoException;
	public List<Transaction> consultAllTransactions() throws CredibancoException;

}
