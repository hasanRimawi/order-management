package com.rimawi.project.DTOs;

import java.time.LocalDateTime;

public class OrderDTO {
	private Long id;
	private int quantity;
	private LocalDateTime updatedAt;
	private Long customer_id;

	public OrderDTO() {

	}

	public OrderDTO(int quantity, LocalDateTime updatedAt, Long customer_id) {
		super();
		this.quantity = quantity;
		this.updatedAt = updatedAt;
		this.customer_id = customer_id;
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

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

}
