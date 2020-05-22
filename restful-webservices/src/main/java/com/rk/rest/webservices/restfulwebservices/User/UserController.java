package com.rk.rest.webservices.restfulwebservices.User;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService userService;
	
	@Autowired
	private MessageSource messgeSource;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		User user=  userService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("User not found");
		}
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);
		URI location= ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.build(savedUser.getId());
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userService.deleteById(id);
		if(user == null) {
			throw new UserNotFoundException("User not found");
		}
	}
	
	@GetMapping("/hello")
	public String sayHello(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		return messgeSource.getMessage("good.morning.message", null,locale);
	}
}
