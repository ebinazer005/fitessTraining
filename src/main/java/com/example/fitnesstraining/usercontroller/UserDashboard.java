package com.example.fitnesstraining.usercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.fitnesstraining.userdto.DashBoardDTO;
import com.example.fitnesstraining.userentity.DashboardEntity;
import com.example.fitnesstraining.userservice.DashboardContent;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserDashboard {
	
	@Autowired 
	private DashboardContent dashboardContent;
	
	@PostMapping("/dashboardContent")
	
	public DashboardEntity createdash(@RequestBody DashboardEntity dashboardEntity) {
		return dashboardContent.createDashBoardContent(dashboardEntity);
	}
	
    @GetMapping("/getBashbordData")
    public List<DashBoardDTO> getDashBordData() {
        List<DashboardEntity> dashboards = dashboardContent.fetchDashBoradContent();
        return dashboards.stream()
                         .map(DashBoardDTO::new)
                         .toList();
    }
}
