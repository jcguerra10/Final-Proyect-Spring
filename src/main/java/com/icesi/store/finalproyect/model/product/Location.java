package com.icesi.store.finalproyect.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The persistent class for the location database table.
 *
 */
@Entity
@NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "LOCATION_LOCATIONID_GENERATOR", allocationSize = 1, sequenceName = "LOCATION_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCATION_LOCATIONID_GENERATOR")
	private Integer locationid;




	private BigDecimal availability;

	private BigDecimal costrate;

	private Timestamp modifieddate;

	@Size(min = 1, message = "Al menos tiene que tener 1 caracter")
	private String name;

	@JsonIgnore// bi-directional many-to-one association to Productinventory
	@OneToMany(mappedBy = "location")
	private List<Productinventory> productinventories;

	public Location() {
	}

	public Productinventory addProductinventory(Productinventory productinventory) {
		getProductinventories().add(productinventory);
		productinventory.setLocation(this);

		return productinventory;
	}


	public BigDecimal getAvailability() {
		return this.availability;
	}

	public BigDecimal getCostrate() {
		return this.costrate;
	}

	public Integer getLocationid() {
		return this.locationid;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public List<Productinventory> getProductinventories() {
		return this.productinventories;
	}

	public Productinventory removeProductinventory(Productinventory productinventory) {
		getProductinventories().remove(productinventory);
		productinventory.setLocation(null);

		return productinventory;
	}


	public void setAvailability(BigDecimal availability) {
		this.availability = availability;
	}

	public void setCostrate(BigDecimal costrate) {
		this.costrate = costrate;
	}

	public void setLocationid(Integer locationid) {
		this.locationid = locationid;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProductinventories(List<Productinventory> productinventories) {
		this.productinventories = productinventories;
	}

}