package com.pt15305ud.assignment.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "orderdetails")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long orderId;

	@Column(nullable = false)
	private Long productId;

	@Column(nullable = false)
	private BigDecimal productPrice;

	@Column(nullable = false)
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "orderId", insertable = false, updatable = false)
	private Orders order;

}
