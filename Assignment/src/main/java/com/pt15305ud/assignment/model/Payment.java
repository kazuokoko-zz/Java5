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

	@Column(name = "orderId")
	private Long orderId;

	@Column(name = "paymentType", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private PaymentTypes paymentType;

	@Column(name = "paymentCode", length = 25)
	private String paymentCode;

	@Column(name = "payerAccount", length = 20)
	private String payerAccount;

	@Column(name = "reciever", columnDefinition = "nvarchar(50)")
	private String reciver;

	@Column(name = "recieverAccount", length = 20)
	private String reciverAccount;

	@Column(name = "price", nullable = false)
	private BigDecimal price;

	@Column(name = "description", length = 255)
	private String description;

	@Column(name = "securityCode", length = 10)
	private String securityCode;

	@Column(name = "status", nullable = false)
	private boolean status;

	@OneToOne
	@JoinColumn(name = "orderId", insertable = false, updatable = false, referencedColumnName = "id")
	private Order order;

}
