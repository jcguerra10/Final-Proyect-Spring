package com.icesi.store.finalproyect.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The persistent class for the productinventory database table.
 *
 */
@Entity
@NamedQuery(name = "Productinventory.findAll", query = "SELECT p FROM Productinventory p")
public class Productinventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PRODUCTINVENTORY_PRODUCTINVENTORYID_GENERATOR", allocationSize = 1, sequenceName = "PRODUCTINVENTORY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTINVENTORY_PRODUCTINVENTORYID_GENERATOR")
	private Integer id;

	private Integer bin;

	private Timestamp modifieddate;

	@NotNull
	@Min(value = 0)
	private Integer quantity;

	private Integer rowguid;

	private String shelf;

	// bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name = "locationid")
	private Location location;

	@NotNull(message = "Can´t be null")
	@Transient
	private Integer locationinvid2;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "productid")
	private Product product;

	@NotNull(message = "Can´t be null")
	@Transient
	private Integer productinvid2;

	public Integer getProductinvid2() {
		return productinvid2;
	}

	public void setProductinvid2(Integer productinvid2) {
		this.productinvid2 = productinvid2;
	}

	public Integer getLocationinvid2() {
		return locationinvid2;
	}

	public void setLocationinvid2(Integer locationinvid2) {
		this.locationinvid2 = locationinvid2;
	}

	public Productinventory() {
	}

	public Integer getBin() {
		return this.bin;
	}

	public Integer getId() {
		return this.id;
	}

	public Location getLocation() {
		return this.location;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Product getProduct() {
		return this.product;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public String getShelf() {
		return this.shelf;
	}

	public void setBin(Integer bin) {
		this.bin = bin;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

}