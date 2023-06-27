package com.rimawi.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "No products enough in stock")

public class LowStockException extends RuntimeException {
	public LowStockException(Long product) {
		super(String.format("There isn't enough quantity of %d in stock.", product));
	}
}
