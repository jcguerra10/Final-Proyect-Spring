package com.icesi.store.finalproyect.services.interfaces;

import com.icesi.store.finalproyect.model.product.Product;

public interface ProductService {
    void saveProduct(Product pro);
    void editProduct(Product pro, Integer id);
}
