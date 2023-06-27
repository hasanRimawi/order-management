package com.rimawi.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rimawi.project.DTOs.Product_OrderDTO;
import com.rimawi.project.services.Product_OrderService;

@RestController
@RequestMapping("/v1/productsOrder")
public class Product_OrderController {

	@Autowired
	private Product_OrderService proOrdService;

	@GetMapping
	public ResponseEntity<List<Product_OrderDTO>> getAllProductOrder() {
		return new ResponseEntity<List<Product_OrderDTO>>(proOrdService.getAllProductOrders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product_OrderDTO> getProductOrderById(@PathVariable Long id) {
		return new ResponseEntity<Product_OrderDTO>(proOrdService.getProductOrderById(id), HttpStatus.OK);
	}

	@GetMapping("/{orderId}/order")
	public ResponseEntity<List<Product_OrderDTO>> getOrderProductsOfOrder(@PathVariable Long orderId) {
		return new ResponseEntity<List<Product_OrderDTO>>(proOrdService.getOrderProductsOfOrder(orderId),
				HttpStatus.OK);
	}

	@GetMapping("/{productId}/product")
	public ResponseEntity<List<Product_OrderDTO>> getOrderProductsOfProduct(@PathVariable Long productId) {
		return new ResponseEntity<List<Product_OrderDTO>>(proOrdService.getOrderProductsOfProduct(productId),
				HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Product_OrderDTO> addProductOrder(@RequestBody Product_OrderDTO element) {
		return new ResponseEntity<Product_OrderDTO>(proOrdService.addProductOrder(element), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product_OrderDTO> updateProductOrder(@PathVariable(name = "id") Long id,
			@RequestBody Product_OrderDTO element) {
		return new ResponseEntity<Product_OrderDTO>(proOrdService.updateProduct_Order(element, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProductOrder(@PathVariable Long id) {
		proOrdService.deleteProduct_Order(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
}
