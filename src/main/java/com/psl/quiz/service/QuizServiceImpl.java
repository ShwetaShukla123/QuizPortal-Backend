package com.psl.quiz.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.quiz.model.quizmodel.Category;
import com.psl.quiz.model.quizmodel.Quiz;
import com.psl.quiz.repo.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository quizRepository;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		return quizRepository.saveAndFlush(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		return new HashSet<>(quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		Quiz quiz = null;
		try {
			quiz = quizRepository.findById(quizId).get();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return quiz;
	}

	@Override
	public void deleteQuiz(Long quizId) {
		quizRepository.deleteById(quizId);
	}

	@Override
	public Set<Quiz> getQuizzesByCategory(Category category) {
		return quizRepository.findByCategory(category);
	}

	@Override
	public List<Quiz> getActiveQuizzes() {
		return quizRepository.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizzesByCategory(Category category) {
		return quizRepository.findByCategoryAndActive(category, true);
	}

}
