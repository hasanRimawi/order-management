package com.rimawi.project.DTOs;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

public class Product_OrderDTO {
	private Long id;
	private int quantity;
	@DecimalMin(value = "2.0", inclusive = true)
	@DecimalMax(value = "10.0", inclusive = true)
	private double price;
	@DecimalMin(value = "2.0", inclusive = true)
	@DecimalMax(value = "10.0", inclusive = true)
	private double vat;
	private Long order_id;
	private Long product_id;

	public Product_OrderDTO() {

	}

	public Product_OrderDTO(int quantity,
			@DecimalMin(value = "2.0", inclusive = true) @DecimalMax(value = "10.0", inclusive = true) double price,
			@DecimalMin(value = "2.0", inclusive = true) @DecimalMax(value = "10.0", inclusive = true) double vat,
			Long order_id, Long product_id) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.vat = vat;
		this.order_id = order_id;
		this.product_id = product_id;
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

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

}
