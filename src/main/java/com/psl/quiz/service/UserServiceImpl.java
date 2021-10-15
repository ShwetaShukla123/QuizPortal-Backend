package com.psl.quiz.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.quiz.exception.UserException;
import com.psl.quiz.model.Role;
import com.psl.quiz.model.User;
import com.psl.quiz.repo.RoleRepository;
import com.psl.quiz.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User createUser(User user, Set<Role> roles) throws UserException {
		
		User usr = userRepository.findUserByUsername(user.getUsername());
		if(usr != null) {
			throw new UserException("User already exists");
		}
		else {
			for(Role role: roles) {
				roleRepository.save(role);
			}
			user.getRoles().addAll(roles);
			user.setProfile("default.png");
			usr = userRepository.save(user);
		}
		return usr;
	}

	@Override
	public User getUser(String username) {
		return userRepository.findUserByUsername(username);
		
	}

}
