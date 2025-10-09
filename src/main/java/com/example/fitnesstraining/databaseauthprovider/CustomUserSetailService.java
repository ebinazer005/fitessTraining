package com.example.fitnesstraining.databaseauthprovider;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.fitnesstraining.userentity.UserEntity;
import com.example.fitnesstraining.userrepo.Repo;

@Component
public class CustomUserSetailService implements UserDetailsService {
	
		@Autowired
			
		private Repo repo;

//		@Override
//		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//			UserEntity user = repo.findByName(username);
//			
//			return new User(user.getName() ,user.getPassword(),Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().toUpperCase())));
//		}
		
		@Override
		public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			UserEntity user = repo.findByEmail(email);
			
			return new User(user.getEmail() ,user.getPassword(),Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().toUpperCase())));
		}
		
		
		

}
