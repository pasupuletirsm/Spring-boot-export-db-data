package com.rsm.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String productName;
	private Double price;

	ProductDto() {

	}

	ProductDto(String productName, Double price) {
		this.productName = productName;
		this.price = price;
	}
	
	ProductDto(String productName, Double price, Long id) {
		super();
		this.id =id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
