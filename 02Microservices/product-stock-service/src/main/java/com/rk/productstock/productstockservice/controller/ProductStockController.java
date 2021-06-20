package com.rk.productstock.productstockservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rk.productstock.productstockservice.bean.ProductStockBean;
import com.rk.productstock.productstockservice.entity.ProductStock;
import com.rk.productstock.productstockservice.entity.ProductStockRepository;

@RestController
public class ProductStockController {
	
	@Autowired
	ProductStockRepository stockRepo;
	
	@Autowired
	Environment environment;
	
	@GetMapping("/check-product-stock/productName/{productName}/productavailability/{productAvailability}")
	public ProductStockBean checkProductStatus(@PathVariable String productName,
			@PathVariable String productAvailability) {
		
		ProductStock stockObj=  stockRepo.findByProductNameAndProductAvailability(productName, productAvailability);
		ProductStockBean stockBean = new ProductStockBean(
				stockObj.getId(),
				stockObj.getProductName(),
				stockObj.getProductPrice(),
				stockObj.getProductAvailability(),
				stockObj.getDiscountOffer(),
				Integer.parseInt(environment.getProperty("local.server.port")));
		
		return stockBean;
	}

}
