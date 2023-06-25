package com.rimawi.project.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimawi.project.DTOs.CustomerDTO;
import com.rimawi.project.entity.Customer;
import com.rimawi.project.exceptions.NotFoundException;
import com.rimawi.project.repositories.CustomerRepository;
@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private Mappers mapper;

	public CustomerDTO getCustomerById(Long id) {
		Customer temp = customerRepo.findById(id).orElseThrow(() -> new NotFoundException("Customer", id));
		return mapper.entityToCustomerDTO(temp);
	}

	public List<CustomerDTO> getAllCustomers() {
		return customerRepo.findAll().stream().map((x) -> mapper.entityToCustomerDTO(x)).collect(Collectors.toList());
	}

	public CustomerDTO addCustomer(CustomerDTO customer) {
		Customer temp = mapper.customerDtoToEntity(customer);
		return mapper.entityToCustomerDTO(customerRepo.save(temp));
	}

	public void deleteCustomer(Long id) {
		if (customerRepo.existsById(id))
			customerRepo.deleteById(id);
		else
			throw new NotFoundException("Customer", id);
	}

	public CustomerDTO updateCustomer(CustomerDTO customer, Long id) {
		Customer temp = customerRepo.findById(id).orElseThrow(() -> new NotFoundException("Customer", id));
		temp.setBornAt(customer.getBornAt());
		temp.setFirstName(customer.getFirstName());
		temp.setLastName(customer.getLastName());
		return mapper.entityToCustomerDTO(customerRepo.save(temp));
	}

}
