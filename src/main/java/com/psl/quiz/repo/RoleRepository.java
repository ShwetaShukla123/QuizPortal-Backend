package com.psl.quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psl.quiz.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
