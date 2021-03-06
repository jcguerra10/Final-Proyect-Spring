package com.icesi.store.finalproyect.services.implementation;

import java.util.Optional;

import com.icesi.store.finalproyect.dao.ProductinventoryDaoImp;
import com.icesi.store.finalproyect.model.product.Productinventory;
import com.icesi.store.finalproyect.services.interfaces.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductInventoryServiceImp implements ProductInventoryService {

	@Autowired
	private ProductinventoryDaoImp dao;

	@Transactional
	@Override
	public void saveProductInventory(Productinventory proInventory) {
		if (proInventory == null)
			throw new NullPointerException("ObjectNull");
		if (proInventory.getLocationinvid2() == null)
			throw new NullPointerException("location");
		if (proInventory.getQuantity() == null)
			throw new IllegalArgumentException("Quantity Null");
		if (proInventory.getQuantity() < 0)
			throw new IllegalArgumentException("Quantity is not Greater than 0");
		dao.save(proInventory);
	}

	@Transactional
	@Override
	public void editProductInventory(Productinventory proInventory, Integer id) {
		Optional<Productinventory> op = dao.findById(id);
		Productinventory opLoc = op.get();
		if (proInventory == null)
			throw new NullPointerException("No Object");
		if (proInventory.getLocationinvid2() == null)
			throw new NullPointerException("Location Null");
		if (proInventory.getQuantity() == null)
			throw new IllegalArgumentException("Quantity Null");
		if (proInventory.getQuantity() < 0)
			throw new IllegalArgumentException("Quantity is not Greater than 0");
		opLoc.setProductinvid2(proInventory.getProductinvid2());
		opLoc.setLocationinvid2(proInventory.getLocationinvid2());

		opLoc.setQuantity(proInventory.getQuantity());
		dao.update(opLoc);
	}

	@Override
	public Iterable<Productinventory> findAll() {
		return dao.getAll();
	}

	@Override
	public Optional<Productinventory> findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public void delete(Productinventory product) {
		dao.deleteById(product.getId());
	}

}