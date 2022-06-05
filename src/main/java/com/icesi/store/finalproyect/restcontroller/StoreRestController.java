package com.icesi.store.finalproyect.restcontroller;

import com.icesi.store.finalproyect.model.Client;
import com.icesi.store.finalproyect.model.Store;
import com.icesi.store.finalproyect.services.implementation.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StoreRestController {
    @Autowired
    private StoreService service;
    @GetMapping("/storesRest/list")
    public Iterable<Store> showClientList() {

//		return productDAO.findAll();
        return service.findAll();
    }
    @GetMapping("/storesRest/view/{id}")
    public Optional<Store> viewProduct(@PathVariable("id") Integer id) {

        return service.findById(id);
//		return productDAO.findById(id);
    }

    @PostMapping("/storesRest/addstore/")
    public void addProduct(@RequestBody Store cli) {

        service.addStore(cli);
//        return productDAO.save(p);
    }

    @PutMapping("/storesRest/edit/{id}")
    public void editProduct(@RequestBody Store cli) {

        service.updateStore(cli,cli.getId());
//		return productDAO.update(product);
    }

    @DeleteMapping("/storesRest/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.removeStore(id);
//		productDAO.delete(productDAO.findById(id));
    }
}
