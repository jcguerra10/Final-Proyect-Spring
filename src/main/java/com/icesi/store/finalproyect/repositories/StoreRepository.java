package com.icesi.store.finalproyect.repositories;

import com.icesi.store.finalproyect.model.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends CrudRepository <Store, Integer> {
}
