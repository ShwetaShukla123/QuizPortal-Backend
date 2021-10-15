package com.psl.quiz.model;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Authority implements GrantedAuthority{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5814360199130914703L;
	private String authority;

	@Override
	public String getAuthority() {
		return this.authority;
	}
	
	

}
