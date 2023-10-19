package org.java.api.controllers;

import java.util.List;

import org.java.pojo.Photo;
import org.java.services.CategoryService;
import org.java.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1.0")
public class PhotoRestController {

	
	@Autowired
	private PhotoService photoServ;
	
	@Autowired 
	private CategoryService categoryServ;
	
	@GetMapping("/photos/all")
	public ResponseEntity<List<Photo>> index(@RequestParam(required = false, name = "title") String title){
		

		List<Photo> photos = null;
		
		if(title != null) {
			
			photos = photoServ.findByTitle(title);
		}else {
		
			photos = photoServ.findAll();
		}
		
		
		return new ResponseEntity<List<Photo>>(photos, HttpStatus.OK);
		
	}
	
}
