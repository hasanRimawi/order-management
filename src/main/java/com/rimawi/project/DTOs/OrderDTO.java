package com.rimawi.project.DTOs;

import java.time.LocalDateTime;

public class OrderDTO {
	private Long id;
	private LocalDateTime orderedAt;
	private Long customer_id;

	public OrderDTO() {

	}

	public OrderDTO(LocalDateTime orderedAt, Long customer_id) {
		super();
		this.orderedAt = orderedAt;
		this.customer_id = customer_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getOrderedAt() {
		return orderedAt;
	}

	public void setOrderedAt(LocalDateTime orderedAt) {
		this.orderedAt = orderedAt;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

}
