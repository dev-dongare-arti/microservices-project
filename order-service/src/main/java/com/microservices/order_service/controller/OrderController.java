package com.microservices.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.order_service.service.UserClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	UserClient userClient;
//Service communication using rest template	
//	@GetMapping
//	public String getOrders() {
//	//	return "Order service is running!";
//		   String userResponse = restTemplate.getForObject(
//	                "http://USER-SERVICE/users",
//	                String.class
//	        );
//	return "Order service: "+userResponse;
//	}
	
	

	@GetMapping
	public String getOrders() {
	    System.out.println("Calling user service from order service...");
	    return "Order service with feign client: " + userClient.getUsers();
	}
	
	
//	public String orderServiceFallback(Throwable t) {
//	    return "Order service + user Service is currently down.";
//	}
}
