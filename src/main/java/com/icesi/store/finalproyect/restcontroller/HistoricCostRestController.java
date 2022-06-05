package com.icesi.store.finalproyect.restcontroller;


import com.icesi.store.finalproyect.dao.ProductDaoImp;
import com.icesi.store.finalproyect.dao.ProductcosthistoryDaoImp;
import com.icesi.store.finalproyect.model.product.Productcosthistory;
import com.icesi.store.finalproyect.services.implementation.ProductServiceImp;
import com.icesi.store.finalproyect.services.implementation.ProductcosthistoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HistoricCostRestController {

    @Autowired
    private ProductcosthistoryDaoImp daoProductCost;
    @Autowired
    private ProductcosthistoryServiceImp productcosthistoryServiceImp;

    @Autowired
    private ProductDaoImp daoProduct;
    @Autowired
    private ProductServiceImp productServiceImp;

    @GetMapping("/historiccostsRest/list")
    public Iterable<Productcosthistory> showProductList() {

//		return productDAO.findAll();
        return productcosthistoryServiceImp.findAll();
    }
    @GetMapping("/historiccostsRest/view/{id}")
    public Optional<Productcosthistory> viewProduct(@PathVariable("id") Integer id) {

        return productcosthistoryServiceImp.findById(id);
//		return productDAO.findById(id);
    }

    @PostMapping("/historiccostsRest/addproductcost/")
    public void addProduct(@RequestBody Productcosthistory product) {

        productcosthistoryServiceImp.saveProductcosthistory(product);
//        return productDAO.save(p);
    }

    @PutMapping("/historiccostsRest/edit/{id}")
    public void editProduct(@RequestBody Productcosthistory product) {

        productcosthistoryServiceImp.editProductcosthistory(product,product.getId());
//		return productDAO.update(product);
    }

    @DeleteMapping("/historiccostsRest/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        productcosthistoryServiceImp.delete( productcosthistoryServiceImp.findById(id).get());
//		productDAO.delete(productDAO.findById(id));
    }

}
