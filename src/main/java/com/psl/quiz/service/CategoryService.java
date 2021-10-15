package com.psl.quiz.service;

import java.util.Set;

import com.psl.quiz.model.quizmodel.Category;

public interface CategoryService {

	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Set<Category> getCategories();
	public Category getCategory(Long categoryId);
	public void deleteCategory(Long CategoryId);
}
