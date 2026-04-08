package com.micoservices.api_gateway.util;

import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

	 private String secret = "mysecretkeymysecretkeymysecretkey12";
	
	 public void validateToken(String token) {
	        Jwts.parser()
	                .setSigningKey(secret.getBytes())
	                .parseClaimsJws(token);
	    }
	 
	 //To read role from jwt payload
	 public Claims getClaims(String token) {
		 return Jwts.parser()
				 .setSigningKey(secret.getBytes())
				 .parseClaimsJws(token)
				 .getBody();
		 
	 }
}
