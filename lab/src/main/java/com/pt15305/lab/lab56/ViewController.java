package com.pt15305.lab.lab56;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pt15305.lab.lab34.GearTypes;
import com.pt15305.lab.lab34.Product;
import com.pt15305.lab.lab34.ProductService;

@Controller
@RequestMapping("/gaminggears")
public class ViewController {

	@Autowired
	ProductService _productSer;
	private final int PAGE_SIZE = 2;

	@GetMapping
	public String getListPage(Model model) {
		model.addAttribute("gearType", GearTypes.values());
		List<Product> list = _productSer.getAll();
		model.addAttribute("gamingGears", list);

//		_productSer.setPageStat(model, 1, 1, false);

		model.addAttribute("isPagging", false);
		model.addAttribute("curPage", 1);
		model.addAttribute("totalPage", 1);
		return "lab56/list";
	}

	@GetMapping("/list")
	public String getListPage(Model model, @RequestParam(required = false) GearTypes type) {

		model.addAttribute("gearType", GearTypes.values());
		model.addAttribute("findByType", true);
		List<Product> page;
		if (type == null) {
			page = _productSer.getAll();
		} else {
			page = _productSer.findByGearType(type);
		}
		model.addAttribute("type", type);
		model.addAttribute("gamingGears", page);

//		_productSer.setPageStat(model, 1, 1, false);
//		
		model.addAttribute("isPagging", false);
		model.addAttribute("curPage", 1);
		model.addAttribute("totalPage", 1);
		return "lab56/list";
	}

	@GetMapping("/pagination")
	public String getListPage(Model model, @RequestParam(defaultValue = "1") int curPage,
			@RequestParam(required = false) GearTypes type) {

		model.addAttribute("gearType", GearTypes.values());

		model.addAttribute("findByType", true);

		if (_productSer.getAll().isEmpty())
			return "redirect:/gaminggears";
		Page<Product> page;
		if (type != null) {
			if (curPage < 1)
				curPage = 1;
			page = _productSer.getByTypePages(curPage - 1, PAGE_SIZE, type);

			if (page.getTotalPages() < curPage)
				curPage = page.getTotalPages();
			if (curPage > 0)
				page = _productSer.getByTypePages(curPage - 1, PAGE_SIZE, type);
		} else {
			if (curPage < 1)
				curPage = 1;
			page = _productSer.getPages(curPage - 1, PAGE_SIZE);

			if (page.getTotalPages() < curPage)
				curPage = page.getTotalPages();
			if (curPage > 0)
				page = _productSer.getPages(curPage - 1, PAGE_SIZE);

		}

//			page = _productSer.getPages(page.getTotalPages() - 1, PAGE_SIZE);
//		_productSer.setPageStat(model, curPage, page.getTotalPages(), true);
		model.addAttribute("isPagging", true);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", page.getTotalPages());

		model.addAttribute("type", type);

		model.addAttribute("gamingGears", page.getContent());
		return "lab56/list";
	}

	@GetMapping("/{id}")
	public String showDetails(@PathVariable Long id, Model model) {
		Product gear = _productSer.getById(id);
		model.addAttribute("gear", gear);
		model.addAttribute("gearType", GearTypes.values());
		return "/lab56/details";
	}

	@GetMapping("/new")
	public String addNew(Model model) {
		model.addAttribute("gear", new Product());
		model.addAttribute("gearType", GearTypes.values());
		return "lab56/new";
	}

	@PostMapping("/insert")
	public String addNew(@ModelAttribute("gear") Product product, Model model) {
		Long id = _productSer.save(product);
		model.addAttribute("gear", product);
		System.out.println("Insert");
		return "redirect:/gaminggears/" + id;
	}

	@PutMapping("/update")
	public String update(@ModelAttribute("gear") Product product, Model model) {
		Long id = _productSer.save(product);
		model.addAttribute("gear", product);
		System.out.println("update");
		return "redirect:/gaminggears/" + id;
	}

	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable Long id) {
		_productSer.deleteById(id);
		return "redirect:/gaminggears/pagination";
	}

	@GetMapping("/delete")
	public String deleteMul(@RequestParam Long[] ids) {
		for (Long id : ids) {
			_productSer.deleteById(id);
		}
		return "redirect:/gaminggears/pagination";

	}

}
