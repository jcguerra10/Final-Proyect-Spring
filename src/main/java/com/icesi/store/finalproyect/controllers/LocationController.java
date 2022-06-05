package com.icesi.store.finalproyect.controllers;

import com.icesi.store.finalproyect.businessdelegate.BusinessDelegate;
import com.icesi.store.finalproyect.dao.LocationDao;
import com.icesi.store.finalproyect.model.product.Location;
import com.icesi.store.finalproyect.services.implementation.LocationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	BusinessDelegate delegate;

	@GetMapping("")
	public String locationScreen(Model model) {
		model.addAttribute("locations", delegate.showLocations());

		return "/locations/index";
	}

	@GetMapping("/locations/add/")
	public String locationAddScreen(Model model) {
		model.addAttribute(new Location());
		return "/locations/add";
	}

	@PostMapping("/locations/add")
	private String locationAdd(@Valid @ModelAttribute Location location, BindingResult bindingResult, Model model,
			@RequestParam(value = "action", required = true) String action) {

		String ret = "redirect:/locations/";

		if (!action.equals("Cancel")) {
			if (!bindingResult.hasErrors()) {
				delegate.addLocation(location);
			} else {
				ret = "/locations/add";
			}
		}

		return ret;
	}
	
	@GetMapping("/locations/edit/{id}")
	public String editLocationScreen(@PathVariable("id") Integer id, Model model) {
		Location find = delegate.getLocation(id);

		model.addAttribute("location", find);
		return "locations/edit";
	}
	@PostMapping("/locations/edit/{id}")
	public String editLocation(@Valid @ModelAttribute Location location, BindingResult bindingResult, Model model,
			@PathVariable("id") Integer id, @RequestParam(value = "action", required = true) String action) {
		
		String dir = "redirect:/locations/";

		if (!action.equals("Cancel")) {
			if (!bindingResult.hasErrors()) {			
				delegate.editLocation(id,location);
				model.addAttribute("locations", delegate.showLocations());
			} else {
				model.addAttribute("location", location);
				dir = "locations/edit";
			}
		}
		return dir;
	}

}
