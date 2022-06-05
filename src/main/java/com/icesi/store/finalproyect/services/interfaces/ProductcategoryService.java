package com.icesi.store.finalproyect.services.interfaces;


import com.icesi.store.finalproyect.model.product.Product;
import com.icesi.store.finalproyect.model.product.Productcategory;

import java.util.Optional;

public interface ProductcategoryService {
    void saveProductcategory(Productcategory pc);
    void editProductcategory(Productcategory pc, Integer i);
    public Iterable<Productcategory> findAll();
    public Optional<Productcategory> findById(Integer id);
    public void delete(Productcategory product);
}
