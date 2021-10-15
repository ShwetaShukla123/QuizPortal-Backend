package com.psl.quiz.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.quiz.model.quizmodel.Question;
import com.psl.quiz.model.quizmodel.Quiz;
import com.psl.quiz.repo.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired 
	private QuestionRepository questionRepository;
	
	@Override
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		return new HashSet<>(questionRepository.findAll());
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		return questionRepository.findByQuiz(quiz);
	}

	@Override
	public Question updateQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public Question getQuestion(Long quesId) {
		return questionRepository.findById(quesId).get();
	}

	@Override
	public void deleteQuestion(Long quesId) {
		Question question = questionRepository.findById(quesId).get();
		questionRepository.delete(question);
	}

	@Override
	public Map<String, Object> evalQuiz(List<Question> questions) {
		Integer correctAnswers = 0;
		Integer attempted = 0;
		Double marksGained = 0.0;
		double unitMarks = Double.parseDouble(questions.get(0).getQuiz().getMaxmarks())/questions.size();
		for(Question q: questions) {
			Question ques = questionRepository.findById(q.getQuesId()).get();
			if(q.getUserSelectedAnswer().equals(ques.getAnswer())) {
				correctAnswers++;
				marksGained+=unitMarks;
			}
			if(!q.getUserSelectedAnswer().equals("")) {
				attempted ++;
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("marksGained", marksGained);
		map.put("attempted", attempted);
		map.put("correctAnswers", correctAnswers);
		
		return map;
	}
}
