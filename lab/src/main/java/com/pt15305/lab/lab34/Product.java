package com.pt15305.lab.lab34;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "code", length = 15, nullable = false, unique = true)
	private String code;

	@Column(name = "name", nullable = false, columnDefinition = "nvarchar(150)")
	private String name;

	@Column(name = "created_date", nullable = false)
	private Date created_date;

	@Column(name = "geartype", nullable = false, length = 13)
	@Enumerated(EnumType.ORDINAL)
	private GearTypes gearType;

	@Column(name = "price", nullable = false)
	private BigDecimal price;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;
}
