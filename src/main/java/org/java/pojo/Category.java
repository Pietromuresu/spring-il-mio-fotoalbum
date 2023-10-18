package org.java.pojo;



import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Length(min=3, max=255)
	@NotNull
	private String name;
	
	@Column
	@Length(min=3, max=65535, message = "La descrizione deve avere un minimo di 3 caratteri")
	private String description;
	
	@ManyToMany(mappedBy = "categories")
	private List<Photo> photos;
	
	

	public Category() {};
	public Category(String name, String description, Photo ...photos) {
		setName(name);
		setDescription(description);
		setId(id);
		setPhotos(Arrays.asList(photos));

	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	};
	
	
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	
	
	@Override
	public String toString() {
		
		return "Name: " + getName() + "\n";
	}
}
