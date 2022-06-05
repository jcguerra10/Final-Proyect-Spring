package com.icesi.store.finalproyect.services.interfaces;

import com.icesi.store.finalproyect.model.product.Product;
import com.icesi.store.finalproyect.model.product.Productinventory;

import java.util.Optional;

public interface ProductInventoryService {
    void saveProductInventory(Productinventory proInventory);
	void editProductInventory(Productinventory proInventory, Integer id);
    public Iterable<Productinventory> findAll();
    public Optional<Productinventory> findById(Integer id);
    public void delete(Productinventory product);
}
