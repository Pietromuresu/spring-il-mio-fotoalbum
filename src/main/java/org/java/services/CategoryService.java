package org.java.services;

import java.util.List;
import java.util.Optional;

import org.java.pojo.Category;
import org.java.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	public Category save(Category category) {
		
		return categoryRepo.save(category);
	}
	
	public List<Category> findAll() {
		
		return categoryRepo.findAll();
	}
	
	public List<Category> findByTitle(String title) {
		
		return categoryRepo.findByNameContaining(title);
	}
	
	public Optional<Category> findById(Long id) {
		
		return categoryRepo.findById(id);
	}
	
	public void deleteById(Long id) {
		categoryRepo.deleteById(id);
	}
	
	public void updatePhoto(Category category) {
		
		Long id = category.getId();
		Category categoryToUpdate = categoryRepo.findById(id).get();

		categoryRepo.save(categoryToUpdate);
	}
}
