package com.example.fitnesstraining.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.fitnesstraining.userentity.UserEntity;
import com.example.fitnesstraining.userrepo.Repo;

@Service
public class UserService {

	@Autowired
	private Repo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
		public String Home() {
			return "home";
		}
	
		
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
		
	public List<UserEntity> SigninDatas() {
		return repo.findAll();
	}
	
}

