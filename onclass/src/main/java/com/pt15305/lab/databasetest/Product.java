package com.pt15305.lab.databasetest;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "id",nullable = false)
	private Integer id;
	@Column(name = "name",nullable = false,length = 150)
	private String name;
	@Column(name = "quantity",nullable = false)
	private Integer quantity;
	@Column(name = "price",nullable = false)
	private BigDecimal price;
	@Column(name = "date",nullable = false)
	private Date date;
	@Column(name = "year",nullable = false)
	private int year;
}
