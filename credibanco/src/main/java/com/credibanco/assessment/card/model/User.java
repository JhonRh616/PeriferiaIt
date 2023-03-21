package com.credibanco.assessment.card.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "IDENTIFICATION_NUMBER")
	private String identificationNumber;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

}
