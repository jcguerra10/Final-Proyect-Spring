package com.icesi.store.finalproyect.services.implementation;

import java.time.LocalDate;
import java.util.Optional;

import com.icesi.store.finalproyect.dao.ProductcosthistoryDaoImp;
import com.icesi.store.finalproyect.model.product.Productcosthistory;
import com.icesi.store.finalproyect.services.interfaces.ProductcosthistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductcosthistoryServiceImp implements ProductcosthistoryService {

	@Autowired
	private ProductcosthistoryDaoImp dao;

	@Transactional
	@Override
	public void saveProductcosthistory(Productcosthistory pch) {
		if (pch == null) 
			throw new NullPointerException();
		if (pch.getProduct() == null)
			throw new IllegalArgumentException("Product Not Exist");
		if (pch.getEnddate() == null)
			throw new IllegalArgumentException("EndDate Null");
		if (pch.getEnddate().isAfter(LocalDate.now()))
			throw new IllegalArgumentException("End Date Greater Than Actual");
		if (pch.getStandardcost() == null)
			throw new IllegalArgumentException("Standar Cost Null");
		if (pch.getStandardcost().intValue() < 0)
			throw new IllegalArgumentException("Standar Cost");
		dao.save(pch);
		dao.save(pch);
	}

	@Transactional
	@Override
	public void editProductcosthistory(Productcosthistory pch, Integer id) {
		Optional<Productcosthistory> op = dao.findById(id);
		Productcosthistory oppch = op.get();
		if (pch == null) 
			throw new NullPointerException();
		if (pch.getProduct() == null)
			throw new IllegalArgumentException("Product Not Exist");
		if (pch.getEnddate() == null)
			throw new IllegalArgumentException("EndDate Null");
		if (pch.getEnddate().isAfter(LocalDate.now()))
			throw new IllegalArgumentException("End Date Greater Than Actual");
		if (pch.getStandardcost() == null)
			throw new IllegalArgumentException("Standar Cost Null");
		if (pch.getStandardcost().intValue() < 0)
			throw new IllegalArgumentException("Standar Cost");
		oppch.setProduct(pch.getProduct());;
		oppch.setEnddate(pch.getEnddate());;
		oppch.setStandardcost(pch.getStandardcost());;
		dao.update(oppch);
	}

}
