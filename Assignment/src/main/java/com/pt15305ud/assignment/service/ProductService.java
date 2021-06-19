package com.pt15305ud.assignment.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.pt15305ud.assignment.interfaces.ProductRepository;
import com.pt15305ud.assignment.model.GearTypes;
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

	public Page<Product> getByNameLikeAndGearTypePages(int curPage, int pageSize, String name, GearTypes type) {
		Pageable page = PageRequest.of(curPage, pageSize);
		if (name.isBlank() && type == null) {
			return _productRepo.findAll(page);
		}
		if (!name.isBlank() && type != null) {
			return _productRepo.findByNameOrGearTypes(page, name, type);
		}
		if (name.isBlank()) {
			return _productRepo.findByGearTypes(page, type);
		}
		return _productRepo.findByNameLike(page, name);
	}

	@Transactional
	public Long save(Product product) {
		return _productRepo.save(product).getId();
	}

	public Product getById(Long id) {
		Optional<Product> opt = _productRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		return null;
	}

	@Transactional
	public int deleteById(Long id) {
		try {
			Product product = _productRepo.getById(id);
			product.setActive(false);
			_productRepo.save(product);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Transactional
	public int deleteMul(Long[] ids) {
		try {
			for (Long id : ids) {
				Product product = _productRepo.getById(id);
				product.setActive(false);
				_productRepo.save(product);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

}
