package com.credibanco.assessment.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credibanco.assessment.card.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer>{
	
	public Card findByPan(String pan);
	
}
