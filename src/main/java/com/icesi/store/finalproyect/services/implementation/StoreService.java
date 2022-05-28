package com.icesi.store.finalproyect.services.implementation;

import com.icesi.store.finalproyect.model.Store;
import com.icesi.store.finalproyect.repositories.StoreRepository;
import com.icesi.store.finalproyect.services.interfaces.StoreServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StoreService implements StoreServiceI {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    @Transactional
    public Store addStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    @Transactional
    public Store updateStore(Store store, Integer idToUpdate) {
        Store toUpdate = storeRepository.findById(idToUpdate).get();
        toUpdate.setName(store.getName());
        return storeRepository.save(toUpdate);
    }

    @Override
    @Transactional
    public void removeStore(Integer idToRemove) {
        Store toRemove = storeRepository.findById(idToRemove).get();
        storeRepository.delete(toRemove);
    }

    @Override
    public Iterable<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public Optional<Store> findById(Integer id) {
        return storeRepository.findById(id);
    }
}
