package org.java.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.java.pojo.Photo;
import org.java.repos.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PhotoService {
	
	@Autowired
	private PhotoRepo photoRepo;
	
	public Photo save(Photo photo) {
		
		return photoRepo.save(photo);
	}
	
	public void saveImg(MultipartFile file) throws IOException {
		
		String folder = "/Users/pietromuresu/Desktop/Experis - JAVA/Projects/spring-il-mio-fotoalbum/src/main/resources/static/imgs/";
		byte[] bytes = file.getBytes();
		Path path = Paths.get(folder + getUniqueFileName(file));
		Files.write(path, bytes);
	}
	
	public String getUniqueFileName(MultipartFile multipartFile) {
	    String originalFileName = multipartFile.getOriginalFilename();
	    String baseName = originalFileName.substring(0, originalFileName.lastIndexOf("."));
	    String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
	    String uniqueFileName = originalFileName;

	    String folder = "/Users/pietromuresu/Desktop/Experis - JAVA/Projects/spring-il-mio-fotoalbum/src/main/resources/static/imgs/";

	    File file = new File(folder + uniqueFileName);
	    
	    int count = 1;
	    
	    while (file.exists()) {
	        uniqueFileName = baseName + count + extension;
	        file = new File(folder + uniqueFileName);
	        count++;
	    }

	    return uniqueFileName;
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
	
	public List<Photo> findVisible() {
		return photoRepo.findByVisibleTrue();
	}
	
	public List<Photo> findByTitleAndVisible(String title) {
		return photoRepo.findByTitleContainingAndVisibleTrue(title);
	}
	
	public void updatePhoto(Photo photo) {
		
		Long id = photo.getId();
		Photo photoToUpdate = photoRepo.findById(id).get();

		photoRepo.save(photoToUpdate);
	}
}
