package com.rimawi.project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;

@Entity
@Table
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Product_Order> product_order = new ArrayList<>();

	@OneToMany(mappedBy = "productStock", cascade = CascadeType.ALL)
	private List<Stock> stock = new ArrayList<>();

	public Product() {

	}

	public Product(String slug, String name, String reference,
			@DecimalMin(value = "2.0", inclusive = true) @DecimalMax(value = "10.0", inclusive = true) double price,
			@DecimalMin(value = "2.0", inclusive = true) @DecimalMax(value = "10.0", inclusive = true) double vat,
			boolean stockable, List<Product_Order> product_order, List<Stock> stock) {
		super();
		this.slug = slug;
		this.name = name;
		this.reference = reference;
		this.price = price;
		this.vat = vat;
		this.stockable = stockable;
		this.product_order = product_order;
		this.stock = stock;
	}

	public Product(String slug, String name, String reference,
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Product_Order> getProduct_order() {
		return product_order;
	}

	public void setProduct_order(List<Product_Order> product_order) {
		this.product_order = product_order;
	}

	public List<Stock> getStock() {
		return stock;
	}

	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}

}
