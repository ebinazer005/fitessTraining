package com.example.fitnesstraining.userrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitnesstraining.userentity.DashboardImageEntity;

public interface DashBoardImageRepo extends JpaRepository<DashboardImageEntity, Long> {

}
