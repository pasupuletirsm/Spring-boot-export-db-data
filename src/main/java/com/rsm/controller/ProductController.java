package com.rsm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rsm.dto.ProductDto;
import com.rsm.service.ProductService;

@RestController
public class ProductController {

	Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService service;

	@PostMapping("/save")
	public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto dto) {
		log.info("Product name {}", dto.getProductName());

		service.saveProduct(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
