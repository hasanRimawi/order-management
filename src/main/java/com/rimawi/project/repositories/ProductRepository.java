package com.rimawi.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rimawi.project.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
