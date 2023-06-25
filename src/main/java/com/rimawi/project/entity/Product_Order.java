package com.rimawi.project.entity;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Product_Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private int quantity;
	@DecimalMin(value = "2.0", inclusive = true)
	@DecimalMax(value = "10.0", inclusive = true)
	private double price;
	@DecimalMin(value = "2.0", inclusive = true)
	@DecimalMax(value = "10.0", inclusive = true)
	private double vat;

	@ManyToOne
	@JoinColumn(name = "order_table_id", referencedColumnName = "id")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "productId", referencedColumnName = "id")
	private Product product;

	public Product_Order() {

	}

	public Product_Order(int quantity,
			@DecimalMin(value = "2.0", inclusive = true) @DecimalMax(value = "10.0", inclusive = true) double price,
			@DecimalMin(value = "2.0", inclusive = true) @DecimalMax(value = "10.0", inclusive = true) double vat,
			Order order, Product product) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.vat = vat;
		this.order = order;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
