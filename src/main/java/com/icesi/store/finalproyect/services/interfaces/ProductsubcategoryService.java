package com.icesi.store.finalproyect.services.interfaces;

import com.icesi.store.finalproyect.model.product.Productsubcategory;

public interface ProductsubcategoryService {
    void saveProductsubcategory(Productsubcategory ps);
    void editProductsubcategory(Productsubcategory ps, Integer i);
}
