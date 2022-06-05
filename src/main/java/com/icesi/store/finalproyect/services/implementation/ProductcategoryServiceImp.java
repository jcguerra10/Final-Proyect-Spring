package com.icesi.store.finalproyect.services.implementation;

import java.util.Optional;


import com.icesi.store.finalproyect.dao.ProductcategoryDao;
import com.icesi.store.finalproyect.model.product.Productcategory;
import com.icesi.store.finalproyect.services.interfaces.ProductcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductcategoryServiceImp implements ProductcategoryService {
	
	@Autowired
	private ProductcategoryDao pcRepository;

	@Transactional
	@Override
	public void saveProductcategory(Productcategory pc) {
		if(pc == null)
			throw new NullPointerException("Null Object");
		pcRepository.save(pc);
	}

	@Transactional
	@Override
	public void editProductcategory(Productcategory pc, Integer i) {
		Optional<Productcategory> op = pcRepository.findById(i);
		Productcategory opLoc = op.get();
		if(pc == null)
			throw new NullPointerException("Null Object");
		opLoc.setName(pc.getName());
		pcRepository.save(opLoc);
	}

	@Override
	public Iterable<Productcategory> findAll() {
		return pcRepository.getAll();
	}

	@Override
	public Optional<Productcategory> findById(Integer id) {
		return pcRepository.findById(id);
	}

	@Override
	public void delete(Productcategory product) {
		pcRepository.deleteById(product.getProductcategoryid());
	}
}
