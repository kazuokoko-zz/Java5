package com.pt15305.lab.lab34;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gaminggear")
public class ProductRestController {

	@Autowired
	ProductService _productSer;

	@GetMapping
	public List<Product> getAll() {
		return _productSer.getAll();
	}

	@GetMapping("/{id}")
	public Product getById(@PathVariable Long id) {
		return _productSer.getById(id);
	}

	@GetMapping("/get")
	public List<Product> getByName(@RequestParam(required = false) String name,
			@RequestParam(required = false) @DefaultValue() GearTypes gearType) {
		return _productSer.getByParam(name, gearType);
	}

	@PostMapping
	public Long add(@RequestBody Product product) {
		return _productSer.save(product);
	}

	@PutMapping("/{id}")
	public Long update(@PathVariable Long id, @RequestBody Product product) {
		product.setId(id);
		return _productSer.save(product);
	}

	@DeleteMapping("/delete/{id}")
	public int deletebyId(@PathVariable Long id) {
		return _productSer.deleteById(id);
	}

}
