package com.example.fitnesstraining.userrepo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitnesstraining.userentity.UserEntity;


public interface Repo extends JpaRepository<UserEntity ,Long> {
	
	UserEntity findByEmail(String email);
	UserEntity findByName(String name);
}
