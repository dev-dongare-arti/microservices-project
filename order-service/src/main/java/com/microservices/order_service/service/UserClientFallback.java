package com.microservices.order_service.service;

import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {

	@Override
	public String getUsers() {
		System.out.println("User service is down. Returning fallback response.");
		return "User service is currently unavailable. Please try again later.";
	}

}
