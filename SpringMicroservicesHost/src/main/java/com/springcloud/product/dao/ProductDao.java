package com.springcloud.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.product.entity.Product;
import com.springcloud.product.entity.ProductResponse;
import com.springcloud.product.repository.ProductRepository;



@Repository("productDao")

public class ProductDao {
		
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public List getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}
	
	
	

	@HystrixCommand(fallbackMethod="fallback_getProductByCode", commandProperties= {
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3500"),
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="60")
	})
	public Product getProductByCode(String code) {
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		// TODO Auto-generated method stub
		Product temporaryProduct = productRepository.findByProductCode(code);
		//log.info("Product code: " + temporaryProduct.toString());
		if(temporaryProduct != null) {
			//log.info("Get inventory status for product code: " + code);
			String url = "http://inventory-service/api/inventory/"+code; //http://localhost:9995/api/inventory/P002
			//log.info("URL: " + url);
			ResponseEntity<ProductResponse> responseProduct = restTemplate.getForEntity(url, ProductResponse.class);
			//log.info("Response Product: " + responseProduct.toString());
			
			if(responseProduct.getStatusCode() == HttpStatus.OK) {
				//log.info("Available Quantity: " + responseProduct.getBody().getQuantity());
				if(responseProduct.getBody().getQuantity() > 0 ) {
					temporaryProduct.setStockStatus(true);
				}else {
					temporaryProduct.setStockStatus(false);
				}
			}else {
				//log.error("Not able to get response for " + code);
				//log.error("Error Status Code: " + responseProduct.getStatusCodeValue());
			}
			
		}
		
		
		return temporaryProduct;
	}
	
	Product fallback_getProductByCode(String code) {
		//log.info("Fall back method in action for getProductByCode for :" + code);
		Product pr = new Product();
		pr.setProductCode(code);
		pr.setName("Not Found");
		pr.setStockStatus(false);
		pr.setDescription("Not Found");
		pr.setPrice(0);
		
		return pr;
	}
	
	

}
