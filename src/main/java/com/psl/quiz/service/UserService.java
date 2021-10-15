package com.psl.quiz.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.psl.quiz.exception.UserException;
import com.psl.quiz.model.Role;
import com.psl.quiz.model.User;

@Service
public interface UserService {
	
	public User createUser(User user, Set<Role> roles) throws UserException;
	
	public User getUser(String username);

}
