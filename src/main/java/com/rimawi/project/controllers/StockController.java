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

import com.rimawi.project.DTOs.StockDTO;
import com.rimawi.project.services.StockService;

@RestController
@RequestMapping("/stocks")
public class StockController {

	@Autowired
	private StockService stockService;

	@GetMapping
	public ResponseEntity<List<StockDTO>> getAllStocks() {
		return new ResponseEntity<List<StockDTO>>(stockService.getAllStock(), HttpStatus.OK);
	}

	@GetMapping("/id")
	public ResponseEntity<StockDTO> getStockById(@PathVariable Long id) {
		return new ResponseEntity<StockDTO>(stockService.getStockById(id), HttpStatus.OK);
	}

	@GetMapping("/ofProduct/{id}")
	public ResponseEntity<List<StockDTO>> getStocksOfProduct(@PathVariable Long productId) {
		return new ResponseEntity<List<StockDTO>>(stockService.getStocksByProductId(productId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<StockDTO> addStock(@RequestBody StockDTO stock) {
		return new ResponseEntity<StockDTO>(stockService.addStock(stock), HttpStatus.CREATED);
	}

	@PatchMapping
	public ResponseEntity<StockDTO> updateStock(@RequestParam(name = "quantity") int quantity,
			@RequestParam(name = "id") Long id) {
		return new ResponseEntity<StockDTO>(stockService.updateStock(id, quantity), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStock(@PathVariable Long id) {
		stockService.deleteStock(id);
		return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
	}
}
