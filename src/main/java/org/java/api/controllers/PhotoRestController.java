package org.java.api.controllers;

import java.util.List;

import org.java.auth.pojo.User;
import org.java.auth.services.UserService;
import org.java.pojo.Message;
import org.java.pojo.Photo;
import org.java.pojo.dto.MessageDTO;
import org.java.services.MessageService;
import org.java.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	MessageService messageServ;
	
	@Autowired
	UserService userServ;
	
	
	
	@GetMapping("/users/all")
	public ResponseEntity<List<User>> users(){
		
		
		List<User> users = userServ.findAll();
		
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	
	@GetMapping("/photos/all")
	public ResponseEntity<List<Photo>> index(@RequestParam(required = false, name = "title") String title){
		
		
		List<Photo> photos = null;
		List<User> users = userServ.findAll();
		
		if(title != null) {
			
			photos = photoServ.findByTitleAndVisible(title);
		}else {
		
			photos = photoServ.findVisible();
		}
		
		
		return new ResponseEntity<List<Photo>>(photos, HttpStatus.OK);
		
	}
	
	@GetMapping("/photos/{id}")
	public ResponseEntity<Photo> index(@PathVariable Long id){
		
		
		Photo photo = photoServ.findById(id).get();
		
		
		return new ResponseEntity<Photo>(photo, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/message/send")
	public ResponseEntity<Message> sendMessage(@RequestBody MessageDTO  messageDTO){
		
		
		Message message = new Message(messageDTO);

		
			
		message = messageServ.save(message);
		
		
		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}
	
}
