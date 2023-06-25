package com.rimawi.project.DTOs;

import java.time.LocalDateTime;

public class StockDTO {
	private Long id;
	private int quantity;
	private LocalDateTime updatedAt;
	private Long productStock_id;

	public StockDTO() {

	}

	public StockDTO(int quantity, LocalDateTime updatedAt, Long productStock_id) {
		super();
		this.quantity = quantity;
		this.updatedAt = updatedAt;
		this.productStock_id = productStock_id;
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

	public Long getProductStock_id() {
		return productStock_id;
	}

	public void setProductStock_id(Long productStock_id) {
		this.productStock_id = productStock_id;
	}

}
