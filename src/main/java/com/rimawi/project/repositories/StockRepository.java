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

	@Query(value = "SELECT s.id FROM stock s WHERE s.quantity >= :products AND s.product_id = :productId ORDER BY s.id ASC LIMIT 1", nativeQuery = true)
	public Long stockSufficientQuantity(@Param("products") int products, @Param("productId") Long productId);
}
