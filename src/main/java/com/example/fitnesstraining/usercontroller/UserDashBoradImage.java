package com.example.fitnesstraining.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.fitnesstraining.userentity.DashboardImageEntity;
import com.example.fitnesstraining.userservice.DashBoardImageService;

@RestController
public class UserDashBoradImage {
	
	@Autowired
		private DashBoardImageService dashBoardImageService;
	
	@PostMapping("insertimage/{dashboardId}")
	
	public ResponseEntity<String> insertImage(@PathVariable long dashboardId, @RequestParam("image") MultipartFile file){
		
		try {
			DashboardImageEntity dashImage = dashBoardImageService.saveImage(dashboardId, file.getOriginalFilename(), file.getBytes());
			
			return ResponseEntity.ok("image insert successfully " +dashImage.getId());
			
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("something went wront "+ e.getMessage());
		}
		
	}
	

}
