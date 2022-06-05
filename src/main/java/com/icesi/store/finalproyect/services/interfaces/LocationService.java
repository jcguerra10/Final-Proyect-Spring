package com.icesi.store.finalproyect.services.interfaces;

import com.icesi.store.finalproyect.model.product.Location;
import com.icesi.store.finalproyect.model.product.Product;

import java.util.Optional;

public interface LocationService {
	public void saveLocation(Location loc);
	public void editLocation(Location loc, Integer locId);
	public Iterable<Location> findAll();
	public Optional<Location> findById(Integer id);
	public void delete(Location loc);
}
