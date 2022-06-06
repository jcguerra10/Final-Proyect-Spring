package com.icesi.store.finalproyect.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the productmodel database table.
 *
 */
@Entity
@NamedQuery(name = "Productmodel.findAll", query = "SELECT p FROM Productmodel p")
public class Productmodel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PRODUCTMODEL_PRODUCTMODELID_GENERATOR", allocationSize = 1, sequenceName = "PRODUCTMODEL_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTMODEL_PRODUCTMODELID_GENERATOR")
	private Integer productmodelid;

	private String catalogdescription;

	private String instructions;

	private Timestamp modifieddate;

	private String name;

	//private Integer rowguid;

	@JsonIgnore// bi-directional many-to-one association to Product
	@OneToMany(mappedBy = "productmodel")
	private List<Product> products;

	// bi-directional many-to-one association to Productmodelillustration

	public Productmodel() {
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductmodel(this);

		return product;
	}


	public String getCatalogdescription() {
		return this.catalogdescription;
	}

	public String getInstructions() {
		return this.instructions;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public Integer getProductmodelid() {
		return this.productmodelid;
	}


	public List<Product> getProducts() {
		return this.products;
	}

//	public Integer getRowguid() {
	//	return this.rowguid;
	//}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductmodel(null);

		return product;
	}

	public void setCatalogdescription(String catalogdescription) {
		this.catalogdescription = catalogdescription;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProductmodelid(Integer productmodelid) {
		this.productmodelid = productmodelid;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	//public void setRowguid(Integer rowguid) {
	//	this.rowguid = rowguid;
	//}

}