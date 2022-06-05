package com.icesi.store.finalproyect.controllers;


import com.icesi.store.finalproyect.businessdelegate.BusinessDelegate;
import com.icesi.store.finalproyect.dao.LocationDao;
import com.icesi.store.finalproyect.dao.ProductDaoImp;
import com.icesi.store.finalproyect.dao.ProductinventoryDaoImp;
import com.icesi.store.finalproyect.model.product.Productinventory;
import com.icesi.store.finalproyect.services.implementation.LocationServiceImp;
import com.icesi.store.finalproyect.services.implementation.ProductInventoryServiceImp;
import com.icesi.store.finalproyect.services.implementation.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/inventoryproduct")
public class InventoryController {

	@Autowired
	BusinessDelegate delegate;

	@GetMapping("")
	public String products(Model model) {
		model.addAttribute("productsinventory", delegate.showProductInventorytList());

		delegate.showProductInventorytList().forEach(pi ->
		
		System.out.println("---" +pi.getLocation() == null)
		);

		return "/inventoryproduct/index";
	}

	@GetMapping("/add/")
	public String addInventoryScreen(Model model) {
		model.addAttribute("productinventory", new Productinventory());
		model.addAttribute("products", delegate.showProductList());
		model.addAttribute("locations", delegate.showLocations());
		return "/inventoryproduct/add";
	}

	@PostMapping("/add/")
	public String addInventory(@Valid @ModelAttribute Productinventory productInventory, BindingResult bindingResult,
			Model model, @RequestParam(value = "action", required = true) String action, Integer quantity) {
		String ret = "redirect:/inventoryproduct/";
		
		if (!action.equals("Cancel")) {
			if (!bindingResult.hasErrors()) {
				System.out.println(productInventory.getProduct().getName());
				delegate.addProductInventory(productInventory);
			} else {
				ret = "/inventoryproduct/add";				
			}
		}
		return ret;
	}

	@GetMapping("/edit/{id}")
	public String editInventoryScreen(@Valid @ModelAttribute Productinventory productInventory,
			BindingResult bindingresult, @PathVariable("id") Integer id, Model model) {

		Productinventory pInventory = delegate.getProductInventory(id);

		model.addAttribute("inventoryproduct", pInventory);
		model.addAttribute("products", delegate.showProductList());
		model.addAttribute("locations", delegate.showLocations());
		return "/inventoryproduct/edit";
	}

	@PostMapping("/edit/{id}")
	public String editInventory(@Valid @ModelAttribute Productinventory productInventory, BindingResult bindingResult,
			Model model, @PathVariable("id") Integer id, @RequestParam(value = "action", required = true) String action) {
		String dir = "redirect:/inventoryproduct/";

		if (!action.equals("Cancel")) {
			if (!bindingResult.hasErrors()) {
				delegate.editProductInventory(id,productInventory);
            } else {
				dir = "/inventoryproduct/add";
			}
		}
		return dir;
	}

}
