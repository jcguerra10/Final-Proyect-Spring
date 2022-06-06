package com.icesi.store.finalproyect.restcontroller;

import com.icesi.store.finalproyect.model.product.Productcategory;
import com.icesi.store.finalproyect.model.product.Productsubcategory;
import com.icesi.store.finalproyect.services.interfaces.ProductsubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductsubcategoryRestController {

    @Autowired
    ProductsubcategoryService productsubcategoryService;

    @GetMapping("/productsubcategoryRest/list")
    public Iterable<Productsubcategory> showProductsubcategoryList(){
        return productsubcategoryService.findAll();
    }
    @PostMapping("/productsubcategoryRest/addsubcategory/")
    public void addProduct(@RequestBody Productsubcategory cli) {
        System.out.println("-----"+cli);
        productsubcategoryService.saveProductsubcategory(cli);
    }
}
