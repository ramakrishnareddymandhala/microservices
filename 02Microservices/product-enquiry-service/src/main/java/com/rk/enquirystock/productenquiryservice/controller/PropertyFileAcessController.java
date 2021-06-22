package com.rk.enquirystock.productenquiryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.enquirystock.productenquiryservice.bean.PropertyAccessValue;
import com.rk.enquirystock.productenquiryservice.bean.PropertyAcessBean;


@RestController
@RequestMapping("/access")
public class PropertyFileAcessController {
	
	@Autowired
	PropertyAcessBean accessBean;
	
	@GetMapping("accessPropertyFile")
	public PropertyAccessValue getAccessPropertyFile() {
		return new PropertyAccessValue(accessBean.getName(),accessBean.getDescription());
	}
	
	
}
