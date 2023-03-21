package com.credibanco.assessment.card.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.dto.BussinessErrorEnum;
import com.credibanco.assessment.card.dto.BussinessMessageEnum;
import com.credibanco.assessment.card.dto.RequestModelCancelDto;
import com.credibanco.assessment.card.dto.RequestModelTransactionDto;
import com.credibanco.assessment.card.dto.ResponseModelReferenceNumberDto;
import com.credibanco.assessment.card.dto.ResponseModelStatusDto;
import com.credibanco.assessment.card.dto.StatusTypeEnum;
import com.credibanco.assessment.card.exceptions.CredibancoException;
import com.credibanco.assessment.card.model.Card;
import com.credibanco.assessment.card.model.Transaction;
import com.credibanco.assessment.card.repository.CardRepository;
import com.credibanco.assessment.card.repository.TransactionRepository;
import com.credibanco.assessment.card.service.TransactionService;
import com.credibanco.assessment.card.util.Util;

import static java.util.Objects.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public ResponseModelStatusDto createTransaction(RequestModelTransactionDto request) throws CredibancoException {
		Card card = cardRepository.findByPan(request.getPan());
		
		if(isNull(card))
			throw new CredibancoException(BussinessErrorEnum.NOT_FOUND_CARD);
		if(!card.getState().equals(StatusTypeEnum.ENROLLED.getValue()))
			throw new CredibancoException(BussinessErrorEnum.NOT_ENROLLED);
		if(nonNull(transactionRepository.findByReferenceNumber(request.getReferenceNumber())))
			throw new CredibancoException(BussinessErrorEnum.TRANSACTION_EXIST);
			
		Transaction transaction = new Transaction(null, request.getAddress(), request.getReferenceNumber(), request.getTotal(),
				new Timestamp(new Date().getTime()), StatusTypeEnum.APPROVED.getValue(), card.getUser(), card);
		
		
		transaction = transactionRepository.save(transaction);
			
		return new ResponseModelStatusDto(BussinessMessageEnum.SUCCESS_PURCHASE, transaction.getStatus(), transaction.getReferenceNumber());
	}

	@Override
	public ResponseModelReferenceNumberDto cancelTransaction(RequestModelCancelDto request) throws CredibancoException {
		Transaction transaction = transactionRepository.findByReferenceNumber(request.getReferenceNumber());
		
		if (isNull(transaction))
			throw new CredibancoException(BussinessErrorEnum.NOT_FOUND_TRANSACTION);
		
		if (Util.getDifferenceBetweenDates(transaction.getDate())>5) 
			throw new CredibancoException(BussinessErrorEnum.CANT_CANCEL_TRANSACTION);
		
		try {
			transaction.setStatus(StatusTypeEnum.REJECTED.getValue());
			transactionRepository.save(transaction);
		} catch (Exception e) {
			throw new CredibancoException(BussinessErrorEnum.CANT_CANCEL_TRANSACTION);
		}
		
		return new ResponseModelReferenceNumberDto(BussinessMessageEnum.SUCCESS_CANCEL, transaction.getReferenceNumber());
	}
	
	

	@Override
	public List<Transaction> consultAllTransactions() throws CredibancoException {
		List<Transaction> res = transactionRepository.findAll();
		for (Transaction transaction : res) {
			transaction.getCard().setPan(Util.transformPan(transaction.getCard().getPan()));
		}
		return res;
	}

}
