package com.rk.enquirystock.productenquiryservice.bean;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductEnquiryBean {
	private Long id;
	private String productName;
	private BigDecimal productPrice;
	private String productAvailability;
	private double discountOffer;

	private int unit;
	private double totalPrice;
	
	private int port;

}
