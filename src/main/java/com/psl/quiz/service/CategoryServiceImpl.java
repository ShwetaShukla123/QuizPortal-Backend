package com.psl.quiz.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.quiz.model.quizmodel.Category;
import com.psl.quiz.repo.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired 
    private CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		return new LinkedHashSet<>(categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long categoryId) {
		return categoryRepository.findById(categoryId).get();
	}

	@Override
	public void deleteCategory(Long CategoryId) {
		categoryRepository.deleteById(CategoryId);
	}

}
