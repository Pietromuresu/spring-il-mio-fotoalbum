package org.java.repos;

import java.util.List;

import org.java.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

	public List<Category> findByNameContaining(String name);
}
