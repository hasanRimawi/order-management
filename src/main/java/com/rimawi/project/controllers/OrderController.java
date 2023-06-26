package com.rimawi.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rimawi.project.DTOs.OrderDTO;
import com.rimawi.project.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<List<OrderDTO>> getAllOrders() {
		return new ResponseEntity<List<OrderDTO>>(orderService.getAllOrders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
		return new ResponseEntity<OrderDTO>(orderService.getOrderById(id), HttpStatus.OK);
	}

	@GetMapping("/ofCustomer/{id}")
	public ResponseEntity<List<OrderDTO>> getCustomerOrders(@PathVariable Long id) {
		return new ResponseEntity<List<OrderDTO>>(orderService.getCustomerOrders(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO order) {
		return new ResponseEntity<OrderDTO>(orderService.addOrder(order), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletOrder(@PathVariable Long id) {
		orderService.deleteOrder(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}

}
