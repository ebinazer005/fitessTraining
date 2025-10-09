package com.example.fitnesstraining.jwtutill;


import java.security.Key;
import java.security.KeyStore.SecretKeyEntry;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtill {

		
		private static final String SECRET_KEY_String = "VOgzT1NxAzvNHqCkYFxXLiS5AuCXwg1S";
		private final SecretKey SECRET_KEY =Keys.hmacShaKeyFor(SECRET_KEY_String.getBytes());

		public String generateToken(UserDetails userdetails) {
			return Jwts.builder()
					.subject(userdetails.getUsername())
					.issuedAt(new Date())
					.expiration(new Date(System.currentTimeMillis() + 1000 * 60 *60))
					.signWith(SECRET_KEY , Jwts.SIG.HS256)
					.compact();

		}
		
		public boolean ValidateToken(String token,UserDetails userDetails) {
			return ExstractUserEmail(token).equals(userDetails.getUsername());
		}
		
		public String ExstractUserEmail(String token ) {
			return Jwts.parser()
					.verifyWith(SECRET_KEY)
					.build()
					.parseSignedClaims(token)
					.getPayload()
					.getSubject();
					
		}
}
