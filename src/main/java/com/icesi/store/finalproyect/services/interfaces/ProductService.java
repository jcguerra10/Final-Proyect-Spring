package com.icesi.store.finalproyect.services.interfaces;

import com.icesi.store.finalproyect.model.product.Product;
import java.util.Optional;

public interface ProductService {
    void saveProduct(Product pro);
    void editProduct(Product pro, Integer id);
    public Iterable<Product> findAll();

    public Optional<Product> findById(Integer id);
    public void delete(Product product);
}
