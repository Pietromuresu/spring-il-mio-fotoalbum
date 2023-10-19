package org.java.repos;

import java.util.List;

import org.java.pojo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepo extends JpaRepository<Photo, Long> {

	public List<Photo> findByTitleContaining(String title);
	public List<Photo> 	findByVisibleTrue();
	public List<Photo> 	findByTitleContainingAndVisibleTrue(String title);
	
}
