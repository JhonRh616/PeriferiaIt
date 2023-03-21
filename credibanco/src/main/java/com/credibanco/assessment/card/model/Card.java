package com.credibanco.assessment.card.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "card")
public class Card {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "PAN")
	@Size(min = 16, max = 19, message = "PAN must be between 16 and 19 characters")
	private String pan;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "VALIDATION_NUMBER")
	private int validationNumber;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.DETACH)
	@JoinColumn(name = "USER_ID", foreignKey =  @ForeignKey(name = "USER_ID_FK"))
	private User user;
}
