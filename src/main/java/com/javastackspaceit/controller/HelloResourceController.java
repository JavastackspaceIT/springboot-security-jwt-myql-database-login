package com.javastackspaceit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javastackspaceit.dto.AuthRequest;
import com.javastackspaceit.util.JwtUtil;

@RestController
public class HelloResourceController {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping(value = "/")
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
	
	public String add() {}
}
