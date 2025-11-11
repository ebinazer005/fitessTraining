package com.example.fitnesstraining.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fitnesstraining.userentity.DashboardEntity;
import com.example.fitnesstraining.userentity.DashboardImageEntity;
import com.example.fitnesstraining.userrepo.DashBoardImageRepo;
import com.example.fitnesstraining.userrepo.DashBoardRepo;

import jakarta.transaction.Transactional;

@Service
public class DashBoardImageService {
	
	@Autowired
		private DashBoardImageRepo dashBoardImageRepo;
	
	@Autowired 
		private DashBoardRepo dashBoardRepo;
	
	
	@Transactional
	public DashboardImageEntity saveImage(long dashboardId , String imageName , byte[] imageData) {
		
		DashboardEntity dashboard  = dashBoardRepo.findById(dashboardId)
				.orElseThrow(()-> new RuntimeException("id is not there in dashbordContent"+dashboardId));
		
		
		
		DashboardImageEntity imageEntity = new DashboardImageEntity();
		imageEntity.setImageName(imageName);
		imageEntity.setImageData(imageData);
		imageEntity.setDashboard(dashboard);
			
		return dashBoardImageRepo.save(imageEntity);
	}

}
