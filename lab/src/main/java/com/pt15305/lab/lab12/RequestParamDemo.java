package com.pt15305.lab.lab12;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamDemo {
	@GetMapping("/requestparam")
	public String get(@RequestParam(required = false) String name) {
		return name;
	}
}
