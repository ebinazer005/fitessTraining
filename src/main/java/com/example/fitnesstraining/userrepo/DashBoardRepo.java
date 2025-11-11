package com.example.fitnesstraining.userrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitnesstraining.userentity.DashboardEntity;

public interface DashBoardRepo extends JpaRepository<DashboardEntity, Long> {
	

}
