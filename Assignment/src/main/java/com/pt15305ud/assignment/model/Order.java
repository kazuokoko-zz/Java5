package com.pt15305ud.assignment.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "accountId")
	private Long accountId;

	@Column(name = "dateCreated", nullable = false)
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm")
	private LocalDateTime dateCreated;

	@OneToOne(mappedBy = "order")
	private Payment payment;

	@OneToMany(mappedBy = "order")
	private List<OrderDetails> orderDetails;

	@ManyToOne
	@JoinColumn(name = "accountId", insertable = false, updatable = false)
	private Account account;
}
