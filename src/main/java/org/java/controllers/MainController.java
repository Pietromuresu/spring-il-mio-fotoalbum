package org.java.controllers;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.java.auth.pojo.User;
import org.java.pojo.Category;
import org.java.pojo.Photo;
import org.java.services.CategoryService;
import org.java.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

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
		// prendo i dati dell'utente loggato
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object user = authentication.getPrincipal();
		
		List<Photo> photos = null;
		if(user instanceof User) {

			photos = photoServ.findByUser((User) user);
		}else {
			return "index";
		}
		
		
		
		model.addAttribute("photos", photos);
		
		return "index";
	}
	
	@RequestMapping("/name")
	public String getByName(Model model, 
							@RequestParam(required = false) String name) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object user = authentication.getPrincipal();
		List<Photo> photos = null;
		
		String searched = name;
		if(user instanceof User) {
			
		
			if(name.isEmpty()) {
				
				photos = photoServ.findByUser((User) user);;
			}else {
				
				photos = photoServ.findByUserAndTitle((User) user, name); 
			}
		}
		
		model.addAttribute("photos", photos);
		model.addAttribute("searchedName", searched);
		
		return "index";
	}
	
	@GetMapping("/post/{id}")
	public String show(Model model, @PathVariable Long id) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object user = authentication.getPrincipal();
		
		Photo photo = null;
		
		if(user instanceof User) {
			// Se l'utente non è proprietario della foto si fa il redirect sulla index

			Optional<Photo> photoOpt  = photoServ.findByUserAndId((User) user, id);
			if(!photoOpt.isPresent()) {
				return "redirect:/";
			}
			
			photo = photoOpt.get();
			
		}else {
			return "index";
		}
		
		
		
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
						@RequestParam("file") MultipartFile file,
						BindingResult bindingResult
						)  {
		 
		try {
			photo.setPhotoUrl(photoServ.getUniqueFileName(file));
			photoServ.saveImg(file);
			
		}catch(MaxUploadSizeExceededException e) {
			
			model.addAttribute("error", "Si è verificato un errore durante il caricamento del file.");
			
			return "create";
		}catch(IOException e) {
			
			model.addAttribute("error", "Si è verificato un errore durante il caricamento del file.");
			
			return "create";
		}
		
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
		
		photoServ.deleteById(id);

		return "redirect:/";
		
	}
	
	
	private String savePhoto(Model model, 
			@ModelAttribute @Valid Photo photo, 
			BindingResult bindingResult) {
		// Prima di salvare prendo i dati dell'utente e faccio il set dell'user_id
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object user = authentication.getPrincipal();
		
		if(user instanceof User) {
			
			photo.setUser((User) user);
			
			if (bindingResult.hasErrors()) {
				List<Category> categories = categoryServ.findAll();
				model.addAttribute("categories", categories);
				return "create";
			} else {
				
				photoServ.save(photo);
			}
		
		}
		
		return "redirect:/";
	}
}
