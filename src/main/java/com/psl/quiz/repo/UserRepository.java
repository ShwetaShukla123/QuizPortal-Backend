package com.psl.quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psl.quiz.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findUserByUsername(String username);

}
