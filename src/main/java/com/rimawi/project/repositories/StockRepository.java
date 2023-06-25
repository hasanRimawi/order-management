package com.rimawi.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rimawi.project.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
	@Query(value = "SELECT * FROM stock o WHERE o.product_id = :productId", nativeQuery = true)
	public List<Stock> findStockByProductId(@Param("productId") Long productId);
}
