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

import org.springframework.format.annotation.DateTimeFormat;

//import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "nvarchar(150)")
	private String name;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private GearTypes gearTypes;

	@Column(nullable = false)
//	@JsonFormat()
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;

	@Column(nullable = false)
	private Integer quantity;

	@Column(nullable = false)
	private BigDecimal price;

	@Column(nullable = false)
	private BigDecimal discount;

	@Column(nullable = false)
	private Boolean active;

}
