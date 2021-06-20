package com.rk.productstock.productstockservice.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "product_stock")
@Data
@Getter
@Setter
public class ProductStock {

	@Id
	private Long id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_price")
	private BigDecimal productPrice;
	
	@Column(name="product_availability")
	private String productAvailability;
	
	@Column(name="product_discountoffer")
	private double discountOffer;
	
	
}
