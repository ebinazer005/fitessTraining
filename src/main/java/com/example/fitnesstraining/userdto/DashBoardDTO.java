package com.example.fitnesstraining.userdto;

import java.util.Base64;

import com.example.fitnesstraining.userentity.DashboardEntity;
import com.example.fitnesstraining.userentity.DashboardImageEntity;

public class DashBoardDTO {
	 private long id;
	    private String name;
	    private String muscle;
	    private String equipment;
	    private String difficulty;
	    private String instruction;
	    private String imageName;
	    private String imageBase64;

	   
	    public DashBoardDTO() {}

	    
	    public DashBoardDTO(DashboardEntity entity) {
	        this.id = entity.getId();
	        this.name = entity.getName();
	        this.muscle = entity.getMuscle();
	        this.equipment = entity.getEquipment();
	        this.difficulty = entity.getDifficulty();
	        this.instruction = entity.getInstruction();

	        DashboardImageEntity imageEntity = entity.getImage();
	        if (imageEntity != null) {
	            this.imageName = imageEntity.getImageName();

	            if (imageEntity.getImageData() != null) {
	                this.imageBase64 = Base64.getEncoder()
	                                         .encodeToString(imageEntity.getImageData());
	            }
	        }
	    }


	    public long getId() { return id; }
	    public void setId(long id) { this.id = id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getMuscle() { return muscle; }
	    public void setMuscle(String muscle) { this.muscle = muscle; }

	    public String getEquipment() { return equipment; }
	    public void setEquipment(String equipment) { this.equipment = equipment; }

	    public String getDifficulty() { return difficulty; }
	    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

	    public String getInstruction() { return instruction; }
	    public void setInstruction(String instruction) { this.instruction = instruction; }

	    public String getImageName() { return imageName; }
	    public void setImageName(String imageName) { this.imageName = imageName; }

	    public String getImageBase64() { return imageBase64; }
	    public void setImageBase64(String imageBase64) { this.imageBase64 = imageBase64; }
}



