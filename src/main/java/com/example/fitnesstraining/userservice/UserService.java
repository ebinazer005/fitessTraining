package com.example.fitnesstraining.userservice;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.fitnesstraining.userentity.UserEntity;
import com.example.fitnesstraining.userrepo.Repo;

@Service
public class UserService {

	@Autowired
	private Repo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	//home
		public String Home() {
			return "home";
		}
	
		
//		signin
		public String SigninDetails (String email, String name, String password,String role) {
			UserEntity existingUser = repo.findByEmail(email);
			 if (existingUser != null) {
				 return "email alread Exist : " + email;
			 }
			 UserEntity signin =new UserEntity(email,name,password,role);
			signin.setPassword(passwordEncoder.encode(signin.getPassword())); 
			 repo.save(signin);
			 return "success";
	}
		
//fetch the data
	public List<UserEntity> SigninDatas() {
		return repo.findAll();
	}
	
//login
	public ResponseEntity<String> login(UserEntity user) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return ResponseEntity.ok("success");
			
			
		}  catch (BadCredentialsException | InternalAuthenticationServiceException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("UserName or Password wrong");
		}  catch (AuthenticationException e) {
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UserName or Password wrong");
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
		}
	}
	
}

		
		
	

