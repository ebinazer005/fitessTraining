package com.example.fitnesstraining.userservice;

import java.awt.Image;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.fitnesstraining.userentity.DashboardEntity;
import com.example.fitnesstraining.userentity.DashboardImageEntity;
import com.example.fitnesstraining.userrepo.DashBoardRepo;

@Service
public class DashboardContent {

	@Autowired 
	private DashBoardRepo dashBoardRepo;

	//postContent
	public DashboardEntity createDashBoardContent (DashboardEntity dashboardEntity) {
		
		return dashBoardRepo.save(dashboardEntity);
	}
	
	//getContent
	
	public List<DashboardEntity> fetchDashBoradContent(){
		return dashBoardRepo.findAll();
	}
		
	
		
	

	

}
