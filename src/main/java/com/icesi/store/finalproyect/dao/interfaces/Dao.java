package com.icesi.store.finalproyect.dao.interfaces;

import java.util.List;
import java.util.Optional;

import com.icesi.store.finalproyect.model.product.Productcategory;
import org.springframework.transaction.annotation.Transactional;

public interface Dao<T> {

	Optional<T> get(Integer id);

	Optional<T> findById(Integer id);
	
	List<T> getAll();

	@Transactional
    Productcategory save(T aut);

	@Transactional
	void update(T aut);

	@Transactional
	void deleteById(Integer autId);

}
