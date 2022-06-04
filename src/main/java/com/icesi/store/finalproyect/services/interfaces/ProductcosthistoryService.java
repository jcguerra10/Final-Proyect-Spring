package com.icesi.store.finalproyect.services.interfaces;

import com.icesi.store.finalproyect.model.product.Productcosthistory;

public interface ProductcosthistoryService {
    void saveProductcosthistory(Productcosthistory pch);
    void editProductcosthistory(Productcosthistory pch, Integer id);
}
