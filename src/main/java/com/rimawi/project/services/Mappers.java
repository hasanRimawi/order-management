package com.rimawi.project.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.rimawi.project.DTOs.CustomerDTO;
import com.rimawi.project.DTOs.OrderDTO;
import com.rimawi.project.DTOs.ProductDTO;
import com.rimawi.project.DTOs.Product_OrderDTO;
import com.rimawi.project.DTOs.StockDTO;
import com.rimawi.project.entity.Customer;
import com.rimawi.project.entity.Order;
import com.rimawi.project.entity.Product;
import com.rimawi.project.entity.Product_Order;
import com.rimawi.project.entity.Stock;

@Service
public class Mappers {

	public CustomerDTO entityToCustomerDTO(Customer customer) {
		CustomerDTO temp = new CustomerDTO();
		temp.setBornAt(customer.getBornAt());
		temp.setFirstName(customer.getFirstName());
		temp.setLastName(customer.getLastName());
		temp.setId(customer.getId());
		temp.setUsername(customer.getUsername());
		return temp;
	}

	public Customer customerDtoToEntity(CustomerDTO customer) {
		Customer temp = new Customer();
		temp.setBornAt(customer.getBornAt());
		temp.setFirstName(customer.getFirstName());
		temp.setLastName(customer.getLastName());
		temp.setUsername(customer.getUsername());
		temp.setPassword(customer.getPassword());
		return temp;
	}

	public OrderDTO entityToOrderDTO(Order order) {
		OrderDTO temp = new OrderDTO();
		temp.setCustomer_id(order.getCustomer().getId());
		temp.setOrderedAt(order.getOrderedAt());
		temp.setId(order.getId());
		return temp;
	}

	public Product_OrderDTO entityToProductOrderDTO(Product_Order element) {
		Product_OrderDTO temp = new Product_OrderDTO();
		temp.setId(element.getId());
		temp.setOrder_id(element.getOrder().getId());
		temp.setPrice(element.getPrice());
		temp.setProduct_id(element.getProduct().getId());
		temp.setQuantity(element.getQuantity());
		temp.setVat(element.getVat());
		return temp;
	}

	public ProductDTO entityToProductDTO(Product product) {
		ProductDTO temp = new ProductDTO();
		temp.setId(product.getId());
		temp.setName(product.getName());
		temp.setPrice(product.getPrice());
		temp.setReference(product.getReference());
		temp.setSlug(product.getSlug());
		temp.setStockable(product.isStockable());
		temp.setVat(product.getVat());
		return temp;
	}

	public Product productDtoToEntity(ProductDTO product) {
		Product temp = new Product();
		temp.setName(product.getName());
		temp.setPrice(product.getPrice());
		temp.setReference(product.getReference());
		temp.setSlug(product.getSlug());
		temp.setStockable(product.isStockable());
		temp.setVat(product.getVat());
		return temp;
	}

	public StockDTO entityToStockDTO(Stock stock) {
		StockDTO temp = new StockDTO();
		temp.setId(stock.getId());
		temp.setProductStock_id(stock.getProductStock().getId());
		temp.setQuantity(stock.getQuantity());
		temp.setUpdatedAt(LocalDateTime.now());
		return temp;
	}
}
