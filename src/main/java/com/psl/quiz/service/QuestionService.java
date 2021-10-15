package com.psl.quiz.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.psl.quiz.model.quizmodel.Question;
import com.psl.quiz.model.quizmodel.Quiz;

public interface QuestionService {
	
	public Question addQuestion(Question question);
	public Set<Question> getQuestions();
	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
	public Question updateQuestion(Question question);
	public Question getQuestion(Long quesId);
	public void deleteQuestion(Long quesId);
	public Map<String, Object> evalQuiz(List<Question> questions);
}
