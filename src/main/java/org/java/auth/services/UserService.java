package org.java.auth.services;

import java.util.List;
import java.util.Optional;

import org.java.auth.pojo.User;
import org.java.auth.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	
	public List<User> findAll() {
		
		return userRepo.findAll();
	}
	public User findById(Long id) {
		
		return userRepo.findById(id).get();
	}
	public void save(User user) {
		
		userRepo.save(user);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userRepo.findByUsername(username);
	}

	
}
