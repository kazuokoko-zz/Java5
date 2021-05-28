package com.pt15305.lab.lab34;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

	@Autowired
	IProductRepository _productRepo;

	public List<Product> getAll() {
		return _productRepo.findAll();
	}

	public Product getById(Long id) {
		Optional<Product> opt = _productRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public List<Product> getByParam(String name, GearTypes gearType) {
		if (gearType != null || name != null) {
			if (gearType != null && name != null) {
				return _productRepo.findByNameAndGearType(name, gearType);
			}
			if (name != null) {
				return _productRepo.findByNameLike(name);
			} else {
				return _productRepo.findByGearType(gearType);
			}
		} else {
			return _productRepo.findByNameOrGearType(name, gearType);
		}
	}

	public int add(Product product) {
		try {
			_productRepo.save(product);
			return CommonConst.SUCCESS;
		} catch (Exception e) {
			return CommonConst.ERROR;
		}
	}

	public int update(Product product) {
		try {
			_productRepo.save(product);
			return CommonConst.SUCCESS;
		} catch (Exception e) {
			return CommonConst.ERROR;
		}
	}

	public int deleteById(Long id) {
		try {
			_productRepo.deleteById(id);
			return CommonConst.SUCCESS;
		} catch (Exception e) {
			return CommonConst.ERROR;
		}
	}

}
