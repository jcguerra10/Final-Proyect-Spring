package com.icesi.store.finalproyect.services.implementation;

import java.util.Optional;

import com.icesi.store.finalproyect.dao.LocationDao;
import com.icesi.store.finalproyect.model.product.Location;
import com.icesi.store.finalproyect.services.interfaces.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LocationServiceImp implements LocationService {

	@Autowired
	private LocationDao dao;
	
	@Transactional
	@Override
	public void saveLocation(Location loc) {
		if (loc == null )
			throw new NullPointerException("Parameter Null");
		if (loc.getName() == null)
			throw new IllegalArgumentException("Name Null");
		if (loc.getName().length() < 5)
			throw new IllegalArgumentException("Name Length");
		if (loc.getAvailability() == null)
			throw new IllegalArgumentException("Availabilty Null");
		if (loc.getAvailability().intValue() < 1 || loc.getAvailability().intValue() > 10)
			throw new IllegalArgumentException("Availability");
		if (loc.getCostrate() == null)
			throw new IllegalArgumentException("CostRate Null");
		if (loc.getCostrate().intValue() < 0 || loc.getCostrate().intValue() > 1)
			throw new IllegalArgumentException();
		dao.save(loc);
	}

	@Transactional
	@Override
	public void editLocation(Location loc, Integer locId) {
		Optional<Location> op = dao.findById(locId);
		Location opLoc = op.get();
		if (loc == null )
			throw new NullPointerException("Parameter Null");
		if (loc.getName() == null)
			throw new IllegalArgumentException("Name Null");
		if (loc.getName().length() < 5)
			throw new IllegalArgumentException("Name Length");
		if (loc.getAvailability() == null)
			throw new IllegalArgumentException("Availabilty Null");
		if (loc.getAvailability().intValue() < 1 || loc.getAvailability().intValue() > 10)
			throw new IllegalArgumentException("Availability");
		if (loc.getCostrate() == null)
			throw new IllegalArgumentException("CostRate Null");
		if (loc.getCostrate().intValue() < 0 || loc.getCostrate().intValue() > 1)
			throw new IllegalArgumentException();
		opLoc.setName(loc.getName());
		opLoc.setAvailability(loc.getAvailability());
		opLoc.setCostrate(loc.getCostrate());
		dao.update(opLoc);
	}

	@Override
	public Iterable<Location> findAll() {
		return dao.getAll();
	}

	@Override
	public Optional<Location> findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public void delete(Location loc) {
		dao.deleteById(loc.getLocationid());
	}

}
