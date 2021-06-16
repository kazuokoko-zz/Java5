package com.pt15305ud.assignment.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartDetail {
	private String name;
	private Integer quantity;
	private BigDecimal price;
}
