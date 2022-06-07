package com.icesi.store.finalproyect.services.interfaces;

import com.icesi.store.finalproyect.model.product.Product;
import com.icesi.store.finalproyect.model.product.Productsubcategory;

import java.util.Optional;

public interface ProductsubcategoryService {
    void saveProductsubcategory(Productsubcategory ps);
    void editProductsubcategory(Productsubcategory ps, Integer i);
    public Iterable<Productsubcategory> findAll();
    public Optional<Productsubcategory> findById(Integer id);
    public void delete(Productsubcategory product);
}
