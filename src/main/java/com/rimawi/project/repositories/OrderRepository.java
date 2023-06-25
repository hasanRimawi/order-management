package com.rimawi.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rimawi.project.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	@Query(value = "SELECT * FROM order_table o WHERE o.customer_id = :customer_id", nativeQuery = true)
	public List<Order> findOrderByCustomerId(@Param("customer_id") Long customerId);
}
