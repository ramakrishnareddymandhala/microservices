package com.rk.enquirystock.productenquiryservice.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rk.enquirystock.productenquiryservice.bean.ProductEnquiryBean;
import com.rk.enquirystock.productenquiryservice.client.ProductStockClient;

@RestController
public class StockEnquiryController {

	
	@Autowired
	ProductStockClient stockClient;
	
	@GetMapping("/product-enquiry/name/{name}/availability/{availability}/unit/{unit}")
	public ProductEnquiryBean getEnquiryOfProduct(@PathVariable String name,
													@PathVariable String availability,
													@PathVariable int unit) {
		
		ProductEnquiryBean enquiryBean = stockClient.checkProductStatus(name, availability);
		BigDecimal.valueOf(20).divide(BigDecimal.valueOf(100), 1, RoundingMode.HALF_UP);
		double unitDouble = unit;
		double totalPrice = enquiryBean.getProductPrice().doubleValue() * unitDouble;
		double discount = enquiryBean.getDiscountOffer();
		double discountedPrice = totalPrice - totalPrice * discount/100;;
		
		return new ProductEnquiryBean(enquiryBean.getId(), name, enquiryBean.getProductPrice(), availability, enquiryBean.getDiscountOffer(), unit, discountedPrice, enquiryBean.getPort());
	}
}
