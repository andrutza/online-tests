package edu.onlinetests.frontend.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.onlinetests.backend.service.CategoryService;
import edu.onlinetests.backend.service.TestService;
import edu.onlinetests.frontend.Pages;
import edu.onlinetests.model.Category;

@ManagedBean(name = "categoryResultsController")
@SessionScoped
@Component
public class CategoryResultsController {

	private List<Category> categories;
	private int i = 0;

	@Autowired
	private TestService testService;

	@Autowired
	private CategoryService categoryService;

	public String populateCategories() {
		categories = categoryService.getCategories();
		return Pages.CATEGORY_RESULTS_PAGE;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}