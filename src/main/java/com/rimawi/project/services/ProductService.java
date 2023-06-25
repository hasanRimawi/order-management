package com.rimawi.project.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimawi.project.DTOs.ProductDTO;
import com.rimawi.project.entity.Product;
import com.rimawi.project.exceptions.NotFoundException;
import com.rimawi.project.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private Mappers mapper;

	public List<ProductDTO> getAllProducts() {
		return productRepo.findAll().stream().map((product) -> mapper.entityToProductDTO(product))
				.collect(Collectors.toList());
	}

	public ProductDTO getProductById(Long id) {
		return mapper
				.entityToProductDTO(productRepo.findById(id).orElseThrow(() -> new NotFoundException("Product", id)));
	}

	public ProductDTO addProduct(ProductDTO product) {
		return mapper.entityToProductDTO(productRepo.save(mapper.productDtoToEntity(product)));
	}

	public ProductDTO updateProduct(ProductDTO product, Long id) {
		Product temp = productRepo.findById(id).orElseThrow(() -> new NotFoundException("Product", id));
		temp.setName(product.getName());
		temp.setPrice(product.getPrice());
		temp.setReference(product.getReference());
		temp.setSlug(product.getSlug());
		temp.setStockable(product.isStockable());
		temp.setVat(product.getVat());
		return mapper.entityToProductDTO(productRepo.save(temp));
	}

	public void deleteProduct(Long id) {
		if (productRepo.existsById(id))
			productRepo.deleteById(id);
		else
			throw new NotFoundException("Prodcut", id);
	}
}
