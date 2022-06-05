package com.icesi.store.finalproyect.controllers;

import com.icesi.store.finalproyect.model.Client;
import com.icesi.store.finalproyect.model.Store;
import com.icesi.store.finalproyect.services.implementation.ClientService;
import com.icesi.store.finalproyect.services.implementation.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import com.icesi.store.finalproyect.businessdelegate.BusinessDelegate;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    BusinessDelegate delegate;


    @GetMapping()
    public String showClients(Model model) {
        model.addAttribute("clients", delegate.showClients());
        return "/client/index";
    }

    @GetMapping("/add")
    public String addClient(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("stores", delegate.showStores());
        return "/client/add";
    }

    @PostMapping("/add")
    public String addClientPost(@Valid @ModelAttribute Client client, BindingResult bindingResult, Model model,
                                @RequestParam(value = "action", required = true) String action) {
        String ret = "redirect:/client";
        if (!action.equals("Cancel")) {
            if (!bindingResult.hasErrors()) {
                delegate.addClient(client);
            } else {
                ret = "/client/add";
            }
        }
        return ret;
    }

    @GetMapping("/edit/{id}")
    public String editClientScreen(@PathVariable("id") Integer id, Model model) {
        Client findClient = delegate.getClient(id);
        model.addAttribute("client", findClient);
        model.addAttribute("stores", delegate.showStores());
        return "/client/edit";
    }
    @PostMapping("/edit/{id}")
    public String editStore(@Valid @ModelAttribute Client client, BindingResult bindingResult, Model model,
                            @PathVariable("id") Integer id, @RequestParam(value = "action", required = true) String action) {

        String dir = "redirect:/client";

        if (!action.equals("Cancel")) {
            if (!bindingResult.hasErrors()) {
                delegate.editClient(id, client);
                model.addAttribute("clients", delegate.showClients());
            } else {
                model.addAttribute("client", client);
                model.addAttribute("stores", delegate.showStores());
                dir = "/client/edit";
            }
        }
        return dir;
    }
}
