package com.microservices.order_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="USER-SERVICE", fallback = UserClientFallback.class)
public interface UserClient {
	

	@GetMapping("/users")
	String getUsers();
}
