package com.example.fitnesstraining.usercontroller;


import java.security.PublicKey;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fitnesstraining.jwtutill.JwtUtill;
import com.example.fitnesstraining.userentity.UserEntity;

@RestController

public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtill jwtUtill;
	
	
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody UserEntity user) {
		
			try {
				Authentication authentication	= authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
					
					UserDetails userDetails = (UserDetails) authentication.getPrincipal();
					String token = jwtUtill.generateToken(userDetails);
					return ResponseEntity.ok(Map.of("token" ,token));
				
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("Error","Invalid username or password"));
			}

			

		
	}
	
	

}