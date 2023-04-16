package com.rsm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.rsm.dto.ProductDto;
import com.rsm.entity.Product;
import com.rsm.repository.ProductRepository;

@Service
public class ProductService {

	Logger log = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	ProductRepository repository;

	public void saveProduct(@RequestBody ProductDto dto) {
		log.info("Product name {}", dto.getProductName());
		Product product = new Product();
		product.setProductName(dto.getProductName());
		product.setPrice(dto.getPrice());
		product = repository.save(product);
		log.info("Product saved with Id {}", product.getId());

	}

}
