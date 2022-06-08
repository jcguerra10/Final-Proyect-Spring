package com.icesi.store.finalproyect.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.icesi.store.finalproyect.dao.interfaces.Dao;
import com.icesi.store.finalproyect.model.product.Product;
import com.icesi.store.finalproyect.model.product.Productcategory;
import com.icesi.store.finalproyect.model.product.Productsubcategory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("singleton")
public class ProductDaoImp implements Dao<Product> {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Optional<Product> get(Integer id) {
		return Optional.ofNullable(entityManager.find(Product.class, id));
	}
	
	@Override
	public Optional<Product> findById(Integer id) {
		return Optional.ofNullable(entityManager.find(Product.class, id));
	}

	@Override
	public List<Product> getAll() {
		Query query = entityManager.createQuery("SELECT a FROM Product a");
		return query.getResultList();
	}

	@Override
	@Transactional
	public Productcategory save(Product aut) {
		Productsubcategory psc = Optional.ofNullable(entityManager.find(Productsubcategory.class, aut.getProductsubcategoryid2())).get();
		aut.setProductsubcategory(psc);
		entityManager.persist(aut);
        return null;
    }

	@Override
	@Transactional
	public void update(Product aut) {
		entityManager.merge(aut);
	}

	@Override
	@Transactional
	public void deleteById(Integer autId) {
		Product aut = get(autId).orElse(null);
		entityManager.remove(aut);
	}

	public List<Product> findAllBySubcategoryId(Integer subcategoryId) {
		
		Query query = entityManager.createQuery("SELECT a FROM Product a WHERE a.productsubcategory.productsubcategoryid = :subcategoryId").setParameter("subcategoryId", subcategoryId);
		return query.getResultList();
	}
	
	/*
	public List<Product> findAllByProductmodelid(Integer pmId) {
		Query query = entityManager.createQuery("SELECT a FROM Product a WHERE a.productmodel.productmodelid = :pmId");
		query.setParameter("pmId", pmId);
		return query.getResultList();
	}
	*/
	
	public List<Product> findAllBySize(BigDecimal productSize) {
		Query query = entityManager.createQuery("SELECT a FROM Product a WHERE a.size = :productSize").setParameter("productSize", productSize);
		return query.getResultList();
	}
	
	public List<?> specialQuery1(LocalDate from, LocalDate to) {
		return entityManager.createQuery("SELECT p FROM Product p, Location l, Productinventory pi, Productcosthistory pch "
				+ "WHERE p.productid = pi.product.productid AND pi.location.locationid = l.locationid AND pi.product.productid = p.productid AND pch.product.productid = p.productid "
				+ "AND pch.startdate BETWEEN :from AND :to "
				+ "AND pch.enddate BETWEEN :from AND :to "
				+ "AND pi.quantity > 0 "
				+ "GROUP BY p.productid").setParameter("from", from).setParameter("to", to).getResultList();
	}

	public List<?> specialQuery2() {
		return entityManager.createQuery("SELECT e FROM Product e "
				+ "WHERE e.productcosthistories.size >= 2").getResultList();
	}

	public List<?> specialQuery(Integer subcategory) {
		return entityManager.createQuery("SELECT e FROM Product e, Location l, Productinventory pi " +
				"WHERE pi.product.productsubcategory.productsubcategoryid = :sid " +
				"AND pi.product.productid = e.productid AND pi.location.locationid = l.locationid " +
				"ORDER BY l.locationid").setParameter("sid", subcategory).getResultList();
	}
	
}