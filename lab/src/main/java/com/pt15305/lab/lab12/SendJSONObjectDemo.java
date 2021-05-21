package com.pt15305.lab.lab12;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class SendJSONObjectDemo {
	@GetMapping
	public String readJson(@RequestBody Student student) {
		return "Hello " + student.getName() + " " + student.getId();
	}

	@PostMapping
	public String readJson1(@RequestBody Student student) {
		return "Hello " + student.getName() + " " + student.getId();
	}
}

class Student {
	private String id;
	private String name;

	public Student() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
