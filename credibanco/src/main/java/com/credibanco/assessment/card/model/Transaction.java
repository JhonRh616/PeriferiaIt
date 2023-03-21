package com.credibanco.assessment.card.model;

import java.sql.Timestamp;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transaction")
public class Transaction {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "REFERENCE_NUMBER")
	@Size(min = 6, max = 6, message = "Reference Number must be have 6 characters")
	private String referenceNumber;
	
	@Column(name = "TOTAL_PURCHASE")
	private Long totalPurchase;
	
	@Column(name = "DATE")
	private Timestamp date;
	
	@Column(name = "STATUS")
	private String status;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.DETACH)
	@JsonIgnore
	@JoinColumn(name = "USER_ID", foreignKey =  @ForeignKey(name = "USER_FK"))
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.DETACH)
	@JoinColumn(name = "CARD_ID", foreignKey =  @ForeignKey(name = "CARD_ID_FK"))
	private Card card;
}
