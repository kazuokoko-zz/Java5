package com.pt15305ud.assignment.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pt15305ud.assignment.utils.WebUtils;

@Controller
public class Authen {
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
//		model.addAttribute("title", "Welcome");
//		model.addAttribute("message", "This is welcome page!");
		return "redirect:/home";
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model, Principal principal) {
		if (principal != null) {
			return "redirect:/home";
		}
		return "login";
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		return "redirect:/login";
	}

	@RequestMapping(value = "/loginSuccessful", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {

		// Sau khi user login thanh cong se co principal
//		String userName = principal.getName();
//
//		System.out.println("User Name: " + userName);
//
//		User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//		String userInfo = WebUtils.toString(loginedUser);
//		model.addAttribute("userInfo", userInfo);

		return "redirect:/home";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();

			String userInfo = WebUtils.toString(loginedUser);

			model.addAttribute("userInfo", userInfo);

			String message = "<h1>Có lỗi xảy ra</h1>\n" + principal.getName() //
					+ "<br> bạn không có truy cập vào trang này!";
			model.addAttribute("message", message);

		}

		return "403";
	}
}
