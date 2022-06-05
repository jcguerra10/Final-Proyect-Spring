package com.icesi.store.finalproyect.restcontroller;

import com.icesi.store.finalproyect.dao.LocationDao;
import com.icesi.store.finalproyect.model.product.Location;
import com.icesi.store.finalproyect.services.implementation.LocationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class LocationRestController {
    @Autowired
    private LocationDao daoLocation;
    @Autowired
    private LocationServiceImp locationServiceImp;

    @GetMapping("/locationsRest/")
    public String locationScreen(Model model) {
        model.addAttribute("locations", daoLocation.getAll());

        return "/locations/index";
    }
    @GetMapping("/locationsRest/list")
    public Iterable<Location> showProductList() {
        //log.info("SHOW PRODUCT LIST");
        return locationServiceImp.findAll();
    }

    @GetMapping("/locationsRest/view/{id}")
    public Optional<Location> viewProduct(@PathVariable("id") Integer id) {

        return locationServiceImp.findById(id);
    }

    @PostMapping("/locationsRest/addlocation/")
    public void addProduct(@RequestBody Location loc) {
        //log.info("entro!");
        locationServiceImp.saveLocation(loc);
    }

    @PutMapping("/locationsRest/edit/{id}")
    public void editProduct(@RequestBody Location loc) {
        locationServiceImp.editLocation(loc, loc.getLocationid());
    }

    @DeleteMapping("/locationsRest/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        locationServiceImp.delete(locationServiceImp.findById(id).get());
    }

}
