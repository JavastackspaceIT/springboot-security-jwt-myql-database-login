package com.javastackspaceit.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javastackspaceit.dto.AuthRequest;
import com.javastackspaceit.model.User;
import com.javastackspaceit.repository.UserRepository;
import com.javastackspaceit.util.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloResourceController {

	@Autowired
	private UserRepository userRepository;
	private @Autowired AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping(value = "/hello")
	public String hello() {

		return " Hello world";
	}

	@PostMapping(value = "/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

		} catch (Exception exception) {
			throw new Exception("Invalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());

	}

 @DeleteMapping(value = "/delete")
	public String delete() {
		return " delete method";
	}
	@GetMapping("/user/{userName}")
	public User getUser(@PathVariable("userName") final String userName) {
		User userData = null;
		Optional<User> user = userRepository.findByUserName(userName);
		if (user.isPresent()) {
			userData = user.get();
		}
		return userData;
	}

	@PostMapping(value="/signup")
	public User signUpUser(User user) {
		return userRepository.save(user);
	}
}
