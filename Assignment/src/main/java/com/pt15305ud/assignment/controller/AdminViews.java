package com.pt15305ud.assignment.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminViews {

	@RequestMapping
	public String adminPage(Model model, Principal principal) {

		return "admin";
	}
}
