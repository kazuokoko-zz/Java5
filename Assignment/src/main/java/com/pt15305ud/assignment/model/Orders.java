package com.pt15305ud.assignment.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50, nullable = false)
	private Long userId;

	@Column(name = "dateCreated", nullable = false)
	private LocalDateTime dateCreated = LocalDateTime.now();

	@OneToOne(mappedBy = "order")
	private Payment payment;

	@OneToMany(mappedBy = "order")
	private List<OrderDetails> orderDetails;

}
