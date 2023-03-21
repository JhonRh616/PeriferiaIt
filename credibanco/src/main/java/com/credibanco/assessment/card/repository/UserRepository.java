package com.credibanco.assessment.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credibanco.assessment.card.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByIdentificationNumber(String identificationNumber);
	
}
