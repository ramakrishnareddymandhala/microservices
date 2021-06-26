package com.rk.springapigateway.springcloudapigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {
	
//	@GetMapping("/productServiceFallback")
//	public String productServiceFallBack() {
//		return "Prodcut Service is taking longer";
//	}

	@GetMapping("/enquiryServiceFallback")
	public String enquiryServiceFallBack() {
		return "Enquiry Service is taking longer";
	}
}
