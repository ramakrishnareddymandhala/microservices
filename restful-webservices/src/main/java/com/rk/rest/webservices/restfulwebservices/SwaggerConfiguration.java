package com.rk.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sun.xml.bind.v2.schemagen.xmlschema.Appinfo;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@SuppressWarnings("deprecation")
	private static final ApiInfo Appinfo = new ApiInfo("REST RK API", "", "1.0", "", "", "", "");

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(Appinfo);
	}

}
