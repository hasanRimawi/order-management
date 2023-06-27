package com.rimawi.project.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimawi.project.DTOs.Product_OrderDTO;
import com.rimawi.project.entity.Order;
import com.rimawi.project.entity.Product;
import com.rimawi.project.entity.Product_Order;
import com.rimawi.project.entity.Stock;
import com.rimawi.project.exceptions.LowStockException;
import com.rimawi.project.exceptions.NotFoundException;
import com.rimawi.project.repositories.OrderRepository;
import com.rimawi.project.repositories.ProductRepository;
import com.rimawi.project.repositories.Product_OrderRepository;
import com.rimawi.project.repositories.StockRepository;

@Service
public class Product_OrderService {

	@Autowired
	private Product_OrderRepository proOrdRepo;

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private Mappers mapper;

	public List<Product_OrderDTO> getAllProductOrders() {
		return proOrdRepo.findAll().stream().map((element) -> mapper.entityToProductOrderDTO(element))
				.collect(Collectors.toList());
	}

	public Product_OrderDTO getProductOrderById(Long id) {
		return mapper.entityToProductOrderDTO(
				proOrdRepo.findById(id).orElseThrow(() -> new NotFoundException("Product Order", id)));
	}

	public List<Product_OrderDTO> getOrderProductsOfOrder(Long order_id) {
		return proOrdRepo.findProductOrderByOrderId(order_id).stream()
				.map((element) -> mapper.entityToProductOrderDTO(element)).collect(Collectors.toList());
	}

	public List<Product_OrderDTO> getOrderProductsOfProduct(Long productId) {
		return proOrdRepo.findProductOrderByProductId(productId).stream()
				.map((element) -> mapper.entityToProductOrderDTO(element)).collect(Collectors.toList());
	}

	public Product_OrderDTO addProductOrder(Product_OrderDTO element) {
		Product product = productRepo.findById(element.getProduct_id())
				.orElseThrow(() -> new NotFoundException("Product", element.getProduct_id()));
		Long stock_id = stockRepository.stockSufficientQuantity(element.getQuantity(), element.getProduct_id());
		if (stock_id == null) {
			throw new LowStockException(element.getProduct_id());
		}
		Order order = orderRepo.findById(element.getOrder_id())
				.orElseThrow(() -> new NotFoundException("Order", element.getOrder_id()));
		Product_Order product_order = new Product_Order(element.getQuantity(), element.getPrice(), element.getVat(),
				order, product);
		reduceStockQuantity(stock_id, element.getQuantity());
		return mapper.entityToProductOrderDTO(proOrdRepo.save(product_order));
	}

	public Product_OrderDTO updateProduct_Order(Product_OrderDTO element, Long id) {
		Product_Order temp = proOrdRepo.findById(id).orElseThrow(() -> new NotFoundException("Product Order", id));
		Order order = orderRepo.findById(element.getOrder_id())
				.orElseThrow(() -> new NotFoundException("Order", element.getOrder_id()));
		Product product = productRepo.findById(element.getProduct_id())
				.orElseThrow(() -> new NotFoundException("Product", element.getProduct_id()));
		temp.setPrice(element.getPrice());
		temp.setQuantity(element.getQuantity());
		temp.setVat(element.getVat());
		temp.setOrder(order);
		temp.setProduct(product);
		return mapper.entityToProductOrderDTO(proOrdRepo.save(temp));
	}

	public void deleteProduct_Order(Long id) {
		if (proOrdRepo.existsById(id))
			proOrdRepo.deleteById(id);
		else
			throw new NotFoundException("Product Order", id);
	}

	private void reduceStockQuantity(Long id, int consumed) {
		Stock temp = stockRepository.findById(id).orElseThrow(() -> new NotFoundException("Stock", id));
		int newQuantity = temp.getQuantity() - consumed;
		temp.setQuantity(newQuantity);
		stockRepository.save(temp);
	}
}
