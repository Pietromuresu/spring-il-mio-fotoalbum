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
	
	@RequestMapping("/name")
	public String getByName(Model model, 
							@RequestParam(required = false) String name) {
		List<Photo> photos = null;
		
		String searched = name;
		
		if(name.isEmpty()) {
			
			photos = photoServ.findAll();
		}else {
			
			photos = photoServ.findByTitle(name); 
		}
		
		model.addAttribute("photos", photos);
		model.addAttribute("searchedName", searched);
		
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
	
	@PostMapping("/add")
	public String store(Model model, 
						@ModelAttribute @Valid Photo photo, 
						BindingResult bindingResult
						) {
		return savePhoto(model, photo, bindingResult);
		
	}
	
	@GetMapping("/update/{id}")
	public String update(Model model,@PathVariable Long id) {
		
		Photo photo = photoServ.findById(id).get();

		List<Category> categories = categoryServ.findAll();
		
		model.addAttribute("photo", photo);
		model.addAttribute("categories", categories);
		
		return "create";
	}
	
	@PostMapping("/update/{id}")
	public String update( Model model, 
						@ModelAttribute @Valid Photo photo, 
						BindingResult bindingResult
						) {
		
		return savePhoto(model, photo, bindingResult);
	}
	
	@PostMapping("/delete/{id}")
	public String deletePhoto(@PathVariable("id") Long id) {
		
		Photo photo = photoServ.findById(id).get();
		
		
		photoServ.deleteById(id);

		return "redirect:/";
		
	}
	
	
	private String savePhoto(Model model, 
			@ModelAttribute @Valid Photo photo, 
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			List<Category> categories = categoryServ.findAll();
			model.addAttribute("categories", categories);
			return "create";
		} else {
			
			photoServ.save(photo);
		}
		
		return "redirect:/";
	}
}
