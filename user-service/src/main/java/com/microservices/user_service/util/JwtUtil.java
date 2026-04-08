package com.microservices.user_service.util;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

	 private String secret = "mysecretkeymysecretkeymysecretkey12";

	public String generateToken(String username, String role) {
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.claim("role", role) // Add role claim
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
				.signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
				.compact();
		
	}
}
