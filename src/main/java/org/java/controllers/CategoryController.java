package org.java.controllers;

import java.util.List;


import org.java.pojo.Category;
import org.java.pojo.Photo;
import org.java.services.CategoryService;
import org.java.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private PhotoService photoServ; 
	
	@Autowired
	private CategoryService categoryServ; 
	
	@GetMapping
	public String getIngredientsIndex(Model model) {
		
		List<Category> categories = categoryServ.findAll();
		Category category = new Category();
		
		model.addAttribute("categories", categories);
		model.addAttribute("category", category);
		
		return "categories";
		
	}
	
	@GetMapping("/add")
	public String saveCategory(Model model) {
		
		Category category = new Category();
		
		model.addAttribute(category);	
		
		return "add-categories";	
	}
	
	@PostMapping("/add")
	public String saveCategory(Model model,
			@ModelAttribute @Valid Category category, 
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {

			return "categories";
		} 
	
		categoryServ.save(category);		
	
		
		return "redirect:/categories";	
	}
	
	@GetMapping("/update/{id}")
	public String updateCategory(Model model, @PathVariable String id) {
		
		Category category = categoryServ.findById(Long.valueOf(id)).get();
		
		model.addAttribute(category);	
		
		return "add-categories";	
	}
	
	@PostMapping("/update/{id}")
	public String updateCategory(Model model,
			@ModelAttribute @Valid Category category, 
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			
			return "categories";
		} 
		
		categoryServ.save(category);		
		
		
		return "redirect:/categories";	
	}
	
	
	@PostMapping("/delete/{id}")
	public String deleteCategory(@PathVariable String id) {
		
		List<Photo> photos = photoServ.findAll();
		Category category = categoryServ.findById(Long.valueOf(id)).get();
		
		for(Photo photo : photos) { 
			if(photo.getCategories().contains(category)) photo.getCategories().remove(category);
		}
		
		categoryServ.deleteById(Long.valueOf(id));
		
		return "redirect:/categories";	
	}
	
}
