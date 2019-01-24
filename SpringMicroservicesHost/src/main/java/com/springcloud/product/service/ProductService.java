package com.springcloud.product.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.product.dao.ProductDao;
import com.springcloud.product.entity.Product;

@Service("productService")
public class ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Transactional
	public List getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts();
	}

	@Transactional
	public Product getProductByCode(String code) {
		// TODO Auto-generated method stub
		return productDao.getProductByCode(code);
	}

}
