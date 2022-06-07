package com.icesi.store.finalproyect.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.icesi.store.finalproyect.dao.interfaces.Dao;
import com.icesi.store.finalproyect.model.product.Productcategory;
import com.icesi.store.finalproyect.model.product.Productsubcategory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Repository
@Scope("singleton")
public class ProductsubcategoryDao implements Dao<Productsubcategory> {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Optional<Productsubcategory> get(Integer id) {
		return Optional.ofNullable(entityManager.find(Productsubcategory.class, id));
	}

	@Override
	public Optional<Productsubcategory> findById(Integer id) {
		return Optional.ofNullable(entityManager.find(Productsubcategory.class, id));
	}

	@Override
	public List<Productsubcategory> getAll() {
		Query query = entityManager.createQuery("SELECT a FROM Productsubcategory a");
		return query.getResultList();
	}

	@Override
	public Productcategory save(Productsubcategory aut) {
		entityManager.persist(aut);
        return null;
    }

	@Override
	public void update(Productsubcategory aut) {
		entityManager.merge(aut);
	}

	@Override
	public void deleteById(Integer autId) {
		Productsubcategory aut = get(autId).orElse(null);
		entityManager.remove(aut);
	}

}
