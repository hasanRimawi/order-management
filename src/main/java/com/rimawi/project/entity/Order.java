package com.rimawi.project.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_table")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private int quantity;
	private LocalDateTime updatedAt;

	@ManyToOne
	@JoinColumn(name = "customerId", referencedColumnName = "id")
	private Customer customer;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<Product_Order> product_order = new ArrayList<>();

	public Order() {

	}

	public Order(int quantity, LocalDateTime updatedAt) {
		super();
		this.quantity = quantity;
		this.updatedAt = updatedAt;
	}

	public Order(int quantity, LocalDateTime updatedAt, Customer customer) {
		super();
		this.quantity = quantity;
		this.updatedAt = updatedAt;
		this.customer = customer;
	}

	public Order(int quantity, LocalDateTime updatedAt, Customer customer, List<Product_Order> product_order) {
		super();
		this.quantity = quantity;
		this.updatedAt = updatedAt;
		this.customer = customer;
		this.product_order = product_order;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public List<Product_Order> getProduct_order() {
		return product_order;
	}

	public void setProduct_order(List<Product_Order> product_order) {
		this.product_order = product_order;
	}

}
