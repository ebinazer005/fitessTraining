package com.example.fitnesstraining.usercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fitnesstraining.userentity.UserEntity;
import com.example.fitnesstraining.userrepo.Repo;
import com.example.fitnesstraining.userservice.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {
	
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
	
	@GetMapping("/datas")
	
	public List<UserEntity> SigninDatas() {
		return userservice.SigninDatas();
	}
	
	
	

}
