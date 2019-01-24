package com.springcloud.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.product.entity.Product;
import com.springcloud.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("")
	public List getAllProducts() {
		return productService.getAllProducts();
	}
	
	@RequestMapping("/{code}")
	public Product getProductByCode(@PathVariable String code) {
		return productService.getProductByCode(code);
	}

}
