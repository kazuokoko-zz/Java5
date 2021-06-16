package com.pt15305ud.assignment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.pt15305ud.assignment.interfaces.ProductRepository;
import com.pt15305ud.assignment.model.Product;

@Component
public class ProductService {

	@Autowired
	ProductRepository _productRepo;

	public Page<Product> getPages(int curPage, int pageSize) {
		return getPages(curPage, pageSize, false);
	}

	public Page<Product> getPages(int curPage, int pageSize, Boolean isActive) {
		Pageable page = PageRequest.of(curPage, pageSize);
		if (isActive) {
			return _productRepo.findByActive(page, true);
		} else {
			return _productRepo.findAll(page);
		}
	}

	public Page<Product> getByNameLikePages(int curPage, int pageSize, String name) {
		return getByNameLikePages(curPage, pageSize, false, name);
	}

	public Page<Product> getByNameLikePages(int curPage, int pageSize, Boolean isActive, String name) {
		Pageable page = PageRequest.of(curPage, pageSize);
		if (isActive) {
			return _productRepo.findByActiveAndNameLike(page, true, name);
		} else {
			return _productRepo.findByNameLike(page, name);
		}
	}

	public Long save(Product product) {
		return _productRepo.save(product).getId();
	}

	public Product getById(Long id) {
		Optional<Product> opt = _productRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		return null;
	}
}
