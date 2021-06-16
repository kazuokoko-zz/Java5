package com.pt15305ud.assignment.utils;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.pt15305ud.assignment.model.Cart;
import com.pt15305ud.assignment.model.CartDetail;

public class CartUtils {
	// Products in the cart, stored in Session.
	public static Cart getCartInSession(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("myCart");
		if (cart == null) {
			cart = new Cart();
			cart.setCart(new HashMap<Long, CartDetail>());
			request.getSession().setAttribute("myCart", cart);
		}
		return cart;
	}

	public static void removeCartInSession(HttpServletRequest request) {
		request.getSession().removeAttribute("myCart");
	}
}
