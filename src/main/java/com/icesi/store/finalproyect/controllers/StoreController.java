package com.icesi.store.finalproyect.controllers;

import com.icesi.store.finalproyect.businessdelegate.BusinessDelegate;
import com.icesi.store.finalproyect.model.Store;
import com.icesi.store.finalproyect.services.implementation.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    BusinessDelegate delegate;

    @GetMapping()
    public String showStore(Model model) {
        model.addAttribute("stores", delegate.showStores());
        return "/store/index";
    }

    @GetMapping("/add")
    public String addStore(Model model) {
        model.addAttribute("store", new Store());
        return "/store/add";
    }

    @PostMapping("/add")
    public String addStorePost(@Valid @ModelAttribute Store store, BindingResult bindingResult, Model model,
                               @RequestParam(value = "action", required = true) String action) {
        String ret = "redirect:/store";

        if (!action.equals("Cancel")) {
            if (!bindingResult.hasErrors()) {
                delegate.addStore(store);
            } else {
                ret = "/store/add";
            }
        }

        return ret;
    }

    @GetMapping("/edit/{id}")
    public String editStoreScreen(@PathVariable("id") Integer id, Model model) {
        Store findStore = delegate.getStore(id);
        model.addAttribute("store", findStore);
        return "/store/edit";
    }
    @PostMapping("/edit/{id}")
    public String editStore(@Valid @ModelAttribute Store store, BindingResult bindingResult, Model model,
                               @PathVariable("id") Integer id, @RequestParam(value = "action", required = true) String action) {

        String dir = "redirect:/store";

        if (!action.equals("Cancel")) {
            if (!bindingResult.hasErrors()) {
                delegate.editStore(id,store);
                model.addAttribute("stores", delegate.showStores());
            } else {
                model.addAttribute("store", store);
                dir = "/store/edit";
            }
        }
        return dir;
    }

}
