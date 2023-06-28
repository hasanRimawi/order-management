package com.rimawi.project.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rimawi.project.DTOs.CustomerDTO;
import com.rimawi.project.entity.Customer;
import com.rimawi.project.exceptions.NotFoundException;
import com.rimawi.project.exceptions.UserNameUsedException;
import com.rimawi.project.repositories.CustomerRepository;

@Service
public class CustomerService implements UserDetailsService {
	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private PasswordEncoder bcrypt;

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
		if (customerRepo.findByUsername(customer.getUsername()) != null) {
			throw new UserNameUsedException(customer.getUsername());
		}
		Customer temp = mapper.customerDtoToEntity(customer);
		temp.setPassword(bcrypt.encode(temp.getPassword()));
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

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Customer x = customerRepo.findByUsername(username);
		if (x == null) {
			throw new UsernameNotFoundException(username);
		} else {
			return x;
		}
	}
}
