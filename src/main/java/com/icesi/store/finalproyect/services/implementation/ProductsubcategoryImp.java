package com.icesi.store.finalproyect.services.implementation;

import java.util.Optional;

import com.icesi.store.finalproyect.dao.ProductsubcategoryDao;
import com.icesi.store.finalproyect.model.product.Productsubcategory;
import com.icesi.store.finalproyect.services.interfaces.ProductsubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductsubcategoryImp implements ProductsubcategoryService {
@Autowired
private ProductsubcategoryDao dao;
	@Transactional
	@Override
	public void saveProductsubcategory(Productsubcategory pc) {
		if(pc == null)
			throw new NullPointerException("Null Object");
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
}
