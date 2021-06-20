package com.rk.propaccessservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.propaccessservice.beans.PropertyAccessValue;
import com.rk.propaccessservice.beans.PropertyAcessBean;

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
