package com.rk.rest.webservices.restfulwebservices.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {
	
	@GetMapping("/v1/person")
	public Person personv1() {
		return new Person("RK ree");
	}

	@GetMapping("/v2/person")
	public PersonV2 personv2() {
		Name name = new Name("Rk", "mand");
		return new PersonV2(name);
	}
}
