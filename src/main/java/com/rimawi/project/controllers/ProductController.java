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

import com.rimawi.project.DTOs.ProductDTO;
import com.rimawi.project.services.ProductService;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		return new ResponseEntity<List<ProductDTO>>(productService.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
		return new ResponseEntity<ProductDTO>(productService.getProductById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product) {
		return new ResponseEntity<ProductDTO>(productService.addProduct(product), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO product) {
		return new ResponseEntity<ProductDTO>(productService.updateProduct(product, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return new ResponseEntity<String>("Successfuly Deleted", HttpStatus.OK);
	}

}
