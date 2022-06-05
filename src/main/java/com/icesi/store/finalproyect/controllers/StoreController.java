package com.icesi.store.finalproyect.controllers;

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
    private StoreService service;

    @GetMapping()
    public String showStore(Model model) {
        model.addAttribute("stores", service.findAll());
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
                service.addStore(store);
            } else {
                ret = "/store/add";
            }
        }

        return ret;
    }

    @GetMapping("/edit/{id}")
    public String editStoreScreen(@PathVariable("id") Integer id, Model model) {
        Optional<Store> findStore = service.findById(id);
        if (findStore.isEmpty())
            throw new IllegalArgumentException("Invalid Store Id:" + id);
        model.addAttribute("store", findStore.get());
        return "/store/edit";
    }
    @PostMapping("/edit/{id}")
    public String editStore(@Valid @ModelAttribute Store store, BindingResult bindingResult, Model model,
                               @PathVariable("id") Integer id, @RequestParam(value = "action", required = true) String action) {

        String dir = "redirect:/store";

        if (!action.equals("Cancel")) {
            if (!bindingResult.hasErrors()) {
                service.updateStore(store, id);
                model.addAttribute("stores", service.findAll());
            } else {
                model.addAttribute("store", store);
                dir = "/store/edit";
            }
        }
        return dir;
    }

    @GetMapping("/remove/{id}")
    public String removeStore(@PathVariable("id") Integer id, Model model) {
        service.removeStore(id);
        return "redirect:/store";
    }

}
