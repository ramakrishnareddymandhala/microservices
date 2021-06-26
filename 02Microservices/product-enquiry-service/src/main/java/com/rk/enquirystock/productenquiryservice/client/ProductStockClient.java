package com.rk.enquirystock.productenquiryservice.client;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rk.enquirystock.productenquiryservice.bean.ProductEnquiryBean;

//@FeignClient(name="product-stock-service",url = "localhost:8800")
@FeignClient(name="product-stock-service",fallback = ProductStockClient.ProducStockClientImpl.class)
public interface ProductStockClient {

	
	@GetMapping("/check-product-stock/productName/{productName}/productavailability/{productAvailability}")
	public ProductEnquiryBean checkProductStatus(@PathVariable String productName,
			@PathVariable String productAvailability);
	
	@Component
	class ProducStockClientImpl implements ProductStockClient{

		@Override
		public ProductEnquiryBean checkProductStatus(String productName, String productAvailability) {
			return new ProductEnquiryBean(0L, productName,  new BigDecimal(0), productAvailability, 0, 0, 0, 0);
		}
		
	}
}
