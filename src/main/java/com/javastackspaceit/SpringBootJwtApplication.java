package com.javastackspaceit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javastackspaceit.repository.UserRepository;

@SpringBootApplication
public class SpringBootJwtApplication {
	@Autowired
	UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtApplication.class, args);
	}

	
}
