package com.tracker.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tracker.app.model.Role;
import com.tracker.app.model.User;
import com.tracker.app.repository.RoleRepository;
import com.tracker.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("roleRepository")
	private RoleRepository roleRespository;

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = new Role("USER");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
		
	}
	
	public void createAdmin(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
		
	}
	

}
