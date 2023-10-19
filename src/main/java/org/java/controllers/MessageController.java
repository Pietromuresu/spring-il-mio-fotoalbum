package org.java.controllers;

import java.util.List;

import org.java.pojo.Category;
import org.java.pojo.Message;
import org.java.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	MessageService messageServ;
	
	@GetMapping
	public String getAll(Model model){
		
		List<Message> messages = messageServ.findAll();
		
		model.addAttribute("messages",  messages);
		
		System.out.println(messages);
		
		return "messages";
	}
	
	
	@PostMapping("/send")
	public String send(Model model,
			@ModelAttribute @Valid Message message, 
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {

			return "/";
		} 
	
		messageServ.save(message);		
	
		
		return "redirect:/";	
	}
}
