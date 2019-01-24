package com.springcloud.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcloud.product.entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{
	Product findByProductCode(String productCode);
}
