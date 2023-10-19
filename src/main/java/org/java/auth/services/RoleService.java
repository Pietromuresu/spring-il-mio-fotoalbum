package org.java.auth.services;

import java.util.List;

import org.java.auth.pojo.Role;
import org.java.auth.repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleService {

	@Autowired
	private RoleRepo roleRepo;
	
	
	public List<Role> findAll() {
		
		return roleRepo.findAll();
	}
	public Role findById(Long id) {
		
		return roleRepo.findById(id).get();
	}
	public void save(Role role) {
		
		roleRepo.save(role);
	}

	
}
