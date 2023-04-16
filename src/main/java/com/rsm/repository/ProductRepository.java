package com.rsm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rsm.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
