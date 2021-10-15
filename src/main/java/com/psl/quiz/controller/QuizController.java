package com.psl.quiz.controller;

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

import com.psl.quiz.model.quizmodel.Category;
import com.psl.quiz.model.quizmodel.Quiz;
import com.psl.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(quizService.addQuiz(quiz));
	}
	
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(quizService.updateQuiz(quiz));
	}
	
	@GetMapping("/")
	public ResponseEntity<Set<Quiz>> getQuizzes(){
		return ResponseEntity.ok(quizService.getQuizzes());
	}
	
	@GetMapping("/{qid}")
	public ResponseEntity<Quiz> getQuiz(@PathVariable Long qid){
		return ResponseEntity.ok(quizService.getQuiz(qid));
	}
	
	@GetMapping("/category/{cid}")
	public ResponseEntity<Set<Quiz>> getQuizzesofCategory(@PathVariable Long cid){
		Category category = new Category();
		category.setCid(cid);
		return ResponseEntity.ok(quizService.getQuizzesByCategory(category));
	}
	
	@GetMapping("/category/active/{cid}")
	public ResponseEntity<List<Quiz>> getActiveQuizzesByCategory(@PathVariable Long cid){
		Category category = new Category();
		category.setCid(cid);
		return ResponseEntity.ok(quizService.getActiveQuizzesByCategory(category));
	}
	
	@GetMapping("/active/")
	public ResponseEntity<List<Quiz>> getActiveQuizzes(){
		return ResponseEntity.ok(quizService.getActiveQuizzes());
	}
	
	@DeleteMapping("/{qid}")
	public void deleteQuiz(@PathVariable Long qid) {
		quizService.deleteQuiz(qid);
	}
	
}
