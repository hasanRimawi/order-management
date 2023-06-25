package com.rimawi.project.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimawi.project.DTOs.StockDTO;
import com.rimawi.project.entity.Product;
import com.rimawi.project.entity.Stock;
import com.rimawi.project.exceptions.NotFoundException;
import com.rimawi.project.repositories.ProductRepository;
import com.rimawi.project.repositories.StockRepository;

@Service
public class StockService {
	@Autowired
	private StockRepository stockRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private Mappers mapper;

	public List<StockDTO> getAllStock() {
		return stockRepo.findAll().stream().map((stock) -> mapper.entityToStockDTO(stock)).collect(Collectors.toList());
	}

	public StockDTO getStockById(Long id) {
		return mapper.entityToStockDTO(stockRepo.findById(id).orElseThrow(() -> new NotFoundException("Stock", id)));
	}

	public List<StockDTO> getStocksByProductId(Long product_id) {
		return stockRepo.findStockByProductId(product_id).stream().map((stock) -> mapper.entityToStockDTO(stock))
				.collect(Collectors.toList());
	}

	public StockDTO addStock(StockDTO stock) {
		Product temp = productRepo.findById(stock.getProductStock_id())
				.orElseThrow(() -> new NotFoundException("Product", stock.getProductStock_id()));
		return mapper.entityToStockDTO(stockRepo.save(new Stock(stock.getQuantity(), LocalDateTime.now(), temp)));
	}

	public StockDTO updateStock(Long id, int quantity) {
		Stock temp = stockRepo.findById(id).orElseThrow(() -> new NotFoundException("Stock", id));
		temp.setQuantity(quantity);
		temp.setUpdatedAt(LocalDateTime.now());
		return mapper.entityToStockDTO(stockRepo.save(temp));
	}

	public void deleteStock(Long id) {
		if (stockRepo.existsById(id))
			stockRepo.deleteById(id);
		else
			throw new NotFoundException("Stock", id);
	}

}
