package com.icesi.store.finalproyect.businessdelegate;

import java.util.List;

import com.icesi.store.finalproyect.model.Client;
import com.icesi.store.finalproyect.model.Store;
import com.icesi.store.finalproyect.model.product.*;
import org.springframework.web.client.RestTemplate;


public interface BusinessDelegate {

	RestTemplate getRestTemplate();

	//CLIENT
	Client[] showClients();
	Client addClient(Client c);
	Client getClient(Integer id);
	public void editClient(Integer id, Client c);
	public void deleteClient(Client c);

	//PRODDUCT
	List<Product> showProductList();
	Product addProduct(Product p);
	Product getProduct(Integer id);
	public void editProduct (Product p,Integer id);
	public void deleteProduct(Product p);

	// PRODUCTSUBCATEGORY
	public List<Productsubcategory> showProductsubcategoryList();
	Productsubcategory addProductsubcategory(Productsubcategory p, Integer id);

	// PRODUCTCATEGORY
	public List<Productcategory> showProductcategoryList();
	Productcategory addProductcategory(Productcategory p);

	//PRODUCT COST HISTORY
	List<Productcosthistory> showProductHistoriccostList();
	Productcosthistory addProductHistoriccost(Productcosthistory p);
	Productcosthistory getProductHistoriccost(Integer id);
	public void editProductHistoriccost(Integer id, Productcosthistory p);
	public void deleteProductHistoriccost(Productcosthistory p);

	// PRODUCT INVENTORY
	List<Productinventory> showProductInventorytList();
	Productinventory addProductInventory(Productinventory p);
	Productinventory getProductInventory(Integer id);
	public void editProductInventory(Integer id, Productinventory p);
	public void deleteProductInventory(Productinventory p);

	//LOCATION
	List<Location> showLocations();
	Location addLocation(Location p);
	Location getLocation(Integer id);
	public void editLocation(Integer id, Location p);
	public void deleteLocation(Location p);

	//STORE
	List<Store> showStores();
	Store addStore(Store p);
	Store getStore(Integer id);
	public void editStore(Integer id, Store p);
	public void deleteStore(Store p);

}
