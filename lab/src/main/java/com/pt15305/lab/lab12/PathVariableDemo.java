package com.pt15305.lab.lab12;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableDemo {

	@GetMapping({ "/pathvariable/{id}", "/{id}/pathvariable" })
	public Integer get(@PathVariable Integer id) {
		return id;
	}
}
