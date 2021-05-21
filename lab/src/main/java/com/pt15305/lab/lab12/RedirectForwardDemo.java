package com.pt15305.lab.lab12;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectForwardDemo {
	@RequestMapping("/hello/redirect")
	public String reDirect() {
		return "redirect:/about.html";
	}

	@RequestMapping("/hello/forward")
	public String forWard() {
		return "forward:/about.html";
	}
}
