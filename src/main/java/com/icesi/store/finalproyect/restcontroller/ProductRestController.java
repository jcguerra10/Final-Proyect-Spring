package com.icesi.store.finalproyect.restcontroller;


import com.icesi.store.finalproyect.dao.ProductDaoImp;
import com.icesi.store.finalproyect.model.product.Product;
import com.icesi.store.finalproyect.services.implementation.ProductServiceImp;
import com.icesi.store.finalproyect.services.interfaces.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

//@Log4j2
@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    ProductDaoImp daoProduct;
    @Autowired
    ProductService productService;

    @GetMapping("/productsRest/list")
    public Iterable<Product> showProductList() {
        //log.info("SHOW PRODUCT LIST");
        return productService.findAll();
    }

    @GetMapping("/productsRest/view/{id}")
    public Optional<Product> viewProduct(@PathVariable("id") Integer id) {

        return productService.findById(id);
    }

    @PostMapping("/productsRest/addproduct/")
    public void addProduct(@RequestBody Product product) {
        //log.info("entro!");
        productService.saveProduct(product);
    }

    @PutMapping("/productsRest/edit/{id}")
    public void editProduct(@RequestBody Product product) {
        productService.editProduct(product, product.getProductsubcategory().getProductcategory().getProductcategoryid());
    }

    @DeleteMapping("/productsRest/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        productService.delete(productService.findById(id).get());
    }

}

