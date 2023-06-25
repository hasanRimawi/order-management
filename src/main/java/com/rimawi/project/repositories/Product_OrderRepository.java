package com.rimawi.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rimawi.project.entity.Product_Order;

@Repository
public interface Product_OrderRepository extends JpaRepository<Product_Order, Long> {
	@Query(value = "SELECT * FROM product_order o WHERE o.order_table_id = :orderId", nativeQuery = true)
	public List<Product_Order> findProductOrderByOrderId(@Param("orderId") Long orderId);

	@Query(value = "SELECT * FROM product_order o WHERE o.product_id = :productId", nativeQuery = true)
	public List<Product_Order> findProductOrderByProductId(@Param("productId") Long productId);
}
