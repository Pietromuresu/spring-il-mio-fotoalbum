package org.java.controllers;

import java.util.List;

import org.java.pojo.Category;
import org.java.pojo.Photo;
import org.java.services.CategoryService;
import org.java.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private PhotoService photoServ; 
	
	@Autowired
	private CategoryService categoryServ; 
	
	@GetMapping
	public String index(Model model) {
		
		List<Photo> photos = photoServ.findAll();
		
		model.addAttribute("photos", photos);
		
		return "index";
	}
	
	@GetMapping("/post/{id}")
	public String show(Model model, @PathVariable Long id) {
		
		Photo photo = photoServ.findById(id).get();
		
		model.addAttribute("photo", photo);
		
		return "show";
	}
	
	@GetMapping("/add")
	public String addNew(Model model) {
		
		Photo photo = new Photo();
		List<Category> categories = categoryServ.findAll();
		model.addAttribute("photo", photo);
		model.addAttribute("categories", categories);
		
		return "create";
	}
	
	@GetMapping("/update/{id}")
	public String update(Model model,@PathVariable Long id) {
		
		Photo photo = photoServ.findById(id).get();

		List<Category> categories = categoryServ.findAll();
		
		model.addAttribute("photo", photo);
		model.addAttribute("categories", categories);
		
		return "create";
	}
}
