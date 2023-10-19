package org.java.auth.repositories;

import org.java.auth.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>{

	public User findByUsername(String username);
}
