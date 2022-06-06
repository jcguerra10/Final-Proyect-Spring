package com.icesi.store.finalproyect.businessdelegate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.icesi.store.finalproyect.model.Client;
import com.icesi.store.finalproyect.model.Store;
import com.icesi.store.finalproyect.model.product.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Log4j2
@Component
public class BusinessDelegateImpl implements BusinessDelegate {

	@Setter
	@Getter
	private RestTemplate template;

	private final String baseurl = "http://localhost:8081/api";

	public BusinessDelegateImpl() {
		this.template= new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
		messageConverters.add(converter);
	}

	public void setRestTemplate(RestTemplate resttemplate) {
		this.template = resttemplate;
	}

	@Override
	public RestTemplate getRestTemplate() {
		return template;
	}

	@Override
	public Client[] showClients() {
		ResponseEntity<Client[]> response= template.getForEntity(baseurl + "/clientsRest/list", Client[].class);
		Client[] productarray = response.getBody();

		return productarray;
	}

	@Override
	public Client addClient(Client c) {
		HttpEntity<Client> request = new HttpEntity<>(c);
		//log.info("aqui entro");
		return template.postForObject(baseurl + "/clientsRest/addclient/", request, Client.class);
	}

	@Override
	public Client getClient(Integer id) {
		return template.getForObject(baseurl + "/clientsRest/view/" + id, Client.class);
	}

	@Override
	public void editClient(Integer id, Client c) {
		HttpEntity<Client> request = new HttpEntity<>(c);
		template.put(baseurl + "/clientsRest/edit/" + id, request, Client.class);
	}

	@Override
	public void deleteClient(Client c) {
		template.delete(baseurl + "/clientsRest/delete/" + c.getId());
	}
	//PRODUCT
	@Override
	public List<Product> showProductList() {
		Product[] productarray = template.getForObject(baseurl + "/productsRest/list", Product[].class);
		return Arrays.asList(productarray);
	}

	@Override
	public Product addProduct(Product p) {
		HttpEntity<Product> request = new HttpEntity<>(p);
		//log.info("aqui entro");
		return template.postForObject(baseurl + "/productsRest/addproduct/", request, Product.class);

	}

	@Override
	public Product getProduct(Integer id) {
		return template.getForObject(baseurl + "/productsRest/view/" + id, Product.class);
	}

	@Override
	public void editProduct( Product p, Integer id) {
		HttpEntity<Product> request = new HttpEntity<>(p);
		template.put(baseurl + "/productsRest/edit/" + id, request, Product.class);
	}

	@Override
	public void deleteProduct(Product p) {
		template.delete(baseurl + "/productsRest/delete/" + p.getProductid());
	}

	@Override
	public List<Productsubcategory> showProductsubcategoryList() {
		Productsubcategory[] productsubcategoryarray = template.getForObject(baseurl + "/productsubcategoryRest/list",
				Productsubcategory[].class);
		return Arrays.asList(productsubcategoryarray);
	}

	@Override
	public Productsubcategory addProductsubcategory(Productsubcategory p) {
		HttpEntity<Productsubcategory> request = new HttpEntity<>(p);
		//log.info("aqui entro");
		return template.postForObject(baseurl + "/ProductsubcategoryRest/addproduct/", request, Productsubcategory.class);
	}

	@Override
	public List<Productcategory> showProductcategoryList() {
		Productcategory[] productcategoryarray = template.getForObject(baseurl + "/productcategoryRest/list",
			Productcategory[].class);
		return Arrays.asList(productcategoryarray);
	}

	@Override
	public Productcategory addProductcategory(Productcategory p) {
		HttpEntity<Productcategory> request = new HttpEntity<>(p);
		//log.info("aqui entro");
		return template.postForObject(baseurl + "/productcategoryRest/addcategory/", request, Productcategory.class);

	}

	@Override
	public List<Productcosthistory> showProductHistoriccostList() {
		Productcosthistory[] productsubcategoryarray = template.getForObject(baseurl + "/historiccostsRest/list",
				Productcosthistory[].class);
		return Arrays.asList(productsubcategoryarray);

	}

	@Override
	public Productcosthistory addProductHistoriccost(Productcosthistory p) {

		HttpEntity<Productcosthistory> request = new HttpEntity<>(p);
		//log.info("aqui entro");
		return template.postForObject(baseurl + "/historiccostsRest/addproductcost/", request, Productcosthistory.class);

	}

	@Override
	public Productcosthistory getProductHistoriccost(Integer id) {

		return template.getForObject(baseurl + "/historiccostsRest/view/" + id, Productcosthistory.class);
	}

	@Override
	public void editProductHistoriccost(Integer id, Productcosthistory p) {
		HttpEntity<Productcosthistory> request = new HttpEntity<>(p);
		template.put(baseurl + "/historiccostsRest/edit/" + id, request, Productcosthistory.class);
	}

	@Override
	public void deleteProductHistoriccost(Productcosthistory p) {
		template.delete(baseurl + "/historiccostsRest/delete/" + p.getId());
	}

	@Override
	public List<Productinventory> showProductInventorytList() {
		Productinventory[] productsubcategoryarray = template.getForObject(baseurl + "/inventoryproductRest/list",
				Productinventory[].class);
		return Arrays.asList(productsubcategoryarray);
	}

	@Override
	public Productinventory addProductInventory(Productinventory p) {

		HttpEntity<Productinventory> request = new HttpEntity<>(p);
		//log.info("aqui entro");
		return template.postForObject(baseurl + "/inventoryproductRest/addproductinventory/", request, Productinventory.class);

	}

	@Override
	public Productinventory getProductInventory(Integer id) {

		return template.getForObject(baseurl + "/inventoryproductRest/view/" + id, Productinventory.class);

	}

	@Override
	public void editProductInventory(Integer id, Productinventory p) {
		HttpEntity<Productinventory> request = new HttpEntity<>(p);
		template.put(baseurl + "/inventoryproductRest/edit/" + id, request, Productinventory.class);

	}

	@Override
	public void deleteProductInventory(Productinventory p) {
		template.delete(baseurl + "/inventoryproductRest/delete/" + p.getId());
	}

	@Override
	public List<Location> showLocations() {
		Location[] productsubcategoryarray = template.getForObject(baseurl + "/locationsRest/list",
				Location[].class);
		return Arrays.asList(productsubcategoryarray);
	}

	@Override
	public Location addLocation(Location p) {
		HttpEntity<Location> request = new HttpEntity<>(p);
		//log.info("aqui entro");
		return template.postForObject(baseurl + "/locationsRest/addlocation/", request, Location.class);

	}

	@Override
	public Location getLocation(Integer id) {

		return template.getForObject(baseurl + "/locationsRest/view/" + id, Location.class);

	}

	@Override
	public void editLocation(Integer id, Location p) {
		HttpEntity<Location> request = new HttpEntity<>(p);
		template.put(baseurl + "/locationsRest/edit/" + id, request, Location.class);

	}

	@Override
	public void deleteLocation(Location p) {
		template.delete(baseurl + "/locationsRest/delete/" + p.getLocationid());
	}

	@Override
	public List<Store> showStores() {

		Store[] productarray = template.getForObject(baseurl + "/storesRest/list", Store[].class);
		return Arrays.asList(productarray);
	}

	@Override
	public Store addStore(Store p) {

		HttpEntity<Store> request = new HttpEntity<>(p);
		//log.info("aqui entro");
		return template.postForObject(baseurl + "/storesRest/addstore/", request, Store.class);

	}

	@Override
	public Store getStore(Integer id) {

		return template.getForObject(baseurl + "/storesRest/view/" + id, Store.class);

	}

	@Override
	public void editStore(Integer id, Store p) {
		HttpEntity<Store> request = new HttpEntity<>(p);
		template.put(baseurl + "/storesRest/edit/" + id, request, Store.class);

	}

	@Override
	public void deleteStore(Store p) {
		template.delete(baseurl + "/storesRest/delete/" + p.getId());

	}

}

