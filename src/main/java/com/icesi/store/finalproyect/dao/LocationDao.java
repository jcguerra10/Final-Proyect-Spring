package com.icesi.store.finalproyect.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.icesi.store.finalproyect.dao.interfaces.Dao;
import com.icesi.store.finalproyect.model.product.Location;
import com.icesi.store.finalproyect.model.product.Productcategory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Repository
@Scope("singleton")
public class LocationDao implements Dao<Location> {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Optional<Location> get(Integer id) {
		return Optional.ofNullable(entityManager.find(Location.class, id));
	}

	@Override
	public Optional<Location> findById(Integer id) {
		return Optional.ofNullable(entityManager.find(Location.class, id));
	}

	@Override
	public List<Location> getAll() {
		Query query = entityManager.createQuery("SELECT a FROM Location a");
		return query.getResultList();
	}

	@Override
	public Productcategory save(Location aut) {
		entityManager.persist(aut);
        return null;
    }

	@Override
	public void update(Location aut) {
		entityManager.merge(aut);
	}

	@Override
	public void deleteById(Integer autId) {
		Location aut = get(autId).orElse(null);
		entityManager.remove(aut);
	}

}
