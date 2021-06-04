package com.pt15305ud.assignment.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, columnDefinition = "nvarchar(150)")
	private String name;

	@Column(name = "gearstype", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private GearTypes gearTypes;

	@Column(name = "createdDate", nullable = false)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createdDate;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@Column(name = "price", nullable = false)
	private BigDecimal price;

}
