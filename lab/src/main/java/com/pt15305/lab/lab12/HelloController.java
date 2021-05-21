package com.pt15305.lab.lab12;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping("/hello/message")
	@ResponseBody
	public String helloSpringMessage() {
		return "Hello Ma Văn Hùng PH12447";
	}
	
	@RequestMapping("/hello/view")
	public String helloStringView() {
		return "hello";
	}
}
