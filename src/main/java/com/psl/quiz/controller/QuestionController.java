package com.psl.quiz.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.quiz.model.quizmodel.Question;
import com.psl.quiz.model.quizmodel.Quiz;
import com.psl.quiz.service.QuestionService;
import com.psl.quiz.service.QuizService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		return ResponseEntity.ok(questionService.addQuestion(question));
	}
	
	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
		return ResponseEntity.ok(questionService.updateQuestion(question));
	}
	
	//get questions by quizId
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<List<Question>> getQuestionsByQuizId(@PathVariable Long quizId){
		Quiz quiz = quizService.getQuiz(quizId);
		Set<Question> questions = quiz.getQuestions();
		List<Question> list = new ArrayList<>(questions);
		if(list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
			list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
		}
		list.forEach((q)->{
			q.setAnswer(null);
		});
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/quiz/all/{quizId}")
	public ResponseEntity<Set<Question>> getQuestionsOfQuizForAdmin(@PathVariable Long quizId){
		Quiz quiz = new Quiz();
		quiz.setQid(quizId);
		Set<Question> questionsOfQuiz = questionService.getQuestionsOfQuiz(quiz);
		return ResponseEntity.ok(questionsOfQuiz);
	}
	
	@GetMapping("/{quesId}")
	public ResponseEntity<Question> getQuestion(@PathVariable Long quesId){
		return ResponseEntity.ok(questionService.getQuestion(quesId));
	}
	
	@DeleteMapping("/{quesId}")
	public void deleteQuestion(@PathVariable Long quesId) {
		questionService.deleteQuestion(quesId);
	}
	
	@PostMapping("/eval-quiz/")
	public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions){
		return ResponseEntity.ok(questionService.evalQuiz(questions));
	}
	
}
