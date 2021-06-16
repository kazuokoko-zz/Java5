package com.pt15305ud.assignment.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long orderId;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private PaymentTypes paymentType;

	@Column(length = 25)
	private String paymentCode;

	@Column(length = 20)
	private String payerAccount;

	@Column(columnDefinition = "nvarchar(50)")
	private String reciver;

	@Column(length = 20)
	private String reciverAccount;

	@Column(nullable = false)
	private BigDecimal price;

	@Column(length = 255)
	private String description;

	@Column(length = 10)
	private String securityCode;

	@Column(name = "status", nullable = false)
	private boolean status;

	@OneToOne
	@JoinColumn(name = "orderId", insertable = false, updatable = false, referencedColumnName = "id")
	private Orders order;

}
