package com.taskmanager.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Data;

@Data
@Component
public class JwtUtils {

	// Minimum 32 Characters
	private static String SECRET_KEY = "My_Secrete_Key_12345678901234567";
	// This two fields are taken as non static as it is unique for each user
	private final SecretKey jwtSecret = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
	private final Long expTime = 86400000l; // day

	// This method helps to generate token
	public String generateToken(String username) {

		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expTime))
				.signWith(jwtSecret, SignatureAlgorithm.HS256).compact();
	}

	// We need to design method to extract username from the token
	public String getUserName(String token) {
		return Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token).getBody().getSubject();
	}
	
	// Validate the token
	public Boolean validatToken(String token) {
		Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJwt(token);
		return true;
	}
}
