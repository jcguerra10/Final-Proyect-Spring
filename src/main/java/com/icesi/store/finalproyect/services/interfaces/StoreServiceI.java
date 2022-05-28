package com.icesi.store.finalproyect.services.interfaces;

import com.icesi.store.finalproyect.model.Store;

import java.util.Optional;

public interface StoreServiceI {
    public Store addStore(Store store);
    public Store updateStore(Store store, Integer idToUpdate);
    public void removeStore(Integer idToRemove);

    Iterable<Store> findAll();

    Optional<Store> findById(Integer id);
}
