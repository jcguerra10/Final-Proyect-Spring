package com.icesi.store.finalproyect.restcontroller;

import com.icesi.store.finalproyect.dao.LocationDao;
import com.icesi.store.finalproyect.dao.ProductDaoImp;
import com.icesi.store.finalproyect.dao.ProductinventoryDaoImp;
import com.icesi.store.finalproyect.model.product.Productinventory;
import com.icesi.store.finalproyect.services.implementation.LocationServiceImp;
import com.icesi.store.finalproyect.services.implementation.ProductInventoryServiceImp;
import com.icesi.store.finalproyect.services.implementation.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class InventoryRestController {
    @Autowired
    private ProductinventoryDaoImp daoProductInventory;
    @Autowired
    private ProductInventoryServiceImp productInventoryServiceImp;

    @Autowired
    private LocationDao daoLocation;
    @Autowired
    private LocationServiceImp locationServiceImp;

    @Autowired
    private ProductDaoImp daoProduct;
    @Autowired
    private ProductServiceImp productServiceImp;


    @GetMapping("/inventoryproductRest/list")
    public Iterable<Productinventory> showProductInventoryList() {

//		return productDAO.findAll();
        return productInventoryServiceImp.findAll();
    }

    @GetMapping("/inventoryproductRest/view/{id}")
    public Optional<Productinventory> viewProduct(@PathVariable("id") Integer id) {

        return productInventoryServiceImp.findById(id);
//		return productDAO.findById(id);
    }

    @PostMapping("/inventoryproductRest/addproductinventory/")
    public void addProduct(@RequestBody Productinventory product) {

        productInventoryServiceImp.saveProductInventory(product);
//        return productDAO.save(p);
    }

    @PutMapping("/inventoryproductRest/edit/{id}")
    public void editProduct(@RequestBody Productinventory product) {

        productInventoryServiceImp.editProductInventory(product,product.getId());
//		return productDAO.update(product);
    }

    @DeleteMapping("/inventoryproductRest/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        productInventoryServiceImp.delete(productInventoryServiceImp.findById(id).get());
//		productDAO.delete(productDAO.findById(id));
    }
}
