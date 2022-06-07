package com.icesi.store.finalproyect.repositories;

import com.icesi.store.finalproyect.model.product.UserApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserApp, Long> {

	UserApp findByUsername(String username);

}
