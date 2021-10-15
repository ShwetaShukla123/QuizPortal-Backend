package com.psl.quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psl.quiz.model.quizmodel.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
