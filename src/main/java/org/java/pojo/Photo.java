package org.java.pojo;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column
	@Length(min = 3, max = 255, message = "il titolo deve avere un minimo di 3 caratteri ed un massimo di 255")
	private String title;
	
	@Column
	@Length(min = 3, max = 65535, message = "La descrizione deve avere un minimo di 3 caratteri ")
	private String description;
	
	@Column
	@Length(min = 3, max = 255, message = "Devi inserire anche la foto")
	private String photoUrl;
	
	@Column
	private boolean visible;
	
	public Photo() {}
	public Photo(String title, String description, String photoUrl, boolean visible ) {
		
		setDescription(description);
		setId(id);
		setPhotoUrl(photoUrl);
		setTitle(title);
		setVisible(visible);
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	@Override
	public String toString() {
		
		return "Title: " + getTitle() + "\n"
			 + "Description: " +  getDescription() + "\n"
			 + "Visible: " +  (visible ? "true" : "false");
	}
}
