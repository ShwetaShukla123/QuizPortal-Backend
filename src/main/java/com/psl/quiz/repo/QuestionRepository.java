package com.psl.quiz.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psl.quiz.model.quizmodel.Question;
import com.psl.quiz.model.quizmodel.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	Set<Question> findByQuiz(Quiz quiz);

}
