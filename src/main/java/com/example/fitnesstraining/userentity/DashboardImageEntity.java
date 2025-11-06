package com.example.fitnesstraining.userentity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DashboardImage")
public class DashboardImageEntity {
	
		@Id
		private long id;
		private String imageName;
		
		@Lob
		@Column(columnDefinition = "LONGBLOB")
		private byte[] imageData;
		
		@OneToOne
		@MapsId
		@JoinColumn(name = "id")
		
		private DashboardEntity dashboard;
		
		public DashboardImageEntity() {
			
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getImageName() {
			return imageName;
		}

		public void setImageName(String imageName) {
			this.imageName = imageName;
		}

		public byte[] getImageData() {
			return imageData;
		}

		public void setImageData(byte[] imageData) {
			this.imageData = imageData;
		}

		public DashboardEntity getDashboard() {
			return dashboard;
		}

		public void setDashboard(DashboardEntity dashboard) {
			this.dashboard = dashboard;
		}
		
		
		
		
		
		
}
