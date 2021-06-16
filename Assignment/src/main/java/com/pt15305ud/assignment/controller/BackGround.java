package com.pt15305ud.assignment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pt15305ud.assignment.interfaces.ProductRepository;
import com.pt15305ud.assignment.model.Cart;
import com.pt15305ud.assignment.model.CartDetail;
import com.pt15305ud.assignment.model.Product;
import com.pt15305ud.assignment.utils.CartUtils;

@Controller
public class BackGround {

	@Autowired
	ProductRepository _productRepo;

	@RequestMapping("/addToCart/{id}")
	public String addToCart(@PathVariable Long id, Model model, HttpServletRequest req) {
		Cart cart = CartUtils.getCartInSession(req);
		CartDetail detail = new CartDetail();
		detail.setQuantity(cart.getCart().get(id) == null ? 1 : cart.getCart().get(id).getQuantity() + 1);
		Product product = _productRepo.findById(id).get();
		detail.setPrice(product.getPrice().subtract(product.getDiscount()));
		detail.setName(product.getName());
		cart.getCart().put(id, detail);

//		model.addAttribute("cart", cart.getCart());

		return "redirect:/home";
	}

	@RequestMapping("/cart/delete/{id}")
	public String removeFromCart(@PathVariable Long id, HttpServletRequest req) {
		Cart cart = CartUtils.getCartInSession(req);
		cart.getCart().remove(id);

		return "redirect:/cart";
	}

	@RequestMapping("/cart/delete")
	public String removeFromCart(@RequestParam Long[] ids, HttpServletRequest req) {
		Cart cart = CartUtils.getCartInSession(req);
		for (Long id : ids) {
			cart.getCart().remove(id);
		}
		return "redirect:/cart";
	}

	@RequestMapping("/cart/update/{id}")
	public String updateCart(@PathVariable Long id, @RequestParam Integer quantity, HttpServletRequest req) {
		Cart cart = CartUtils.getCartInSession(req);
		if (quantity > 0) {
			CartDetail detail = cart.getCart().get(id);
			cart.getCart().remove(id);
			detail.setQuantity(quantity);
			cart.getCart().put(id, detail);

		} else {
			cart.getCart().remove(id);
		}

		return "redirect:/cart";
	}

}
