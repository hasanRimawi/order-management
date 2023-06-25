package com.rimawi.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rimawi.project.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
