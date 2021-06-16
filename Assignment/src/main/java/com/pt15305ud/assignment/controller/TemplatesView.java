package com.pt15305ud.assignment.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pt15305ud.assignment.model.Cart;
import com.pt15305ud.assignment.utils.CartUtils;

@Controller
public class TemplatesView {

	@RequestMapping("/templates/header")
	public String header(Model model, HttpServletRequest req) {

		Cart cart = CartUtils.getCartInSession(req);

		Integer count = 0;
		if (!cart.getCart().isEmpty()) {
			for (Long id : cart.getCart().keySet()) {
				count += cart.getCart().get(id).getQuantity();
			}
		}
		model.addAttribute("cartCount", count);
		if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
				.anyMatch(r -> r.getAuthority().equals("ADMIN")))
			model.addAttribute("isAdmin", true);

		return "templates/header";
	}

	@RequestMapping("/templates/footer")
	public String footer() {
		return "templates/footer";
	}

}
