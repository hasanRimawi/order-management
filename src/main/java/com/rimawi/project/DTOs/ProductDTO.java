package com.rimawi.project.DTOs;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

public class ProductDTO {
	private Long id;
	private String slug;
	private String name;
	private String reference;
	@DecimalMin(value = "2.0", inclusive = true)
	@DecimalMax(value = "10.0", inclusive = true)
	private double price;
	@DecimalMin(value = "2.0", inclusive = true)
	@DecimalMax(value = "10.0", inclusive = true)
	private double vat;
	private boolean stockable;

	public ProductDTO() {

	}

	public ProductDTO(String slug, String name, String reference,
			@DecimalMin(value = "2.0", inclusive = true) @DecimalMax(value = "10.0", inclusive = true) double price,
			@DecimalMin(value = "2.0", inclusive = true) @DecimalMax(value = "10.0", inclusive = true) double vat,
			boolean stockable) {
		super();
		this.slug = slug;
		this.name = name;
		this.reference = reference;
		this.price = price;
		this.vat = vat;
		this.stockable = stockable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public boolean isStockable() {
		return stockable;
	}

	public void setStockable(boolean stockable) {
		this.stockable = stockable;
	}

}
