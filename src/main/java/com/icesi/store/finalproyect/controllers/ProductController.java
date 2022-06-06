package com.icesi.store.finalproyect.controllers;

import com.icesi.store.finalproyect.businessdelegate.BusinessDelegate;
import com.icesi.store.finalproyect.businessdelegate.BusinessDelegateImpl;
import com.icesi.store.finalproyect.model.product.Product;
import com.icesi.store.finalproyect.model.product.Productcategory;
import com.icesi.store.finalproyect.model.product.Productsubcategory;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Optional;

@Controller
@RequestMapping("/products")
@Log4j2
public class ProductController {

	@Autowired
	BusinessDelegateImpl delegate;

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("products", delegate.showProductList());
		return "/products/index";
	}

	@GetMapping("/add/")
	public String productAddScreen(Model model) {
		model.addAttribute(new Product());
		model.addAttribute("subcategories", delegate.showProductsubcategoryList());
		return "/products/add";
	}

	@PostMapping("/add/")
	public String productAdd(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model,
			@RequestParam(value = "action", required = true) String action, String startdate, String enddate) {

		String ret = "redirect:/products/";

		if (!action.equals("Cancel")) {
			if (!bindingResult.hasErrors()) {

				delegate.addProduct(product);

			} else {
				ret = "/products/add";
			}
		}
		return ret;
	}

	private Timestamp Convert(String date) {
		String res = "";
		String[] splt = null;

		if (!date.isEmpty() || !date.isBlank()) {
			splt = date.split("T");

			res += splt[0];

			res += " " + splt[1] + ":00";
		}
		return Timestamp.valueOf(res);
	}

	// ----------------- CATEGORIES -----------------

	@GetMapping("/createcategories/")
	public String createCategoriesScreen(Model model) {

		return "/products/createcategories";
	}

	@PostMapping("/createcategories/")
	public String createCategories(Model model, String category, String subcategory) {

		Productcategory pc = new Productcategory();
		pc.setName(category);

		Productsubcategory psc = new Productsubcategory();
		psc.setName(subcategory);

		psc.setProductcategory(pc);

		System.out.println(pc);
		System.out.println(psc);

		delegate.addProductcategory(pc);
		delegate.addProductsubcategory(psc);

		return "redirect:/products/add/";
	}

	// ----------------- EDIT -----------------

	@GetMapping("/edit/{id}")
	public String editProductScreen(@PathVariable("id") Integer id, Model model) {
		Product find = delegate.getProduct(id);
		model.addAttribute("product", find);
		model.addAttribute("productcategories", delegate.showProductcategoryList());
		model.addAttribute("productsubcategories", delegate.showProductsubcategoryList());

		return "/products/edit";
	}

	@PostMapping("/edit/{id}")
	public String editProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model,
			@PathVariable("id") Integer id, @RequestParam(value = "action", required = true) String action, String startdate, String enddate) {
		
		String dir = "redirect:/products/";

		if (!action.equals("Cancel")) {
			if (!bindingResult.hasErrors()) {

				delegate.editProduct(product, id);
				model.addAttribute("products", delegate.showProductList());
			} else {
				model.addAttribute("product", product);
				dir = "products/edit";
			}
		}
		return dir;
	}

}
