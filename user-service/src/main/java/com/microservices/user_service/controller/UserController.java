package com.microservices.user_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.user_service.modal.LoginRequest;
import com.microservices.user_service.util.JwtUtil;

@RestController
@RequestMapping("/users")
public class UserController {

    private JwtUtil jwtUtil = new JwtUtil();
    
    
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
    	System.out.println("Inside login method with request: " + loginRequest);
    	 if (loginRequest.getUsername().equals("admin") &&
    			 loginRequest.getPassword().equals("admin")) {

    	            return jwtUtil.generateToken(loginRequest.getUsername(), loginRequest.getRole());	
    	        }
			 return "Invalid credentials";
	}
    
	@GetMapping
	public String getUsers() {
		return "User service is running!";
	}
	
}
