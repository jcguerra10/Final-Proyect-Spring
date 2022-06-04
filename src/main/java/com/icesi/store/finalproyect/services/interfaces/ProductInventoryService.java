package com.icesi.store.finalproyect.services.interfaces;

import com.icesi.store.finalproyect.model.product.Productinventory;

public interface ProductInventoryService {
    void saveProductInventory(Productinventory proInventory);
	void editProductInventory(Productinventory proInventory, Integer id);
}
