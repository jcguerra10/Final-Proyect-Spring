package com.icesi.store.finalproyect.services.interfaces;

import com.icesi.store.finalproyect.model.product.Location;

public interface LocationService {
	public void saveLocation(Location loc);
	public void editLocation(Location loc, Integer locId);
}
