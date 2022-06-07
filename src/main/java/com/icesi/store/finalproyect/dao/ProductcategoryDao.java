package com.icesi.store.finalproyect.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.icesi.store.finalproyect.dao.interfaces.Dao;
import com.icesi.store.finalproyect.model.product.Productcategory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Scope("singleton")
public class ProductcategoryDao implements Dao<Productcategory> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Productcategory> get(Integer id) {
        return Optional.ofNullable(entityManager.find(Productcategory.class, id));
    }

    @Override
    public Optional<Productcategory> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Productcategory.class, id));
    }

    @Override
    public List<Productcategory> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM Productcategory a");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Productcategory save(Productcategory aut) {
        entityManager.persist(aut);
        return aut;
    }

    @Override
    @Transactional
    public void update(Productcategory aut) {
        entityManager.merge(aut);
    }

    @Override
    @Transactional
    public void deleteById(Integer autId) {
        Productcategory aut = get(autId).orElse(null);
        entityManager.remove(aut);
    }

}
