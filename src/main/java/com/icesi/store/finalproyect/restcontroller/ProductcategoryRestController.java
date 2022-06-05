package com.icesi.store.finalproyect.restcontroller;

import com.icesi.store.finalproyect.model.Client;
import com.icesi.store.finalproyect.model.product.Productcategory;
import com.icesi.store.finalproyect.services.interfaces.ProductcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductcategoryRestController {

    @Autowired
    ProductcategoryService productcategoryService;

    @GetMapping("/productcategoryRest/list")
    public Iterable<Productcategory> showProductcategoryList(){
        return productcategoryService.findAll();
    }

    @PostMapping("/productcategoryRest/addcategory/")
    public void addProduct(@RequestBody Productcategory cli) {
        productcategoryService.saveProductcategory(cli);
    }
}

