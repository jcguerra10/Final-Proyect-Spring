package com.icesi.store.finalproyect.services.implementation;

import java.util.Optional;

import com.icesi.store.finalproyect.dao.ProductcategoryDao;
import com.icesi.store.finalproyect.dao.ProductsubcategoryDao;
import com.icesi.store.finalproyect.model.product.Productcategory;
import com.icesi.store.finalproyect.model.product.Productsubcategory;
import com.icesi.store.finalproyect.services.interfaces.ProductsubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductsubcategoryImp implements ProductsubcategoryService {
@Autowired
private ProductsubcategoryDao dao;

@Autowired
private ProductcategoryDao daoCategory;

	@Transactional
	@Override
	public void saveProductsubcategory(Productsubcategory pc, int i) {
		if(pc == null)
			throw new NullPointerException("Null Object");

		Productcategory pca = daoCategory.findById(i).get();
		pc.setProductcategory(pca);
		dao.save(pc);
	}

	@Transactional
	@Override
	public void editProductsubcategory(Productsubcategory pc, Integer i) {
		Optional<Productsubcategory> op = dao.findById(i);
		Productsubcategory opLoc = op.get();
		if(pc == null)
			throw new NullPointerException("Null Object");
		opLoc.setName(pc.getName());
		dao.update(opLoc);
	}

	@Override
	public Iterable<Productsubcategory> findAll() {
		return dao.getAll();
	}

	@Override
	public Optional<Productsubcategory> findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public void delete(Productsubcategory product) {
		dao.deleteById(product.getProductsubcategoryid());
	}
}
