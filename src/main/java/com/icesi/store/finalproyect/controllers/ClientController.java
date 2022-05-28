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

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @Autowired
    private StoreService storeService;

    @GetMapping()
    public String showClients(Model model) {
        model.addAttribute("clients", service.findAll());
        return "/client/index";
    }

    @GetMapping("/add")
    public String addClient(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("stores", storeService.findAll());
        return "/client/add";
    }

    @PostMapping("/add")
    public String addClientPost(@Valid @ModelAttribute Client client, BindingResult bindingResult, Model model,
                                @RequestParam(value = "action", required = true) String action) {
        String ret = "redirect:/client";
        if (!action.equals("Cancel")) {
            if (!bindingResult.hasErrors()) {
                service.addClient(client);
            } else {
                ret = "/client/add";
            }
        }
        return ret;
    }

    @GetMapping("/edit/{id}")
    public String editClientScreen(@PathVariable("id") Integer id, Model model) {
        Optional<Client> findClient = service.findById(id);
        if (findClient.isEmpty())
            throw new IllegalArgumentException("Invalid Client Id:" + id);
        model.addAttribute("client", findClient.get());
        model.addAttribute("stores", storeService.findAll());
        return "/client/edit";
    }
    @PostMapping("/edit/{id}")
    public String editStore(@Valid @ModelAttribute Client client, BindingResult bindingResult, Model model,
                            @PathVariable("id") Integer id, @RequestParam(value = "action", required = true) String action) {

        String dir = "redirect:/client";

        if (!action.equals("Cancel")) {
            if (!bindingResult.hasErrors()) {
                service.updateClient(client, id);
                model.addAttribute("clients", service.findAll());
            } else {
                model.addAttribute("client", client);
                model.addAttribute("stores", storeService.findAll());
                dir = "/client/edit";
            }
        }
        return dir;
    }
}
