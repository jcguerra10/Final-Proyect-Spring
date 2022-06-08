package com.icesi.store.finalproyect.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.icesi.store.finalproyect.dao.interfaces.Dao;
import com.icesi.store.finalproyect.model.product.Location;
import com.icesi.store.finalproyect.model.product.Product;
import com.icesi.store.finalproyect.model.product.Productcategory;
import com.icesi.store.finalproyect.model.product.Productinventory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("singleton")
public class ProductinventoryDaoImp implements Dao<Productinventory> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Optional<Productinventory> get(Integer id) {
		return Optional.ofNullable(entityManager.find(Productinventory.class, id));
	}

	@Override
	public Optional<Productinventory> findById(Integer id) {
		return Optional.ofNullable(entityManager.find(Productinventory.class, id));
	}

	@Override
	public List<Productinventory> getAll() {
		Query query = entityManager.createQuery("SELECT a FROM Productinventory a");
		return query.getResultList();
	}

	@Override
	public Productcategory save(Productinventory aut) {
		Product psc = Optional.ofNullable(entityManager.find(Product.class, aut.getProductinvid2())).get();
		aut.setProduct(psc);
		Location loc = Optional.ofNullable(entityManager.find(Location.class, aut.getLocationinvid2())).get();
		aut.setLocation(loc);
		executeInsideTransaction(entityManager -> entityManager.persist(aut));
        return null;
    }

	@Override
	public void update(Productinventory aut) {
		Product psc = Optional.ofNullable(entityManager.find(Product.class, aut.getProductinvid2())).get();
		aut.setProduct(psc);
		Location loc = Optional.ofNullable(entityManager.find(Location.class, aut.getLocationinvid2())).get();
		aut.setLocation(loc);
		executeInsideTransaction(entityManager -> entityManager.merge(aut));
	}

	@Override
	public void deleteById(Integer autId) {
		Productinventory aut = get(autId).orElse(null);
		executeInsideTransaction(entityManager -> entityManager.remove(aut));
	}

	private void executeInsideTransaction(Consumer<EntityManager> action) {
		try {
			action.accept(entityManager);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public List<Product> findAllByProductId(Integer prdId) {
		Query query = entityManager.createQuery("SELECT a FROM Productinventory a WHERE a.product.productid = :prdId");
		query.setParameter("prdId", prdId);
		return query.getResultList();
	}

	public List<Product> findAllBySize(Integer lctId) {
		Query query = entityManager.createQuery("SELECT a FROM Productinventory a WHERE a.location.locationid = :lctId");
		query.setParameter("lctId", lctId);
		return query.getResultList();
	}

}
