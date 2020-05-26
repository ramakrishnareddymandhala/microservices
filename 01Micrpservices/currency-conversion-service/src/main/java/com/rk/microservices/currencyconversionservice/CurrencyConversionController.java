package com.rk.microservices.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeProxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
	
		CurrencyConversionBean res =  currencyExchangeProxy.retrieveExchangeValue(from, to);
		return new CurrencyConversionBean(1L,from,to,res.getConversionMultiple(),quantity,
				quantity.multiply(res.getConversionMultiple()),res.getPort());
	}
}
