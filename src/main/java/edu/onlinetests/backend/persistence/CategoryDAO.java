package edu.onlinetests.backend.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.onlinetests.model.Category;

@Repository
public interface CategoryDAO {

	List<Category> getCategories();
	
}
