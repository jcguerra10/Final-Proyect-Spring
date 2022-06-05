package com.icesi.store.finalproyect.restcontroller;
import com.icesi.store.finalproyect.model.Client;
import com.icesi.store.finalproyect.services.implementation.ClientService;
import com.icesi.store.finalproyect.services.implementation.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientRestController {

    @Autowired
    private ClientService service;

    @Autowired
    private StoreService storeService;

    @GetMapping("/clientsRest/list")
    public Iterable<Client> showClientList() {

//		return productDAO.findAll();
        return service.findAll();
    }
    @GetMapping("/clientsRest/view/{id}")
    public Optional<Client> viewProduct(@PathVariable("id") Integer id) {

        return service.findById(id);
//		return productDAO.findById(id);
    }

    @PostMapping("/clientsRest/addclient/")
    public void addProduct(@RequestBody Client cli) {

        service.addClient(cli);
//        return productDAO.save(p);
    }

    @PutMapping("/clientsRest/edit/{id}")
    public void editProduct(@RequestBody Client cli) {

        service.updateClient(cli,cli.getId());
//		return productDAO.update(product);
    }

    @DeleteMapping("/clientsRest/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.removeClient(id);
//		productDAO.delete(productDAO.findById(id));
    }
}
