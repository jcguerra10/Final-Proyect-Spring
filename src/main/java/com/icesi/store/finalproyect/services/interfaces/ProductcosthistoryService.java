package com.icesi.store.finalproyect.services.interfaces;

import com.icesi.store.finalproyect.model.product.Product;
import com.icesi.store.finalproyect.model.product.Productcosthistory;

import java.util.Optional;

public interface ProductcosthistoryService {
    void saveProductcosthistory(Productcosthistory pch);
    void editProductcosthistory(Productcosthistory pch, Integer id);
    public Iterable<Productcosthistory> findAll();
    public Optional<Productcosthistory> findById(Integer id);
    public void delete(Productcosthistory product);
}
