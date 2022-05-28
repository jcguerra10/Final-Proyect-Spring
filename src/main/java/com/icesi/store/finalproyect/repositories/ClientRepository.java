package com.icesi.store.finalproyect.repositories;

import com.icesi.store.finalproyect.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
}
