package com.rimawi.project.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private int quantity;
	private LocalDateTime updatedAt;
	@ManyToOne
	@JoinColumn(name = "productId", referencedColumnName = "id")
	private Product productStock;

	public Stock() {

	}

	public Stock(int quantity, LocalDateTime updatedAt) {
		super();
		this.quantity = quantity;
		this.updatedAt = updatedAt;
	}

	public Stock(int quantity, LocalDateTime updatedAt, Product productStock) {
		super();
		this.quantity = quantity;
		this.updatedAt = updatedAt;
		this.productStock = productStock;
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

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Product getProductStock() {
		return productStock;
	}

	public void setProductStock(Product productStock) {
		this.productStock = productStock;
	}

}
