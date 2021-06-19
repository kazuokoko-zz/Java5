package com.pt15305ud.assignment.controller;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pt15305ud.assignment.model.Account;
import com.pt15305ud.assignment.model.GearTypes;
import com.pt15305ud.assignment.model.Product;
import com.pt15305ud.assignment.service.AccountService;
import com.pt15305ud.assignment.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminViews {

	@Autowired
	ProductService _productSer;
	private final int limit = 10;

	@Autowired
	AccountService _accountSer;

	@RequestMapping
	public String adminPage(Model model, Principal principal) {

		return "admin";
	}

	@RequestMapping("/product")
	public String adminProduct(@RequestParam(defaultValue = "1") Integer p,
			@RequestParam(defaultValue = "") String name, @RequestParam(required = false) GearTypes type, Model model,
			Principal principal) {

		Page<Product> page;

		if (p < 1)
			p = 1;
		page = _productSer.getByNameLikeAndGearTypePages(p - 1, limit, name, type);

		if (page.getTotalPages() < p)
			p = page.getTotalPages();
		if (p > 0)
			page = _productSer.getByNameLikeAndGearTypePages(p - 1, limit, name, type);

		model.addAttribute("curPage", p);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("name", name.isBlank() ? "" : name);
		model.addAttribute("type", type);
		model.addAttribute("gearTypes", GearTypes.values());
		model.addAttribute("gears", page.getContent());

		return "admin/product";
	}

	@RequestMapping("/product/{id}")
	public String gearDetails(@PathVariable Long id, Model model) {

		model.addAttribute("gear", _productSer.getById(id));
		model.addAttribute("gearTypes", GearTypes.values());
		return "admin/details";
	}

	@RequestMapping("/product/new")
	public String newGear(Model model) {
		Product p = new Product();
		p.setCreatedDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		model.addAttribute("gear", p);
		model.addAttribute("gearTypes", GearTypes.values());
		return "admin/newproduct";
	}

	@RequestMapping("/product/insert")
	public String addGear(@ModelAttribute("gear") Product product, Model model) {
		product.setQuantity(
				product.getQuantity() != null ? product.getQuantity() > 0 ? product.getQuantity() : 10 : 10);
		product.setCreatedDate(product.getCreatedDate() != null ? product.getCreatedDate()
				: Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		product.setPrice(product.getPrice() != null
				? product.getPrice().compareTo(new BigDecimal(0)) > 0 ? product.getPrice() : new BigDecimal(0)
				: new BigDecimal(0));
		product.setDiscount(product.getDiscount() != null
				? product.getDiscount().compareTo(new BigDecimal(0)) > 0 ? product.getDiscount() : new BigDecimal(0)
				: new BigDecimal(0));
		Long id = _productSer.save(product);
		return "redirect:/admin/product/" + id;
	}

	@RequestMapping("/product/update")
	public String update() {
		Long id = 0l;
		return "redirect:/admin/product/" + id;
	}

	@RequestMapping("/product/delete")
	public String deleteMul(@RequestParam Long[] ids) {

		_productSer.deleteMul(ids);

		return "redirect:/admin/product";
	}

	@RequestMapping("/product/delete/{id}")
	public String delete(@PathVariable Long id) {
		_productSer.deleteById(id);
		return "redirect:/admin/product";
	}

	// account
//
	//
	//
	//
	//
	//
	//
	//
	//
	@RequestMapping("/account")
	public String adminAccount(@RequestParam(defaultValue = "1") Integer p,
			@RequestParam(defaultValue = "") String name, Model model, Principal principal) {

		Page<Account> page;

		if (p < 1)
			p = 1;
		page = _accountSer.findAllByName(p - 1, limit, name);

		if (page.getTotalPages() < p)
			p = page.getTotalPages();
		if (p > 0)
			page = _accountSer.findAllByName(p - 1, limit, name);

		model.addAttribute("curPage", p);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("name", name.isBlank() ? "" : name);
		model.addAttribute("tks", page.getContent());

		return "admin/account";
	}

	@RequestMapping("/account/{id}")
	public String gearDetailsAccount(@PathVariable Long id, Model model) {
		Account account = _accountSer.getById(id);
		String oldpass = account.getEncrytedPassword();
		account.setEncrytedPassword("");
		model.addAttribute("tk", account);
		return "admin/detailsaccount";
	}

	@RequestMapping("/account/new")
	public String newAccount(Model model) {
		Product p = new Product();
		model.addAttribute("gear", p);
		return "admin/newaccount";
	}

	@RequestMapping("/account/insert")
	public String addAccount(@ModelAttribute("gear") Product product, Model model) {
		product.setQuantity(
				product.getQuantity() != null ? product.getQuantity() > 0 ? product.getQuantity() : 10 : 10);
		product.setCreatedDate(product.getCreatedDate() != null ? product.getCreatedDate()
				: Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		product.setPrice(product.getPrice() != null
				? product.getPrice().compareTo(new BigDecimal(0)) > 0 ? product.getPrice() : new BigDecimal(0)
				: new BigDecimal(0));
		product.setDiscount(product.getDiscount() != null
				? product.getDiscount().compareTo(new BigDecimal(0)) > 0 ? product.getDiscount() : new BigDecimal(0)
				: new BigDecimal(0));
		Long id = _productSer.save(product);
		return "redirect:/admin/account/" + id;
	}

	@RequestMapping("/account/update")
	public String updateAccount() {
		Long id = 0l;
		return "redirect:/admin/account/" + id;
	}

	@RequestMapping("/account/delete")
	public String deleteMulAccount(@RequestParam Long[] ids) {

		_productSer.deleteMul(ids);

		return "redirect:/admin/account";
	}

	@RequestMapping("/account/delete/{id}")
	public String deleteAccount(@PathVariable Long id) {
		_productSer.deleteById(id);
		return "redirect:/admin/account";
	}
}
