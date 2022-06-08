package com.icesi.store.finalproyect.services.implementation;

import java.util.Optional;

import com.icesi.store.finalproyect.dao.ProductDaoImp;
import com.icesi.store.finalproyect.model.product.Product;
import com.icesi.store.finalproyect.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	public ProductDaoImp dao;

	@Override
	public void delete(Product product) {
//		productRepository.delete(product);
		dao.deleteById(product.getProductid());
	}
	@Override
	public Optional<Product> findById(Integer id) {

		return dao.findById(id);
	}
	@Override
	public Iterable<Product> findAll() {
//		return productRepository.findAll();
		return dao.getAll();
	}
	@Transactional
	@Override
	public void saveProduct(Product pro) {
		if(pro == null)
			throw new NullPointerException();
		
		if(pro.getProductsubcategoryid2() == null)
			throw new NullPointerException("Not have Sub category");

		if(pro.getProductnumber() == null)
			throw new IllegalArgumentException("ProductNumber Null");

		if(pro.getProductnumber().equals(""))
			throw new IllegalArgumentException("Not Have Product Number");
		
		if(pro.getSellstartdate() == null)
			throw new IllegalArgumentException("startDate Null");
		
		if(pro.getSellenddate() == null)
			throw new IllegalArgumentException("endDate Null");
		
		if(pro.getSellstartdate().compareTo(pro.getSellenddate()) > 0)
			throw new IllegalArgumentException("Start Date Greater than End Date");
		
		if(pro.getSize() == null)
			throw new IllegalArgumentException("Size null");
		if(pro.getSize().intValue() <= 0)
			throw new IllegalArgumentException("Size is not Greater than 0");
		
		if(pro.getWeight() == null)
			throw new IllegalArgumentException("Weight null");
		
		if(pro.getWeight().doubleValue() <= 0)
			throw new IllegalArgumentException("Weight is not Greater than 0");
		
		dao.save(pro);
	}

	@Transactional
	@Override
	public void editProduct(Product pro, Integer id) {
		Optional<Product> opPro = dao.findById(id);
		Product editPro = opPro.get();
		if(pro == null)
			throw new NullPointerException();

		if(pro.getProductsubcategoryid2() == null)
			throw new NullPointerException("Not have Sub category");

		if(pro.getProductnumber() == null)
			throw new IllegalArgumentException("ProductNumber Null");

		if(pro.getProductnumber().equals(""))
			throw new IllegalArgumentException("Not Have Product Number");

		if(pro.getSellstartdate() == null)
			throw new IllegalArgumentException("startDate Null");

		if(pro.getSellenddate() == null)
			throw new IllegalArgumentException("endDate Null");

		if(pro.getSellstartdate().compareTo(pro.getSellenddate()) > 0)
			throw new IllegalArgumentException("Start Date Greater than End Date");

		if(pro.getSize() == null)
			throw new IllegalArgumentException("Size null");
		if(pro.getSize().intValue() <= 0)
			throw new IllegalArgumentException("Size is not Greater than 0");

		if(pro.getWeight() == null)
			throw new IllegalArgumentException("Weight null");

		if(pro.getWeight().doubleValue() <= 0)
			throw new IllegalArgumentException("Weight is not Greater than 0");
		//editPro.setProductsubcategory(pro.getProductsubcategory());
		editPro.setName(pro.getName());
		editPro.setProductsubcategoryid2(pro.getProductsubcategoryid2());
		editPro.setProductnumber(pro.getProductnumber());
		editPro.setSellstartdate(pro.getSellstartdate());
		editPro.setSellenddate(pro.getSellenddate());
		editPro.setSize(pro.getSize());
		editPro.setWeight(pro.getWeight());
		dao.update(editPro);
	}

}