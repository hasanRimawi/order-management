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

import com.rimawi.project.DTOs.CustomerDTO;
import com.rimawi.project.services.CustomerService;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public ResponseEntity<List<CustomerDTO>> getAllCustomer() {
		List<CustomerDTO> customers = customerService.getAllCustomers();
		return new ResponseEntity<List<CustomerDTO>>(customers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
		CustomerDTO customer = customerService.getCustomerById(id);
		return new ResponseEntity<CustomerDTO>(customer, HttpStatus.OK);
	}

//	@PostMapping
//	public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customer) {
//		CustomerDTO addedCustomer = customerService.addCustomer(customer);
//		return new ResponseEntity<CustomerDTO>(addedCustomer, HttpStatus.CREATED);
//	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customer,
			@PathVariable(name = "id") Long id) {
		CustomerDTO updatedCustomer = customerService.updateCustomer(customer, id);
		return new ResponseEntity<CustomerDTO>(updatedCustomer, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
	}
}
