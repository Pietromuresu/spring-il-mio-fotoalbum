package org.java.services;

import java.util.List;
import java.util.Optional;

import org.java.pojo.Message;
import org.java.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepo messageRepo;
	
	public Message save(Message message) {
		
		return messageRepo.save(message);
	}
	
	public List<Message> findAll() {
		
		return messageRepo.findAll();
	}
	
	public Optional<Message> findById(Long id) {
		
		return messageRepo.findById(id);
	}
	
	public void deleteById(Long id) {
		messageRepo.deleteById(id);
	}
	
	public void updatePhoto(Message message) {
		
		Long id = message.getId();
		Message categoryToUpdate = messageRepo.findById(id).get();

		messageRepo.save(categoryToUpdate);
	}
}
