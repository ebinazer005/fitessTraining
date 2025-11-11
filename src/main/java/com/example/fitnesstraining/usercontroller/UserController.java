package com.example.fitnesstraining.usercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fitnesstraining.userentity.UserEntity;
import com.example.fitnesstraining.userrepo.Repo;
import com.example.fitnesstraining.userservice.UserService;

import ch.qos.logback.core.net.LoginAuthenticator;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {
	
	@Autowired
	private UserService userservice;
	
	
	
	@PostMapping("/home")
	
	public String Home() {
		
		String response = userservice.Home();
		return response;
	}
	
	@GetMapping("/sign")
	public String SigninData(@RequestParam String email,@RequestParam String name ,@RequestParam String password,@RequestParam String role ) {
		 String responce =userservice.SigninDetails(email,name,password,role);
		 return responce;
		 
	}
	
	@PostMapping("/UserLogin")
	public ResponseEntity<String> login (@RequestBody UserEntity user) {
		return userservice.login(user);
	}
	
	
	@GetMapping("/Userdatas")
	
	public List<UserEntity> SigninDatas() {
		return userservice.SigninDatas();
	}
	
	@GetMapping("/demo")
	public String demo() {
		return "ebinzer";
	}
	

		

	

}
