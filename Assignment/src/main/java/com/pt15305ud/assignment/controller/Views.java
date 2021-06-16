package com.pt15305ud.assignment.controller;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pt15305ud.assignment.model.Cart;
import com.pt15305ud.assignment.model.OrderDetails;
import com.pt15305ud.assignment.model.Orders;
import com.pt15305ud.assignment.model.Product;
import com.pt15305ud.assignment.service.AccountService;
import com.pt15305ud.assignment.service.OrderService;
import com.pt15305ud.assignment.service.ProductService;
import com.pt15305ud.assignment.utils.CartUtils;

@Controller
public class Views {

	@Autowired
	ProductService _productSer;

	@Autowired
	OrderService _orderSer;

	@Autowired
	AccountService _accountSer;

	private final int limit = 20;

	@RequestMapping(value = { "/home", "/new", "/hot", "/discount" })
	public String home(Model model, @RequestParam(defaultValue = "1") Integer p,
			@RequestParam(defaultValue = "") String name) {
		Page<Product> page;// = _productSer.getPages(curPage, limit, true);
		if (name != null) {
			if (p < 1)
				p = 1;
			page = _productSer.getByNameLikePages(p - 1, limit, true, name);

			if (page.getTotalPages() < p)
				p = page.getTotalPages();
			if (p > 0)
				page = _productSer.getByNameLikePages(p - 1, limit, true, name);
		} else {
			if (p < 1)
				p = 1;
			page = _productSer.getPages(p - 1, limit, true);

			if (page.getTotalPages() < p)
				p = page.getTotalPages();
			if (p > 0)
				page = _productSer.getPages(p - 1, limit, true);
		}
		model.addAttribute("curPage", p);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("name", name);
		model.addAttribute("finding", name.isBlank());
		model.addAttribute("gamingGears", page.getContent());

		return "home";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}

//	@RequestMapping("/product")
//	public String product() {
//
//		return "product";
//	}

	@RequestMapping("/product/{id}")
	public String productDetails(@PathVariable Long id, Model model) {
		if (id == null) {
			return "redirect:/home";
		}

		Product product = _productSer.getById(id);
		if (product == null)
			return "redirect:/home";

		model.addAttribute("product", product);

		return "product";
	}

	@RequestMapping("/cart")
	public String Cart(Model model, HttpServletRequest req) {
		Cart cart = CartUtils.getCartInSession(req);
		model.addAttribute("haveItems", cart.getCart().size() > 0 ? true : false);
		model.addAttribute("cart", cart.getCart());
		BigDecimal sumPrice = new BigDecimal(0);
		if (cart.getCart().size() > 0) {
			for (Long id : cart.getCart().keySet()) {
				sumPrice = sumPrice.add(cart.getCart().get(id).getPrice()
						.multiply(new BigDecimal(cart.getCart().get(id).getQuantity())));
			}
		}

		model.addAttribute("sumPrice", sumPrice);
		return "cart";
	}

	@RequestMapping("/cart/buy")
	public String checkout(Model model, HttpServletRequest req, Principal principal) throws Exception {
		if (principal == null) {
			return "redirect:/login";
		}
		Cart cart = CartUtils.getCartInSession(req);
		if (!(cart.getCart().size() > 0)) {
			return "redirect:/cart";
		}
		Orders orders = new Orders();

		List<OrderDetails> details = new ArrayList<OrderDetails>();

		cart.getCart().forEach((id, detail) -> {
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setProductId(id);
			orderDetails.setQuantity(detail.getQuantity());
			orderDetails.setProductPrice(detail.getPrice());
			details.add(orderDetails);
		});
		orders.setOrderDetails(details);
		orders.setUserId(_accountSer.findByUserName(principal.getName()).getId());
		orders = _orderSer.newOrder(orders);

		CartUtils.removeCartInSession(req);
		model.addAttribute("order", orders);
		model.addAttribute("account", _accountSer.getById(orders.getUserId()));
		return "buy";
	}

}
