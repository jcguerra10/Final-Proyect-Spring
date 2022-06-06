package com.icesi.store.finalproyect.model.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

/**
 * The persistent class for the product database table.
 *
 */
@Entity
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PRODUCT_PRODUCTID_GENERATOR", allocationSize = 1, sequenceName = "PRODUCT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_PRODUCTID_GENERATOR")
	private Integer productid;

	@Column(name = "class")
	private String class_;

	private String color;

	private Integer daystomanufacture;

	private Timestamp discontinueddate;

	private String finishedgoodsflag;

	private BigDecimal listprice;

	private String makeflag;

	private Timestamp modifieddate;

	@Size(min=1, message = "necesita ser mas de 1 caracter")
	private String name;

	private String productline;

	@Min(value = 0,  message = "Tienes que ser Mayor que 0")
	private String productnumber;

	private Integer reorderpoint;

	private Integer rowguid;

	private Integer safetystocklevel;

	@NonNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate sellenddate;

	@NonNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate sellstartdate;

	@Positive
	private BigDecimal size;

	@NonNull()
	@Positive
	@Min(value = 0)
	private BigDecimal standardcost;

	private String style;
	
	@NonNull()
	@Positive
	@Min(value = 0, message = "Tienes que ser Mayor que 1")
	private BigDecimal weight;

	// bi-directional many-to-one association to Billofmaterial

	@ManyToOne
	@JoinColumn(name = "productmodelid", insertable = false, updatable = false)
	private Productmodel productmodel;

	// bi-directional many-to-one association to Productsubcategory
	@ManyToOne
	@JoinColumn(name = "productsubcategoryid")
	@NonNull
	private Productsubcategory productsubcategory;

	// bi-directional many-to-one association to Unitmeasure



	// bi-directional many-to-one association to Productcosthistory
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<Productcosthistory> productcosthistories;

	// bi-directional many-to-one association to Productdocument
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<Productinventory> productinventories;


	public Product() {
	}



	public Productcosthistory addProductcosthistory(Productcosthistory productcosthistory) {
		getProductcosthistories().add(productcosthistory);
		productcosthistory.setProduct(this);

		return productcosthistory;
	}

	public Productinventory addProductinventory(Productinventory productinventory) {
		getProductinventories().add(productinventory);
		productinventory.setProduct(this);

		return productinventory;
	}





	public String getClass_() {
		return this.class_;
	}

	public String getColor() {
		return this.color;
	}

	public Integer getDaystomanufacture() {
		return this.daystomanufacture;
	}

	public Timestamp getDiscontinueddate() {
		return this.discontinueddate;
	}

	public String getFinishedgoodsflag() {
		return this.finishedgoodsflag;
	}

	public BigDecimal getListprice() {
		return this.listprice;
	}

	public String getMakeflag() {
		return this.makeflag;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public List<Productcosthistory> getProductcosthistories() {
		return this.productcosthistories;
	}

	public Integer getProductid() {
		return this.productid;
	}

	public List<Productinventory> getProductinventories() {
		return this.productinventories;
	}

	public String getProductline() {
		return this.productline;
	}

	public Productmodel getProductmodel() {
		return this.productmodel;
	}

	public String getProductnumber() {
		return this.productnumber;
	}

	public Productsubcategory getProductsubcategory() {
		return this.productsubcategory;
	}

	public Integer getReorderpoint() {
		return this.reorderpoint;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public Integer getSafetystocklevel() {
		return this.safetystocklevel;
	}

	public LocalDate getSellenddate() {
		return this.sellenddate;
	}

	public LocalDate getSellstartdate() {
		return this.sellstartdate;
	}

	public BigDecimal getSize() {
		return this.size;
	}

	public BigDecimal getStandardcost() {
		return this.standardcost;
	}

	public String getStyle() {
		return this.style;
	}



	public BigDecimal getWeight() {
		return this.weight;
	}



	public Productcosthistory removeProductcosthistory(Productcosthistory productcosthistory) {
		getProductcosthistories().remove(productcosthistory);
		productcosthistory.setProduct(null);

		return productcosthistory;
	}
	public Productinventory removeProductinventory(Productinventory productinventory) {
		getProductinventories().remove(productinventory);
		productinventory.setProduct(null);

		return productinventory;
	}


	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setDaystomanufacture(Integer daystomanufacture) {
		this.daystomanufacture = daystomanufacture;
	}

	public void setDiscontinueddate(Timestamp discontinueddate) {
		this.discontinueddate = discontinueddate;
	}

	public void setFinishedgoodsflag(String finishedgoodsflag) {
		this.finishedgoodsflag = finishedgoodsflag;
	}

	public void setListprice(BigDecimal listprice) {
		this.listprice = listprice;
	}

	public void setMakeflag(String makeflag) {
		this.makeflag = makeflag;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProductcosthistories(List<Productcosthistory> productcosthistories) {
		this.productcosthistories = productcosthistories;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public void setProductinventories(List<Productinventory> productinventories) {
		this.productinventories = productinventories;
	}

	public void setProductline(String productline) {
		this.productline = productline;
	}

	public void setProductmodel(Productmodel productmodel) {
		this.productmodel = productmodel;
	}

	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}

	public void setProductsubcategory(Productsubcategory productsubcategory) {
		this.productsubcategory = productsubcategory;
	}

	public void setReorderpoint(Integer reorderpoint) {
		this.reorderpoint = reorderpoint;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

	public void setSafetystocklevel(Integer safetystocklevel) {
		this.safetystocklevel = safetystocklevel;
	}

	public void setSellenddate(LocalDate sellenddate) {
		this.sellenddate = sellenddate;
	}

	public void setSellstartdate(LocalDate sellstartdate) {
		this.sellstartdate = sellstartdate;
	}

	public void setSize(BigDecimal size) {
		this.size = size;
	}

	public void setStandardcost(BigDecimal standardcost) {
		this.standardcost = standardcost;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public void setWeight(BigDecimal weight) {
		this.weight=weight;
	}
}