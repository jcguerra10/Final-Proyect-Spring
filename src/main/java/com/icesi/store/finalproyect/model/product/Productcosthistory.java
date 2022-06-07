package com.icesi.store.finalproyect.model.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

/**
 * The persistent class for the productcosthistory database table.
 *
 */
@Entity
@NamedQuery(name = "Productcosthistory.findAll", query = "SELECT p FROM Productcosthistory p")
public class Productcosthistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PRODUCTCOSTHISTORY_PRODUCTCOSTHISTORYID_GENERATOR", allocationSize = 1, sequenceName = "PRODUCTCOSTHISTORY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTCOSTHISTORY_PRODUCTCOSTHISTORYID_GENERATOR")
	private Integer id;

	@NonNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startdate;
	
	@NonNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate enddate;

	private LocalDate modifieddate;

	@NonNull()
	@Min(value = 0)
	private BigDecimal standardcost;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "productid")
	private Product product;

	@NotNull(message = "Can´t be null")
	@Transient
	private Integer productCostid2;

	public Integer getProductCostid2() {
		return productCostid2;
	}

	public void setProductCostid2(Integer productCostid2) {
		this.productCostid2 = productCostid2;
	}

	public Productcosthistory() {
	}

	public LocalDate getEnddate() {
		return this.enddate;
	}

	public Integer getId() {
		return this.id;
	}

	public LocalDate getModifieddate() {
		return this.modifieddate;
	}

	public Product getProduct() {
		return this.product;
	}

	public BigDecimal getStandardcost() {
		return this.standardcost;
	}

	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}
	
	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setModifieddate(LocalDate modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setStandardcost(BigDecimal standardcost) {
		this.standardcost = standardcost;
	}

}