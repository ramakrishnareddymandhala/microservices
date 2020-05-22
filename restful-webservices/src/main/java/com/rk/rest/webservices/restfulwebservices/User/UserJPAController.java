package com.rk.rest.webservices.restfulwebservices.User;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAController {
	
	@Autowired
	private UserRepository userService;
	
	@Autowired
	private PostRepository postService;
	
	
	@GetMapping("/jpa/users")
	public List<User> getAllUsers() {
		return userService.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public User getUser(@PathVariable int id) {
		Optional<User> user=  userService.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		return user.get();
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);
		URI location= ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.build(savedUser.getId());
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteById(id);
		
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getPosts(@PathVariable int id) {
		Optional<User> user=  userService.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		User userObj =  user.get();
		return userObj.getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> savePost(@PathVariable int id,@RequestBody Post post) {
		Optional<User> user=  userService.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		User userObj =  user.get();
		post.setUser(userObj);
		Post savedPost = postService.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(savedPost.getId());
		return ResponseEntity.created(location).build();
	}
}