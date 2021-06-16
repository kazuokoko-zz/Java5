package com.pt15305ud.assignment.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pt15305ud.assignment.model.Product;
import com.pt15305ud.assignment.service.ProductService;
import com.pt15305ud.assignment.utils.CommonConst;

@RestController
@RequestMapping("/api/product")
public class ProductAPI {
	public final int ITEM_ON_PAGE = 10;

	@Autowired
	ProductService _productSer;

	@GetMapping
	public List<Product> getOnePage(@RequestParam(defaultValue = "1") int p) {
		return _productSer.getPages(p, ITEM_ON_PAGE).getContent();
	}

	@PostMapping
	public int add(@RequestBody Product product) {
		try {
			_productSer.save(product);
			return CommonConst.SUCCESS;
		} catch (Exception e) {

			return CommonConst.SUCCESS;
		}
		
	}

}
