package com.pt15305.lab.lab34;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class ProductService {

	@Autowired
	IProductRepository _productRepo;

	public List<Product> getAll() {
		return _productRepo.findAll();
	}
	public List<Product> findByGearType(GearTypes gearType) {
		return _productRepo.findByGearType(gearType);
	}

	public Page<Product> getPages(int curPage, int pageSize) {
		Pageable page = PageRequest.of(curPage, pageSize);
		return _productRepo.findAll(page);
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

	public Long save(Product product) {
		try {
			return _productRepo.save(product).getId();

		} catch (Exception e) {
			return (long) CommonConst.ERROR;
		}
	}

//	public int add(Product product) {
//		try {
//			_productRepo.save(product);
//			return CommonConst.SUCCESS;
//		} catch (Exception e) {
//			return CommonConst.ERROR;
//		}
//	}

//	public int update(Product product) {
//		try {
//			_productRepo.save(product);
//			return CommonConst.SUCCESS;
//		} catch (Exception e) {
//			return CommonConst.ERROR;
//		}
//	}

	public int deleteById(Long id) {
		try {
			_productRepo.deleteById(id);
			return CommonConst.SUCCESS;
		} catch (Exception e) {
			return CommonConst.ERROR;
		}
	}

	public void setPageStat(Model model, int curPage, int totalPage, boolean isPagging) {
		model.addAttribute("isPagging", true);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
	}
}
