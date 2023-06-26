package com.rimawi.project.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimawi.project.DTOs.OrderDTO;
import com.rimawi.project.entity.Customer;
import com.rimawi.project.entity.Order;
import com.rimawi.project.exceptions.NotFoundException;
import com.rimawi.project.repositories.CustomerRepository;
import com.rimawi.project.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private Mappers mapper;

	public OrderDTO getOrderById(Long id) {
		Order temp = orderRepo.findById(id).orElseThrow(() -> new NotFoundException("Order", id));
		return mapper.entityToOrderDTO(temp);
	}

	public List<OrderDTO> getAllOrders() {
		return orderRepo.findAll().stream().map((order) -> mapper.entityToOrderDTO(order)).collect(Collectors.toList());
	}

	public OrderDTO addOrder(OrderDTO order) {
		Customer customer = customerRepo.findById(order.getCustomer_id())
				.orElseThrow(() -> new NotFoundException("Customer", order.getCustomer_id()));
		Order newOrder = new Order(LocalDateTime.now(), customer);
		return mapper.entityToOrderDTO(orderRepo.save(newOrder));
	}

	public List<OrderDTO> getCustomerOrders(Long customer_id) {
		if (customerRepo.existsById(customer_id)) {
			return orderRepo.findOrderByCustomerId(customer_id).stream().map((order) -> mapper.entityToOrderDTO(order))
					.collect(Collectors.toList());
		} else
			throw new NotFoundException("Customer", customer_id);
	}

	public void deleteOrder(Long id) {
		if (orderRepo.existsById(id))
			orderRepo.deleteById(id);
		else
			throw new NotFoundException("Order", id);
	}

}
