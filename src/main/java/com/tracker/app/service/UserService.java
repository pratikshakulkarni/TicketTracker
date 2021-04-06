package com.tracker.app.service;

import org.springframework.stereotype.Service;

import com.tracker.app.model.User;

public interface UserService  {
	
	public User findByEmail(String email);
	
	public void save(User user);
	
	
	
}
