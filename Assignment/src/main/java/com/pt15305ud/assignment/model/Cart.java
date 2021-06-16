package com.pt15305ud.assignment.model;

import java.util.Map;

import lombok.Data;

@Data
public class Cart {

	private Map<Long, CartDetail> cart;

}
