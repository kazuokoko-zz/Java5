package com.pt15305.lab.databasetest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class ControllerProduct {

	@Autowired
	private ProductsJpaRepository crud;
	
	
	public List<Product> getAll() {
		
		return crud.findAll();
	}
	
	public Product getById(Integer id) {
		Optional<Product> opt = crud.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}
}
