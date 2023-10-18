package org.java.services;

import java.util.List;
import java.util.Optional;

import org.java.pojo.Photo;
import org.java.repos.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {
	
	@Autowired
	private PhotoRepo photoRepo;
	
	public Photo save(Photo photo) {
		
		return photoRepo.save(photo);
	}
	
	public List<Photo> findAll() {
		
		return photoRepo.findAll();
	}
	
	public List<Photo> findByTitle(String title) {
		
		return photoRepo.findByTitleContaining(title);
	}
	
	public Optional<Photo> findById(Long id) {
		
		return photoRepo.findById(id);
	}
	
	public void deleteById(Long id) {
		photoRepo.deleteById(id);
	}
	
	public void updatePhoto(Photo photo) {
		
		Long id = photo.getId();
		Photo photoToUpdate = photoRepo.findById(id).get();

		photoRepo.save(photoToUpdate);
	}
}
