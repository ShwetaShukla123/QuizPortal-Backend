package com.psl.quiz.service;

import java.util.List;
import java.util.Set;

import com.psl.quiz.model.quizmodel.Category;
import com.psl.quiz.model.quizmodel.Quiz;

public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public Set<Quiz> getQuizzes();
	public Quiz getQuiz(Long quizId);
	public void deleteQuiz(Long quizId);
	public Set<Quiz> getQuizzesByCategory(Category category);
	public List<Quiz> getActiveQuizzes();
	public List<Quiz> getActiveQuizzesByCategory(Category category);
}
