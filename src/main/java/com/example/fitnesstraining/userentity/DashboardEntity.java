package com.example.fitnesstraining.userentity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dashBoradData")
public class DashboardEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String name;
	String muscle;
	String equipment;
	String difficulty;
	String instruction;
	
	
	@OneToOne(mappedBy = "dashboard",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private DashboardImageEntity imageEntity;
	
	public DashboardEntity() {}
	
	public DashboardEntity(String name, String muscle, String equipment, String difficulty, String instruction) {
		super();
		this.name = name;
		this.muscle = muscle;
		this.equipment = equipment;
		this.difficulty = difficulty;
		this.instruction = instruction;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMuscle() {
		return muscle;
	}


	public void setMuscle(String muscle) {
		this.muscle = muscle;
	}


	public String getEquipment() {
		return equipment;
	}


	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}


	public String getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}


	public String getInstruction() {
		return instruction;
	}


	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	
	public DashboardImageEntity getImage() {
		return imageEntity;
	}
	
	public void setImage(DashboardImageEntity imageEntity) {
		this.imageEntity = imageEntity;
		if (imageEntity != null) {
			imageEntity.setDashboard(this);
		}
	}
	
	
			

}
