package com.psl.quiz.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psl.quiz.model.quizmodel.Category;
import com.psl.quiz.model.quizmodel.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

	public Set<Quiz> findByCategory(Category category);
	
	public List<Quiz> findByActive(Boolean b);
	
	public List<Quiz> findByCategoryAndActive(Category c, Boolean b);
}
