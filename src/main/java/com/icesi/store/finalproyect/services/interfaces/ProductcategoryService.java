package com.icesi.store.finalproyect.services.interfaces;


import com.icesi.store.finalproyect.model.product.Productcategory;

public interface ProductcategoryService {
    void saveProductcategory(Productcategory pc);
    void editProductcategory(Productcategory pc, Integer i);
}
