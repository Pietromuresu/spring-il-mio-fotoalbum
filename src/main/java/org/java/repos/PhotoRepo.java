package org.java.repos;

import java.util.List;
import java.util.Optional;

import org.java.auth.pojo.User;
import org.java.pojo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepo extends JpaRepository<Photo, Long> {

	public List<Photo> findByTitleContaining(String title);
	public List<Photo> 	findByVisibleTrue();
	public List<Photo> 	findByTitleContainingAndVisibleTrue(String title);
	public List<Photo> 	findByUser(User user);
	public List<Photo> 	findByUserAndTitle(User user, String title);
	public Optional<Photo> 	findByUserAndId(User user, Long id);
	
}
