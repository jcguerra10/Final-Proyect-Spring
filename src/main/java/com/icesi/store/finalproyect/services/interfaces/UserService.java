package com.icesi.store.finalproyect.services.interfaces;

import java.util.Optional;

import com.icesi.store.finalproyect.model.product.UserApp;

public interface UserService {
	public void save(UserApp user);

	public Optional<UserApp> findById(int id);

	public Iterable<UserApp> findAll();
	
	public void delete(UserApp user);
}
