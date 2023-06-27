package com.rimawi.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rimawi.project.DTOs.CustomerDTO;
import com.rimawi.project.DTOs.JwtRequest;
import com.rimawi.project.DTOs.JwtResponse;
import com.rimawi.project.jwt.JwtTokenUtil;
import com.rimawi.project.services.CustomerService;

@RestController
@RequestMapping("/v1/gate")
public class AuthController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@PostMapping("/register")
	public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customer) {
		CustomerDTO addedCustomer = customerService.addCustomer(customer);
		return new ResponseEntity<CustomerDTO>(addedCustomer, HttpStatus.CREATED);
	}

	@PostMapping(value = "/authenticate")
	public ResponseEntity<JwtResponse> addEmp(@RequestBody JwtRequest user) {
		String username = user.getUsername();
		UserDetails temp = customerService.loadUserByUsername(username);
		final String token = jwtTokenUtil.generateToken(temp);
		return new ResponseEntity<JwtResponse>(new JwtResponse(token), HttpStatus.ACCEPTED);
	}

}
